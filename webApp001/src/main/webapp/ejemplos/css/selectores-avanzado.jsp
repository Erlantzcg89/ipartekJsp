<%
	String titulo = "Selectores avanzados css";
%>

<%@include file="/includes/cabecera.jsp" %>

   <nav class="menu" id="menu">
         <a href="index.jsp">Inicio</a>
        <a href="ejemplos/css/index.jsp">Volver</a>
    </nav>

    <main>
        <h1 class="blanco">Selectores Css Avanzados</h1>

        <section>
            <h2>&gt;, +, ...</h2>
            <div class="blockAuto width600">
                <ol>
                    <li>elemente > elemento</li>
                    <li>elemento + elemento</li>
                    <li>otros</li>
                </ol>
            </div>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>