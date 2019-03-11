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
@WebServlet("/alunocadastro")
public class AlunoCadastroController extends HttpServlet {

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
				if (doSalvarAluno(request, response)) {
					response.sendRedirect("alunoconsulta?acao=consulta");
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

	private boolean doSalvarAluno(HttpServletRequest req, HttpServletResponse resp) {
		AlunoService alunoService = null;
		Aluno aluno = null;
		boolean isSalvo = false;
		try {
			alunoService = new AlunoService();
			aluno = new Aluno();
			String idAluno = req.getParameter("idAluno");
			String idResp = req.getParameter("respID");
			aluno.setId(idAluno != "" ? Integer.parseInt(idAluno) : 0);
			aluno.setMatricula(req.getParameter("matricula"));
			aluno.setNome(req.getParameter("nome"));
			aluno.setCpf(req.getParameter("cpf"));
			aluno.setRg(req.getParameter("rg"));
			aluno.setEmail(req.getParameter("email"));
			String sexo = req.getParameter("sexo");
			aluno.setSexo(!sexo.isEmpty() ? sexo.charAt(0) : ' ');
			String dataNascimento = req.getParameter("dataNascimento");
			aluno.setDataNascimento(!dataNascimento.isEmpty() ? LocalDate.parse(dataNascimento) : null);
			aluno.setCelular(req.getParameter("celular"));
			aluno.getResponsavel().setId(idResp != "" ? Integer.parseInt(idResp) : 0);
			aluno.getResponsavel().setNome(req.getParameter("respNome"));
			aluno.getResponsavel().setEmail(req.getParameter("respEmail"));
			aluno.getResponsavel().setCelular(req.getParameter("respCelular"));
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
	
	private boolean doExcluir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isExcluiu = false;
		AlunoService alunoService = null;
		String idAluno = request.getParameter("idAluno");
		int id = Integer.parseInt((idAluno != null && !idAluno.isEmpty()) ? idAluno : "0" );
		try {
			alunoService = new AlunoService();
			
			if(alunoService.excluirPoId(id)) {
				isExcluiu = true;
			}
			
		}catch(RegraNegocioException e) {
			e.printStackTrace();
		}finally {
			alunoService = null;
			idAluno = null;
		}
		
		return isExcluiu;
	}

	private void doCarregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Aluno aluno = null;
		AlunoService alunoService = null;
		try {
			int id = Integer.parseInt(request.getParameter("idaluno"));
			alunoService = new AlunoService();
			aluno = alunoService.buscarPorId(id);
			if (aluno != null) {
				request.setAttribute("aluno", aluno);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/cadastro.jsp");
				dispatcher.forward(request, response);
			}
		} catch (RegraNegocioException e) {
			e.printStackTrace();
		} finally {
			alunoService = null;
		}
	}
}
