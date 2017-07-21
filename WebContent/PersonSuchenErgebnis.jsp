<%@ include file="header.jsp" %> 



	<%  ArrayList<Person>ergebnis = (ArrayList<Person>)session.getAttribute("ergebnisListe"); %>
	<% for(Person iterPerson : ergebnis){ %>
			<br>
			Person ID: <%= iterPerson.getPersonID() %>
			<br>
			<%= iterPerson.getVorname() %>   <%= iterPerson.getNachname() %><br>
		<% } %>

	<form action="PersonSuchenServlet" method="get">
		<br><br>			
		Person mit ID:<input type="number" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="idPerson"></input>
		<button type= "submit" class="button"> ansehen </button>
	</form>
	<form action="PublicPinnwandServlet" method="get">
							<button type= "submit" class="button"> Auf Public Pinnwand zugreifen </button>
						</form>




<%@ include file="footer.jsp" %> 