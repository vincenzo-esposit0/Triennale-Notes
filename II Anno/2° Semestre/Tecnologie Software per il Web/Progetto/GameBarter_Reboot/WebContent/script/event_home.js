/**
 * Eventi per la home
 */
$(document).ready(function (){
	
	$( ".fps" ).click(function() {
		$.getJSON("ProdottiSpecifici", {"val": "FPS"} , function (object, status){
			$(".card").remove();
			var num = 0;
			for(x in object){

				var single_object = object[x];
				
				var card = $(
						"<div class=\"card\">" +
	                        "<img class=\"card_image\" src=" + single_object.path +">" +
	                        "<form action=\"AddToCart\" method=\"post\" id=\"fpsForm_"+ num +"\"></form>" +
	                        "<input type=\"hidden\" form=\"fpsForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
							"<div>" +
								"<h3>" + single_object.titolo + "</h3>" +
								"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
								"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
								"<p> Genere: " + single_object.genere + "</p>" +
								"<p> Disponibili: "+ single_object.volume +"<p>"+
							"<\div>" +
						"<\div>"+
						"<input class=\"button_car\" form=\"fpsForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
						);

				$(".products").append(card);	
				num++;
			}
			
		})
	})
	
	$( ".tps" ).click(function() {
		$.getJSON("ProdottiSpecifici", {"val": "TPS"} , function (object, status){
			$(".card").remove();
			var num = 0;
			for(x in object){

				var single_object = object[x];
				
				var card = $(
						"<div class=\"card\">" +
	                        "<img class=\"card_image\" src=" + single_object.path +">" +
	                        "<form action=\"AddToCart\" method=\"post\" id=\"tpsForm_"+ num +"\"></form>" +
	                        "<input type=\"hidden\" form=\"tpsForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
							"<div>" +
								"<h3>" + single_object.titolo + "</h3>" +
								"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
								"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
								"<p> Genere: " + single_object.genere + "</p>" +
								"<p> Disponibili: "+ single_object.volume +"<p>"+
							"<\div>" +
						"<\div>"+
						"<input class=\"button_car\" form=\"tpsForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
						);

				$(".products").append(card);	
				num++;
			}
			
		})
	})
	
	$( ".sport" ).click(function() {
		$.getJSON("ProdottiSpecifici", {"val": "Sport"} , function (object, status){
			$(".card").remove();
			var num = 0;
			for(x in object){

				var single_object = object[x];
				
				var card = $(
						"<div class=\"card\">" +
	                        "<img class=\"card_image\" src=" + single_object.path +">" +
	                        "<form action=\"AddToCart\" method=\"post\" id=\"sportForm_"+ num +"\"></form>" +
	                        "<input type=\"hidden\" form=\"sportForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
							"<div>" +
								"<h3>" + single_object.titolo + "</h3>" +
								"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
								"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
								"<p> Genere: " + single_object.genere + "</p>" +
								"<p> Disponibili: "+ single_object.volume +"<p>"+
							"<\div>" +
						"<\div>"+
						"<input class=\"button_car\" form=\"sportForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
						);

				$(".products").append(card);	
				num++;
			}
			
		})
	})
	
	$( ".rpg" ).click(function() {
		$.getJSON("ProdottiSpecifici", {"val": "RPG"} , function (object, status){
			$(".card").remove();
			var num = 0;
			for(x in object){

				var single_object = object[x];
				
				var card = $(
						"<div class=\"card\">" +
	                        "<img class=\"card_image\" src=" + single_object.path +">" +
	                        "<form action=\"AddToCart\" method=\"post\" id=\"rpgForm_"+ num +"\"></form>" +
	                        "<input type=\"hidden\" form=\"rpgForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
							"<div>" +
								"<h3>" + single_object.titolo + "</h3>" +
								"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
								"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
								"<p> Genere: " + single_object.genere + "</p>" +
								"<p> Disponibili: "+ single_object.volume +"<p>"+
							"<\div>" +
						"<\div>"+
						"<input class=\"button_car\" form=\"rpgForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
						);

				$(".products").append(card);	
				num++;
			}
			
		})
	})
	
	$( ".all" ).click(function() {
		$.getJSON("DisplayProdotti", function (object, status){
			$(".card").remove();
			var num = 0;
			for(x in object){

				var single_object = object[x];
				
				var card = $(
						"<div class=\"card\">" +
	                        "<img class=\"card_image\" src=" + single_object.path +">" +
	                        "<form action=\"AddToCart\" method=\"post\" id=\"allForm_"+ num +"\"></form>" +
	                        "<input type=\"hidden\" form=\"allForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
							"<div>" +
								"<h3>" + single_object.titolo + "</h3>" +
								"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
								"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
								"<p> Genere: " + single_object.genere + "</p>" +
								"<p> Disponibili: "+ single_object.volume +"<p>"+
							"<\div>" +
						"<\div>"+
						"<input class=\"button_car\" form=\"allForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
						);

				$(".products").append(card);	
				num++;
			}
			
		})
	})
})
