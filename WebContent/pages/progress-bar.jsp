<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progresso</title>
<script src="../scripts/jQuery.js"></script>
<link rel="stylesheet" href="../styles/jQueryUiThemes.css" />
<script src="../scripts/jQuery.js"></script>
<script src="../scripts/jQueryUi.js"></script>
<style>
	#progress-bar-background {
		width: 50%;
		background-color: #ddd;
		border: 1px solid grey 
	}
	
	#progress-bar {
		position: relative;
		text-align: center;
		vertical-align: middle;
		width: 0%;
		height: 30px;
		background-color: #4caf50;
	}
	
	.ui-progressbar {
		position: relative		
	}
	
	.progress-label {
		position: absolute;
		left: 50%;
		top: 4px;
		font-weight: bolder;
		text-shadow: 0px 0px 5px #fff;
	}
	
</style>
</head>
<body>
	<h1>Exemplo com JavaScript</h1>
	<div id="progress-bar-background"><div id="progress-bar"></div></div> <!-- Barra de progresso -->
	<br>
	<button style="height:30px; border-radius: 5px" type="button" onclick="startBarJS();">Começar progresso</button>
	<script src="../scripts/myScript.js"></script>
	
	<h1>Exemplo com jQuery</h1>
	<div style="width: 50%" id="progressbar"><div class="progress-label">Carregando...</div></div> <!-- Barra de progresso com jQuery -->
</body>
</html>