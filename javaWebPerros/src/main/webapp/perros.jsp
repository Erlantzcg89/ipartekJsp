
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<% String titulo = "perrosApp | perros"; %>

<style>
body{
	background-color: #57423F;
	color:white;
}

body>span{
display: block;
margin: auto;
text-align: center;
margin-top: 20px;
margin-bottom: 20px;
}

a{
	text-decoration:none;
	color: #354F7A;
}

a:hover{
	color: #007EEE;
}

main{
color: white;
	margin: auto;
	width: 1024px;
	border: 1px solid black;
	padding: 20px;
	background-color: #EA1D33;
}

img{
max-width: 100px;
}

.lista-wrapper{
margin:auto;
margin-top: 20px;
margin-bottom: 20px;
width: 600px;
background-color: white;
color: #D1196B;
padding: 20px 0;
}

ol{
list-style: none;
}

ol li span{
position:relative;
bottom: 45px;
left: 20px;
}

ol li:lastchild{
margin-bottom:0;
}

</style>
<main class="index-main">
<h1>CRUD de perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");

%>

Listado del array de perros. CRUD con modificación, borrado y creación de nuevos perros

<div class="lista-wrapper">
<ol>
	<% for ( Perro perro :  perros ){ %>
	
		<li><img src="<%=perro.getFoto()%>"><span> id <%=perro.getId()%> - <%=perro.getNombre()%> - <%=perro.getRaza()%> - <a href="perros?id=<%=perro.getId()%>&editar=s">modificar</a> - <a href="perros?id=<%=perro.getId()%>&adoptar=s">adoptar</a></span></li>
		
	<% } %>
</ol>
</div>

<hr>

Añadir perro

<%
	Perro perroEditar = (Perro)request.getAttribute("perroEditar");
	if ( perroEditar == null ){
		perroEditar = new Perro();
	}
%>

<form action="perros" method="post">
	
	<input type="text" readonly name="id" required value="<%=perroEditar.getId()%>">
	<input type="text" name="nombre" placeholder="nombre" value="<%=perroEditar.getNombre()%>" required>	
	<input type="text" name="raza" placeholder="raza" value="<%=perroEditar.getRaza()%>" required>
	<input type="text" name="imagen" placeholder="url de la imagen" value="<%=perroEditar.getFoto()%>" required>
	<input type="submit" value="Guardar">
</form>

</main>

<%@include file="includes/footer.jsp" %>