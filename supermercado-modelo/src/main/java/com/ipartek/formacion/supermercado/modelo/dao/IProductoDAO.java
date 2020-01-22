package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public interface IProductoDAO extends IDAO<Producto>{

	/**
	 * Lista los productos de un Usuario
	 * @param idUsuario int identificador del Usuario
	 * @return List<Productos>, lista inicializada en caso de no tener Productos
	 */
	List<Producto> getAllByUser(int idProducto);
	
	/**
	 * Recupera un Producto de un Usuario concreto
	 * @param idProducto
	 * @param idUsuario
	 * @return Producto si encuentra, null si no encuentra
	 * @throws ProductoException Cuando itenta recuperar un producto que no pertenece al Usuario
	 */
	Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException;
	
	/**
	 * Modificar un Producto de un Usuario concreto
	 * @param id
	 * @param idUsuario
	 * @param pojo
	 * @return
	 * @throws ProductoException
	 * @throws SQLException 
	 */
	Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException, SQLException;
	
	/**
	 * Elimina de forma lógica un Producto de un Usuario
	 * @param id
	 * @param idUsuario
	 * @return
	 * @throws 
	 * 		<ol>
	 * 			<li>ProductoException Cuando itenta eliminar un productoque no pertenece al Usuario</li>
	 * 			<li>Cuando no enceuntra un Producto por su id para idUsuario</li>
	 * 		</ol>
	 */
	Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException;
}
