/**
 * 
 */

$(document).ready(function () {
	$.getJSON("PrintOrderView", function (object, status){

		for(x in object){
			
  			var x = "<tr><td>" + object[x].idordine + " </td><td>" + object[x].titolo + " </td><td>" + object[x].volume + " </td><td>" + object[x].username + " </td><td>" + object[x].data + " </td><td>" + object[x].prezzo + " </td></tr>"
 
				
			$(".tbodyOrder").append(x);
		}	
	})

})