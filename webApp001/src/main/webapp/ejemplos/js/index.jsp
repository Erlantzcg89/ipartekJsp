<%
	String titulo = "Ejercicios Js";
%>

<%@include file="/includes/cabecera.jsp" %>

<div class="menuWrapper">
	<nav class="menu" id="menu">
        <a href="index.jsp">Volver</a>
        <a href="ejemplos/js/arkanoid.jsp">Arkanoid</a>
        <a href="ejemplos/js/datatable.jsp">Datatable</a>
  	</nav>
</div>

    <main>
        <h1 class="blanco">Ejercicios Js</h1>

        <section>
            <h2>Descripción</h2>
            <p>En este submenú encontrarás diferentes ejercicios y documentación sobre el lenguaje Javascript</p>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>>