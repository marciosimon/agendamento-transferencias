<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de Agendamento de Transferencias</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Cadastro de Cliente</h2>
		<hr>
		<div>
			<spring:url value="/agendamento/" var="home" />
			<a href="${home}">Home</a> | <a href="/agendamento/clientes/">Lista
				de Cliente</a><br>
			<br>
		</div>
		<div>
			<form:form modelAttribute="cliente"
				action="/agendamento/clientes/save" method="post">
				<form:hidden path="id" />
				
				<div class="form-group row">
				  <label for="nome" class="col-2 col-form-label">Nome</label>
				  <div class="col-5">
				  	<form:input path="nome" class="form-control" />
				  </div>
				  <div class="col-5">
					<form:errors path="nome" cssClass="label label-danger" />
				  </div>
				</div>				
				<div class="form-group row">
				  <label for="cpf" class="col-2 col-form-label">Cpf</label>
				  <div class="col-5">
				  	<form:input path="cpf" class="form-control" />
				  </div>
				  <div class="col-5">
					<form:errors path="cpf" cssClass="label label-danger" />
				  </div>
				</div>				
				<button type="submit" class="btn btn-primary">Confirmar</button>
			</form:form>
		</div>
	</div>
	
	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>
	
</body>
</html>