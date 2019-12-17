<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Nuevo producto";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>

<div class="login-form-wrapper">

	<c:if test="${not empty mensajeAlerta }">

		<div
			class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-3"
			role="alert">
			${mensajeAlerta.texto}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

	</c:if>

	<form class="login-form" action="seguridad/producto?accion=crear-nuevo"
		method="post">
		<h1 class="h3 mb-3 font-weight-normal">Nuevo producto</h1>
		<input type="text" name="nombre" class="form-control"
			placeholder="Nombre" required autofocus>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
		<p class="mt-3 mb-3 text-muted">
			© Ipartek 2019<br>
			<a href="seguridad/index.jsp">volver</a><br>
			<a href="seguridad/producto?accion=listar">ver listado</a>
		</p>
	</form>
</div>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>