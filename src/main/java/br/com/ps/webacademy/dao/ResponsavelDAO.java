package br.com.ps.webacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.ps.webacademy.beans.Responsavel;
import br.com.ps.webacademy.database.IDAO;

public class ResponsavelDAO implements IDAO<Responsavel> {

	private Connection connection = null;

	public ResponsavelDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean inserir(Responsavel responsavel) throws SQLException {

		boolean isInsert = false;
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		if (responsavel != null) {
			try {
				sql = new StringBuilder("INSERT INTO responsavel(nome,email,celular) ").append("VALUES(?,?,?)");
				statement = this.connection.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				statement.setString(1, responsavel.getNome());
				statement.setString(2, responsavel.getEmail());
				statement.setString(3, responsavel.getCelular());
				if (statement.executeUpdate() == 1) {
					result = statement.getGeneratedKeys();
					int idResponsavel = 0;
					if (result.next()) {
						idResponsavel = result.getInt("id");
						responsavel.setId(idResponsavel);
						isInsert = true;
					}
				}

			} catch (SQLException e) {
				throw e;
			} finally {
				sql.delete(0, sql.length());
				sql = null;
				statement = null;
				result = null;
			}
		}

		return isInsert;
	}

	@Override
	public boolean atualizar(Responsavel responsavel) throws SQLException {

		boolean isUpdate = false;
		StringBuilder sql = null;
		PreparedStatement statement = null;

		if (responsavel != null) {
			try {
				sql = new StringBuilder("UPDATE responsavel SET ");
				sql.append("nome = ?,email = ?,celular = ? ");
				sql.append("WHERE id = ? ");
				statement = this.connection.prepareStatement(sql.toString());
				statement.setString(1, responsavel.getNome());
				statement.setString(2, responsavel.getEmail());
				statement.setString(3, responsavel.getCelular());
				statement.setInt(4, responsavel.getId());
				if (statement.executeUpdate() == 1) {
					isUpdate = true;
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				sql = null;
				statement = null;
			}
		}

		return isUpdate;
	}

	@Override
	public Responsavel buscarPoId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletar(Responsavel responsavel) throws SQLException {
		boolean isDelete = false;
		String sql = "";
		PreparedStatement statement = null;
		if (responsavel != null) {
			try {
				sql = "DELETE FROM responsavel WHERE id = ".concat(String.valueOf(responsavel.getId()));
				statement = this.connection.prepareStatement(sql);
				if (statement.executeUpdate() == 1) {
					isDelete = true;
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				sql = null;
				statement = null;
			}
		}
		return isDelete;
	}

	@Override
	public boolean deletarPoID(int id) throws SQLException {
		boolean isDelete = false;
		String sql = "";
		PreparedStatement statement = null;
		if (id > 0) {
			try {
				sql = "DELETE FROM responsavel WHERE id = ".concat(String.valueOf(id));
				statement = this.connection.prepareStatement(sql);
				if (statement.executeUpdate() == 1) {
					isDelete = true;
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				sql = null;
				statement = null;
			}
		}
		return isDelete;
	}

	@Override
	public List<Responsavel> todos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
