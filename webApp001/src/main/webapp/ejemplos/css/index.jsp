<%
	String titulo = "Ejercicios Css";
%>

<%@include file="/includes/cabecera.jsp" %>

    <nav class="menu" id="menu">
        <a href="index.jsp">Volver</a>
        <a href="ejemplos/css/especificidad.jsp">Especificidad</a>
        <a href="ejemplos/css/selectores-basico.jsp">Selectores b&aacute;sico</a>
        <a href="ejemplos/css/selectores-avanzado.jsp">Selectores avanzado</a>
        <a href="ejemplos/css/animaciones.jsp">Animaciones</a>
        <a href="ejemplos/css/font-awesome.jsp">Font-Awesome</a>
        <a href="ejemplos/css/flex-box.jsp">Flex-box</a>
    </nav>
    <main>
        <h1 class="blanco">Ejercicios Css</h1>

        <section>
            <h2>Descripción</h2>
            <p>En este submenú encontrarás diferentes ejercicios y documentación sobre el lenguaje Css</p>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>