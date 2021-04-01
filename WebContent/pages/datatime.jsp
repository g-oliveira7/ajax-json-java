<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datas</title>
<link rel="stylesheet" href="../styles/jQueryUiThemes.css" />
<script src="../scripts/jQuery.js"></script>
<script src="../scripts/jQueryUi.js"></script>
</head>
<body>
	<h1>Trabalhando com datas</h1>
	<form action="date-calc" method="post">
		<table>
			<thead style="text-align: center; font-weight: bold">
				<tr>
					<td>Data
					<td>Tempo em horas
			<tbody style="text-align: right; font-weight: bold">
				<tr>
					<td><input id="date" name="date" />
					<td><input id="hours" type="number" step="0.01" name="hours" />
				<tr>
					<td>
					<td><input type="submit" class="ui-button ui-widget ui-corner-all" value="Calcular"/>
				<tr>
					<td><label>Resultado</label>
					<td><input readonly value="${result}" />
			</tbody>
		</table>
	</form>

	<script>
		jQuery(function($) {
			$.datepicker.regional['pt-BR'] = {
				closeText : 'Fechar',
				prevText : '&#x3c;Anterior',
				nextText : 'Pr&oacute;ximo&#x3e;',
				currentText : 'Hoje',
				monthNames : [ 'Janeiro', 'Fevereiro', 'Mar&ccedil;o', 'Abril',
						'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
						'Outubro', 'Novembro', 'Dezembro' ],
				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun',
						'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
				dayNames : [ 'Domingo', 'Segunda-feira', 'Ter&ccedil;a-feira',
						'Quarta-feira', 'Quinta-feira', 'Sexta-feira', 'Sabado' ],
				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
						'Sab' ],
				dayNamesMin : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
				weekHeader : 'Semana',
				dateFormat : 'dd/mm/yy',
				firstDay : 1,
				isRTL : false,
				showMonthAfterYear : false,
				yearSuffix : ''
			};
			$.datepicker.setDefaults($.datepicker.regional['pt-BR']);
		});

		$(function() {
			$("#date").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	</script>
</body>
</html>