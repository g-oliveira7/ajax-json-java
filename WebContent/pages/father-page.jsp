<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main page</title>
<script src="../scripts/jQuery.js"></script>
</head>
<body>
	<h1>Página pai</h1>
	<p>Conteúdo</p>
	<button type="button" onclick="load();">Carregar página filha</button>
	
	<div id="daugther-page"></div> <!-- Where loads daugther page -->
	<script src="../scripts/myScript.js"></script>
</body>
</html>