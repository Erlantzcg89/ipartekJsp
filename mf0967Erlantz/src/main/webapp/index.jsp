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
	
	<p>En construcción...</p>
		<div class="3libros row">

			<div class="col-sm-4 detalle-wrapper">
				<div class="detalle">
					<hr>
					<div class="detalle-imagen">
						<img src="https://source.unsplash.com/600x800/?book">
					</div>
					<hr>
					<div class="detalle-texto">
					</div>
					<div class="detalle-precio row">
						<div class="col3"><span>11,35&euro; </span></div>
						<div class="col3"><span>11,95&euro; </span></div>
						<div class="col3"><span>-5&#37;</span></div>
					</div>
				</div>
			</div>
			<div class="col-sm-4 detalle-wrapper">
				<div class="detalle">
					<hr>
					<div class="detalle-imagen">
						<img src="https://source.unsplash.com/600x800/?books">
					</div>
					<hr>
					<div class="detalle-texto">
					</div>
					<div class="detalle-precio row">
						<div class="col3"><span>11,35&euro; </span></div>
						<div class="col3"><span>11,95&euro; </span></div>
						<div class="col3"><span>-5&#37;</span></div>
					</div>
				</div>
			</div>
			<div class="col-sm-4 detalle-wrapper">
				<div class="detalle">
					<hr>
					<div class="detalle-imagen">
						<img src="https://source.unsplash.com/600x800/?writing">
					</div>
					<hr>
					<div class="detalle-texto">
					</div>
					<div class="detalle-precio row">
						<div class="col3"><span>11,35&euro; </span></div>
						<div class="col3"><span>11,95&euro; </span></div>
						<div class="col3"><span>-5&#37;</span></div>
					</div>
				</div>
			</div>
		</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
