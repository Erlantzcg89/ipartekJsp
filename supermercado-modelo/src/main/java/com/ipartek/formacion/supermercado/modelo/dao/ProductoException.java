package com.ipartek.formacion.supermercado.modelo.dao;

public class ProductoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_UNAUTORIZED = "El Producto no pertence al Usuario";
	
	public ProductoException(String mensaje) {
		super(mensaje);
	}
}
