<!-- Menu Index -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
	<span class="navbar-brand"><span
		class="menu-icono fas fa-dice-d6 mr-2"></span>CMS Jsp y Bootstrap</span>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link pl-3"
				href="index.jsp">Inicio</a></li>

			<%
				String user = (String) session.getAttribute("usuarioLogeado");

				if (user == null) {
			%>
			<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
			<%
				} else {
			%>
			<li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
			<%
				}
			%>


		</ul>
	</div>
</nav>