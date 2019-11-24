<%
	String titulo = "Arkanoid";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

<style>
canvas {
    border: 1px solid;
    display: block;
    margin: 0 auto;
}
</style>

    <main>
        <h1 class="blanco">Arkanoid</h1>

        <section>
            <canvas id="myCanvas" width="480" height="320"></canvas>
        </section>
        
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
       
    </main>
    <script src="js/game.js"></script>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>