<%@ page language="java" contentType="text/html; 
  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Sistema de Agendamento de Transferencias</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
	<h2>Lista de Clientes</h2>
	<hr />
	<a href="/agendamento/">Home</a> |
	<a href="/agendamento/clientes/new/">Adicionar Cliente</a>
	<br>
	<br>
	<table class="table table-sm">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th colspan="2">Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td><a href="/agendamento/clientes/edit/${cliente.id}">Editar</a>
					<td><a href="/agendamento/clientes/delete/${cliente.id}">Excluir</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>	  
</body>
</html>