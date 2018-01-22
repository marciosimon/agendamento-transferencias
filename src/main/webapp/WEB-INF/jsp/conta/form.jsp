<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema de Agendamento de Transferencias</title>
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Cadastro de Conta</h2>
    <hr>
    <div>
		<spring:url value="/agendamento/" var="home"/>
		<a href="${home}">Home</a> | <a href="/agendamento/contas/">Lista de Contas</a><br><br>
    </div>
    <div>
        <form:form modelAttribute="conta" action="/agendamento/contas/save" method="post">
        	<form:hidden path="id"/>
			<div class="form-group row">
			  <label for="numero" class="col-2 col-form-label">Numero</label>
			  <div class="col-5">
			  	<form:input path="numero" class="form-control" />
			  </div>
			  <div class="col-5">
				<form:errors path="numero" cssClass="label label-danger" />
			  </div>
			</div>
			<div class="form-group row">
			  <label for="cliente" class="col-2 col-form-label">Cliente</label>
			  <div class="col-5">
				<form:select path="cliente" class="form-control">
					<option value="">-- Escolha --</option>
					<c:forEach var="cliente" items="${clientes}">
						<option value="${cliente.id}" <c:if test = "${cliente.id == conta.cliente.id}"> selected="selected"</c:if>>${cliente.nome}</option>
					</c:forEach>
				</form:select>
			  </div>
			  <div class="col-5">
				<form:errors path="cliente" cssClass="label label-danger" />
			  </div>
			</div>
			<button type="submit" class="btn btn-primary">Confirmar</button>
        </form:form>
    </div>
</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>	  

</body>
</html>