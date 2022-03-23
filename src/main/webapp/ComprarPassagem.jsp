<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="Passagem" method="post">
	
		Embarque: <input type="text" name="txtEmb"><br>
		Desembarque: <input type="text" name="txtDesem"><br>
		Preço: <input type="text" name="txtPreco"><br>
		<input type="submit" value="Comprar">
		<input type="reset" value="Limpar">
		
	</form>
	<br> <%@ include file = "ButaoHome.html" %>
</body>
</html>