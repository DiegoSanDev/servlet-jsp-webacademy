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
			     <p>
				   <button class="btn btn-primary btn-sm" type="button" 
				   		   data-toggle="collapse" data-target="#collapseExample" id="btn-filtro"
				   		   aria-expanded="false" aria-controls="collapseExample" onclick="exibirOuOcultaFiltros()">
				     <i class="fas fa-filter"></i> <span id="nomeBtn" >Exibir filtros</span> 
				   </button>
				  </p>
				  <div class="collapse" id="collapseExample">
				    <div class="card card-body">
						  <div class="form-row">
						  	<div class="form-group col-md-1">
						  		<label for="idPesquisa" class="col-form-label col-form-label-sm" >ID:</label>
				      			<input type="text" class="form-control form-control-sm" id="idPesquisa" name="idPesquisa">
						    </div>
						    <div class="form-group col-md-3">
						  		<label for="matriculaPesquisa" class="col-form-label col-form-label-sm" >Matrícula:</label>
				      			<input type="text" class="form-control form-control-sm" id="matriculaPesquisa" name="matriculaPesquisa">
						    </div>
						  	<div class="form-group col-md-4">
						  		<label for="nomePesquisa" class="col-form-label col-form-label-sm" >Nome:</label>
				      			<input type="text" class="form-control form-control-sm" id="nomePesquisa" name="nomePesquisa">
						    </div>
						    <div class="form-group col-md-4">
						      	<label for="emailPesquisa" class="col-form-label col-form-label-sm" >E-mail:</label>
				      		 	<input type="email" class="form-control form-control-sm" id="emailPesquisa" name="emailPesquisa">
						    </div>
						  </div>
						  <div class="form-row">
						  	<div class="form-group col-md-3">
						  		<label for="dataInicioPesquisa" class="col-form-label col-form-label-sm" >Data inicio:</label>
				      			<input type="date" class="form-control form-control-sm" id="dataInicioPesquisa" name="dataInicioPesquisa">
						    </div>
						    <div class="form-group col-md-3">
						  		<label for="dataInicioPesquisa" class="col-form-label col-form-label-sm" >Data fim:</label>
				      			<input type="date" class="form-control form-control-sm" id="dataFimPesquisa" name="dataFimPesquisa">
						    </div>
						  </div>
					    	<button type="button" onclick="pesquisar()" class="btn btn-primary btn-sm">
					   			<i class="fas fa-search"></i> Pesquisar
					   		</button>
				    </div> 
				  </div>
			  </div>
			<div id="alunoLista"></div>
			<div style="margin-top: 10px;">
				<table  data-toggle="table"
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
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="https://unpkg.com/bootstrap-table@1.13.5/dist/bootstrap-table.min.js"></script>
		
		<script type="text/javascript">

			function pesquisar(){
				/*filtros*/
				let id = $("#idPesquisa").val();
				let nome = $("#nomePesquisa").val();
				let email = $("#emailPesquisa").val();
				let matricula = $("#matriculaPesquisa").val();
				let dataInicio = $("#dataInicioPesquisa").val();
				let dataFim = $("#dataFimPesquisa").val();
				let param = "idPesquisa="+id+"&nomePesquisa="+nome+"&emailPesquisa="+email+"&matriculaPesquisa="+matricula;
				param +="&dataInicioPesquisa="+dataInicio+"&dataFimPesquisa="+dataFim;
				/*requisição*/
				document.location.replace("./alunoconsulta?acao=pesquisa&"+param);
				
			}
		
			function exibirOuOcultaFiltros(){
				var isOcultar = document.getElementById('btn-filtro').getAttribute('aria-expanded');
				$("#nomeBtn").text(isOcultar == 'false' ? "Ocultar filtros" : "Exibir filtros");
			}
		</script>
	</body>
</html>