<%
	String titulo = "Formularios Html";
%>

<%@include file="/includes/cabecera.jsp" %>

<div class="menuWrapper">
    <nav class="menu" id="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/html/index.jsp">Volver a ejemplos Html</a>
    </nav>
</div>

    <main>
        <h1 class="blanco">Formularios Html</h1>

        <section>
            <p>Usar siempre etiqueta <code>form</code> junto con botón <code>submit</code></p>
            <p>Atributo <code>action</code> sirve para indicar el nombre del controlador en el servidor</p>
            <p>El atributo <code>name</code> de un input sirve para especifiar el nombre del parámetro a enviar al
                servidor</p>
            <p>Existen varios atributos para los input: autofocus, pattern, placeholder</p>

            <div class="blockAuto width600">
                <form method="POST" action="ejemplos/html/formularios.html">
                    <fieldset>
                        <legend>Datos Personales</legend>
                        <div class="lineaForm">
                            <label for="nombre">Nombre*:</label>
                            <input required type="text" name="" id="nombre" autofocus
                                placeholder="mínimo 5 letras máximo 8">
                        </div>
                        <div class="lineaForm">
                            <label for="contrasena">Constraseña*:</label>
                            <input required type="password" name="contrasena" id="contrasena" pattern=".{3,10}"
                                placeholder="mínimo 3 letras máximo 10">
                            <button onclick="verTexto()">Ver</button>
                        </div>
                        <div>
                            <code>
                                function verTexto() {
                                console.trace('entrando');
                                let iContrasena = document.getElementById('contrasena');
                                if (iContrasena.type == "text") {
                                iContrasena.type = "password";
                                event.target.innerHTML = "Ver";
                                } else {
                                iContrasena.type = "text";
                                event.target.innerHTML = "Ocultar";
                                }
                                }
                            </code>
                        </div>

                        <script>
                            function verTexto() {
                                console.trace('entrando');
                                let iContrasena = document.getElementById('contrasena');
                                if (iContrasena.type == "text") {
                                    iContrasena.type = "password";
                                    event.target.innerHTML = "Ver";
                                } else {
                                    iContrasena.type = "text";
                                    event.target.innerHTML = "Ocultar";
                                }
                            }
                        </script>

                        <div class="lineaForm">
                            <label for="edad">Edad*:</label>
                            <input type="number" name="edad" id="edad" min="0" max="99" required
                                placeholder="número de años 0-99">
                        </div>
                        <div class="lineaForm">
                            <label for="deportes">Deportes:</label><br>
                            <input type="checkbox" name="deportes" id="deportes" value="1">Surf<br>
                            <input type="checkbox" name="deportes" id="deportes" value="2" checked>Quidditch<br>
                            <input type="checkbox" name="deportes" id="deportes" value="3">Jugger<br>
                            <input type="checkbox" name="deportes" id="deportes" value="4">Petanca
                        </div>
                        <div class="lineaForm">
                            <label for="sexo">Sexo:</label>
                            <select name="sexo" id="sexo">
                                <option value="h">Hombre</option>
                                <option value="m">Mujer</option>
                                <option value="se" selected>Sin Especifiar</option>
                            </select>
                        </div>
                    </fieldset>

                    <div class="lineaForm">
                        <label for="situacion">Situación Actual:</label><br>
                        <input type="radio" name="situacion" id="situacion" value="0" checked>Trabajando<br>
                        <input type="radio" name="situacion" id="situacion" value="1">Desempleado
                    </div>
                    <div class="lineaForm">
                        <label for="observaciones">Observaciones:</label><br>
                        <textarea name="observaciones" id="observaciones" cols="30" rows="10"
                            placeholder="tu opinión es muy importante para nosotros"></textarea>
                    </div>


                    <input class="blockAuto" type="submit" value="Enviar">
                </form>
            </div>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>