<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
<jsp:useBean id="session_view_order" class="it.unisa.GameBarter.Model.Ordine" ></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico Ordini</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script/home.js"type="text/javascript"></script>
<script src="script/event_home.js"type="text/javascript"></script>
<script src="script/storicoordini.js"type="text/javascript"></script>

<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/storicoordini.css" type="text/css">
</head>

<body style="background: url(Css/img_css/LRbackgroung.jpg);">

<!--Header Menu-->
<nav class="header clearfix">
    <a href="index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" alt="Logo" class="header_logo_img"></a>
</nav>

<div class="box">
	<div class="box_table">
		<h3>Ordini:</h3>
		<table class="table">
			<thead class="thead">
				<tr><th>n° Ordine</th><th>Titolo</th><th>Quantità</th><th>Acquirente</th><th>Data</th><th>Valuta scambiata</th></tr>
			</thead>
			<tbody class="tbodyOrder">
			
			</tbody>
		</table>
	</div>
	<div class="box_text">
		<form action="admin.jsp">
			<input class="button" type="submit" value="Indietro">
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
