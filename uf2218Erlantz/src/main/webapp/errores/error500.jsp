<%@ page isErrorPage="true" %>

<%
	String titulo = "Error 500";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<div class="index-acceso-denegado">
	<img src="images/error500.png">
</div>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>