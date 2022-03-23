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
				<th>Celular</th>
				<th>Telefone</th>
				<th>ID Cliente</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${telefones}" var="telefone">
				<tr>
					<td>${telefone.idTel}</td> 
					<td>${telefone.celular}</td>
					<td>${telefone.fixo}</td>
					<td>${telefone.idCliente}</td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br> <%@ include file = "ButaoHome.html" %>
</body>
</html>