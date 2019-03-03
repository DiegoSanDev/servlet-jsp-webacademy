package br.com.ps.webacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ps.webacademy.service.AlunoService;

@SuppressWarnings("serial")
@WebServlet("/alunoconsulta")
public class AlunoConsultaController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("alunos", new AlunoService().todos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/aluno/consulta.jsp");
		dispatcher.forward(req, resp);
		
	}

}
