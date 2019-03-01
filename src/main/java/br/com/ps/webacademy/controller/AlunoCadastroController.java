package br.com.ps.webacademy.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.exception.RegraNegocioException;
import br.com.ps.webacademy.service.AlunoService;

@SuppressWarnings("serial")
@WebServlet("/aluno/cadastro")
public class AlunoCadastroController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (doSalvarAluno(req, resp)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/webacademy/aluno/consulta.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/webacademy/aluno/erro-cadastro.jsp");
			dispatcher.forward(req, resp);
		}
	}

	private boolean doSalvarAluno(HttpServletRequest req, HttpServletResponse resp) {
		AlunoService alunoService = null;
		Aluno aluno = null;
		boolean isSalvo = false;
		try {
			alunoService = new AlunoService();
			aluno = new Aluno();
			aluno.setNome(req.getParameter("nome"));
			aluno.setCpf(req.getParameter("cpf"));
			aluno.setRg(req.getParameter("rg"));
			aluno.setEmail(req.getParameter("email"));
			String sexo = req.getParameter("sexo");
			aluno.setSexo(!sexo.isEmpty() ? sexo.charAt(0) : ' ');
			String dataNascimento = req.getParameter("dataNascimento");
			aluno.setDataNascimento(!dataNascimento.isEmpty() ? LocalDate.parse(dataNascimento) : null);
			aluno.setCelular(req.getParameter("celular"));
			if (alunoService.salvar(aluno)) {
				isSalvo = true;
			}
		} catch (RegraNegocioException ex) {
			ex.printStackTrace();
		} finally {
			aluno = null;
			alunoService = null;
		}
		return isSalvo;
	}
}
