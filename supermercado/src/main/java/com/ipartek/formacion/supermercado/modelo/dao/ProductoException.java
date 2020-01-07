package com.ipartek.formacion.supermercado.modelo.dao;

import javax.servlet.jsp.jstl.sql.SQLExecutionTag;

public class ProductoException extends Exception {
	
	

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_UNAUTORIZED = "El Producto no pertenece al Usuario";
	
	
	public ProductoException(String mensaje) {
		super(mensaje);
	}
	

}
