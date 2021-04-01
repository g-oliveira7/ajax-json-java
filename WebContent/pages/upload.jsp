<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Image upload</title>
<script src="../scripts/jQuery.js"></script>
</head>
<body>
	<h1>Image Upload</h1>
	<input id="upload" name="upload" type="file" onchange="uploadFile();"/>
	<img id="image" alt="Image" width="200px" height="200px"/>
	
	<script src="../scripts/myScript.js"></script>
</body>
</html>