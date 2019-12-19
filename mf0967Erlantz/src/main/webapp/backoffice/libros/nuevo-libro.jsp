<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Nuevo producto";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<div class="login-form-wrapper">

	<%@include file="/includes/mensaje-alerta.jsp"%>
	
	<p class="text-danger">${mensajeValidacion}</p>
	
	<form class="login-form" action="backoffice/crear"
		method="post">
		<h1 class="h3 mb-3 font-weight-normal">Nuevo libro</h1>
		<%-- <input type="text" name="id" value="${idLibro}" class="form-control" readonly> --%>
		<input type="text" name="nombre" value="${nombreLibro}" class="form-control"
			placeholder="Nombre (entre 2 y 150 letras)" autofocus>
		<input type="text" name="precio" value="${precioLibro}" class="form-control"
			placeholder="Precio (con punto, mayor que 0)">
		<input type="text" name="descuento" value="${descuentoLibro}" class="form-control"
			placeholder="Descuento (entre 0 y 100)">
		<input type="text" name="autor" value="${autorLibro}" class="form-control"
			placeholder="Autor (sin validacion)">
		<input type="text" name="imagen" value="${imagenLibro}" class="form-control"
			placeholder="Imagen (sin validacion)">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
		<p class="mt-3 mb-3 text-muted">
			<a href="backoffice/index.jsp">volver al dashboard</a><br>
			<a href="inicio">ver listado</a>
		</p>
	</form>
</div>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>