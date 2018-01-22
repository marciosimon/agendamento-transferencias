<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Cadastro de Agendamento</h2>
		<hr>
		<div>
			<spring:url value="/agendamento/" var="home" />
			<a href="${home}">Home</a> | <a href="/agendamento/agendamentos/">Lista
				de Agendamento</a><br>
			<br>
		</div>
		<div>
			<form:form modelAttribute="agendamento"
				action="/agendamento/agendamentos/save" method="post">
				<form:hidden path="id" />
				<form:hidden path="dataAgendamento" />
				<form:hidden path="taxa" />

				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">
	  					<strong>Erro:</strong> ${error}.
					</div>
				</c:if>

				<div class="form-group row">
					<label for="contaOrigem" class="col-2 col-form-label">Conta
						Origem</label>
					<div class="col-5">
						<form:select path="contaOrigem" class="form-control">
							<option value="">-- Escolha --</option>
							<c:forEach var="conta" items="${contas}">
								<option value="${conta.id}"
									<c:if test = "${conta.id == agendamento.contaOrigem.id}"> selected="selected"</c:if>>${conta.numero}
									- ${conta.cliente.nome}</option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-5">
						<form:errors path="contaOrigem" cssClass="label label-danger" />
					</div>
				</div>
				<div class="form-group row">
					<label for="contaDestino" class="col-2 col-form-label">Conta
						de Destino</label>
					<div class="col-5">
						<form:select path="contaDestino" class="form-control">
							<option value="">-- Escolha --</option>
							<c:forEach var="conta" items="${contas}">
								<option value="${conta.id}"
									<c:if test = "${conta.id == agendamento.contaDestino.id}"> selected="selected"</c:if>>${conta.numero}
									- ${conta.cliente.nome}</option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-5">
						<form:errors path="contaDestino" cssClass="label label-danger" />
					</div>
				</div>
				<div class="form-group row">
					<label for="valor" class="col-2 col-form-label">Valor</label>
					<div class="col-5">
						<form:input path="valor" class="form-control" />
					</div>
					<div class="col-5">
						<form:errors path="valor" cssClass="label label-danger" />
					</div>
				</div>
				<div class="form-group row">
					<label for="dataTransferencia" class="col-2 col-form-label">Data Transferência</label>
					<div class="col-5">
						<form:input path="dataTransferencia" class="form-control" />
					</div>
					<div class="col-5">
						<form:errors path="dataTransferencia" cssClass="label label-danger" />
					</div>
				</div>
				<div class="form-group row">
					<label for="dataAgendamento" class="col-2 col-form-label">Data
						Agendamento</label>
					<div class="col-5">
						<form:input path="dataAgendamento" class="form-control"
							readonly="true" />
					</div>
					<div class="col-5">
						<form:errors path="dataAgendamento" cssClass="label label-danger" />
					</div>
				</div>
				<div class="form-group row">
					<label for="taxa" class="col-2 col-form-label">Taxa</label>
					<div class="col-5">
						<form:input path="taxa" class="form-control" readonly="true" />
					</div>
					<div class="col-5">
						<form:errors path="taxa" cssClass="label label-danger" />
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