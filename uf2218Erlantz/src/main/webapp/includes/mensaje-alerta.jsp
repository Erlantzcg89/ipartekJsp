	<c:if test="${not empty mensajeAlerta }">

		<div
			class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-3"
			role="alert">
			${mensajeAlerta.texto}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

	</c:if>