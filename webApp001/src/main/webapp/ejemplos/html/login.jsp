<%
	String titulo = "Formulario de Login Html";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>
 

    <main>
        <h1 class="blanco">Formulario con login (Java Server)</h1>

        <section>

            <div class="container">
                <form id="contact" action="" method="post">
                    <h3>Login Ipartek</h3>
                    <fieldset>
                        <input placeholder="Nombre" type="text" name="nombre" tabindex="1" required autofocus>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Password" type="password" name="contrasena" tabindex="2" required>
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
                        <input type="checkbox" name="recuerdame" id="recuerdame" value="0">
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