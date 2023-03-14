<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%//check if the user is registered
	Boolean admin = (Boolean) session.getAttribute("isAdmin");
	if((admin == null) || !admin.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>

<jsp:useBean id="session_product" class="it.unisa.GameBarter.Model.Prodotto" ></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Amministratore</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script/home.js"type="text/javascript"></script>
<script src="script/event_home.js"type="text/javascript"></script>
<script type="text/javascript">
function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
};

 function validateUser(){
		var username = document.forms[1].nome_utente.value;

		
		var usernameErr = true;
		
	    //Username
	    if(username == "") {
	        printError("usernameErr", "Inserire un username");
	    } else {
	        var regex = /^[0-9a-zA-Z_.-]+$/;                
	        if(regex.test(username) === false) {
	            printError("usernameErr", "Inserire un username valido");
	        } else {
	            printError("usernameErr", "");
	            usernameErr = false;
	        }
	    }
	    
	    if(usernameErr == true) {
	        return false;
	     }
 }
		
function validateForm() {
			
		   	var titolo = document.addform.titolo.value;
			var prezzo = document.addform.prezzo.value;
		    var piattaforma = document.addform.piattaforma.value;
		    var genere = document.addform.genere.value;
		    var anno = document.addform.anno.value;
		   
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
		  	
		    if((titoloErr = prezzoErr = piattaformaErr = genereErr = annoErr) == true) {
		       return false;
		    }
		}

</script>

<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/admin.css" type="text/css">
<script src="script/admin.js"type="text/javascript"></script>
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">

<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>
  <ul class="header_menu">
  	<li class="header_menu_item_login"><a href="Logout">Logout   <img src="Css/img_css/logout.png" alt="img_login"></a></li>
  </ul>
</nav>

<div class="box">
	<img class="admin" src="Css/img_css/admin.png" alt="gamer">
	<div class="box_text">
		<h3>Nome Utente: ${user.username} </h3>
		<p style="display:none" id="idutente"> ${user.idutente} </p>
		<p>Nome: ${user.nome}</p>
		<p>Cognome: ${user.cognome}</p>
	</div>
	<div class="box_add">
		<h3>Aggiungi gioco: </h3>
		<form action="AddGameAdmin" onsubmit="return validateForm()" method="post" name="addform">	
			Titolo: <input class="text_titolo" type="text" name="titolo" placeholder="Titolo">
			<div class="error" id="titoloErr"></div>
			Prezzo: <input class="text_prezzo" type="text" name="prezzo" placeholder="Prezzo">
			<div class="error" id="prezzoErr"></div>
			Piattaforma: <input class="text_piatt" type="text" name="piattaforma" placeholder="Piattaforma">
			<div class="error" id="piattaformaeErr"></div>
			Genere: <input class="text_gen" type="text" name="genere" placeholder="Genere">
			<div class="error" id="genereErr"></div>
			Anno: <input class="text_anno" type="text" name="anno" placeholder="Anno">
			<div class="error" id="annoErr"></div>
			<input class="button" type="submit" value="invia">
		</form>	
	</div>
	<div class="box_query">
		<h3>Visualizza gli ordini: </h3>
		<form onsubmit="return validateUser()" action="ViewOrder" method="post" id="CIAO" >	 
			<input class="text_nomeutente" type="text" name="nome_utente" placeholder="Nome utente" >
			<input class="text_date" type="date" name="datastart" >
			<input class="text_date" type="date" name="dataend" >
			<input class="button" type="submit" value="invia" >
			<div class="error" id="usernameErr"></div>
		</form>	
	</div>
	<div class="box_table">
		<h3>Giochi online:</h3>
		<table class="table">
			<thead class="thead">
				<tr><th>Titolo</th><th>Prezzo</th><th>Piattaforma</th><th>Genere</th><th>Disponibili</th><th>Gestisci</th></tr>
			</thead>
			<tbody class="tbodyAdmin"></tbody>
		</table>
	</div>
</div>

<!--Footer Copiright-->
<div class="footer">
	<p>@Copyright - 2019 Progetto di: Giuseppe Arienzo, Mattia Mascolo, Cocchinone Lorenzo Paolo.</p>
	<p>Logo di: Gaia Gattuso</p>
</div>

</body>
</html>
