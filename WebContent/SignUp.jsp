<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "soNet.*" %>


<%
	Person admin = new Person(1, "admin", "admin", "admin", "01-01-1990", "admin", "m", true, false);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>SoNet</title>
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body>

 <ul class="menu">
	<li><a href="Anmelden.jsp">Anmelden</a></li>
	<li class = "active"><a class ="active" href="Registrierung">Registrierung</a></li>
</ul>
<div class="whiteBox">
	<h2>Neue Registrierung</h2>

	<p style="color:red"><i><%--= message --%></i></p>
	<br>
	<form action="SignUpServlet" method="post">
		<label for="vname">Vorname*</label> &nbsp;&nbsp;
		<input type="text" id="vname" name="vorname" placeholder="Vorname" required>
		&nbsp;&nbsp;
		<label for="nname">Nachname*</label> &nbsp;
		<input type="text" id="nname" name="nachname" placeholder="Nachname" required><br><br>
		
		<label for="email">E-mail*</label> &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
		<input type="text" id="email" name="email" placeholder="E-mail" required><br><br>
		
		<label for="passwort">Passwort*</label> &nbsp; &nbsp;
		<input type="password" id="passwort" name="passwort" placeholder="Passwort" required>
		&nbsp;&nbsp;
		<label for="passwort2">Passwort wiederholen*</label>
		<input type="password" id="passwort2" name="passwort2" placeholder="Passwort wiederholen" required>
		<br><br>
		<label for="gdatum">Geburtsdatum</label>
		<span id="gdatum">
			<select name="geburtstag">
				<option value="tag">Tag</option>
				<%
					for(int i=1; i<=31; i++) {
				%>
				<option value="<%= (i<10 ? "0" : "") %><%=i%>"><%=i%></option>
				<%
					}
				%></select>
			<select name="geburtsmonat">
				<option value ="monat">Monat</option>
				<option value="01">Januar</option>
				<option value="02">Februar</option>
				<option value="03">März</option>
				<option value="04">April</option>
				<option value="05">Mai</option>
				<option value="06">Juni</option>
				<option value="07">Juli</option>
				<option value="08">August</option>
				<option value="09">September</option>
				<option value="10">Oktober</option>
				<option value="11">November</option>
				<option value="12">Dezember</option>
			</select>
			<select name="geburtsjahr">
				<option value="jahr">Jahr</option>
				<%
					for (int i = 2004; i >= 1950; i--) {
					%>
						<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>	
			</select>
		</span>
		
		<br><br>
		<input type="radio" id="m" name="geschlecht" value="m"> 
		<label for="male">Männlich</label> <br>
		<input type="radio" id="f" name="geschlecht" value="f" checked="checked">
		<label for="female">Weiblich</label>
		<br><br>

		Registrieren als:
		<input type="radio" id="person" name="angemeldetAls" value="person" checked="checked"> <label for="person">Person</label> 
		<input type="radio" id="forscher" name="angemeldetAls" value="forscher"><label for="forscher">ForscherIn</label> 
		<br><br>

		<!--  <input type="submit" value="Register">-->
		<button type="submit" class="button button-block" value="signup">Registrieren</button>
	</form>


</body>
</html>