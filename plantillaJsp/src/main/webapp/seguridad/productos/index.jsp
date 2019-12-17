<%@ page errorPage="privado/error500.jsp"%>

<%
	String titulo = "Dashboard";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<div class="listado-wrapper">
		<h1>Listado de productos</h1>


		<div class="mt-3">

			<c:forEach items="${productos}" var="producto">

				<ul>
					<li>Id: ${producto.id} | Nombre: ${producto.nombre}</li>
				</ul>

			</c:forEach>
			
			<a href="seguridad/index.jsp">volver al dashboard |</a>
			<a href="seguridad/producto?accion=nuevo">nuevo producto</a>

		</div>

	</div>
</main>

<%@include file="/includes/footer.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/pie.jsp"%>
