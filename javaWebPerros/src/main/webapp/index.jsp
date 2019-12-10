
<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

  
<% String titulo = "perrosApp | Inicio"; %>

<%
	
	out.print("<h1>Página inicial.jsp</h1>");

%>

<a href="perros">CRUD Perros</a><br>
<a href="perros2">CRUD Perros con JSTL</a><br>
<a href="login.jsp">login</a><br>


<%@include file="includes/footer.jsp" %>