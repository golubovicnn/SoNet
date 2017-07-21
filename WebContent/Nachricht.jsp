<%@ include file="header.jsp" %> 




<h2>Nachrichten</h2>


<% 
Person angemeldetePerson = (Person)session.getAttribute("person");
Person besitzer = (Person)session.getAttribute("person2"); 
ArrayList<Nachricht> konversation = manage.konversationFinden(angemeldetePerson.getPersonID(), besitzer.getPersonID());
%>
<% if(konversation != null) {%>
<%= konversation %>
<% }
	else {%>
		<h3> Konversation mit 
		<%= besitzer.getVorname() %>
		<% } %></h3>
		
		<form action="NachrichtServlet" method="post"> 
		
		 Schreibe eine neue Nachricht: <input type="text" name="nachricht" placeholder="Deine nette Nachricht"></input>
		<button type="submit" class="button"> Senden </button>
		</form>
<%@ include file="footer.jsp" %>