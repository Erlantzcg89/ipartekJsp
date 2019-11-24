<%
	String titulo = "Ipartek Web App";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/tableResources.jsp" %>
<%@include file="/includes/parallax.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

    <main>

        <h1 class="blanco">Alumn@s Ipartek</h1>
        <section>
            <div>
                <button class="botonEstilo001" onclick="buscarVoluntario()">¿Quién Lee?</button>
                <h2>var voluntario = <span id="nombre"></span></h2>
            </div>

            <table class="tablaAlumnos tablaData stripe" style="width:100%; padding: 20px;">
            	<tbody>
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
                    <td id="ander" colspan="2">Profesor: Ander</td>
                </tr>
                </tbody>
            </table>
        </section>
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>