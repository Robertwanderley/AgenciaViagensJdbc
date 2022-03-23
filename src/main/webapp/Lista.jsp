<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Email</th>
				<th>CPF</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.idCliente}</td> 
					<td>${cliente.nome}</td>
					<td>${cliente.sobrenome}</td>
					<td>${cliente.email}</td> 
					<td>${cliente.cpf}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br> <%@ include file = "ButaoHome.html" %>
</body>
</html>