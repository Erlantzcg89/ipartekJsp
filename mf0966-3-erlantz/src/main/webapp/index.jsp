<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="es">

<head>
<meta charset="utf-8">
<title>Documentación mf0966-3-erlantz</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<base href="${pageContext.request.contextPath}/">

<!-- bootstrap cdn -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- font awesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>

	<header>
		<h1 class="text-center my-4">Documentación</h1>
		<p class="text-center  my-4">
			&copy; Erlantz Caballero 2020<br>Endpoint:
			${pageContext.request.contextPath}/api/
		</p>

		<main class="container-fluid mt-4 p-4">

			<section>

				<h2 class="text-center mb-4">/api/curso/</h2>
				<div class="alert alert-info bg-info" role="alert">
					<div class="alert alert-info mt-4" role="alert">
						GET <a class="" target="_blank"
							href="${pageContext.request.contextPath}/api/curso/">/api/curso/</a><br>
						Recurso: Listar. Array de Objetos JSON<br>Códigos de estado:
						<span class="text-success">200 éxito</span> | <span
							class="text-success">204 listado vacio</span>
					</div>
				</div>

				<div class="alert alert-info bg-info" role="alert">
					<div class="alert alert-info mt-4" role="alert">
						GET <a class="" target="_blank"
							href="${pageContext.request.contextPath}/api/curso/1">/api/curso/{id}</a><br>
						Recurso: Detalle. Objeto JSON<br>Códigos de estado: <span
							class="text-success">200 éxito</span> | <span class="text-danger">404
							recurso no encontrado</span>
					</div>
				</div>

				<h2 class="text-center mb-4">/api/valoracion/</h2>
				
							<div class="alert alert-info bg-info" role="alert">
					<div class="alert alert-info mt-4" role="alert">
						GET <a class="" target="_blank"
							href="${pageContext.request.contextPath}/api/valoracion/">/api/valoracion/</a><br>
						Recurso: Listar. Array de Objetos JSON<br>Códigos de estado:
						<span class="text-success">200 éxito</span> | <span
							class="text-success">204 listado vacio</span>
					</div>
				</div>

				<div class="alert alert-info bg-info" role="alert">
					<div class="alert alert-info mt-4" role="alert">
						GET <a class="" target="_blank"
							href="${pageContext.request.contextPath}/api/valoracion/1">/api/valoracion/{id}</a><br>
						Recurso: Detalle. Objeto JSON<br>Códigos de estado: <span
							class="text-success">200 éxito</span> | <span class="text-danger">404
							recurso no encontrado</span>
					</div>
				</div>

				<div class="alert alert-danger bg-danger" role="alert">
					<div class="alert alert-danger mt-4" role="alert">
						DELETE /api/valoracion/{id}<br>
						Recurso: Eliminar<br>Códigos de estado: <span
							class="text-success">200 éxito</span> | <span class="text-danger">404
							recurso no encontrado</span>
					</div>
				</div>

				<div class="alert alert-success bg-success" role="alert">
					<div class="alert alert-success mt-4" role="alert">
						POST /api/valoracion/<br>
						Recurso: Insertar<br>Códigos de estado: <span
							class="text-success">201 creado con éxito</span> | <span
							class="text-danger">400 conflicto (parámetros incorrectos)</span>,
						<span class="text-danger">409 conflicto (unique key)</span>
					</div>
				</div>

				<div class="alert alert-warning bg-warning" role="alert">
					<div class="alert alert-warning mt-4" role="alert">
						PUT /api/valoracion/{id}<br>
						Recurso: Update<br>Códigos de estado: <span
							class="text-success">200 éxito</span> | <span class="text-danger">400
							conflicto (parámetros incorrectos)</span>, <span class="text-danger">404
							recurso no encontrado</span>, <span class="text-danger">409
							conflicto (unique key)</span>
					</div>
				</div>

			</section>

			<section class="mt-4 p-4 border rounded bg-dark">

				<h2 class="text-center text-white">Ejemplos del comportamiento
					del servicio con la herramienta Postman</h2>

				<article class="p-4 m-4 border rounded bg-white">
					<div class="my-4">
						<h6 class="mb-3 ml-4">Get: listado en postman</h6>
						<img src="images/getAllPostman.PNG" alt="get listado">
					</div>
				</article>

				<article class="p-4 m-4 border rounded bg-white">
					<div class="my-4">
						<h6 class="mb-3 ml-4">
							Get: listado con filtro de nombre en postman. <small
								class="text-muted">Cuando la petición al recurso libro
								devuelve una lista vacia, ya sea porque la base de datos esté
								vacia o porque la busqueda por el parámetro nombre ha devuelto
								una lista vacía, el codigo devuelto será un 204</small>
						</h6>

						<img src="images/getAllNombrePostman.PNG"
							alt="get listado con filtro">
					</div>
				</article>

				<article class="p-4 m-4 border rounded bg-white">
					<div class="my-4">
						<h6 class="mb-3 ml-4">Recurso (listado) vacio en postman</h6>
						<img src="images/204.PNG" alt="204">
					</div>
				</article>

				<article class="p-4 m-4 border rounded bg-white">
					<div class="my-4">
						<h6 class="mb-3 ml-4">
							Recurso no encontrado en postman. <small class="text-muted">Cuando
								la dirección del recurso esté mal escrita la api devolverá un
								estado 404, recurso no encontrado</small>
						</h6>
						<img src="images/404.PNG" alt="404">
					</div>
				</article>

			</section>

		</main>

		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>

</html>