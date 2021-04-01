<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Table</title>
<link rel="stylesheet" href="../styles/jQueryDataTable.css"/>
<script src="../scripts/jQuery.js"></script>
<script src="../scripts/jQueryDataTable.js"></script>
</head>
<body>
	<div style="
position: relative; 
width: 50%;
margin: auto;
font-family: Arial, sans-serif">
		<h1>Data Table</h1>
		<table id="myTable" class="display">
    <thead>
        <tr>
            <th style="width: 100px">Id</th>
            <th>Usuário</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td style="text-align: center">1</td>
            <td>Usuário 1</td>
        </tr>
    </tbody>
</table>
</div>
	<script>
		$(document).ready(function() {
			$("#myTable").DataTable({
				"language": {
					"url": "//cdn.datatables.net/plug-ins/1.10.24/i18n/Portuguese-Brasil.json"
				}
			});
		});
	</script>
</body>
</html>