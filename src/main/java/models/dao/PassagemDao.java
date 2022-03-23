package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexaoBd.Conexao;
import models.Passagem;

public class PassagemDao {
	private static String comandoSql;
	private static PreparedStatement ps;
	private static Connection conn;
	
	public void comprar(Passagem passagem) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		try {
			comandoSql = "INSERT INTO passagem (Embarque, Desembarque, Preco, IdCliente) VALUES (?, ?, ?, LAST_INSERT_ID());";
			conn = Conexao.getConexao();
			
			ps = conn.prepareStatement(comandoSql);
			
			ps.setString(1, passagem.getEmbarque());
			ps.setString(2, passagem.getDesembarque());
			ps.setDouble(3, passagem.getPreco());
			//ps.setInt(4, passagem.getIdCliente());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Passagem> Listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			comandoSql = "SELECT * FROM passagem;";
			conn = Conexao.getConexao();
			
			ps = conn.prepareStatement(comandoSql);
			
			List<Passagem> passagens = new ArrayList<Passagem>();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(comandoSql);
			
			while(rs.next()) {
				
				Passagem passagem = new Passagem();
				
				passagem.setIdPass(rs.getInt("idPass"));
				passagem.setEmbarque(rs.getString("embarque"));
				passagem.setDesembarque(rs.getString("desembarque"));
				passagem.setPreco(rs.getDouble("preco"));
				passagem.setIdCliente(rs.getInt("idCliente"));
				
				passagens.add(passagem);
				
			}
			System.out.println("COMANDO NO BANCO DE DADOS BEM SUCEDIDO!");
			return passagens;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("COMANDO NO BANCO DE DADOS FALHOU!");
			return null;
		}
	}
	
}
