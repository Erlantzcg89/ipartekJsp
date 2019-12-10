<h1>Login</h1>

<%
	String mensaje = (String)request.getAttribute("mensaje");
	if ( mensaje != null ){
		%>
			<p style="color:red"><%=mensaje%></p>
		<% 
	}
%>

<form action="login" method="post">

	<input type="text" name="usuario" placeholder="Nombre usuario" required>
	<br>
	<input type="password" name="contrasena" placeholder="Contraseña" required>
	<br>
	<select name="idioma">
		<option value="es">Castellano</option>
		<option value="eu" selected>Euskera</option>
		<option value="en">Ingles</option>
	</select>
	<br>
	Recuerdame
	<input type="checkbox" name="recuerdame" value="1" />
	<br>

	<input type="submit" value="Acceder" />

</form>