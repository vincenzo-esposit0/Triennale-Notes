/**
 * 
 */
$(document).ready(function() {
	
	$.getJSON("DisplayProdotti", function (object, status){
		for(x in object){
			var option = $("<option>" + object[x].titolo + "</option>");
  			$(".select").append(option);
  				}
  			})
  			
  	$.getJSON("TableUser", function (object, status){
  		var a = 0;
		for(x in object){
			
			var x = "<tr> <form action=\"RemoveUser\" method=\"post\" id=\""+ a +"\"></form>" +
					"<td>" + object[x].titolo + " <input type=\"hidden\" form=\""+ a +"\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>" +
			"<td>" + object[x].volume + " <input type=\"hidden\" form=\""+ a +"\" value=\""+ object[x].volume + "\"/> </td>" +
			"<td> <input type=\"image\" form=\""+ a +"\" src=\"Css/img_css/x.png\" alt=\"Logo\" class=\"x\"> </td></tr>";
				
			$(".tbody").append(x);
			a++;
				}	
			})	
			
	  	$.getJSON("OrderUser", function (object, status){
	  		
	  		for(x in object){
			
	  			var x = "<tr><td>" + object[x].idordine + " </td><td>" + object[x].titolo + " </td><td>" + object[x].volume + " </td><td>" + object[x].data + " </td><td>" + (object[x].prezzo * object[x].volume)  + " </td></tr>"

	  			$(".tbody_order").append(x);
			}	
		})
})



