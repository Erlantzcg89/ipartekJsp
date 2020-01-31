<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="es">

<head>
<meta charset="utf-8">
<title>Documentación</title>
<base href="/">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="favicon.ico">

<!-- bootstrap cdn -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- font awesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>

	<header>
		<h1 class="text-center mt-3">Documentación</h1>
		<p class="text-center  mb-3">&copy; Erlantz Caballero 2020</p>
		<p class="text-center mb-4">
			Endpoint: <b>${pageContext.request.contextPath}/api/examen/</b>
		</p>
	</header>

	<main class="container-fluid">

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/pokemon/">/api/examen/</a><br>
				Recurso: Listar<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-success">204
					listado vacio</span>
			</div>
		</div>

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/pokemon/4">/api/examen/{id}</a><br>
				Recurso: Detalle<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-danger">404
					recurso no encontrado</span>
			</div>
		</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>

</html>