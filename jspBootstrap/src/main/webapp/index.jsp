<%@ page errorPage="error.jsp" %>

<%
	String titulo = "CMS Jsp y Bootstrap";
	asdfasdf
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesDatatable.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<!-- Formulario de login modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Login
					Administrador</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="login" method="post">
					
						<div class="form-group">
							<input type="text" class="form-control" name="usuario"
								placeholder="Usuario (admin)" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="contrasena"
								placeholder="Contraseña (admin)" required>
						</div>
						<div class="form-group">
							<select class="form-control" name="idioma">
								<option value="Castellano">Castellano</option>
								<option value="Euskera" selected>Euskera</option>
								<option value="English">Ingles</option>
							</select>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1" name="recuerdame"> <label
								class="form-check-label" for="exampleCheck1">Recuerdame</label>
						</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<input type="submit" class="btn btn-primary" value="Login">
			</form>
		</div>
	</div>
</div>
</div>

<!-- mensaje login incorrecto -->
<%
	String mensaje = (String) request.getAttribute("mensaje");
	if (mensaje != null) {
%>
<div class="submenu">
	<span class="submenu-text text-danger"><%=mensaje%></span>
</div>
<%
	}
%>



<%@include file="/includes/footer-fixed.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/scriptsDatatable.jsp"%>
<%@include file="/includes/pie.jsp"%>