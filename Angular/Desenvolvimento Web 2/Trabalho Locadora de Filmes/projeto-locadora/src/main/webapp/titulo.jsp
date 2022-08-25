<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Locadora - Titulos</title>
	<style>
	.table {
	  font-family: Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	  margin-bottom: 5px;
	  text-align:center;
	}

	.table td, .table th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}
	
	.table tr:nth-child(even){background-color: #f2f2f2;}
	
	.table tr:hover {background-color: #ddd;}
	
	.table th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  background-color: #04AA6D;
	  color: white;
	}
	.btn-voltar:link, .btn-voltar:visited {
	  background-color: #6cfaa7;
	  color: white;
	  padding: 14px 25px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	}
.btn-voltar:link, .btn-voltar:visited {
  background-color: #6cfaa7;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

.btn-voltar:hover, .btn-voltar:active {
  background-color: #3bff8d;
}
input, select, textarea {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
select{
	cursor: pointer;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 15%;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input[type=checkbox] {
        position: relative;
	    cursor: pointer;
		width: 20px;
		height: 20px;
}
textarea{
	height: 100px;
	resize: none;
	outline:none;
}
input#idTitulo::placeholder{
	color: red;
}
i{
  color: rgba(255, 0, 0, 0.7);
  font-size: 20px;
}
i:hover{
  color: rgba(255, 0, 0, 1);
}
</style>
<script src="https://kit.fontawesome.com/d0aebddfaf.js" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="https://pt.seaicons.com/wp-content/uploads/2015/10/movie-folded-icon.png" />
</head>
<body>
   <h3>Resultado da última operação realizada: <b style="color: ${cor}">${mensagem}</b></h3>

<div>
	<form action="TituloManterController" method="POST">
	<label>ID:</label><br>
	 <input type="number" name="idTitulo" placeholder="Only for update" id="idTitulo"><br><br>
	 
	 <label>Nome:</label><br>
	 <input type="text" name="nome" placeholder="Nome do título..."><br><br>

	 <label>Ano:</label><br>
	 <input type="number" name="ano" placeholder="Ano de lançamento do título..."><br><br>

	 <label>Sinopse:</label><br>
	 <textarea  type="text" name="sinopse" id="sinopse" placeholder="Sinopse do titulo..."></textarea><br><br>

	 <label>Categoria:</label><br>
	 <input type="text" name="categoria" placeholder="Categoria do título..."><br><br>
	 
	 <label>Diretor:</label><br>
	 <select name="idDiretor" id="selectDiretor">
		 <c:forEach items="${diretores}" var="diretor">	
			   <option value="${diretor.idDiretor}">${diretor.nome}</option>
		 </c:forEach>
	 </select>
	 
	 <br><br>
	 
	 <label>Classe:</label><br>
	 <select name="idClasse" id="selectClasse">
		 <c:forEach items="${classes}" var="classe">	
			   <option value="${classe.idClasse}">${classe.nome}</option>
		 </c:forEach>
	 </select>
	 
	 <br><br>
	 
	 <label>Atores:</label><br>
	 <table class="table">
	   <tr>
		 <th>Nome</th>
		 <th>Ação</th>
	   </tr>
	   <c:forEach items="${atores}" var="ator" varStatus="loop">	
		   <tr>
			   <td>${ator.nome}</td>
			   <td>
				   <input type="checkbox" name="ator${loop.index}" value="${ator.idAtor}">
			   </td>
		   </tr>
	   </c:forEach>
	 </table>
	 <input type="submit" value="Salvar">
	</form>
</div>
<h2>Titulos Cadastrados</h2>
	<table class="table">
		<tr>
		  <th>ID</th>
		  <th>Nome</th>
		  <th>Ano</th>
		  <th>Categoria</th>
		  <th>Classe</th>
		  <th>Diretor</th>
		  <th>Ação</th>
		</tr>
		<c:forEach items="${titulos}" var="titulo">	
			<tr>
				<td>${titulo.idTitulo}</td>
				<td>${titulo.nome}</td>
				<td>${titulo.ano}</td>
				<td>${titulo.categoria}</td>
				<td>${titulo.classe.nome}</td>
				<td>${titulo.diretor.nome}</td>
				<td>
					<a href="<%=request.getContextPath()%>/TituloDeletarController?idTitulo=${titulo.idTitulo}"><i class="fas fa-trash-alt"></i></a>
				</td>
			</tr>
		</c:forEach>
	  </table>



  <a href="index.jsp" class="btn-voltar">Voltar</a>
</body>
</html>