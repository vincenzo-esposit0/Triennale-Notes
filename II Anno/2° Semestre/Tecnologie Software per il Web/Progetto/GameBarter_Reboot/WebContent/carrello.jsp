<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
<jsp:useBean id="session_cart" class="it.unisa.GameBarter.Model.Prodotto" ></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script/home.js"type="text/javascript"></script>
<script src="script/cart.js"type="text/javascript"></script>

<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/carrello.css" type="text/css">
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">
<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>
  
  <ul class="header_menu">
	<%Boolean logged1 = (Boolean) session.getAttribute("isLog"); 
		if(logged1 != null){
			if(logged1.booleanValue()) {%>
					<% Boolean admin = (Boolean) session.getAttribute("isAdmin"); %>
					<%if(admin.booleanValue()) {%>
						<li class="header_menu_item_login"><a href="admin.jsp">Area Personale   <img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>
					<%} else { %>
						<li class="header_menu_item_login"><a href="utente.jsp">Area Personale   <img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>
					<%}%>
				<%} %>
		<%} else if(logged1 == null || logged1.booleanValue() == false) {%>
					<li class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>	
		<%} %>
  </ul>
</nav>

<div class="box">
	<div class="box_table">
		<h3>Carrello:</h3>
		<table class="table">
			<thead class="thead">
				<tr><th>Titolo</th><th>Quantità</th><th>Piattaforma</th><th>Prezzo</th></tr>
			</thead>
			<tbody class="tbodyCart">

			</tbody>
		</table>
	</div>
	<div class="box_text">
		<h3 class="h3"></h3>
		<input id="invia" class="button" type="submit" value="Procedi All'acquisto">
	</div>
</div>

<script>
$("#invia").click(function() {
	$.getJSON("Ordine", function (object, status){
		var string = JSON.stringify(object);
		alert(string);
		location.reload();
	})
})
</script>

<!--Footer Copiright-->
<div class="footer">
	<p>@Copyright - 2019 Progetto di: Giuseppe Arienzo, Mattia Mascolo, Cocchinone Lorenzo Paolo.</p>
	<p>Logo di: Gaia Gattuso</p>
</div>

</body>
</html>
