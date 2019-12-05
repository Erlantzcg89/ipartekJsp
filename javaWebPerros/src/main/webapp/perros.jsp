
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<style>
img{
max-width: 100px;
}
ol{
list-style: none;
}
</style>

<h1>Perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");

%>

listado

<ol>
	<% for ( Perro perro :  perros ){ %>
	
		<li><img src="<%=perro.getFoto()%>"> id <%=perro.getId()%> - <%=perro.getNombre()%> - <%=perro.getRaza()%> - <a href="perros?idBorrar=<%=perro.getId()%>">eliminar</a></li>
		
	<% } %>
</ol>

<hr>

Formulario añadir perro

<form action="perros" method="post">
	
	<input name="nombre" placeholder="nombre" required>
	<input name="raza" placeholder="raza" required>	
	
	<input type="submit" value="añadir perro">
</form>


<%@include file="includes/footer.jsp" %>