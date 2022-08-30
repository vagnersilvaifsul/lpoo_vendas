package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends BaseDAO {
	public static List<Cliente> selectClientes() {
		final String sql = "SELECT * FROM clientes ORDER BY nome";
		try // try-witch-resource
		(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		)
		{
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				clientes.add(resultsetToCliente(rs));
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Cliente> selectClientesByName(String nome) {
		final String sql = "SELECT * FROM clientes WHERE nome LIKE ? ORDER BY nome";
		try // try-witch-resource
		(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, nome.toLowerCase() + "%");
			ResultSet rs = pstmt.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				clientes.add(resultsetToCliente(rs));
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Cliente> selectClientesBySituacao(boolean situacao) {
		final String sql = "SELECT * FROM clientes WHERE situacao=?";
		try // try-witch-resource
		(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, situacao);
			ResultSet rs = pstmt.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				clientes.add(resultsetToCliente(rs));
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Cliente selectClienteById(Long id) {
		final String sql = "SELECT * FROM clientes WHERE id=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			Cliente cliente = null;
			if (rs.next()) {
				cliente = resultsetToCliente(rs);
			}
			rs.close();
			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertCliente(Cliente cliente) {
		final String sql = "INSERT INTO clientes (nome, sobrenome, situacao) VALUES (?, ?, ?)";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getSobrenome());
			pstmt.setBoolean(3, cliente.getSituacao());
			int count = pstmt.executeUpdate();
			return count > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateCliente(Cliente cliente) {
		final String sql = "UPDATE clientes SET nome=?, sobrenome=?, situacao=? WHERE id=?";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getSobrenome());
			pstmt.setBoolean(3, cliente.getSituacao());
			pstmt.setLong(4, cliente.getId());
			int count = pstmt.executeUpdate();
			return count > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean softDeleteCliente(long id, boolean situacao) {
		final String sql = "UPDATE clientes SET situacao=? WHERE id=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, situacao);
			pstmt.setLong(2, id);
			int count = pstmt.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// método utilitário, converte ResultSet na classe de modelo (nesse caso, Cliente)
	private static Cliente resultsetToCliente(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getLong("id"));
		c.setNome(rs.getString("nome"));
		c.setSobrenome(rs.getString("sobrenome"));
		c.setSituacao(rs.getBoolean("situacao"));

		return c;
	}

	public static void main(String[] args) {
		System.out.println("\nLista de Clientes");
		System.out.println(ClienteDAO.selectClientes());

		System.out.println("\nCliente pelo id");
		System.out.println(ClienteDAO.selectClienteById(1L));

		System.out.println("\nClientes pelo nome");
		System.out.println(ClienteDAO.selectClientesByName("a"));

		System.out.println("\nCliente pela situação");
		System.out.println(ClienteDAO.selectClientesBySituacao(true));

		System.out.println("\nCriando um Clente");
		Cliente cliente = new Cliente(3L,"Aline", "Dias", false, null);
		System.out.println(ClienteDAO.insertCliente(cliente));
		System.out.println("\nCliente INSERIDO na base de dados: " + ClienteDAO.selectClienteById(3L));

		System.out.println("\nAlterando um cliente (o criado recentemente)");
		cliente = selectClienteById(3L);
		cliente.setNome("Aline Marisa");
		cliente.setSobrenome("Vaz");
		System.out.println(ClienteDAO.updateCliente(cliente));
		System.out.println("\nCliente ALTERADO na base de dados: " + ClienteDAO.selectClienteById(3L));

		System.out.println("\nDeletando um cliente (o criado recentemente)");
		System.out.println(softDeleteCliente(3, false));
		System.out.println("\nCliente EXCLUÍDO na base de dados: " + ClienteDAO.selectClienteById(3L));
	}

}
