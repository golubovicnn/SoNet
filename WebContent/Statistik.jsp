<%@ include file="header.jsp" %> 

<div class="Statistik">

	<p>
		<% ArrayList<Statistik> alleStatistik = manage.getStatistikList(); %>
	
		<p>
				<% for(Statistik statistik : alleStatistik){ %>
					<br>
					Statistik ID: <%= statistik.getStatistikID() %>
					<br>
					Statistik von: <%= statistik.getTagMonatJahr() %>
					<br>
					Personen in SoNet: <%= statistik.getIngesamtPerson() %>
					<br>
					Beiträge ingesamt: <%= statistik.getIngesamtBeitrag() %>
					<br>
					Gefällt mir Angaben ingesamt: <%= statistik.getIngesamtLike() %>
					<br>
					Beiträge pro Person durschnittlich: <%= statistik.getDurschnittBeitragProPerson() %>
					<br>
					Likes pro Beitrag durschnittlich: <%= statistik.getDurschnittLike() %>
					<br>
					Statistik erstellt von: <%= manage.getForscherByID(statistik.getForscherID()).getVorname()  %>	
											<%= manage.getForscherByID(statistik.getForscherID()).getNachname() %>
					<br>
				<% } %>
				
				<br><br>
			</p>
	
	</p>


			<form action="StatistikServlet" method="post">
				<br><br>
				<button type= "submit" class="button"> zurück zum Homepage </button>
			</form>
</div>









<%@ include file="footer.jsp" %> 