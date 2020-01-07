<%@ page errorPage="privado/error500.jsp"%>

<%
	String titulo = "Listado productos";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/enlacesDatatable.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<main>
	<main>
	
		<div class="listado-wrapper">

			<table class="dataTable display" style="width: 100%">
				<thead>
					<tr>
						<th>id</th>
						<th>nombre</th>
						<th>editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productos}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.nombre }</td>
							<td><a
								href="backoffice/productos?accion=formulario&id=${p.id}">editar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<!-- fin listado-wrapper -->
	</main>
</main>

<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/scriptsDatatable.jsp"%>
<%@include file="/includes/pie.jsp"%>