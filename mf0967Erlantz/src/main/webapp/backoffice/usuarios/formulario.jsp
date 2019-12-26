<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Formulario usuario";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<div class="login-form-wrapper">

	<%@include file="/includes/mensaje-alerta.jsp"%>

	<p class="text-danger">${mensajeValidacion}</p>

	<form class="login-form" action="backoffice/usuarios" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Usuario</h1>
		<input type="text" name="id" value="${usuario.id}"
			class="form-control" readonly> <input type="text"
			name="nombre" value="${usuario.nombre}" class="form-control"
			placeholder="Nombre (entre 2 y 150 letras)" autofocus> <input
			class="btn btn-lg btn-primary btn-block" type="submit"
			value="${(usuario.id>0)?"Modificar":"Crear" }"></input>
		<!-- Button trigger modal -->
		<c:if test="${usuario.id > 0}">
			<button type="button" class="btn btn-lg btn-block btn-outline-danger"
				data-toggle="modal" data-target="#exampleModal">Eliminar</button>
		</c:if>
		<p class="mt-3 mb-3 text-muted">
			<a href="backoffice/index.jsp">volver al dashboard</a><br> <a
				href="backoffice/usuarios?accion=listar">ver usuarios</a>
		</p>
	</form>

	<c:if test="${usuario.id > 0}">

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">¿Estas seguro de que quieres
						eliminar el usuario?<br> { Id: ${usuario.id}, Nombre: <b>${usuario.nombre} }</b></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<a class="btn btn-danger"
							href="seguridad/productos?id=${usuario.id}&accion=eliminar">Eliminar</a>
					</div>
				</div>
			</div>
		</div>


	</c:if>

</div>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>