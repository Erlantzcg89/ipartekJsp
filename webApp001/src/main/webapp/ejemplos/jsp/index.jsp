<%
	String titulo = "Ejercicios Jsp";
%>

<%@include file="/includes/cabecera.jsp" %>

    <nav class="menu">
    	<a href="index.jsp">Volver</a>
        <a href="ejemplos/jsp/calculadora.jsp">Calculadora</a>
        <a href="ejemplos/jsp/login.jsp">Login</a>
        <a href="ejemplos/jsp/urlParams.jsp">Parámetros por Url</a>
    </nav>

    <main>

        <h1 class="blanco">Java Web App</h1>
        <section>
            <p>Bienvenido a Java Web App</p>
        </section>
        
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>