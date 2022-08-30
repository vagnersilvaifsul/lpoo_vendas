package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO extends BaseDAO{

	public static List<Produto> selectProdutos() {
		final String sql = "SELECT * FROM produtos ORDER BY nome";
		try //try-witch-resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			)
		{
			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				produtos.add(resultsetToProduto(rs));
			}
			return produtos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Produto> selectProdutosByName(String nome) {
		final String sql = "SELECT * FROM produtos WHERE nome LIKE ? ORDER BY nome";
		try //try-witch-resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setString(1, nome.toLowerCase() + "%");	
			ResultSet rs = pstmt.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				produtos.add(resultsetToProduto(rs));
			}
			return produtos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Produto> selectProdutosBySituacao(boolean situacao) {
		final String sql = "SELECT * FROM produtos WHERE situacao=?";
		try //try-witch-resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setBoolean(1, situacao);	
			ResultSet rs = pstmt.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				produtos.add(resultsetToProduto(rs));
			}
			return produtos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Produto selectProdutoById(Long id) {
		final String sql = "SELECT * FROM produtos WHERE id=?";
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setLong(1, id);	
			ResultSet rs = pstmt.executeQuery();
			Produto produto = null;
			if(rs.next()) {
				produto = resultsetToProduto(rs);
			}
			rs.close();
			return produto;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insertProduto(Produto produto) {
		final String sql = "INSERT INTO produtos (nome, descricao, valor, situacao, quantidade) VALUES (?, ?, ?, ?, ?)";
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		)
		{
			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setDouble(3, produto.getValor());
			pstmt.setBoolean(4, produto.getSituacao());
			pstmt.setInt(5, produto.getEstoque());
			int count = pstmt.executeUpdate();
			return count > 0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateProduto(Produto produto) {
		final String sql = "UPDATE produtos SET nome=?, descricao=?, valor=?, situacao=?, quantidade=? WHERE id=?";
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		)
		{
			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setDouble(3, produto.getValor());
			pstmt.setBoolean(4, produto.getSituacao());
			pstmt.setInt(5, produto.getEstoque());
			pstmt.setLong(6, produto.getId());
			int count = pstmt.executeUpdate();
			return count > 0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean softDeleteProduto(long id, boolean situacao) {
		final String sql = "UPDATE produtos SET situacao=? WHERE id=?";
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		)
		{
			pstmt.setBoolean(1, situacao);
			pstmt.setLong(2, id);
			int count = pstmt.executeUpdate();
			return count > 0;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//método utilitário, converte ResultSet na classe de modelo (nesse caso, Produto)
	private static Produto resultsetToProduto(ResultSet rs) throws SQLException {
		Produto p = new Produto();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setDescricao(rs.getString("descricao"));
		p.setValor(rs.getDouble("valor"));
		p.setEstoque(rs.getInt("quantidade"));
		p.setSituacao(rs.getBoolean("situacao"));

		return p;
	}
      
    
    public static void main(String[] args) {
    	//Produto produto = new Produto(6L,"Farinha", "Farinha Tordilho 5kg", 12.50, 200, true);
		System.out.println(softDeleteProduto(6L, true));
	}

}//fim classe
