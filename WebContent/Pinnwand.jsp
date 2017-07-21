<%@ include file="header.jsp" %> 


	
	
	<div class="wrapper">
		<div id = "leftDiv">
			<div>
			
			<% 
	Person angemeldetePerson = (Person)session.getAttribute("person");
	session.setAttribute("personID", angemeldetePerson.getPersonID());
	session.setAttribute("besitzerID", angemeldetePerson.getPersonID());
	request.setAttribute("include", "<script src='sc.js'></script>");
	%>
	<%	ArrayList<Beitrag> alleBesitzerBeitrage = manage.getBeitragList(angemeldetePerson); %>
	
				<h3>Hallo <%= angemeldetePerson.getVorname() %>!</h3>
				<h4>Meine Informationen</h4>
				<h3> Vorname:<%= angemeldetePerson.getVorname() %> <br> 
				     Nachname: <%= angemeldetePerson.getNachname() %></h3>
				<div id="userInfo">
					<p>Geburtsdatum: <%=  angemeldetePerson.getGeburtsdatum() %></p>
					<p>Geschlecht: <%= angemeldetePerson.getGeschlecht() %></p>
					<p>E-Mail: <%= angemeldetePerson.getEmail() %></p>
					<% if(angemeldetePerson.isAdmin()) { %>
					Diese Person ist Admin.
					<% } %>
					 
					 		<p> Anzahl von Freunden:
							<%= angemeldetePerson.getFreundlist().size() %>
							<br>
							<% if(angemeldetePerson.getFreundlist().size()>0) {%>
							Freunde:
							<% for(Person iterPerson : angemeldetePerson.getFreundlist()){ %>
							<br>
								<%= iterPerson.getVorname() %>   <%= iterPerson.getNachname() %>	---> ID:<%= iterPerson.getPersonID() %>
								
							<% } %>
					<% } %></p>
			<form action="FreundServlet" method="get">	
			Freund mit ID: <input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="friendID"></input>					
				<button type= "submit" class="button"> entfernen </button>
			</form>
		</div>
	</div>		
				<div id="rightDiv">
				
					<form action="BeitragServlet" method="post">
						Beitrag teilen: <input type="text" name="post" placeholder="Text schreiben...">
						<button type="submit" class="button">Teilen</button>
					</form>
				
					
						 
					
					<% for(Beitrag beitrag : alleBesitzerBeitrage){ %>
					<br><br>
								<%= angemeldetePerson.getVorname() %>
									<br>
									Beitrag ID: <%= beitrag.getBeitragID() %>
									<br>
									<p style="text-align:center"><%= beitrag.getInhalt() %></p>
									
									Gefällt mir Angaben: <%= beitrag.getGeffaltMirAngaben() %>
							<% } %>
							
						
						<form action="BeitragServlet" method="get">
							<br><br>
							Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>löschen/melden.
							<button type= "submit" class="button"> Beitrag löschen/melden </button>
						</form>
						
						
						<br><br><br>
						<form action="ForscherServlet" method="post">
							<button type= "submit" class="button"> Statistik ansehen </button>
						</form>
						
					<form action="PublicPinnwandServlet" method="get">
							<button type= "submit" class="button"> Auf Public Pinnwand zugreifen </button>
						</form>
						
						<form action="AbmeldenServlet" method="get">
						<br><br><br>
							<button type= "submit" class="button"> Abmelden </button>
						</form>
	</div>
	</div>
</div>
		 <%@ include file="footer.jsp" %> 