<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>   
    	
	
	<a href="seguridad/productos?accion=formulario">Nuevo Producto</a>
	
	<table  class="tabla display" style="width:100%">
        <thead>
            <tr>
                <th>id</th>                
                <th>nombre</th>
                <th>Editar</th>                
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${productos}" var="p">
            	<tr>
                	<td>${p.id}</td>
                	<td>${p.nombre }</td>
                	<td><a href="seguridad/productos?accion=formulario&id=${p.id}">Editar</a></td>
            	</tr>
            </c:forEach>	
        </tbody>    
    </table>
	
	

<%@ include file="/includes/footer.jsp" %> 