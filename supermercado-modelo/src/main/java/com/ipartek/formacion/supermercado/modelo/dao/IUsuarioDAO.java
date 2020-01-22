package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public interface IUsuarioDAO extends IDAO<Usuario> {

	/**
	 * Comprueba si existe el usuario en la base de datos
	 * @param nombre
	 * @param contrasenia
	 * @return Usuario con datos si lo encuentra, <b>null</b> en caso contrario
	 */
	Usuario exist(String nombre, String contrasenia);
	
}
