<%
	String titulo = "Arkanoid";
%>

<%@include file="/includes/cabecera.jsp" %>

<style>
canvas {
    border: 1px solid;
    display: block;
    margin: 0 auto;
}
</style>

<div class="menuWrapper">
	<nav class="menu" id="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/js/index.jsp">Volver a ejercicios Js</a>
        <a target="_blank" href="https://developer.mozilla.org/es/docs/Games/Workflows/Famoso_juego_2D_usando_JavaScript_puro">Tutorial</a>    
    </nav>
</div>

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