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

		<h1 class="h3 mt-5 font-weight-normal text-center">Listado de
			libros</h1>

		<div class="listado my-5">

			<c:forEach items="${libros}" var="libro">

				<ul>
					<li><b>Id:</b> ${libro.id} | <b>Nombre:</b> ${libro.nombre} |
						<b>Precio:</b> ${libro.precio}&euro; | <b>Descuento:</b>
						${libro.descuento}&#37;</li>
				</ul>

			</c:forEach>

		</div>
		<div class="text-center">
			<a href="index.jsp">volver al dashboard</a><br> <a
				href="libros/nuevo-libro.jsp">nuevo libro</a>
		</div>

	</div>
</main>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
