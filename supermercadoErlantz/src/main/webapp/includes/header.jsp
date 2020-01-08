<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es_ES"/>

<%@ page contentType="text/html; charset=UTF-8" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Ander Uraga">
    <title>Supermercado</title>
    
   <base href="${pageContext.request.contextPath}/" >

   <!-- Bootstrap core CSS -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" rel="stylesheet">

	<!-- datatables -->
	<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"  rel="stylesheet">

   <!-- nuestro css -->
   <link rel="stylesheet" href="css/custom.css?time=<%=System.currentTimeMillis()%>">

  </head>
  <body id="top">
	  
    <nav class="site-header sticky-top py-1">
        <div class="container d-flex flex-column flex-md-row justify-content-between">
            
            <a class="py-2 d-md-inline-block" href="index.jsp">Inicio</a>
            
            <c:if test="${empty usuarioLogeado }" >
            	<a class="py-2 d-none d-md-inline-block" href="login.jsp">Login</a>
            </c:if>
            
            <c:if test="${usuarioLogeado.rol.id eq 2 }" >
            	<a class="py-2 d-none d-md-inline-block" href="seguridad/productos?accion=listar">Tabla</a>
            	<a class="py-2 d-none d-md-inline-block" href="seguridad/productos?accion=formulario">Formulario</a>            	
            </c:if>	            
            
            <c:if test="${usuarioLogeado.rol.id eq 1 }" >            	
            	<a class="py-2 d-none d-md-inline-block" href="mipanel/productos?accion=listar">Mis Producto</a>
            	<a class="py-2 d-none d-md-inline-block" href="mipanel/productos?accion=formulario">Crear Nuevo</a>            	
            </c:if>
            
            <c:if test="${not empty usuarioLogeado }" >
            	<a class="py-2 d-none d-md-inline-block" href="logout">Cerrar Sessión</a>
            </c:if>	
           
        </div>
    </nav>

    <main class="container">
    
   
	    <c:if test="${not empty mensajeAlerta }">
	    
		    <div class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-3" role="alert">
			  ${mensajeAlerta.texto}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		
		</c:if>
    
    