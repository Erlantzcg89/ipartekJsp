<%@ page errorPage="privado/error500.jsp"%>

<%
	String titulo = "Dashboard";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="dashboard-wrapper">
	
		<%@include file="/includes/mensaje-alerta.jsp"%>
	
		<h1>Dashboard</h1>
		<a href="backoffice/crear" class="btn btn-primary btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Crear libro</a><br>
		<a href="backoffice/modificar" class="btn btn-primary btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Modificar libro</a><br>
		<a href="backoffice/borrar" class="btn btn-danger btn-lg btn-block" tabindex="-1" role="button" aria-disabled="true">Borrar libro</a>
	</div>
</main>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>