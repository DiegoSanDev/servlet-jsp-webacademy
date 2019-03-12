package br.com.ps.webacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ps.webacademy.beans.Curso;
import br.com.ps.webacademy.exception.RegraNegocioException;
import br.com.ps.webacademy.service.CursoService;

@SuppressWarnings("serial")
@WebServlet("/curso-cadastro")
public class CursoCadastroController extends HttpServlet {

	private final static String SALVAR = "salvar";
	private final static String EDITAR = "editar";
	private final static String EXCLUIR = "excluir";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processaRequisicao(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processaRequisicao(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processaRequisicao(req, resp);
	}

	private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && !acao.isEmpty()) {
			switch (acao) {
			case SALVAR:
				if (doSalvar(request, response)) {
					response.sendRedirect("curso-consulta?acao=consulta");
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/erro-cadastro.jsp");
					dispatcher.forward(request, response);
				}
				break;
			case EDITAR:
				this.doCarregar(request, response);
				break;
			case EXCLUIR:
				doExcluir(request, response);
				break;
			}
		}

	}

	private boolean doSalvar(HttpServletRequest req, HttpServletResponse resp) {
		CursoService cursoService = null;
		Curso curso = null;
		boolean isSalvo = false;
		try {
			cursoService = new CursoService();
			curso = new Curso();
			String idAluno = req.getParameter("idCurso");
			curso.setId((idAluno == null || idAluno.isEmpty() ? 0 : Integer.parseInt(idAluno)));
			curso.setNome(req.getParameter("nome"));
			curso.setDescricao(req.getParameter("descricao"));
			if (cursoService.salvar(curso)) {
				isSalvo = true;
			}

		} catch (RegraNegocioException ex) {
			ex.printStackTrace();
		} finally {
		}
		return isSalvo;
	}

	private boolean doExcluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isExcluiu = false;
		CursoService cursoService = null;
		String idCurso = request.getParameter("idCurso");
		int id = Integer.parseInt((idCurso != null && !idCurso.isEmpty()) ? idCurso : "0");
		try {
			cursoService = new CursoService();

			if (cursoService.excluirPoId(id)) {
				isExcluiu = true;
			}

		} catch (RegraNegocioException e) {
			e.printStackTrace();
		} finally {
			cursoService = null;
			idCurso = null;
		}

		return isExcluiu;
	}

	private void doCarregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Curso curso = null;
		CursoService cursoService = null;
		try {
			int id = Integer.parseInt(request.getParameter("idcurso"));
			cursoService = new CursoService();
			curso = cursoService.buscarPorId(id);
			if (curso != null) {
				request.setAttribute("curso", curso);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/curso/cadastro.jsp");
				dispatcher.forward(request, response);
			}
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		} finally {
			cursoService = null;
		}
	}
}
