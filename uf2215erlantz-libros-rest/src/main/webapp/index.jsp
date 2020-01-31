<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="es">

<head>
<meta charset="utf-8">
<title>Documentación uf2215erlantz-libros-rest</title>
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
		<h1 class="text-center mt-3">Documentación</h1>
		<p class="text-center  mb-3">uf2215erlantz-libros-rest</p>
		<p class="text-center  mb-3">&copy; Erlantz Caballero 2020</p>
		<p class="text-center mb-4">
			Endpoint: <b>${pageContext.request.contextPath}/api/libro/</b>
		</p>
	</header>

	<main class="container-fluid px-4">

		<div class="alert alert-info bg-info" role="alert">
			<div class="alert alert-info mt-4" role="alert">
				GET <a class="" target="_blank"
					href="${pageContext.request.contextPath}/api/libro/">/api/libro/</a><br>
				Recurso: Listar. Array de Objetos JSON<br>Códigos de estado: <span
					class="text-success">200 éxito</span> | <span class="text-success">204
					listado vacio</span>
			</div>
		</div>

		<div>
			<h3>Parámetros disponibles para GET /api/libro/: listar</h3>
			<ul>
				<li><b>nombre</b>: Filtra los libros por su nombre. Ejemplo:
					api/libro/<b>?nombre=juego muestra el libro "Juego de tronos"</b></li>
			</ul>
			<p>A continuación se muestran cuatro capturas del comportamiento
				del servicio con la herramienta Postman</p>
		</div>

		<p>El GET para el recurso libro ofrece un listado de los libros
			disponibles en nuestra base de datos, y el parámetro nombre permite
			filtrar los libros por su nombre propio.</p>

		<div class="my-4">
			<h3 class="mb-3">Get: listado en postman</h3>
			<img src="images/getAllPostman.PNG" alt="get listado">
		</div>

		<div class="my-4">
			<h3 class="mb-3">Get: listado con filtro de nombre en postman</h3>
			<img src="images/getAllNombrePostman.PNG"
				alt="get listado con filtro">
		</div>

		<p>Cuando la petición al recurso libro devuelve una lista vacia,
			ya sea porque la base de datos esté vacia o porque la busqueda por el
			parámetro nombre ha devuelto una lista vacía, el codigo devuelto será
			un 204.</p>

		<div class="my-4">
			<h3 class="mb-3">Recurso (listado) vacio en postman</h3>
			<img src="images/204.PNG" alt="204">
		</div>

		<p>Cuando la dirección del recurso esté mal escrita la api
			devolverá un estado 404, recurso no encontrado.</p>

		<div class="my-4">
			<h3 class="mb-3">Recurso no encontrado en postman</h3>
			<img src="images/404.PNG" alt="404">
		</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>

</html>