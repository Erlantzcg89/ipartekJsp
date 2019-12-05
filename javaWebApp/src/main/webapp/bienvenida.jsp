<%
	String titulo = "CMS Jsp y Bootstrap";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/enlacesCustom.jsp" %>
<%@include file="/includes/menuIndex.jsp" %>

   <!-- Formulario de login modal -->
   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Login Administrador</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="privado/index.html">
                        <form>
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="contra"
                                    placeholder="Contraseña. Mayúscula, minúscula y número" required
                                    pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Recuerdame</label>
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
    
<%@include file="/includes/scriptsMain.jsp" %>
<%@include file="/includes/pie.jsp" %>