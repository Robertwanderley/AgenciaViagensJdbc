<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Embarque</th>
				<th>Desembarque</th>
				<th>Preco</th>
				<th>Id Cliente</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${passagens}" var="passagem">
				<tr>
					<td>${passagem.idPass}</td> 
					<td>${passagem.embarque}</td>
					<td>${passagem.desembarque}</td>
					<td>${passagem.preco}</td> 
					<td>${passagem.idCliente}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br> <%@ include file = "ButaoHome.html" %>
</body>
</html>