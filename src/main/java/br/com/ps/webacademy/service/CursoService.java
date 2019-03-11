package br.com.ps.webacademy.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ps.webacademy.beans.Curso;
import br.com.ps.webacademy.dao.CursoDAO;
import br.com.ps.webacademy.database.Conexao;
import br.com.ps.webacademy.database.Transacao;
import br.com.ps.webacademy.exception.RegraNegocioException;

public class CursoService implements IService<Curso> {

	public CursoService() {
	}

	@Override
	public Curso buscarPorId(int id) throws RegraNegocioException {
		CursoDAO cursoDAO = null;
		if (id > 0) {
			try {
				cursoDAO = new CursoDAO(Conexao.getConexao());
				Curso curso = cursoDAO.buscarPoId(id);
				if (curso == null) {
					throw new RegraNegocioException("Curso não encontrado.");
				} else {
					return curso;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cursoDAO = null;
				Conexao.fechar();
			}
		}

		return null;
	}

	@Override
	public boolean salvar(Curso curso) throws RegraNegocioException {
		boolean isSalvo = false;
		CursoDAO cursoDAO = null;
		if (curso != null) {
			try {
				cursoDAO = new CursoDAO(Conexao.getConexao());
				Transacao.iniciar(Conexao.getConexao());
				if (curso.getId() == 0) {
					if (cursoDAO.inserir(curso)) {
						isSalvo = true;
					}
				} else {
					if (cursoDAO.atualizar(curso)) {
						isSalvo = true;
					}
				}
				Transacao.finalizar(Conexao.getConexao());
			} catch (SQLException e) {
				Transacao.finalizar(Conexao.getConexao());
			} finally {
				cursoDAO = null;
				Conexao.fechar();
			}
		}
		return isSalvo;
	}

	@Override
	public List<Curso> todos() {
		CursoDAO cursoDAO = null;
		try {
			cursoDAO = new CursoDAO(Conexao.getConexao());
			List<Curso> cursos = cursoDAO.todos();
			if (!cursos.isEmpty()) {
				return cursos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cursoDAO = null;
			Conexao.fechar();
		}
		return null;
	}

	@Override
	public boolean excluirPoId(int id) throws RegraNegocioException {
		return false;
	}

}
