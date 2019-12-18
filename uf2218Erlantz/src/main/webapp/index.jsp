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
	
		<h1>Dashboard</h1>
		<a href="libros" class="btn btn-dark btn-lg btn-block mt-3 mb-2" tabindex="-1" role="button" aria-disabled="true">Listar libros</a><br>
		<a href="libros/nuevo-libro.jsp" class="btn btn-dark btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Nuevo libro</a><br>
	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
