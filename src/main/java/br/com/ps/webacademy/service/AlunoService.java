package br.com.ps.webacademy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.dao.AlunoDAO;
import br.com.ps.webacademy.database.Conexao;
import br.com.ps.webacademy.database.Transacao;
import br.com.ps.webacademy.exception.RegraNegocioException;
import br.com.ps.webacademy.filtro.AlunoFiltro;

public class AlunoService implements IService<Aluno> {

	@Override
	public Aluno buscarPorId(int id) throws RegraNegocioException {
		Aluno aluno = null;
		AlunoDAO alunoDAO = null;
		if (id > 0) {
			try {
				alunoDAO = new AlunoDAO(Conexao.getConexao());
				aluno = alunoDAO.buscarPoId(id);
				if (aluno != null) {
					return aluno;
				} else {
					throw new RegraNegocioException("Aluno não encontrado.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				alunoDAO = null;
				Conexao.fechar();
			}
		} else {
			throw new RegraNegocioException("ID do aluno não identificado.");
		}

		return null;
	}

	@Override
	public boolean salvar(Aluno aluno) throws RegraNegocioException {
		boolean isSalvo = false;
		Connection conexao = Conexao.getConexao();
		AlunoDAO alunoDAO = null;
		if (aluno != null) {
			try {
				alunoDAO = new AlunoDAO(conexao);
				Transacao.iniciar(conexao);
				if (aluno.getId() == 0) {
					if (alunoDAO.inserir(aluno)) {
						aluno.setMatricula(gerarMatricula(aluno));
						if (alunoDAO.atualizar(aluno)) {
							isSalvo = true;
						}
					}
				} else {
					if (alunoDAO.atualizar(aluno)) {
						isSalvo = true;
					}
				}
				Transacao.finalizar(conexao);
				return true;
			} catch (SQLException e) {
				Transacao.cancelar(conexao);
				e.printStackTrace();
			} finally {
				alunoDAO = null;
				Conexao.fechar();
			}
		}
		return isSalvo;
	}

	@Override
	public List<Aluno> todos() {
		AlunoDAO alunoDAO = null;
		try {
			alunoDAO = new AlunoDAO(Conexao.getConexao());
			List<Aluno> alunos = alunoDAO.todos();
			if (alunos != null && !alunos.isEmpty()) {
				return alunos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			alunoDAO = null;
			Conexao.fechar();
		}
		return null;
	}

	public List<Aluno> pesquisar(AlunoFiltro filtros)throws SQLException {
		List<Aluno> alunos = null;
		AlunoDAO alunoDAO = null;
		if (filtros != null) {
			try {
				alunoDAO = new AlunoDAO(Conexao.getConexao());
				alunos = alunoDAO.pesquisar(filtros);
				if(!alunos.isEmpty()) {
					return alunos;
				}
			}catch(SQLException e) {
				throw e;
			}finally {
				Conexao.fechar();
				alunoDAO = null;
			}
		}
		return null;
	}

	@Override
	public boolean excluirPoId(int id) throws RegraNegocioException {
		AlunoDAO alunoDAO = null;
		boolean isExcluiu = false;
		if(id > 0) {
			try {
				alunoDAO = new AlunoDAO(Conexao.getConexao());
				Transacao.iniciar(Conexao.getConexao());
				if(alunoDAO.deletarPoID(id)) {
					isExcluiu = true;
				}
				Transacao.finalizar(Conexao.getConexao());
			}catch (SQLException e) {
				Transacao.cancelar(Conexao.getConexao());
				e.printStackTrace();
			}finally {
				alunoDAO = null;
				Conexao.fechar();
			}
		}
		return isExcluiu;
	}
	

	private String gerarMatricula(Aluno aluno) {
		String matricula = "";
		if (aluno != null) {
			int anoMatricula = LocalDate.now().getYear();
			matricula += String.valueOf(anoMatricula).concat(String.valueOf(aluno.getId()));
			if (matricula.length() < 10) {
				while (matricula.length() < 10) {
					matricula += "0";
				}
			}
		}
		return matricula;
	}
}
