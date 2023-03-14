	/**
 * Script per la scelta random delle cover dei prodotti da visulizzare nella home
 */

$(document).ready(function (){		
	$.getJSON("DisplayProdotti", function (object, status){
		
		Object.size = function(obj) {
		    var size = 0, key;
		    for (key in obj) {
		        if (obj.hasOwnProperty(key)) size++;
		    }
		    return size;
		};

		// Get the size of an object
		var size = Object.size(object);
		
		console.log(size)
		
		function indexOfRandom(n){
			var index = [];
			while(index.length != n){
				var rnd = Math.floor(Math.random() * size ) ;
				if(index.indexOf(rnd) == -1) 
					index.push(rnd);
			}
			return index;
		}
		
		random = indexOfRandom(24);
		
		var num = 0;
		for(x in random){
			var rnd = random[x];
			var single_object = object[rnd];
			
			var card = $(
					"<div class=\"card\">" +
                        "<img class=\"card_image\" src=" + single_object.path +">" +
                        "<form action=\"AddToCart\" method=\"post\" id=\"cartForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"cartForm_"+ num +"\" name=\"id\" value=\"" + single_object.idprodotto + "\">" +
						"<div>" +
							"<h3>" + single_object.titolo + "</h3>" +
							"<p> Prezzo: " + single_object.prezzo + "BR;</p>" +
							"<p> Piattaforma: " + single_object.piattaforma + "</p>" +
							"<p> Genere: " + single_object.genere + "</p>" +
							"<p> Disponibili: "+ single_object.volume +"<p>"+
						"<\div>" +
					"<\div>"+
					"<input class=\"button_car\" form=\"cartForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"
					);

			$(".products").append(card);	
			num++;
		}
	})
})