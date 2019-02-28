package br.com.ps.webacademy.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.database.IDAO;

public class AlunoDAO implements IDAO<Aluno> {

	@Override
	public Aluno buscarPoId(int id) {
		return null;
	}

	@Override
	public boolean inserir(Aluno t) throws SQLException {
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

}
