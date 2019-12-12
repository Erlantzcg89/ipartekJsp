<!-- Menu Index -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
	<span class="navbar-brand"><span
		class="menu-icono fas fa-dice-d6 mr-2"></span>CMS</span>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<%
				String user = (String) session.getAttribute("usuarioLogeado");

				if (user == null) {
			%>
			<li class="nav-item">
				<button type="button" class="btn btn-danger" data-toggle="modal"
					data-target="#exampleModal">Login</button>
			</li>
			<%
				} else {
			%>
			<!-- esconder el boton si estamos logueados -->
			<%
				}
			%>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Jsp básicos </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="privado/servlet-pinta">servlet pinta</a>
					<a class="dropdown-item" href="privado/jsp/ejemplo02.jsp">jsp pinta</a>
					<a class="dropdown-item" href="privado/formulario-deportes.jsp">formulario deportes</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Perros </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="privado/servlet-pinta">scriplets</a>
					<a class="dropdown-item" href="privado/jsp/ejemplo02.jsp">jslt</a>
					<a class="dropdown-item" href="privado/formulario-deportes.jsp">formulario deportes</a>
					
				</div></li>



		</ul>
	</div>
</nav>