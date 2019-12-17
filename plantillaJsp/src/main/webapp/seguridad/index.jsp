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
		<a href="seguridad/producto?accion=listar" class="btn btn-dark btn-lg btn-block mt-3 mb-2" tabindex="-1" role="button" aria-disabled="true">Listar productos</a><br>
		<a href="seguridad/producto?accion=nuevo" class="btn btn-dark btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Nuevo producto</a><br>
		<a href="seguridad/producto?accion=modificar" class="btn btn-dark btn-lg btn-block mb-2" tabindex="-1" role="button" aria-disabled="true">Modificar producto</a><br>
		<a href="seguridad/producto?accion=borrar" class="btn btn-danger btn-lg btn-block" tabindex="-1" role="button" aria-disabled="true">Borrar producto</a>
	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
