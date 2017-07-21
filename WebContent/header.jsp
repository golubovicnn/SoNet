<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="soNet.*, controllers.*, controllers.servlets.*, java.util.ArrayList, java.util.List, java.util.Calendar, java.text.DateFormat, java.text.SimpleDateFormat"
 %>
<% 

Authentifikation control = Authentifikation.getInstanz();
Person person = (Person)request.getAttribute("personAngemeldet");
Management manage = Management.getInstanz();

%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="mystyle.css"/>

<title>SoNet</title>
</head>
<body>
	
		<div id="header">
		<h1> SoNet </h1>
		</div>
		
		<div id="info">
		<% if(person!=null) { %>
	
		<p class="angemeldetPerson">Angemeldet als: <%=person.getVorname() %><button id="abmelden">Abmelden</button></p>
	
		<ul class="menu">
		<li><button href="Pinnwand.jsp">Pinnwand</button></li>
		<li><button href="HauptseiteServlet">Hauptseite</button></li>
		<li><button href="PersonenServlet">Personen</button></li>
		
		<% if(control.hatRechte(request, "adminStellen")) { %>
			<li><a href="MeldungenServlet">Meldungen</a></li>
		<% } %>
		</ul>
		<% } %>
		
		</div>