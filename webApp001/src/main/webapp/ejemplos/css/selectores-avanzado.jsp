<%
	String titulo = "Selectores avanzados css";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

    <main>
        <h1 class="blanco">Selectores Css Avanzados</h1>

        <section>
            <h2>Selector hijo <code>&gt;</code></h2>
            <p>Aunque el selector descendiente es bastante interesante, nos puede interesar hacer la misma operación, pero en lugar de seleccionar todos los elementos descendientes, seleccionar sólo los descendientes directos del elemento, descartando así nietos y sucesivos.</p>
        	<h2>Selector hermano adyacente <code>&#43;</code></h2>
        	<p>Es posible también hacer referencia a los elementos hermanos, es decir, aquellos elementos que están directamente a continuación del elemento especificado. Mediante el selector hermano adyacente se pueden seleccionar aquellos elementos hermanos que están seguidos el uno de otro (en el mismo nivel).</p>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>