<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
<jsp:useBean id="session_product" class="it.unisa.GameBarter.Model.Prodotto" ></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modifica</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="script/home.js"type="text/javascript"></script>
	<script src="script/event_home.js"type="text/javascript"></script>
	<script src="script/storicoordini.js"type="text/javascript"></script>
	
	<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
	<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="Css/modifica.css" type="text/css">
	<script>
	function printError(elemId, hintMsg) {
	    document.getElementById(elemId).innerHTML = hintMsg;
	}
	
	function validateForm() {
		
	    var titolo = document.modifyform.titolo.value;
	    var prezzo = document.modifyform.prezzo.value;
	    var piattaforma = document.modifyform.piattaforma.value;
	    var genere = document.modifyform.genere.value;
	    var anno = document.modifyform.anno.value;
	   
	    var titoloErr = prezzoErr = piattaformaErr = genereErr = annoErr = true;
	    
		//titolo
	    if(titolo == "") {
	        printError("titoloErr", "Inserire un titolo");
	    } else {
	        var regex = /^[0-9a-zA-Z]+$/;                
	        if(regex.test(titolo) === false) {
	            printError("titoloErr", "Inserire un titolo valido");
	        } else {
	            printError("titoloErr", "");
	            titoloErr = false;
	        }
	    }
	    
	    //prezzo
	    if(prezzo == "") {
	        printError("prezzoErr", "Inserire un prezzo");
	    } else {
	        var regex = /^\d{10}$/;                 
	        if(regex.test(prezzo) === false) {
	            printError("prezzoErr", "Inserire un prezzo valido");
	        } else {
	            printError("prezzoErr", "");
	            prezzoErr = false;
	        }
	    }
	    
		//piattaforma
	    if(piattaforma == "") {
	        printError("piattaformaErr", "Inserire una piattaforma");
	    } else {
	        var regex = /^[A-Za-z]+$/; 
	        if(regex.test(piattaforma) === false) {
	            printError("piattaformaErr", "Inserire una piattaforma valida");
	        } else{
	            printError("piattaformaErr", "");
	            piattaformaErr = false;
	        }
	    }
	    
	  	//genere
	    if(genere == "") {
	        printError("genereErr", "Inserire una genere");
	    } else {
	        var regex = /^[A-Za-z]+$/; 
	        if(regex.test(genere) === false) {
	            printError("genereErr", "Inserire una genere valida");
	        } else{
	            printError("genereErr", "");
	            genereErr = false;
	        }
	    }
	    
	  	//prezzo
	    if(anno == "") {
	        printError("annoErr", "Inserire un anno");
	    } else {
	        var regex = /^\d{10}$/;                 
	        if(regex.test(anno) === false) {
	            printError("annoErr", "Inserire un anno valido");
	        } else {
	            printError("annoErr", "");
	            annoErr = false;
	        }
	    }       
	  	
	    if((titoloErr = prezzoErr = piattaformaErr = genereErr = annoErr = true)) {
	       return false;
	    }
	};
	</script>
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">

<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>
</nav>

<div class="box">
	<div class="box_conf">
		<h3>Modifica gioco: </h3>
		<form action="UpdateGameAdmin" onsubmit="return validateForm()" method="post" name="modifyform">	
			Titolo: <input class="text_titolo" type="text" name="titolo" placeholder="Titolo" value="${product.titolo}">
			<div class="error" id="titoloErr"></div>
			
			<input class="text_id" type="hidden" name="id"  value="${product.idprodotto}">
			
			Prezzo: <input class="text_prezzo" type="text" name="prezzo" placeholder="Prezzo" value="${product.prezzo}">
			<div class="error" id="prezzoErr"></div>
			
			Piattaforma: <input class="text_piatt" type="text" name="piattaforma" placeholder="Piattaforma"value="${product.piattaforma}">
			<div class="error" id="piattaformaeErr"></div>
			
			Genere: <input class="text_gen" type="text" name="genere" placeholder="Genere" value="${product.genere}">
			<div class="error" id="genereErr"></div>
			
			Anno: <input class="text_anno" type="text" name="anno" placeholder="Anno" value="${product.anno}">
			<div class="error" id="annoErr"></div>
			
			<input class="button" type="submit" value="invia">
		</form>	
	</div>
</div>

<!--Footer Copiright-->
<div class="footer">
	<p>@Copyright - 2019 Progetto di: Giuseppe Arienzo, Mattia Mascolo, Cocchinone Lorenzo Paolo.</p>
	<p>Logo di: Gaia Gattuso</p>
</div>
</body>
</html>