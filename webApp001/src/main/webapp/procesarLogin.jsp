<%
	String titulo = "Bienvenido";
%>

<%@include file="includes/cabecera.jsp" %>

	<nav class="menu">
		<a href="index.jsp">Inicio</a>
		<a href="login.jsp">Volver</a>
	</nav>

	<main>
	
	<%
		String nombre = (String)request.getAttribute("nombre");
		String password = (String)request.getAttribute("password");
		String idioma = (String)request.getAttribute("idioma");
		int recuerdame = (int)request.getAttribute("recuerdame");
	%>

		<h1 class="blanco">Login Correcto</h1>
		<section>
			<div class="container">
				<h3>Datos del login</h3>
				<p>Nombre= <%= nombre%>, Password= <%= password%>, Idioma= <%= idioma%>, Recuerdame= <%= recuerdame%></p>
			</div>
		</section>
	</main>
	
<%@include file="includes/pie.jsp" %>