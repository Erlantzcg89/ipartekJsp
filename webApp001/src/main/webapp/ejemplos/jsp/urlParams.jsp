<%
	String titulo = "Parámetros por Url";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

    <main>
        <h1 class="blanco">Url con parámetros</h1>
        <section>
        <h2>Parámetros <code>?</code> y <code>&</code></h2>
        <p>Los diferentes parámetros son añadidos al final de la url:</p>
		<p>
			<a target="_blank" href="https://es.wallapop.com/search?keywords=cafetera&max_sale_price=50">Realizar búsqueda de cafetera</a>
        </p>
        <p>A la búsqueda de la cafetera se le ha especificado los parámetros ?=keywords=cafetera y &max_sale_price=50</p>
        </section>
    </main>
    
<%@include file="/includes/pie.jsp" %>