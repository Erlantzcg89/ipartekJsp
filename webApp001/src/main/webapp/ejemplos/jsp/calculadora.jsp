<%
	String titulo = "Calculadora";
%>

<%@include file="/includes/cabecera.jsp" %>

    <nav class="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/jsp/index.jsp">Volver a ejercicios Jsp</a>
    </nav>

    <main>

        <h1 class="blanco">Calculadora Ipartek</h1>
        <section>
            <div class="container">
                <form id="contact" action="sumar" method="post">
                    <h3>Calculadora</h3>
                    <fieldset>
                        <input placeholder="Número 1" type="text" name="op1" tabindex="1" autofocus>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Número 2" type="text" name="op2" tabindex="2">
                    </fieldset>
                    <fieldset>
                        <select name="op3" id="operacion">
                            <option value="+">Sumar</option>
                            <option value="-">Restar</option>
                            <option value="*">Multiplicar</option>
                            <option value="/">Dividir</option>
                            <option value="saludo" selected>Seleccionar operación</option>
                        </select>
                    </fieldset>
                    <fieldset>
                        <button name="submit" type="submit" id="contact-submit"
                            data-submit="...Enviando">Calcular</button>
                    </fieldset>
                </form>
            </div>
        </section>
        
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>