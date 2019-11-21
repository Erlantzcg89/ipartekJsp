<%
	String titulo = "Ipartek Web App";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/parallax.jsp" %>

<div class="menuWrapper">
    <nav class="menu">
        <a href="ejemplos/html/index.jsp">Ejercicios Html</a>
        <a href="ejemplos/css/index.jsp">Ejercicios Css</a>
        <a href="ejemplos/js/index.jsp">Ejercicios Js</a>
        <a href="ejemplos/jsp/index.jsp">Ejercicios Jsp</a>
       	<a href="ejemplos/howTos/menuPro.jsp">How To</a>
    </nav>
</div>

    <main>

        <h1 class="blanco">Alumn@s Ipartek</h1>
        <section>
            <div>
                <button class="blockAuto botonEstilo001" onclick="buscarVoluntario()">¿Quién Lee?</button>
                <h2>var voluntario = <span id="nombre"></span></h2>
            </div>

            <table id="ipartek" class="tablaAlumnos">
                <tr>
                    <td>Aitor</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Endika</td>
                    <td>Iker</td>
                </tr>
                <tr>
                    <td>Iñigo</td>
                    <td>kiryl</td>
                </tr>
                <tr>
                    <td>juan carlos</td>
                    <td>Maria</td>
                </tr>
                <tr>
                    <td>alejandro</td>
                    <td>ana</td>
                </tr>
                <tr>
                    <td>Cristian</td>
                    <td>Erlantz</td>
                </tr>
                <tr>
                    <td>Raul</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Joseba</td>
                    <td>Mikel</td>
                </tr>
                <tr>
                    <td colspan="2">ander</td>
                </tr>
            </table>
        </section>
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>