<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
		<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.13.5/dist/bootstrap-table.min.css">
		
		<title>Cadastro de aluno</title>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #000051">
		  <a class="navbar-brand text-white" href="#">WebAcademy</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav">
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Aluno
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          <a class="dropdown-item text-primary" href="#">Cadastro</a>
		          <a class="dropdown-item text-primary" href="#">Consulta</a>
		        </div>
		      </li>
		       <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Turma
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          <a class="dropdown-item text-primary" href="#">Cadastro</a>
		          <a class="dropdown-item text-primary" href="#">Consulta</a>
		        </div>
		      </li>
		      
		       <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Curso
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          <a class="dropdown-item text-primary" href="#">Cadastro</a>
		          <a class="dropdown-item text-primary" href="#">Consulta</a>
		        </div>
		      </li>
		      
		    </ul>
		  </div>
		</nav>
		
		<div class="container-fluid">
			
			<div class="card"> 
			  <div  style="background-color: #1a237e; height: 5px;">
			  </div>
			  <div style="margin-bottom: 5px; margin-top: 5px;">
			  	  
			  	  <div class="container-fluid">
					  <div class="row">
					    	<div class="col-md-2">
					    		<span>Consulta de alunos</span>
					    	</div>
					    	<div class="col-md-2 offset-md-8">
					    		<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/aluno/cadastro.jsp">
					    			<i class="fas fa-save"></i> Novo Aluno
					    		</a>
					    	</div>
					    </div>
				    </div>
			  </div>
			</div>
			<div style="margin-top: 10px;">
				<table data-toggle="table"
					    data-show-columns="true"
					   class="table-striped table-sm">
					<thead class="text-white" style="background-color: #18227c" >
						<tr>
							<th>Ação</th>
							<th>ID</th>
				        	<th>Nome</th>
				        	<th>Email</th>
				        	<th>Matrícula</th>
				        	<th>Responsável</th>
				        </tr>
					</thead>
					<tbody>
						<c:forEach var="aluno" items="${alunos}">
							<tr>
							  <td style="text-align: center;">
							  	<a style="margin-left: 10px; margin-right: 10px;" href="<%=request.getContextPath()%>/alunocadastro?acao=arquivoMat&idaluno=${aluno.id}" 
					          	   title="Matrícula">
					          		<i class="fas fa-file-alt"></i>
					          	</a>
					          	<a style="margin-left: 10px; margin-right: 10px;" href="<%=request.getContextPath()%>/alunocadastro?acao=editar&idaluno=${aluno.id}"
					          	   title="Editar">
					          		<i class="fas fa-edit"></i>
					          	</a>
					          	<a style="margin-left: 10px; margin-right: 10px;" href="<%=request.getContextPath()%>/alunocadastro?acao=excluir&idaluno=${aluno.id}" 
					          	   title="Excluir">
					          		<i class="fas fa-user-times"></i>
					          	</a>
					          </td>
					          <td>${aluno.id}</td>
					          <td>${aluno.nome}</td>
					          <td>${aluno.email}</td>
					          <td>${aluno.matricula}</td>
					          <td>${aluno.responsavel.nome}</td>
					        </tr>
				        </c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script src="https://unpkg.com/bootstrap-table@1.13.5/dist/bootstrap-table.min.js"></script>
	</body>
</html>