<!DOCTYPE html> <!-- html5 -->
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title><%=titulo%></title>

        <!-- la base para construir todas las rutas de esta pagina -->
        <base href="/perrosApp/">
        
        <!--  fontawesome  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />

        <!-- estilos -->
        <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">

    </head>
    <body id="#top">
    
    <section id="usuario">
    	<%
    		String usuario = (String)session.getAttribute("usuarioLogeado");
    		String idioma = (String)session.getAttribute("idioma");    	
    		
    		if ( usuario == null ){
    			
    			%>
    				<p>Por favor <a href="login.jsp">inicio session</a></p>
    			    			
    			<%
    		}else{
    			%>    	
    				<p>Usuario: <%=usuario%></p>
    				<p>Idioma: <%=idioma%></p>	
    				<p><a href="logout">Cerrar Sesssion</a></p>	
    			<%
    		}
    	%>
    	
    	
    </section>
    <span>HEADER</span>