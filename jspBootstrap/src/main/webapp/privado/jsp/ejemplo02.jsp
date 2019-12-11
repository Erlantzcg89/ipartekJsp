<%@ page errorPage="error.jsp" %>

<%
	String titulo = "CMS Jsp y Bootstrap";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/enlacesDatatable.jsp" %>
<%@include file="/includes/enlacesCustom.jsp" %>
<%@include file="/includes/menuJsp.jsp" %>
<%@include file="/includes/submenu.jsp"%>

<div class="container-fluid p-4">
	
	<main class="ejemplo02-main">
	<h4 class="text-center text-dark">Ejemplo nº2</h4>
	<p class="text-center">
		Rellena los parámetros nombre y password mediante un formulario
	</p>
	
	<div class="ejemplo02-caja-centrado">
	<button type="button" class="btn btn-secondary d-block my-2" data-toggle="modal" data-target="#exampleModal">Rellenar Parámetros</button>	
	<ul>
		<li>Nombre: ${nombre}</li>
		<li>Password: ${password}</li>
		<li>Movil: ${movil}</li>
	</ul>
	</div>
	
		 <!-- Formulario de registro modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Introducir datos</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="ejemplo02" method="get">
                        <form>
                            <div class="form-group">
                                <input type="text" class="form-control" name="nombre"
                                    placeholder="Nombre (Cualquier caracter válido)" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="password"
                                    placeholder="Contraseña (Cualquier caracter válido)" required>
                            </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <input type="submit" class="btn btn-primary" value="Guardar">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- fin del formulario -->
	</main>
</div>

<%@include file="/includes/footer-fixed.jsp"%>
<%@include file="/includes/scriptsMain.jsp" %>
<%@include file="/includes/scriptsDatatable.jsp" %>
<%@include file="/includes/pie.jsp" %>