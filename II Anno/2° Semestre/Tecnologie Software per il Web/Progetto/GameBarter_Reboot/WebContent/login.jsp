<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		
		<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
		<link rel="stylesheet" type="text/css" href="Css/Login.css">
	</head>
	
	<body style="background: url(Css/img_css/LRbackgroung.jpg);">
		
		<div class="loginbox">
			<h1>Login</h1>
			
			<%Boolean logged = (Boolean) session.getAttribute("isWrong"); 
			if(logged != null){
				if(logged.booleanValue()) {%>
					<script>
						alert("Username o password errata");
					</script>
				<%}%>
			<%}%>
			
			<form action="Login" method="post">
				<input type="text" placeholder="Username" name="username" required><br>
				
				<input type="password" placeholder="Password" name="password" required><br>
				
				<input type="submit" value="Login"><br>
				
				<a href="registrazione.html"> Non hai un account ? Registrati ora...</a>
			</form>
		</div>
	
	</body>
</html>