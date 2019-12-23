<%
	String usuario = (String) session.getAttribute("usuarioLogeado");
	if (usuario == null) {
%>
<div class="submenu"><p><span class="submenu-text">Bienvenido al CMS<br>
El usuario puede <a href="login.jsp">hacer login</a> puede crear nuevos productos, modificarlos o eliminarlos</p></div>
<%
	} else {
%>
<div class="submenu">
	<span class="submenu-text">Usuario: <%=usuario%> | Usuarios logeados: ${applicationScope.numeroUsuariosConectados}
		| <div><a class="" href="logout">Cerrar Sesión</a></div></span>
</div>
<%
	}
%>


