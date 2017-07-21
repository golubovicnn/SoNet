<%@ include file="header2.jsp" %> 


<% 	
	Forscher besitzer = (Forscher)session.getAttribute("forscher");
	session.setAttribute("forscherID", besitzer.getForscherID());	
%>
	<div class="wrapper">
		<div id = "leftDiv">
			<div>
				<h3>Hallo <%= besitzer.getVorname() %>!</h3>
				<h4>Meine Informationen</h4>
				<h3> Vorname:<%= besitzer.getVorname() %> <br> 
				     Nachname: <%= besitzer.getNachname() %></h3>
				<div id="personInfo">
					<p>E-Mail: <%= besitzer.getEmail() %></p>
		</div>
	</div>		
					<div id = "rightDiv">
						<form action="ForscherServlet" method="get">
							<button type= "submit" class="button"> Statistik erstellen </button>	
						</form>
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

</body>
</html>