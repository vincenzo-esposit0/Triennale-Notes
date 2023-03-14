<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>

<jsp:useBean id="session_user" class="it.unisa.GameBarter.Model.Utente" ></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area personale</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script/home.js"type="text/javascript"></script>
<script src="script/event_home.js"type="text/javascript"></script>

<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/utente.css" type="text/css">
<script src="script/utente.js"type="text/javascript"></script>
<script>
$(document).ready(function(){
	  $(".gamer").hover(function(){
		  $(".gamer").hide(500);
		  $(".gamer2").show(500);
	});
});
</script>
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">

<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>

  <ul class="header_menu">
  	<li class="header_menu_item_login"><a href="Logout">Logout   <img src="Css/img_css/logout.png" alt="img_login"></a></li>
  	<li class="header_menu_item_login2"><a href="carrello.jsp">Carrello    <img src="Css/img_css/carrello.png" alt="img_Carrello"></a></li>
  </ul>
</nav>

<div class="box">
	<img class="gamer" src="Css/img_css/gamer.png" alt="gamer">
	<img class="gamer2" src="Css/img_css/gameregg.png" alt="gamer">
	<div class="box_text">
		<h3>Nome Utente: ${user.username}</h3>
		<p style="display:none" id="idutente"> ${user.idutente} </p>
		<p>Nome: ${user.nome}</p>
		<p>Cognome: ${user.cognome}</p>
		<p>Indirizzo: ${user.indirizzo}</p>
		<p>Saldo: ${user.valuta} BR </p>
	</div>
	<div class="box_add">
		<h3>Aggiungi gioco: </h3>
		<form action="AddGameUser" method="post">	
			<select class="select" name="titolo">
			
			</select>
			<input class="text" type="text" placeholder="Quantità" name="volume">
			<input class="button" type="submit" value="invia">
		</form>	
	</div>
	<div class="box_table">
		<h3>I miei giochi:</h3>
		<form action="RemoveUser" method="post" id="form"></form>
			<table class="table">
				<thead class="thead">
					<tr><th>Titolo</th><th>Quantità</th><th>Gestisci</th></tr>
				</thead>
				<tbody class="tbody">
					
				</tbody>
			</table>

	</div>
	<div class="box_table_ord">
		<h3>I miei ordini:</h3>
		<table class="table">
			<thead class="thead">
				<tr><th>N°Ordine</th><th>Titolo</th><th>Quantit�</th><th>Data</th><th>Totale</th></tr>
			</thead>
			<tbody class="tbody_order">

			</tbody>
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
