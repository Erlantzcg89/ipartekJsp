<%@ page errorPage="errores/error500.jsp"%>
<%
	String titulo = "CMS Jsp y Bootstrap";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesDatatable.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuJsp.jsp"%>
<%@include file="/includes/submenu.jsp"%>

<div class="container-fluid p-4">

	<main class="ejemplo02-main">
		<h4 class="text-center text-dark mb-4">Formulario deportes</h4>

		<div class="ejemplo02-caja-centrado">

			<div class="formulario-deportes">
				<form action="privado/deportes" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nombre"
							name="nombre" required>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Email"
							name="email" required>
					</div>
					<p>Deportes favoritos:</p>
					<div class="form-check">
						<div class="form-group">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1" name="deportes" value="Football"> <label
								class="form-check-label" for="exampleCheck1">Football</label>
						</div>
						<div class="form-group">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck2" name="deportes" value="Basketball"> <label
								class="form-check-label" for="exampleCheck2">Basketball</label>
						</div>
						<div class="form-group">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck3" name="deportes" value="KickBoxing"> <label
								class="form-check-label" for="exampleCheck3">KickBoxing</label>
						</div>
						<div class="form-group">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck4" name="deportes" value="KungFu"> <label
								class="form-check-label" for="exampleCheck4">KungFu</label>
						</div>
						<div class="form-group">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck5" name="deportes" value="Boxeo"> <label
								class="form-check-label" for="exampleCheck5">Boxeo</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
			<p class="mt-4">
				Nombre: ${nombre}<br> Email: ${email}
			</p>
				<ul>
				<c:forEach items="${deportes}" var="deporte" varStatus="i">
  					<li>${deporte}</li>
				</c:forEach>
				</ul>

		</div>

	</main>
</div>

<%@include file="/includes/footer-fixed.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/scriptsDatatable.jsp"%>
<%@include file="/includes/pie.jsp"%>