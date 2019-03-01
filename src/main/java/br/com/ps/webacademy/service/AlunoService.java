package br.com.ps.webacademy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.dao.AlunoDAO;
import br.com.ps.webacademy.database.Conexao;
import br.com.ps.webacademy.database.Transacao;
import br.com.ps.webacademy.exception.RegraNegocioException;

public class AlunoService implements IService<Aluno> {

	@Override
	public boolean salvar(Aluno aluno) throws RegraNegocioException {
		boolean isSalvo = false;
		Connection conexao = Conexao.conexao();
		AlunoDAO alunoDAO = null;
		if (aluno != null) {
			try {
				alunoDAO = new AlunoDAO(conexao);
				Transacao.iniciar(conexao);
				if (aluno.getId() == 0) {
					if (alunoDAO.inserir(aluno)) {
						aluno.setMatricula(geraMatricula(aluno));
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

	private String geraMatricula(Aluno aluno) {
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
