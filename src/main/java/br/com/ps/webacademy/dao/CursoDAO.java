package br.com.ps.webacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ps.webacademy.beans.Curso;
import br.com.ps.webacademy.database.IDAO;
import br.com.ps.webacademy.database.UtilDB;
import br.com.ps.webacademy.util.Util;

public class CursoDAO implements IDAO<Curso> {

	private Connection conexao = null;

	public CursoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public Curso buscarPoId(int id) throws SQLException {
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		if (id > 0) {
			try {
				sql = new StringBuilder("SELECT c.id, c.nome, c.descricao FROM curso c ").append("WHERE c.id = ?");

				statement = this.conexao.prepareStatement(sql.toString());
				statement.setInt(1, id);
				result = statement.executeQuery();
				if (result.next()) {
					Curso curso = new Curso();
					curso.setId(result.getInt("id"));
					curso.setNome(result.getString("nome"));
					curso.setDescricao(result.getString("descricao"));
					return curso;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Util.limpaSB(sql);
				sql = null;
				UtilDB.fechar(statement, result);
			}
		}
		return null;
	}

	@Override
	public boolean inserir(Curso curso) throws SQLException {

		boolean isSalvo = false;
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		if (curso != null) {
			try {
				sql = new StringBuilder("INSERT INTO curso(nome,descricao) VALUES(?,?)");
				statement = this.conexao.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				statement.setString(1, curso.getNome());
				statement.setString(2, curso.getDescricao());
				if (statement.executeUpdate() == 1) {
					result = statement.getGeneratedKeys();
					if (result.next()) {
						int idCurso = result.getInt("id");
						if (idCurso > 0) {
							curso.setId(idCurso);
							isSalvo = true;
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Util.limpaSB(sql);
				sql = null;
				UtilDB.fechar(statement, result);
			}
		}
		return isSalvo;
	}

	@Override
	public boolean atualizar(Curso curso) throws SQLException {
		boolean isSalvo = false;
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		if (curso != null) {
			try {
				sql = new StringBuilder("UPDATE curso SET nome = ?, descricao = ? WHERE id = ?");
				statement = this.conexao.prepareStatement(sql.toString());
				statement.setString(1, curso.getNome());
				statement.setString(2, curso.getDescricao());
				statement.setInt(3, curso.getId());
				if (statement.executeUpdate() == 1) {
					isSalvo = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Util.limpaSB(sql);
				sql = null;
				UtilDB.fechar(statement, result);
			}
		}
		return isSalvo;
	}

	@Override
	public boolean deletar(Curso curos) throws SQLException {
		return false;
	}

	@Override
	public boolean deletarPoID(int id) throws SQLException {
		return false;
	}

	@Override
	public List<Curso> todos() throws SQLException {
		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Curso curso = null;
		List<Curso> cursos = new ArrayList<>();
		try {
			sql = new StringBuilder("SELECT c.id, c.nome, c.descricao FROM curso c ");
			statement = this.conexao.prepareStatement(sql.toString());
			result = statement.executeQuery();
			while (result.next()) {
				curso = new Curso();
				curso.setId(result.getInt("id"));
				curso.setNome(result.getString("nome"));
				curso.setDescricao(result.getString("descricao"));
				cursos.add(curso);
			}

		} catch (SQLException e) {

		} finally {
			Util.limpaSB(sql);
			sql = null;
			UtilDB.fechar(statement, result);
		}

		return cursos;
	}
}
