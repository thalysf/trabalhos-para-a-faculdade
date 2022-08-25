<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locadora - Diretores</title>
<style>
#primary-title{
	text-align: center;
	font-size: 3em;
}
#atores {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-bottom: 5px;
}

#atores td, #atores th {
  border: 1px solid #ddd;
  padding: 8px;
}

#atores tr:nth-child(even){background-color: #f2f2f2;}

#atores tr:hover {background-color: #ddd;}

#atores th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
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

.btn-voltar:hover, .btn-voltar:active {
  background-color: #3bff8d;
}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
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
</style>
<link rel="shortcut icon" href="https://pt.seaicons.com/wp-content/uploads/2015/10/movie-folded-icon.png" />
</head>
<body>
   <h3>Resultado da última operação realizada: <b style="color: ${cor}">${mensagem}</b></h3>

<div>
  <form action="DiretorManterController" method="POST">
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" placeholder="Nome do diretor...">

    <input type="submit" value="Salvar">
  </form>

</div>
<h2>Diretores Cadastrados</h2>
<table id="atores">
  <tr>
    <th>Nome</th>
  </tr>
  <c:forEach items="${diretores}" var="diretor">	
    <tr>
      <td>${diretor.nome}</td>
    </tr>
  </c:forEach>
  </table>



  <a href="index.jsp" class="btn-voltar">Voltar</a>
</body>
</html>