package br.com.ps.webacademy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.database.IDAO;

public class AlunoDAO implements IDAO<Aluno> {

	private Connection connection;

	public AlunoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Aluno buscarPoId(int id) throws SQLException {
		if (id > 0) {
			Aluno aluno = null;
			String sql = "";
			ResultSet result = null;
			PreparedStatement statement = null;
			try {
				sql = "SELECT * FROM aluno a WHERE a.id = ?";
				statement = this.connection.prepareStatement(sql);
				statement.setInt(1, id);
				result = statement.executeQuery();
				if (result.next()) {
					aluno = new Aluno();
					aluno.setId(result.getInt("id"));
					aluno.setCpf(result.getString("cpf"));
					aluno.setRg(result.getString("rg"));
					aluno.setEmail(result.getString("email"));
					aluno.setNome(result.getString("nome"));
					aluno.setDataNascimento(result.getDate("data_nascimento").toLocalDate());
					aluno.setSexo(result.getString("sexo").charAt(0));
					aluno.setCelular(result.getString("celular"));
					aluno.setMatricula(result.getString("matricula"));
					return aluno;
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				sql = null;
				result = null;
				statement = null;
			}
		}
		return null;
	}

	@Override
	public boolean inserir(Aluno aluno) throws SQLException {
		ResponsavelDAO responsavelDAO = null;
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			sql = new StringBuilder("INSERT INTO aluno");
			sql.append("(nome,email,cpf,rg,data_nascimento,sexo,celular) ");
			sql.append("VALUES(?,?,?,?,?,?,?)");
			statement = this.connection.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getRg());
			statement.setDate(5, aluno.getDataNascimento() != null ? Date.valueOf(aluno.getDataNascimento()) : null);
			statement.setString(6, String.valueOf(aluno.getSexo()));
			statement.setString(7, aluno.getCelular());

			if (statement.executeUpdate() == 1) {
				result = statement.getGeneratedKeys();
				int idAluno = 0;
				if (result.next()) {
					idAluno = result.getInt("id");
					if (idAluno > 0) {
						aluno.setId(idAluno);
						// persistindo informações do responsável
						responsavelDAO = new ResponsavelDAO(this.connection);
						responsavelDAO.inserir(aluno.getResponsavel());
						return true;
					}
				}
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			responsavelDAO = null;
			sql.delete(0, sql.length());
			statement = null;
			result = null;
		}

		return false;
	}

	@Override
	public boolean atualizar(Aluno aluno) throws SQLException {

		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResponsavelDAO responsavelDAO = null;
		try {
			sql = new StringBuilder("UPDATE aluno SET ");
			sql.append("nome = ?, email = ?, cpf = ?, rg = ?, data_nascimento = ?, ");
			sql.append("sexo = ?, celular = ?,matricula = ?, id_responsavel = ? ");
			sql.append("WHERE id = ").append(aluno.getId());
			statement = this.connection.prepareStatement(sql.toString());
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getRg());
			statement.setDate(5, aluno.getDataNascimento() != null ? Date.valueOf(aluno.getDataNascimento()) : null);
			statement.setString(6, String.valueOf(aluno.getSexo()));
			statement.setString(7, aluno.getCelular());
			statement.setString(8, aluno.getMatricula());
			statement.setInt(9, aluno.getResponsavel().getId());
			if (statement.executeUpdate() == 1) {
				responsavelDAO = new ResponsavelDAO(this.connection);
				responsavelDAO.atualizar(aluno.getResponsavel());
				return true;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			sql.delete(0, sql.length());
			statement = null;
		}
		return false;
	}

	@Override
	public boolean deletar(Aluno aluno) throws SQLException {

		StringBuilder sql = null;
		PreparedStatement statement = null;
		try {
			sql = new StringBuilder();
			sql.append("DELETE FROM aluno ");
			sql.append("WHERE id = ?");
			statement = this.connection.prepareStatement(sql.toString());
			statement.setInt(1, aluno.getId());
			if (!statement.execute()) {
				return true;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			sql.delete(0, sql.length());
			statement = null;
		}
		return false;
	}

	@Override
	public boolean deletarPoID(int id) throws SQLException {
		StringBuilder sql = null;
		PreparedStatement statement = null;
		try {
			sql = new StringBuilder();
			sql.append("DELETE FROM aluno ");
			sql.append("WHERE id = ?");
			statement = this.connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			if (!statement.execute()) {
				return true;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			sql.delete(0, sql.length());
			statement = null;
		}
		return false;
	}

	@Override
	public List<Aluno> todos() throws SQLException {

		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Aluno aluno = null;
		List<Aluno> alunos = new ArrayList<>();
		try {
			sql = new StringBuilder();
			sql.append("SELECT a.id,a.nome,a.email,a.matricula,resp.id as id_resp,resp.nome as nome_resp ");
			sql.append("FROM aluno a ");
			sql.append("LEFT JOIN responsavel resp ON (a.id_responsavel = resp.id) ");
			sql.append("ORDER BY a.id ASC");
			statement = this.connection.prepareStatement(sql.toString());
			result = statement.executeQuery();
			if (result != null) {
				alunos = new ArrayList<>();
				while (result.next()) {
					aluno = new Aluno();
					aluno.setId(result.getInt("id"));
					aluno.setEmail(result.getString("email"));
					aluno.setNome(result.getString("nome"));
					aluno.setMatricula(result.getString("matricula"));
					aluno.getResponsavel().setId(result.getInt("id_resp"));
					aluno.getResponsavel().setNome(result.getString("nome_resp"));
					alunos.add(aluno);
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			sql.delete(0, sql.length());
			statement = null;
			result = null;
			aluno = null;
		}
		return alunos;
	}
}
