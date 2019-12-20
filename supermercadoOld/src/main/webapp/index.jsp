
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es_ES" />

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Ander Uraga">
<title>Supermercado</title>

<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<!-- nuestro css -->
<link rel="stylesheet" href="css/custom.css?time=<%=System.currentTimeMillis()%>">

</head>
<body id="top">
	<nav class="site-header sticky-top py-1">
		<div
			class="container d-flex flex-column flex-md-row justify-content-between">
			<a class="py-2" href="index.html"> <svg
					xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" class="d-block mx-auto"
					role="img" viewBox="0 0 24 24" focusable="false">
					<title>Product</title><circle cx="12" cy="12" r="10" />
					<path
						d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" /></svg>
			</a> <a class="py-2 d-none d-md-inline-block" href="login.html">Login</a>
			<a class="py-2 d-none d-md-inline-block" href="tabla.html">Tabla</a>
			<a class="py-2 d-none d-md-inline-block" href="formulario.html">Formulario</a>

		</div>
	</nav>

	<main class="container">



		<div class="row contenedor-productos">

			<c:forEach items="${productos}" var="producto">

				<div class="col">

					<!-- producto -->
					<div class="producto">
						<c:set var="descuento" value="${producto.descuento}"/>
						<c:if test="${descuento > 0}">
							<span class="descuento">${producto.descuento}%</span>
						</c:if> 
						
 						<img src="${producto.imagen}" alt="imagen de bottela de vodka">

						<div class="body">
							<p>
								<span class="precio-descuento"><fmt:formatNumber
										type="currency" currencySymbol="€" value="${producto.precio}" /></span>
								<span class="precio-original"><fmt:formatNumber
										type="currency" currencySymbol="€"
										value="${producto.precioDescuento}" /></span>
							</p>
							<p class="text-muted precio-unidad">(${producto.precio})</p>
							<p class="descripcion">${producto.nombre}
								${producto.description}</p>
						</div>

						<div class="botones">
							<button class="minus">-</button>
							<input type="text" value="1">
							<button class="plus">+</button>
						</div>

						<button class="carro">añadir al carro</button>

					</div>
					<!-- /.producto -->

				</div>

			</c:forEach>

		</div>

	</main>

	<div class="footer-wrapper">
		<footer class="container py-5">
			<div class="row">
				<div class="col-12 col-md">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="none" stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" class="d-block mb-2"
						role="img" viewBox="0 0 24 24" focusable="false">
						<title>Product</title><circle cx="12" cy="12" r="10" />
						<path
							d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" /></svg>
					<small class="d-block mb-3 text-muted">&copy; 2019</small>
				</div>

				<div class="col-6 col-md offset-6">
					<h5>Enlaces de Interes</h5>
					<ul class="list-unstyled text-small">
						<li><a class="text-muted" href="politica-privacidad.html">Politica
								Privacidad</a></li>
						<li><a class="text-muted" href="localizacion.html">LocalizaciÃ³n</a></li>
						<li><a class="text-muted" href="contacto.html">Contacto</a></li>
					</ul>
				</div>

			</div>
		</footer>
	</div>

	<a id="btn-top" href="#top" class="btn btn-primary">top</a>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>

</html>
