package com.ipartek.formacion.modelo.dao;

import com.ipartek.formacion.modelo.pojos.Usuario;

public interface IUsuarioDAO extends IDAO<Usuario>{
	
	/**
	 * Comoprueba si existe el usuario en la bd
	 * @param nombre
	 * @param contrasenia
	 * @return Usuario/null
	 */
	Usuario exist( String nombre, String contrasenia);

}
