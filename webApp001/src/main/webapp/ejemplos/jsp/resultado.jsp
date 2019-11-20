<%
	String titulo = "Resultado";
%>

<%@include file="/includes/cabecera.jsp" %>

	<nav class="menu">
		<a href="index.jsp">Inicio</a>
		<a href="ejemplos/jsp/calculadora.jsp">Volver a la Calculadora</a>
		<a href="ejemplos/jsp/index.jsp">Volver a ejercicios Jsp</a>
	</nav>

	<main>

	<%
		String resultado = (String)request.getAttribute("enviar");
		String op1 = (String)request.getAttribute("op1");
		String op2 = (String)request.getAttribute("op2");
		String operacion = (String)request.getAttribute("op3");
	%>

		<h1 class="blanco">Calculadora Ipartek</h1>
		<section>
			<div class="container">
				<h3>Resultado</h3>
				<p>El resultado de <%=op1%> <%=operacion%> <%=op2%> es= <%=resultado%></p>
			</div>
		</section>
		
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>