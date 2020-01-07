package com.ipartek.formacion.modelo.dao;

import java.util.List;

import com.ipartek.formacion.modelo.pojos.Producto;

public interface IProductoDAO extends IDAO<Producto> {
	
	/**
	 * Lista los productos de un Usuario
	 * @param idUsuario int identificador del Usuario
	 * @return List<Producto>, lista inicializada en caso de que no tenga productos
	 */
	List<Producto> getAllByUser(int idUsuario);
	
	/**
	 * Recupera un producto de un usuario concreto
	 * @param idProducto int
	 * @param idUsuario int
	 * @return Producto si encuentra, null si no encuentra
	 * @throws ProductoException Cuando intenta recuperar un producto que no pertenece al usuario
	 */
	Producto getByIdUser(int idProducto, int idUsuario) throws ProductoException;
	
	Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException;
	
	/**
	 * 
	 * @param idProducto
	 * @param idUsuario
	 * @return
	 * @throws ProductoException
	 * 		<ol>
	 * 			<li>Cuando intenta eliminar un producto que no pertenece al usuario</li>
	 * 			<li>Cuando no encuentra producto por su id para idUsuario</li>
	 * 		</ol>
	 */
	Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException;

}
