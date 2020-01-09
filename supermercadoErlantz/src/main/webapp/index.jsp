<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="includes/header.jsp"%>

<form action="inicio" method="post" class="mb-5">

	<div class="form-group">
		<label>Filtrar por Categoria:</label> <select name="categoriaId" class="custom-select">
			<c:forEach items="${categorias}" var="c">
				<option value="${c.id}">${c.nombre}</option>
			</c:forEach>
		</select>
		
		<label>Filtrar por Nombre:</label>
		<input type="text" name="nombre" value="${producto.nombre}" class="form-control" placeholder="introduce el nombre del producto">
	</div>
	
	<input type="submit" value="Filtrar" class="btn btn-block btn-success">

</form>

<div class="row contenedor-productos">

	<c:forEach items="${productos}" var="p">

		<div class="col">

			<!-- producto -->
			<div class="producto mb-4">
				<span class="descuento">${p.descuento}%</span> <img
					src="${p.imagen}" alt="imagen de ${p.nombre}">

				<div class="body">
					<p>
						<span class="precio-descuento"> <fmt:formatNumber
								minFractionDigits="2" type="currency" currencySymbol="€"
								value="${p.precio}" />
						</span> <span class="precio-original"> <fmt:formatNumber
								minFractionDigits="2" type="currency" currencySymbol="€"
								value="${p.precioDescuento}" />
						</span>
					</p>
					<p class="text-muted precio-unidad ">${p.nombre}</p>
					<p class="descripcion text-truncate">${p.descripcion}</p>
					<p class="descripcion text-truncate">Categoria: ${p.categoria.nombre}</p>
					<p class="descripcion text-truncate">Usuario: ${p.usuario.nombre}</p>
				</div>

				<div class="botones">
					<button class="minus">-</button>
					<input type="text" value="1">
					<button class="plus">+</button>
				</div>

				<button class="carro">añadir al carro</button>

			</div>
			<!-- /.producto -->

		</div>
		<!-- /.col -->

	</c:forEach>

</div>
<!-- row contenedor-productos -->

<%@ include file="includes/footer.jsp"%>
