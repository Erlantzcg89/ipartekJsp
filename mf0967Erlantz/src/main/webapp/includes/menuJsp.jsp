<!-- Menu Jsp -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
	<span class="navbar-brand"><span
		class="menu-icono fas fa-dice-d6 mr-2"></span>CMS Productos</span>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<ul class="navbar-nav mr-auto">

			<li class="nav-item"><a class="nav-link pl-3"
				href="inicio">Inicio</a></li>

			<li class="nav-item active"><a class="nav-link pl-3"
				href="backoffice/index.jsp">Dashboard</a></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Productos</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="backoffice/productos?accion=listar">Ver productos</a> <a
						class="dropdown-item" href="backoffice/productos?accion=formulario">Nuevo producto</a>
				</div></li>
				
						<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Usuarios</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="backoffice/usuarios?accion=listar">Ver Usuarios</a> <a
						class="dropdown-item" href="backoffice/usuarios?accion=formulario">Nuevo usuario</a>
				</div></li>

		</ul>

	</div>
</nav>