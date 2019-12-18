<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Dashboard";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="dashboard-wrapper">
	
		<a href="libros" class="btn btn-primary btn-lg btn-block mt-3 mb-2" tabindex="-1" role="button" aria-disabled="true">Ver listado de libros</a><br>
		<a href="libros/nuevo-libro.jsp" class="btn btn-primary btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Crear nuevo libro</a><br>
	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
