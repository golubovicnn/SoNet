<%@ include file="header.jsp" %> 

<div class="PublicPinnwand">

	</nav>
		<nav id="menu">	
	<ul>
		<li><form action="NavigatorServlet" method="get">
			<button type= "submit" class="button"> Mein Profil </button>
		</form></li>
		<li><form action="ForscherServlet" method="post">
			<button type= "submit" class="button"> Statistik ansehen </button>
		</form><li>
		<li><form action="AbmeldenServlet" method="get">
			<button type= "submit" class="button"> Abmelden </button>
		</form></li>
	</ul>
	</nav>
		
		<form action=Beitrag2Servlet method="post">
		<% ArrayList<Beitrag> alleBeitrage = manage.getAlleBeitraege(); %>
		<h3> News Feed: </h3>
			<p>
				<% for(Beitrag beitrag : alleBeitrage){ %>
					<br>
					Beitrag ID: <%= beitrag.getBeitragID() %>
					<br>
					<%= manage.getPersonByID(beitrag.getBesitzerID()).getVorname() %>
					<br>
					<%= beitrag.getInhalt() %>
					<br>
					Gefällt mir Angaben: <%= beitrag.getGeffaltMirAngaben() %>
					<br>
					Kommentare: <%= beitrag.getKommentare() %>
					<br>
				<% } %>
				
				<br><br>
				
				Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>
				<button name="submit" value="like" class="button">liken</button>
			</p>
		</form>
		<form action="Beitrag2Servlet" method="get">
			Beitrag mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idBeitrag"></input>
			<input type="text" placeholder="deine nette Meinung" name="kommentar"></input>
			<button type= "submit" class="button"> kommentieren </button>
		</form>
		<h3> Users: </h3>
		<% ArrayList<Person> allePersonen = manage.getPersonenList(); %>
		<% for(Person iterPerson : allePersonen){ %>
			<br>
			Person ID: <%= iterPerson.getPersonID() %>
			<br>
			<%= iterPerson.getVorname() %>   <%= iterPerson.getNachname() %><br>
		<% } %>
		
		<form action="PersonSuchenServlet" method="get">
			<br><br>
				
			Persons mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idPerson"></input>
			<button type= "submit" class="button"> Profil ansehen </button>

		</form>
		<form action="PersonSuchenServlet" method="post">
			Person suchen:<input type="text" name="suchen"> </input>
			<button type= "submit" class="button"> Suchen </button>
		</form>
				
				
		<h3> ForscherInnen: </h3>
		<% ArrayList<Forscher> alleForscher = manage.getForscherList(); %>
		<% for(Forscher iterForscher : alleForscher){ %>
			<br>
			Forscher ID: <%= iterForscher.getForscherID() %>
			<br>
			<%= iterForscher.getVorname() %>		<%= iterForscher.getNachname() %><br>
		<% } %>
	
	
	
				
		
</div>
<%@ include file="footer.jsp" %> 