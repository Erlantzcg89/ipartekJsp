package com.ipartek.formacion.supermercado.utils;

public class Utilidades {

	/**
	 * obtenemos el id de la uri através del pathinfo
	 * @param pathInfo es la variable (request.pathInfo) que almacena la uri
	 * @return numero id
	 * @throws Exception si la uri está mal formada
	 * <br><br>
	 * ejemplos:
	 *  <ol>
	 *  	<li>/ uri valida</li>
	 *  	<li>/2 uri valida</li>
	 *  	<li>/2/ uri valida</li>
	 *  	<li>/2/2 uri mal formada</li>
	 *  	<li>/2/otracosa/34 uri mal formada</li>
	 *  <ol>
	 *  
	 */
	public static int obtenerId(String pathInfo) throws Exception{
		
		throw new Exception("Sin implementar, primero Test!");
		//return ; 
	}
	
}
