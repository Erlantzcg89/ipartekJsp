<%
	String titulo = "Conversor";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

<style>
	.verde{
		color: green;
	}
	.rojo{
	color: red;
	}
</style>

	<%
		String metros ="";
		String resultado = "";
		String clasesMensaje ="verde";
		String mensaje = "Introduce la distancia en metros";
		if(request.getAttribute("pies")!=null && request.getAttribute("metros")!=null){
			mensaje = "";
			metros = (String)request.getAttribute("metros");
			resultado = (String)request.getAttribute("pies");
		}
		if(request.getAttribute("mensageError")!=null){
			mensaje =(String)request.getAttribute("mensageError");
			clasesMensaje = "rojo";
		}
	%>

    <main>

        <h1 class="blanco">Conversor Ipartek</h1>
        <section>
            <div class="container">
                <form id="contact" action="convertir" method="post">
                    <h3>Metros a pies</h3>
                    <span class="<%=clasesMensaje%>"><%=mensaje%></span>
                    <fieldset>
                        <input value="<%=metros%>" placeholder="Distancia en metros" type="text" name="op1" tabindex="1" autofocus>
                    </fieldset>
                    <fieldset>
                    	<input type="text" value="<%=resultado%>" placeholder="Resultado"  readonly>
                    </fieldset>
                    <fieldset>
                        <button name="submit" type="submit" id="contact-submit"
                            data-submit="...Enviando">Convertir</button>
                    </fieldset>
                </form>
            </div>
        </section>
        
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>