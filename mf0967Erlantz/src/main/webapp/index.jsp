<%@page import="java.util.ArrayList"%>
<%@ page errorPage="errores/error500.jsp"%>

<%
	String titulo = "Dashboard";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="listado-wrapper">

		<c:if test="${not empty mensajeAlertaListado }">

			<div
				class="alert alert-${mensajeAlertaListado.tipo} alert-dismissible fade show mt-3"
				role="alert">
				${mensajeAlertaListado.texto}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

		</c:if>

		<h1 class="h3 mt-5 font-weight-normal text-center">Listado de
			libros</h1>


		<div class="listado my-5">

			<c:forEach items="${libros}" var="libro">

				<fmt:formatNumber var="p" minFractionDigits="2" type="number"
					value="${libro.precio}" />

				<ul>
					<li><b>Id:</b> ${libro.id} | <b>Nombre:</b> ${libro.nombre} |
						<b>Precio:</b> ${p}&euro; | <b>Descuento:</b>
						${libro.descuento}&#37;</li>
				</ul>

			</c:forEach>

		</div>

	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
