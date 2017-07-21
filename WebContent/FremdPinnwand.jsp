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
			<% if(besitzer.isGesperrt()) { %>
				<h2 style="color: red"> <i>Diese Person ist Gesperrt! </i></h2>
				<% } %>
				<h4>Informationen</h4>
				<h3> Vorname:<%= besitzer.getVorname() %> <br> 
				     Nachname: <%= besitzer.getNachname() %></h3>
				<div id="personInfo">
					<p>Geburtsdatum: <%=  besitzer.getGeburtsdatum() %></p>
					<p>Geschlecht: <%= besitzer.getGeschlecht() %></p>
					<p>E-Mail: <%= besitzer.getEmail() %></p>
					<% if(besitzer.isAdmin()) { %>
				Diese Person ist Admin.
				<% } %>
		</div>
	</div>		
	
			<form action="FreundServlet" method="post">							
				<button type= "submit" class="button"> Als Freund hinzufügen </button>
			</form>
			<form action="FreundServlet" method="get">							
				<button type= "submit" class="button"> Als Freund entfernen </button>
			</form>
			
			<form action="NachrichtServlet" method="get">
				<button type= "submit" class="button"> Nachricht senden </button>
			</form>
						
			<form action="MeldenServlet" method="get">
				<button type= "submit" class="button"> Person sperren </button>
			</form>
			<form action="MeldenServlet" method="post">
				<button type= "submit" class="button"> Person entsperren </button>
			</form>
			<form action="AdminServlet" method="post">
				<button type= "submit" class="button"> Als Admin stellen </button>
			</form>
					
					<div id = "rightDiv"> 
						<form action="Beitrag2Servlet" method="post">
							<% for(Beitrag beitrag : alleBesitzerBeitrage){ %>
								<%= besitzer.getVorname() %>
									<br>
									Beitrag ID: <%= beitrag.getBeitragID() %>
									<br>
									<%= beitrag.getInhalt() %>
									<br>
									Gefällt mir Angaben: <%= beitrag.getGeffaltMirAngaben() %>
							<% } %>
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
							<input type="text" placeholder="deine nette Meinung" name="kommentar"></input>
							<button type= "submit"> kommentieren </button>
						</form>
					</div>
					
					
					
						<br><br>
						<form action="NavigatorServlet" method="get">
							<button type= "submit"> Mein Profil </button>
						</form>
						<form action="AbmeldenServlet" method="get">	
							<button type= "submit"> Abmelden </button>
						</form>
						
						
					
	</div>
</div>
		 <%@ include file="footer.jsp" %>
		  