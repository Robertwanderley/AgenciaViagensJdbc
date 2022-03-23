<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Por favor, cadastre seu telefone para maior segurança</h2>

	<form action="Telefone" method="post">
	
		<!--IdCliente: <input type="text" name="txtId"><br>-->
		Celular: <input type="text" name="txtCel"><br>
		Fixo: <input type="text" name="txtFix"><br>
		<input type="submit" value="Cadastrar">
		<input type="reset" value="Limpar"><br>
		<br>	
	</form>
	<br> <%@ include file = "ButaoHome.html" %>

</body>
</html>