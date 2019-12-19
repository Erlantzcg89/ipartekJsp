<%@ page errorPage="privado/error500.jsp"%>

<%
	String titulo = "Dashboard";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="dashboard-wrapper mt-3">
	
		<%@include file="/includes/mensaje-alerta.jsp"%>
	
		<a href="backoffice/libros/nuevo-libro.jsp" class="btn btn-primary btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Crear libro</a><br>
		<a href="inicio" class="btn btn-primary btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Modificar libro</a><br>
		<a href="inicio" class="btn btn-danger btn-lg btn-block" tabindex="-1" role="button" aria-disabled="true">Borrar libro</a>
		<p class="mt-3 mb-3 text-muted text-center">
			<a href="inicio">ver listado</a>
		</p>
	</div>
</main>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>