<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
		
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
					    		<span>Cadastro de aluno</span>
					    	</div>
					    	<div class="col-md-1 offset-md-9">
					    		<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/alunoconsulta">
					    			<i class="fas fa-list-ul"></i> Consulta
					    		</a>
					    	</div>
					    </div>
				    </div>
			  </div>
			</div>
			
			<form action="<%=request.getContextPath()%>/alunocadastro" method="POST">
			  <div class="form-row">
			  	<div class="form-group col-md-4">
			      <label for="matricula" class="col-form-label col-form-label-sm" >Matricula:</label>
			      <input type="text" class="form-control form-control-sm" readonly="readonly" 
			      		 id="matricula" name="matricula" placeholder="0000000000">
			    </div>
			    <div class="form-group col-md-8">
			      <label for="nome" class="col-form-label col-form-label-sm" >Nome:</label>
			      <input type="text" class="form-control form-control-sm" id="nome" name="nome" >
			    </div>
			  </div>
			  <div class="form-row">
			  	<div class="form-group col-md-2">
			      <label for="cpf" class="col-form-label col-form-label-sm" >CPF:</label>
			      <input type="text" class="form-control form-control-sm	" id="cpf" name="cpf" placeholder="000.000.000-00">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="rg" class="col-form-label col-form-label-sm" >RG:</label>
			      <input type="text" class="form-control form-control-sm" id="rg" name="rg">
			    </div>
			    <div class="form-group col-md-8">
			      <label for="email" class="col-form-label col-form-label-sm" >Email:</label>
			      <input type="email" class="form-control form-control-sm" id="email" name="email" >
			    </div>
			  </div>
			  <div class="form-row">
			  	<div class="form-group col-md-2">
			      <label for="dataNascimento" class="col-form-label col-form-label-sm" >Data de nascimento:</label>
			      <input type="date" class="form-control form-control-sm" id="dataNascimento" name="dataNascimento">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="sexo" class="col-form-label col-form-label-sm">Sexo:</label>
			      <select id="sexo" name="sexo" class="form-control form-control-sm">
			        <option value="" selected>Selecione...</option>
			        <option value="M" >Masculino</option>
			        <option value="F" >Feminino</option>
			      </select>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="celular" class="col-form-label col-form-label-sm" >Celular:</label>
			      <input type="tel" class="form-control form-control-sm" id="celular" name="celular">
			    </div>
			  </div>
			  
			  <ul class="nav nav-tabs" id="myTab" role="tablist">
				  <li class="nav-item">
				    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Responsável</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Endereço</a>
				  </li>
			  </ul>
			  <div class="tab-content" id="myTabContent">
			  <!-- RESPONSÁVEL -->
			   <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			   	  <div class="form-row">
				  	<div class="form-group col-md-5">
				      <label for="respNome" class="col-form-label col-form-label-sm" >Nome:</label>
				      <input type="text" class="form-control form-control-sm" 
				      		 id="respNome" name="respNome">
				    </div>
				    <div class="form-group col-md-5">
				      <label for="respEmail" class="col-form-label col-form-label-sm" >E-mail:</label>
				      <input type="email" class="form-control form-control-sm" id="respEmail" name="respEmail" >
				    </div>
				    <div class="form-group col-md-2">
				      <label for="respCelular" class="col-form-label col-form-label-sm" >Celular:</label>
				      <input type="tel" class="form-control form-control-sm" id="respCelular" name="respCelular" >
				    </div>
				  </div>
			   </div>
			   <!-- ENDEREÇO -->
			   <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
			   	  <div class="form-row">
			   	  	<div class="col-sm-3 my-1">
				      <label class="sr-only" for="cep">CEP</label>
				      <input type="text" class="form-control form-control-sm" id="cep" placeholder="CEP">
				    </div>
			   	  	<div class="col-auto my-1">
				      <button type="button" class="btn btn-primary btn-sm">
				      	<i class="fas fa-search"></i>
				      </button>
				    </div>
			   	  	
			   	  </div>
			   	  <div class="form-row">
				  	<div class="form-group col-md-6">
				      <label for="logradouro" class="col-form-label col-form-label-sm" >Logradouro:</label>
				      <input type="text" class="form-control form-control-sm" 
				      		 id="logradouro" name="logradouro">
				    </div>
				    <div class="form-group col-md-3">
				      <label for="bairro" class="col-form-label col-form-label-sm" >Bairro:</label>
				      <input type="text" class="form-control form-control-sm" id="bairro" name="bairro" >
				    </div>
				    <div class="form-group col-md-2">
				      <label for="cidade" class="col-form-label col-form-label-sm" >Cidade:</label>
				      <input type="text" class="form-control form-control-sm" id="cidade" name="cidade" >
				    </div>
				    <div class="form-group col-md-1">
				      <label for="uf" class="col-form-label col-form-label-sm" >UF</label>
				      <input type="text" class="form-control form-control-sm" id="uf" name="uf" >
				    </div>
				  </div>
				  <div class="form-row">
				  	<div class="form-group col-md-3">
				      <label for="numero" class="col-form-label col-form-label-sm" >Número:</label>
				      <input type="number" class="form-control form-control-sm" 
				      		 id="numero" name="numero">
				    </div>
				    <div class="form-group col-md-9">
				      <label for="comlemento" class="col-form-label col-form-label-sm" >Complemento:</label>
				      <input type="text" class="form-control form-control-sm" id="complemento" name="complemento" >
				    </div>
				  </div>
			   </div>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">
			  	<i class="fas fa-save"></i> Salvar
			  </button>
			  
			</form>
			
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>