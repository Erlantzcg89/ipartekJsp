<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Login";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>

<div class="login-form-wrapper">

	<%@include file="/includes/mensaje-alerta.jsp"%>

	<form class="login-form" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Accede a tu usuario</h1>
		<input type="text" name="nombre" class="form-control"
			placeholder="Nombre" required autofocus> <input
			type="password" name="password" class="form-control"
			placeholder="Password" required>
<!-- 		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Recuerdame
			</label>
		</div> -->
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		<p class="mt-3 mb-3 text-muted">© Ipartek 2019<br><a href="inicio">volver</a></p>
	</form>
</div>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>