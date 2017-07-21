<%@ include file="header.jsp" %> 

<% 
	//Object angemeldetAlsO=request.getAttribute("angemeldetAls");
	//String angemeldetAls = "";
	//if(angemeldetAlsO != null) angemeldetAls=(String) angemeldetAlsO; 


	//String person =(String) request.getAttribute("angemeldetAls");
	//System.out.println(person);
	//Boolean besitzt = (Boolean) request.getAttribute("besitzt");
	
	
	Person angemeldetePerson = (Person)session.getAttribute("person");
	Person besitzer = (Person)session.getAttribute("person2");	%>
	<%  session.setAttribute("besitzerID", besitzer.getPersonID());
		session.setAttribute("personID", angemeldetePerson.getPersonID()); %>
	<%	ArrayList<Beitrag> alleBesitzerBeitrage = manage.getBeitragList(besitzer); %>
	<div class="wrapper">
		<div id = "leftDiv">
			<div>
				<h4>Informationen</h4>
				<%= besitzer.isGesperrt() %>
				<% if(besitzer.isGesperrt()) { %>
				<h1> Diese Person ist Gesperrt! </h1>
				<% } %>
				
				
				<h3> Vorname:<%= besitzer.getVorname() %> <br> 
				     Nachname: <%= besitzer.getNachname() %></h3>
				<div id="personInfo">
					<p>Geburtsdatum: <%=  besitzer.getGeburtsdatum() %></p>
					<p>Geschlecht: <%= besitzer.getGeschlecht() %></p>
					<p>E-Mail: <%= besitzer.getEmail() %></p>
		</div>
	</div>		
					
					<form action="FreundServlet" method="post">
							<br><br>
							
							<button type= "submit"> Als Freund hinzufügen </button>
						</form>
				<form action="" method=>
							<br><br>
							<button type= "submit"> Abonnieren </button>
						</form>
						
						<form action="NachrichtServlet" method="get">
							<br><br>
							<button type= "submit"> Nachricht senden </button>
						</form>
						
						<form action="MeldenServlet" method="get">
							<br><br>
							<button type= "submit"> Person melden </button>
						</form>
					
						<div id = "rightDiv"> 
						<form action="Beitrag2Servlet" method="post">
					<%= alleBesitzerBeitrage %>
							<br><br>
							Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>liken.
							<button type= "submit"> Gefällt mir </button>
						</form>
						
						<form action="BeitragServlet" method="get">
							<br><br>
							Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>löschen/melden.
							<button type= "submit"> Beitrag melden </button>
						</form>
						
						<form action="Beitrag2Servlet" method="get">
							<br><br>
							Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>
							<input type="text" placeholder="deine nette Meinung" name="kommentar"></input>kommentieren.
							<button type= "submit"> kommentieren </button>
						</form>
						</div>
						
						<form action="ForscherServlet" method="post">
							<br><br>
						</form>
						<form action="AbmeldenServlet" method="get">
							<br><br>
							<button type= "submit"> Abmelden </button>
						</form>
						
						
					
	</div>
</div>
		 <%@ include file="footer.jsp" %>
		  