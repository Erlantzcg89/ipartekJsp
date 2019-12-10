<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% String titulo = "perrosApp | perros-jslt"; %>

<h1>Perros JSTL</h1>
<p>Mismo ejemplo para hacer un CRUD pero usando taglibs y EL (Expresion Languages)</p>

<c:choose>
    <c:when test="${not empty mensaje}">
		<p style="color:teal; font-size: 2em;">${mensaje}</p>
    </c:when>    
    <c:otherwise>
		<p style="color:teal; font-size: 2em;">Esperando mensage...</p>
    </c:otherwise>
</c:choose>

<ul>
	<c:forEach items="${perros}" var="p">
	<li><img src="${p.foto}"> ${p.id} - ${p.nombre} - ${p.raza}</li>
	</c:forEach>
</ul>

Añadir perro

<c:if test="${empty perroEditar}">
	<!-- si no existe el perroEditar useBeans -->
	
</c:if>

<form action="perros" method="post">
	
	<input type="text" readonly name="id" required value="${perroEditar.id}">
	<input type="text" name="nombre" placeholder="nombre" value="${perroEditar.nombre}" required>	
	<input type="text" name="raza" placeholder="raza" value="${perroEditar.raza}" required>
	<input type="text" name="imagen" placeholder="url de la imagen" value="${perroEditar.foto}" required>
	<input type="submit" value="Guardar">
</form>