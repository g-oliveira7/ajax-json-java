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
	<h1>P�gina pai</h1>
	<p>Conte�do</p>
	<button type="button" onclick="load();">Carregar p�gina filha</button>
	
	<div id="daugther-page"></div> <!-- Where loads daugther page -->
	<script src="../scripts/myScript.js"></script>
</body>
</html>