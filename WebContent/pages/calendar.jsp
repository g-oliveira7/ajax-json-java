<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendário</title>
<link rel="stylesheet" href="../styles/jQueryFullCalendar.css" />
<script src="../scripts/jQuery.js"></script>
<script src="../scripts/jQueryFullCalendar.js"></script>
<style>
#calendar {
	width: 50%;
	margin: auto
}
</style>
</head>
<body>
	<h1 align="center" style="font-family: arial, sans-serif">Calendário</h1>
	<div id="calendar" style="font-family: arial, sans-serif"></div>

	<script>
		$.get("eventsCalendar", function(resp) {
			
			let datas = JSON.parse(resp);
			
				let elCalendar = $("#calendar")[0];
				let calendar = new FullCalendar.Calendar(elCalendar, {
					headerToolbar : {
						left : "dayGridMonth,dayGridWeek,dayGridDay",
						center : "title",
						right : "prev,next today"
					},
					events : datas
				}); // Fim variavel-calendar
				calendar.render();
		}); // Fim Get-Request-Ajax
	</script>
</body>
</html>