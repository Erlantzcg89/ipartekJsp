<%
	String titulo = "Animaciones Css";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

<style>
        .box-animacion {

            display: block;
            margin: auto;
            width: 150px;
            height: 150px;
            background-color: #0099CC;
            animation: mymove 2s infinite alternate;
        }
</style>

    <main>
        <h1 class="blanco">Animaciones @Keyframe</h1>

        <section>
            <h2>@Keyframe en un &lt;div&gt;</h2>
            <div class="box-animacion"></div>
        </section>
    </main>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>