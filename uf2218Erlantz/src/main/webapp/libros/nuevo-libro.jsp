<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Nuevo producto";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>

<div class="login-form-wrapper">

	<%@include file="/includes/mensaje-alerta.jsp"%>
	
	<p class="text-danger">${mensajeValidacion}</p>
	
	<form class="login-form" action="libros"
		method="post">
		<h1 class="h3 mb-3 font-weight-normal">Nuevo libro</h1>
		<input type="text" name="nombre" value="${nombreLibro}" class="form-control"
			placeholder="Nombre (entre 2 y 150 letras)" autofocus>
		<input type="text" name="precio" value="${precioLibro}" class="form-control"
			placeholder="Precio (con punto, mayor que 0)">
		<input type="text" name="descuento" value="${descuentoLibro}" class="form-control"
			placeholder="Descuento (entre 0 y 100)">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
		<p class="mt-3 mb-3 text-muted">
			<a href="index.jsp">volver al dashboard</a><br>
			<a href="libros">ver listado</a>
		</p>
	</form>
</div>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>