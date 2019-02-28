package br.com.ps.webacademy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.database.Conexao;
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
					aluno.setDataCadastro(result.getDate("data_nascimento").toLocalDate());
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

		StringBuilder sql = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			sql = new StringBuilder("INSERT INTO aluno");
			sql.append("(nome,email,cpf,rg,data_nascimento) ");
			sql.append("VALUES(?,?,?,?,?)");
			statement = this.connection.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getRg());
			statement.setDate(5, Date.valueOf(aluno.getDataNascimento()));

			if (statement.executeUpdate() == 1) {
				result = statement.getGeneratedKeys();
				int idAluno = 0;
				if (result.next()) {
					idAluno = result.getInt("id");
					if (idAluno > 0) {
						aluno.setId(idAluno);
						return true;
					}
				}
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			sql.delete(0, sql.length());
			statement = null;
			result = null;
		}

		return false;
	}

	@Override
	public boolean atualizar(Aluno t) throws SQLException {

		return false;
	}

	@Override
	public boolean deletar(Aluno t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarPoID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Aluno> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setCpf("----");
		aluno.setDataNascimento(LocalDate.now());
		aluno.setEmail("---");
		aluno.setNome("---");
		aluno.setRg("---");

		AlunoDAO dao = new AlunoDAO(Conexao.conexao());
		try {
			dao.inserir(aluno);
			Conexao.conexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
