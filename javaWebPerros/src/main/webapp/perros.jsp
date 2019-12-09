
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
ol li span{
position:relative;
bottom: 45px;
left: 20px;
}

</style>

<h1>Perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");

%>

listado

<ol>
	<% for ( Perro perro :  perros ){ %>
	
		<li><img src="<%=perro.getFoto()%>"><span> id <%=perro.getId()%> - <%=perro.getNombre()%> - <%=perro.getRaza()%> - <a href="perros?id=<%=perro.getId()%>&editar=s">modificar</a> - <a href="perros?id=<%=perro.getId()%>">eliminar</a></span></li>
		
	<% } %>
</ol>

<hr>

Añadir perro

<form action="perros" method="post">
	
	<input name="nombre" placeholder="nombre" required>
	<input name="raza" placeholder="raza" required>	
	
	<input type="submit" value="añadir perro">
</form>


<%@include file="includes/footer.jsp" %>