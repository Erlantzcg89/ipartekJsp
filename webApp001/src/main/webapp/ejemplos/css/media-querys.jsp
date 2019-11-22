<%
	String titulo = "@Media";
%>

<%@include file="/includes/cabecera.jsp" %>

<style>
	@media screen and (min-width: 426px) and (max-width: 768px){
		section{
			background-color: purple;
			border-color: purple;
		}
		h1{
			color: purple !important;
		}
	}
	
	@media screen and (max-width: 425px){
		section{
			background-color: pink;
			border-color: pink;
		}
		h1{
			color: pink !important;
		}
	}
	

</style>

<div class="menuWrapper">
     <nav class="menu" id="menu">
          <a href="index.jsp">Inicio</a>
        <a href="ejemplos/css/index.jsp">Volver</a>
    </nav>
</div>
    
    <main>

        <h1 class="blanco">@Media Query</h1>

        <section>
        	<p>Se utilizan para el diseño responsivo</p>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>