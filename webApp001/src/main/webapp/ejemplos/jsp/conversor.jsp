<%
	String titulo = "Conversor";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

	<%
		String resultado = "resultado";
		if(request.getAttribute("pies")!=null){
			resultado = (String)request.getAttribute("pies");
		}
	%>

    <main>

        <h1 class="blanco">Conversor Ipartek</h1>
        <section>
            <div class="container">
                <form id="contact" action="convertir" method="post">
                    <h3>Conversor</h3>
                    <fieldset>
                        <input placeholder="Distancia en metros" type="text" name="op1" tabindex="1" autofocus>
                    </fieldset>
                    <fieldset>
                    	<input type="text" placeholder="<%=resultado%>" readonly>
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