<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body>

	
	<ul class="menu">
			<li class = "active" ><a href="Anmelden.jsp">Anmelden</a></li>
			<li><a href="SignUp.jsp">Registrieren</a></li>
			
		</ul>
	<div class="whiteBox">
		<h3 style="margin-left: 50px">Anmelden</h3>
		
		<br>
		<form action="LogIn" method="post" id="anmelden" style="text-align:center"> 
			
			<p><i>Anmelden fehlgeschlagen. Sie haben die Daten falsch eingetragen oder Sie sind von Admin gesperrt.</i></p>
		
			<label for="uname">E-Mail</label>
				<input type="text" name="email" placeholder="Email"><br><br>
			<label for="password">Passwort</label>
				<input type="password" name="password" placeholder="Passwort"><br><br><br>
			<button type="submit" class="button button-block">Anmelden</button>
			
		</form>
		
	</div>
</body>
</html>
</body>
</html>

	