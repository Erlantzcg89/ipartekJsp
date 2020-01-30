package com.ipartek.formacion.model.utilidades;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utilidades {
	
	private final static Logger LOG = LogManager.getLogger(Utilidades.class);

	/**
	 * obtenemos el id de la uri através del pathinfo
	 * 
	 * @param pathInfo es la variable (request.pathInfo) que almacena la uri
	 * @return numero id
	 * @throws Exception si la uri está mal formada <br>
	 *                   <br>
	 *                   ejemplos:
	 *                   <ol>
	 *                   <li>/ uri valida</li>
	 *                   <li>/2 uri valida</li>
	 *                   <li>/2/ uri valida</li>
	 *                   <li>/2/2 uri mal formada</li>
	 *                   <li>/2/otracosa/34 uri mal formada</li>
	 *                   <ol>
	 * 
	 */
	public static int obtenerId(String pathInfo) throws Exception {

		int resultado = -1;

		if (pathInfo != null) {

			String[] troceado = pathInfo.split(Pattern.quote("/"));

			if (troceado.length > 2) {

				// uri mal formada
				throw new Exception("Uri mal formada");

			} else {

				try {
					// /{id}, /{id}/
					resultado = Integer.parseInt(troceado[1]);

				} catch (Exception e) {

					// Integer no válido
					LOG.error("Integer no válido");

				}
			}

		}

		return resultado;
	}


}
