<%@ page errorPage="error.jsp" %>

<%
	String titulo = "CMS Jsp y Bootstrap";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/enlacesDatatable.jsp" %>
<%@include file="/includes/enlacesCustom.jsp" %>
<%@include file="/includes/menuJsp.jsp" %>

<main class="container-fluid pt-3">
	<h3>Ejemplo nº2</h3>
	<p>
		Rellena los parámetros nombre y password mediante un formulario
		<button type="button" class="btn btn-secondary d-block mt-2" data-toggle="modal" data-target="#exampleModal">Rellenar Parámetros</button>
	</p>
	
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
    
    <h1 class="text-danger pb-2">Eres una tetera <i class="fas fa-coffee"></i></h1>
	
	<ul>
		<li>Nombre: ${nombre}</li>
		<li>Password: ${password}</li>
		<li>Movil: ${movil}</li>
	</ul>
</main>
	
<%@include file="/includes/scriptsMain.jsp" %>
<%@include file="/includes/scriptsDatatable.jsp" %>
<%@include file="/includes/pie.jsp" %>