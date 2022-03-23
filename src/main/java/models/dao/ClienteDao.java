package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexaoBd.Conexao;
import models.Cliente;

public class ClienteDao {
	private static String comandoSql;
	private static PreparedStatement ps;
	private static Connection conn;

	public void cadastrar(Cliente cliente)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		comandoSql = "INSERT INTO cliente (Nome, Sobrenome, Email, Cpf) VALUES (?, ?, ?, ?);";
		conn = Conexao.getConexao();

		ps = conn.prepareStatement(comandoSql);

		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getSobrenome());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getCpf());

		ps.executeUpdate();
		
		ps.close();
	}
	
	public static List<Cliente> Listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			comandoSql = "SELECT * FROM cliente;";
			conn = Conexao.getConexao();
			
			ps = conn.prepareStatement(comandoSql);
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(comandoSql);
			
			while(rs.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("IdCliente"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setSobrenome(rs.getString("Sobrenome"));
				cliente.setEmail(rs.getString("Email"));
				cliente.setCpf(rs.getString("Cpf"));
				
				clientes.add(cliente);
				
			}
			System.out.println("COMANDO NO BANCO DE DADOS BEM SUCEDIDO!");
			ps.close();
			return clientes;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("COMANDO NO BANCO DE DADOS FALHOU!");
			return null;
		}
	}
	
	public void deletar(Cliente cliente) {
		 try {
			 comandoSql = "DELETE FROM cliente WHERE Cpf = ?";
			 conn = Conexao.getConexao();
			 ps = conn.prepareStatement(comandoSql);
			 
			 ps.setString(1, cliente.getCpf());
			 
			 ps.executeUpdate();
			 ps.close();
			 System.out.println("COMANDO NO BANCO DE DADOS BEM SUCEDIDO!");
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("COMANDO NO BANCO DE DADOS FALHOU!");
		 }
				 
	}
	
	public void alterar(Cliente cliente, String cpf) {
		try {
			comandoSql = "UPDATE cliente SET Nome = ?, Sobrenome = ?, Email = ?, Cpf = ? WHERE Cpf = ? ";
			conn = Conexao.getConexao();
			ps = conn.prepareStatement(comandoSql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getCpf());
			ps.setString(5, cpf);
			
			ps.executeUpdate();
			ps.close();
			System.out.println("COMANDO NO BANCO DE DADOS BEM SUCEDIDO!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}