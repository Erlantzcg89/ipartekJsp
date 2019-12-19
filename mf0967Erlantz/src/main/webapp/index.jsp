<%@page import="java.util.ArrayList"%>
<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Inicio - Listado de libros";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="listado-wrapper">

		<%@include file="/includes/mensaje-alerta.jsp"%>
		
		<div class="row">
			<div class="col-lg-4 detalle-wrapper">
				
			</div>
			<div class="col-lg-4">hola</div>
			<div class="col-lg-4">hola</div>
			<div class="col-lg-4">hola</div>
			<div class="col-lg-4">hola</div>
			<div class="col-lg-4">hola</div>
		</div>

		<div class="listado my-5">

			<c:forEach items="${libros}" var="libro">

				<fmt:formatNumber var="p" minFractionDigits="2" type="number"
					value="${libro.precio}" />

				<ul>
					<li><b>Id:</b> ${libro.id} | <b>Nombre:</b> ${libro.nombre} |
						<b>Precio:</b> ${p}&euro; | <b>Descuento:</b>
						${libro.descuento}&#37; | <b>Autor:</b>
						${libro.autor} | <b>Imagen:</b>
						${libro.imagen}
						
<%
	if (usuario != null) {
%>
| <a href="backoffice/modificar?id=${libro.id}&nombre=${libro.nombre}&precio=${libro.precio}&descuento=${libro.descuento}&autor=${libro.autor}&imagen=${libro.imagen}">modificar</a> - <a href="backoffice/borrar?id=${libro.id}&nombre=${libro.nombre}">eliminar</a>
<%
}
%>
	
						</li>
				</ul>

			</c:forEach>

		</div>

	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
