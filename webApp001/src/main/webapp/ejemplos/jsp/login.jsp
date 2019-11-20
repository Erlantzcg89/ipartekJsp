<%
	String titulo = "Formulario de Login";
%>

<%@include file="/includes/cabecera.jsp" %>

    <nav class="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/jsp/index.jsp">Volver a ejercicios Jsp</a>
    </nav>

    <main>
        <h1 class="blanco">Formulario para iniciar sesión</h1>
        <section>

            <div class="container">
                <form id="contact" action="login" method="post">
                
    <%
		if(request.getAttribute("error") != null){
			
			String nombre = (String)request.getAttribute("nombre");
			String password = (String)request.getAttribute("password");
			
			out.println("<p>Datos incorrectos: "+nombre+", "+password+", intentelo otra vez.</p>");
		}

	%>
	
                    <h3>Login Ipartek</h3>
                    <fieldset>
                        <input placeholder="Nombre" type="text" name="nombre" tabindex="1" required autofocus>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Password" type="password" name="password" tabindex="2" required>
                    </fieldset>
                    <fieldset>
                        <select name="idioma" id="idioma">
                            <option value="es">Español</option>
                            <option value="en">Ingles</option>
                            <option value="se" selected>Sin Especifiar</option>
                        </select>
                    </fieldset>
                    <fieldset>
                        <label for="recuerdame">Recuerdame</label>
                        <input type="checkbox" name="recuerdame" id="recuerdame" value="1">
                    </fieldset>
                    <fieldset>
                        <button name="submit" type="submit" id="contact-submit"
                            data-submit="...Enviando">Enviar</button>
                    </fieldset>
                </form>
            </div>
        </section>
        
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>