<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
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
					    		<a class="btn btn-primary btn-sm" href="#">
					    			Consulta
					    		</a>
					    	</div>
					    </div>
				    </div>
			  </div>
			</div>
			
			<form>
			  <div class="form-row">
			    <div class="form-group col-md-8">
			      <label for="nome" class="col-form-label col-form-label-sm" >Nome:</label>
			      <input type="text" class="form-control form-control-sm" id="nome" name="nome" >
			    </div>
			    <div class="form-group col-md-2">
			      <label for="cpf" class="col-form-label col-form-label-sm" >CPF:</label>
			      <input type="text" class="form-control form-control-sm	" id="cpf" name="cpf" placeholder="000.000.000-00">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="rg" class="col-form-label col-form-label-sm" >RG:</label>
			      <input type="text" class="form-control form-control-sm" id="rg" name="rg">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-8">
			      <label for="email" class="col-form-label col-form-label-sm" >Email:</label>
			      <input type="email" class="form-control form-control-sm" id="email" name="email" >
			    </div>
			    <div class="form-group col-md-2">
			      <label for="dataNascimento" class="col-form-label col-form-label-sm" >Data de nascimento:</label>
			      <input type="date" class="form-control form-control-sm" id="dataNascimento" name="dataNascimento">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="sexo" class="col-form-label col-form-label-sm">Sexo</label>
			      <select id="sexo" name="sexo" class="form-control form-control-sm">
			        <option selected>Selecione...</option>
			        <option value="M" >Masculino</option>
			        <option value="F" >Feminino</option>
			      </select>
			    </div>
			  </div>
			  <button type="submit" class="btn btn-primary">Salvar</button>
			</form>
			
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>