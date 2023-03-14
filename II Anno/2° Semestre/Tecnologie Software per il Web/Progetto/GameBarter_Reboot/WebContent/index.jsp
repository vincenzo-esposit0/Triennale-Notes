<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>GameBarter</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="script/home.js"type="text/javascript"></script>
	<script src="script/event_home.js"type="text/javascript"></script>

	<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="Css/home.css" type="text/css">
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">
<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>

  	<ul class="header_menu">
    	<li class="header_menu_item sport"><a href="#Sport" >Sport</a></li>
    	<li class="header_menu_item std fps"><a href="#First Person Shooter" >First Person Shooter</a></li>
    	<li class="header_menu_item std tps"><a href="#Third Person Shooter" >Third Person Shooter</a></li>
    	<li class="header_menu_item std rpg"><a href="#Role Playing Games" >Role Playing Games</a></li>
    	<li class="header_menu_item media fps"><a href="#First Person Shooter">FPS</a></li>
    	<li class="header_menu_item media tps"><a href="#Third Person Shooter" >TPS</a></li>
    	<li class="header_menu_item media rpg"><a href="#Role Playing Games" >RPG</a></li>
    	<li class="header_menu_item all"><a href="#Tutti i giochi">Tutti i giochi</a></li>
    
		<%Boolean logged = (Boolean) session.getAttribute("isLog"); 
			if(logged != null){
				if(logged.booleanValue()) {%>
						<% Boolean admin = (Boolean) session.getAttribute("isAdmin");
						if(admin.booleanValue()) {%>
							<li class="header_menu_item_login"><a href="admin.jsp"><img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>
						<%} else { %>
							<li class="header_menu_item_login"><a href="utente.jsp"><img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>
						<%} %>
					<%} %>
		<%} else if(logged == null || logged.booleanValue() == false) {%>
						<li class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/LoginImg.png" alt="img_login"></a></li>
						
		<%} %>
  	</ul>
</nav>

<!--Card Giochi-->
<div class="products cards clearfix"></div>

<!--Footer Copiright-->
<div class="footer">
	<p>@Copyright - 2019 Progetto di: Giuseppe Arienzo, Mattia Mascolo, Cocchinone Lorenzo Paolo.</p>
	<p>Logo di: Gaia Gattuso</p>
</div>

</body>
</html>
