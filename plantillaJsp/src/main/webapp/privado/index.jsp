<%@ page errorPage="privado/error500.jsp" %>

<% String titulo = "jspBootstrap | Inicio"; %>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesDatatable.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<div class="login-exito-bienvenida">

<div class="alert alert-secondary alert-dismissible fade show text-center text-dark" role="alert">
  Logeado Correctamente<br>${mensaje}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

</div>

<%@include file="/includes/footer-fixed.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/scriptsDatatable.jsp"%>
<%@include file="/includes/pie.jsp"%>
