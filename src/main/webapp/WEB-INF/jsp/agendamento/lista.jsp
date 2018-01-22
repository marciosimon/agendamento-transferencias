<%@ page language="java" contentType="text/html; 
  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Sistema de Agendamento de Transferencias</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
</head>
<body>
	<h2>Lista de Agendamentos</h2>
	<hr />
	<a href="/agendamento/">Home</a> | <a href="/agendamento/agendamentos/new/">Adicionar Agendamento</a><br><br>

	<c:if test="${empty pattern}">
	    <c:set var="pattern" value="MM/dd/yyyy"/>
	</c:if>
	<table class="table table-sm">
		<thead>
			<tr>
				<th>Id</th>
				<th>Conta de Origem</th>
				<th>Conta de Destino</th>
				<th>Valor</th>
				<th>Taxa</th>
				<th>Data Transferência</th>
				<th>Data Agendamento</th>
				<th colspan="2">Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="agendamento" items="${agendamentos}">
				<tr>
					<td>${agendamento.id}</td>
					<td>${agendamento.contaOrigem.numero} - ${agendamento.contaOrigem.cliente.nome}</td>
					<td>${agendamento.contaDestino.numero} - ${agendamento.contaDestino.cliente.nome}</td>
					<td align="right"><fmt:formatNumber value="${agendamento.valor}" type="currency" /></td> 
					<td align="right"><fmt:formatNumber value="${agendamento.taxa / 100}" type="percent" maxFractionDigits="2" maxIntegerDigits="2" /></td> 
					<td align="center"> 
						<fmt:parseDate value="${agendamento.dataTransferencia}" pattern="yyyy-MM-dd" var="parsedDateTransferencia" type="both" />
						<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDateTransferencia}" />
					</td> 
					<td align="center">
						<fmt:parseDate value="${agendamento.dataAgendamento}" pattern="yyyy-MM-dd" var="parsedDateAgendamento" type="both" />
						<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDateAgendamento}" />
					</td>
					<td><a href="/agendamento/agendamentos/edit/${agendamento.id}">Editar</a> 
					<td><a href="/agendamento/agendamentos/delete/${agendamento.id}">Excluir</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
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