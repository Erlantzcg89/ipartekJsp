<%
	String titulo = "Menu Dropdown";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

<main id="contenido">
    <h1 class="blanco">Menú responsive</h1>
    <section>
    	<sample>
    		<nav class="topnav" id="myTopnav">
    <a href="#home" class="active">Inicio</a>
    <div class="dropdown">
        <button class="dropbtn">Ejercicios html
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="ejemplos/html/etiquetas-basicas.jsp">Etiquetas básicas</a>
            <a href="ejemplos/html/visualizacion.jsp">Visualización</a>
            <a href="ejemplos/html/posicionamiento.jsp">Posicionamiento</a>
            <a href="ejemplos/html/formularios.jsp">Formularios</a>
            <a href="ejemplos/html/login.jsp">Login</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Ejercicios css
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="ejemplos/css/especificidad.jsp">Especificidad</a>
            <a href="ejemplos/css/selectores-basico.jsp">Selectores b&aacute;sicos</a>
            <a href="ejemplos/css/selectores-avanzado.jsp">Selectores avanzados</a>
            <a href="ejemplos/css/animaciones.jsp">Animaciones</a>
            <a href="ejemplos/css/font-awesome.jsp">Font-Awesome</a>
            <a href="ejemplos/css/flex-box.jsp">Flex-box</a>
            <a href="ejemplos/css/menuPro.jsp">Menu-dropdown</a>
            <a href="ejemplos/css/media-querys.jsp">Media-queries</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Ejercicios js
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="ejemplos/js/arkanoid.jsp">Arkanoid</a>
            <a href="ejemplos/js/datatable.jsp">Datatable</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Ejercicios jsp
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="ejemplos/jsp/calculadora.jsp">Calculadora</a>
            <a href="ejemplos/jsp/login.jsp">Login</a>
            <a href="ejemplos/jsp/urlParams.jsp">Parámetros por url</a>
        </div>
    </div>
    <a href="javascript:void(0);" class="icon" onclick="menuResponsive()">&#9776;</a>
</nav>
    	</sample>
    </section>

    <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
</main>

    
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>