<%
	String titulo = "Menu Pro";
%>

<%@include file="/includes/cabecera.jsp" %>

<style>
body {margin:0;font-family:Arial}

.topnav {
  overflow: hidden;
  background-color: black;
  padding: 0;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.active {
/*   background-color: #4CAF50; */
  color: white;
}

.topnav .icon {
  display: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 15px;    
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: black;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  pointer-events:none;
}

button i{
	pointer-events:none;

}

.dropdown-content a {
  float: none;
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: #555;
  color: white;
}

.dropdown-content a:hover {
  background-color: #555;
  color: white;
}

/* .dropdown:hover .dropdown-content {
  display: block;
} */

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child), .dropdown .dropbtn {
    display: none;
  }
  .topnav a.icon {
    float: right;
    display: block;
  }
}

  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
    display: block;
    width: 100%;
    text-align: left;
  }
  
  #desplegable:target{
  
  }

</style>

<nav class="topnav" id="myTopnav">
  <a href="#home" class="active">Inicio</a>
  <a href="#news">News</a>
  <a href="#desplegable">Contact</a>
  <div id="dropdown" class="dropdown">
    <button id="boton" onclick="mostrar()" class="dropbtn">Dropdown 
      <i class="fa fa-caret-down"></i>
    </button>
    <div id="desplegable" class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
  <a href="#about">About</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</nav>

    <main id="contenido">
        <h1 class="blanco">Menú responsive</h1>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
    
    <script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function mostrar() {
	console.info('estoy en la funcion mostrar');
	var desplegable = document.getElementById("desplegable");
	
	desplegable.style.display = "block";
	  
/* 	setTimeout(ocultar, 3000); */
}

function ocultar(){
	console.info('estoy en la funcion ocultar');
	var desplegable = document.getElementById("desplegable");

	desplegable.style.display = "none";
	console.info('despues del timeout display none');
}

var body = document.getElementById('cuerpo');
var contenido = document.getElementById('contenido');
var except = document.getElementById('dropdown');


body.addEventListener("click", function () {
	desplegable.style.display = "none";
}, false);

contenido.addEventListener("click", function () {
	desplegable.style.display = "none";
}, false);

except.addEventListener("click", function (ev) {
    ev.stopPropagation();
}, false);
	
</script>
    
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>