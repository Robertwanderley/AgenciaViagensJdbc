package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexaoBd.Conexao;
import models.Telefone;


public class TelefoneDao {
	private static String comandoSql;
	private static PreparedStatement ps;
	private static Connection conn;
	
	public void cadastrar(Telefone telefone) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		try {
			comandoSql = "INSERT INTO telefone (Celular, Fixo, IdCliente) VALUES (?, ?, LAST_INSERT_ID());";
			conn = Conexao.getConexao();
			
			ps = conn.prepareStatement(comandoSql);
			
			ps.setString(1, telefone.getCelular());
			ps.setString(2, telefone.getFixo());
			//ps.setInt(3, telefone.getIdCliente());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ps.close();
		
		}
		
	}
	
	public static List<Telefone> Listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			comandoSql = "SELECT * FROM telefone;";
			conn = Conexao.getConexao();
			
			ps = conn.prepareStatement(comandoSql);
			
			List<Telefone> telefones = new ArrayList<Telefone>();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(comandoSql);
			
			while(rs.next()) {
				
				Telefone telefone = new Telefone();
				
				telefone.setIdTel(rs.getInt("idTel"));
				telefone.setCelular(rs.getString("celular"));
				telefone.setFixo(rs.getString("fixo"));
				telefone.setIdCliente(rs.getInt("idCliente"));
				
				telefones.add(telefone);
				
			}
			System.out.println("COMANDO NO BANCO DE DADOS BEM SUCEDIDO!");
			return telefones;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("COMANDO NO BANCO DE DADOS FALHOU!");
			return null;
		}
	}
	
}
