<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Dashboard - listado";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="listado-wrapper">
	
	<%@include file="/includes/mensaje-alerta.jsp"%>
	
		<h1>Listado de libros</h1>

		<div class="mt-3">

			<c:forEach items="${libros}" var="libro">

				<ul>
					<li>Id: ${libro.id} | Nombre: ${libro.nombre}</li>
				</ul>

			</c:forEach>
			
			<a href="index.jsp">volver al dashboard |</a>
			<a href="libros/nuevo-libro.jsp">nuevo libro</a>

		</div>

	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
