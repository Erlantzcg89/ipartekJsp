<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

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
	</header>

	<main class="container-fluid">

		<p class="text-center mb-4">
			Endpoint: <b>${pageContext.request.contextPath}/api/usuario/</b>
		</p>

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/usuario/?nombre=admin&password=admin">/api/usuario/?nombre de usuario & contraseña</a><br>
				Recurso: Login, devuelve detalle de usuario si es exitoso<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-danger">404
					recurso no encontrado</span>
			</div>
		</div>

		<p class="text-center mb-4">
			Endpoint: <b>${pageContext.request.contextPath}/api/habilidad/</b>
		</p>

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/habilidad/">/api/habilidad/</a><br>
				Recurso: Listar<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-success">204
					listado vacio</span>
			</div>
		</div>

		<p class="text-center mb-4">
			Endpoint: <b>${pageContext.request.contextPath}/api/pokemon/</b>
		</p>

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/pokemon/">/api/pokemon/</a><br>
				Recurso: Listar<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-success">204
					listado vacio</span>
			</div>
		</div>

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/pokemon/4">/api/pokemon/{id}</a><br>
				Recurso: Detalle<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-danger">404
					recurso no encontrado</span>
			</div>
		</div>

		<div class="alert alert-danger bg-danger" role="alert">
			<div class="alert alert-danger mt-4" role="alert">
				DELETE <a class="" href="pokemon-rest">/api/pokemon/{id}</a><br>
				Recurso: Eliminar<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-danger">404
					recurso no encontrado</span>
			</div>
		</div>

		<div class="alert alert-success bg-success" role="alert">
			<div class="alert alert-success mt-4" role="alert">
				POST <a class="" href="pokemon-rest">/api/pokemon/{id}</a><br>
				Recurso: Insertar<br>Códigos de estado: <span
					class="text-success">201 creado con éxito</span> | <span
					class="text-danger">400 conflicto (parámetros incorrectos)</span>,
				<span class="text-danger">409 conflicto (unique key)</span>
			</div>
		</div>

		<div class="alert alert-warning bg-warning" role="alert">
			<div class="alert alert-warning mt-4" role="alert">
				PUT <a class="" href="pokemon-rest">/api/pokemon/{id}</a><br>
				Recurso: Update<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-danger">400
					conflicto (parámetros incorrectos)</span>, <span class="text-danger">404
					recurso no encontrado</span>, <span class="text-danger">409
					conflicto (unique key)</span>
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