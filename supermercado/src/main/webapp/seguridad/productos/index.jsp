<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>   
    	
	<h1>TABLA</h1>
	
	<a href="/seguridad/productos?accion=formulario">Nuevo Producto</a>
	
	
	
	<ol>
		<c:forEach items="${productos}" var="p">
			<li>
				${p} <br>
				<a href="/seguridad/productos?accion=formulario&id=${p.id}">Editar</a>
			</li>
		</c:forEach>
	</ol>
	
	${productos}

<%@ include file="/includes/footer.jsp" %> 