package br.com.ps.webacademy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ps.webacademy.beans.Aluno;
import br.com.ps.webacademy.filtro.AlunoFiltro;
import br.com.ps.webacademy.service.AlunoService;
import br.com.ps.webacademy.service.CursoService;

@SuppressWarnings("serial")
@WebServlet("/curso-consulta")
public class CursoConsultaController extends HttpServlet {

	private static final String CONSULTA = "consulta";
	private static final String PESQUISA = "pesquisa";

	private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		if (acao != null && !acao.isEmpty()) {
			switch (acao) {
			case CONSULTA:
				request.setAttribute("cursos", new CursoService().todos());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/curso/consulta.jsp");
				dispatcher.forward(request, response);
				break;
			case PESQUISA:
				AlunoService alunoService = null;
				AlunoFiltro alunoFiltro = null;
				try {
					alunoFiltro = new AlunoFiltro();
					alunoService = new AlunoService();
					String id = request.getParameter("idPesquisa");
					alunoFiltro.setId((id==null || id.isEmpty()) ? 0 : Integer.parseInt(id));
					alunoFiltro.setNome(request.getParameter("nomePesquisa"));
					alunoFiltro.setMatricula(request.getParameter("matriculaPesquisa"));
					alunoFiltro.setEmail(request.getParameter("emailPesquisa"));
					String dataInicio = request.getParameter("dataInicioPesquisa");
					String dataFim = request.getParameter("dataFimPesquisa");
					alunoFiltro.setDataInicio((dataInicio == null ||dataInicio.equals(""))? null : LocalDate.parse(dataInicio));
					alunoFiltro.setDataFim((dataFim == null ||dataFim.equals(""))? null : LocalDate.parse(dataFim));
					List<Aluno> alunos = alunoService.pesquisar(alunoFiltro);
					request.setAttribute("alunos", alunos);
					RequestDispatcher dispatcherPesquisa = request.getRequestDispatcher("/aluno/consulta.jsp");
					dispatcherPesquisa.forward(request, response);
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					alunoService = null;
				}
				break;
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processaRequisicao(req, resp);
	}
}
