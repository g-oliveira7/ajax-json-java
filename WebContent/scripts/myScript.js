function test() {

	$.ajax({
		method: "post",
		url: "../exceptions",
		data: { element: $("#my-input").val() }
	})
		.always(function(resp) {
			alert(resp);
		});
}

function load() {
	$('#daugther-page').load('daugther-page.jsp');
}

function startBarJS() {
	let bar = document.getElementById("progress-bar");
	let int = setInterval(increment, 100); //setInterval(A, B) -> executa A de B em B ms (milisegundos); 
	let w = 1;

	function increment() {
		if (w >= 100) {
			clearInterval(int);
		} else {
			++w;
			bar.style.width = w + "%";
		}
	}
}

$(function() {
	let bar = $("#progressbar"), label = $(".progress-label");

	bar.progressbar({
		value: false,
		change: function() {
			label.text(bar.progressbar("value") + "%");
		},
		complete: function() {
			label.text("Completo!");
		}
	});

	function progress() {
		let val = bar.progressbar("value") || 0;

		bar.progressbar("value", val + 2);

		if (val <= 99) {
			setTimeout(progress, 80);
		}
	}
	setTimeout(progress, 200);
});

function uploadFile() {
	let file = document.querySelector("#upload").files[0];
	let target = document.querySelector("img");
	let r = new FileReader();

	r.onloadend = function() {
		target.src = r.result;
		
		$.ajax({
			method: "post",
			url: "../upload",
			data: { uploadFile: target.src }
		})
			.done(function(resp) {
				alert('Sucesso' + resp);
			})
			.fail(function(xhr) {
				alert('Error' + xhr.responseText);
			});
	}

	if (file) {
		r.readAsDataURL(file);
	} else {
		target.src = "";
	}
}