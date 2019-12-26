package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.ProductoDAO;
import com.ipartek.formacion.utilidades.Alerta;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables para el uso del controlador

		private final static Logger LOG = Logger.getLogger(InicioController.class);

		private static Alerta mensajeAlerta = null;

		
		private static final String VIEW_LISTA = "index.jsp";

		private static ProductoDAO dao;
       
		
		@Override
		public void init() throws ServletException {
			super.init();
			
			// inicio del controlador

			dao = ProductoDAO.getInstance();
		}
		
		@Override
		public void destroy() {
			super.destroy();

			// destrucción del controlador
			
			dao = null;
			mensajeAlerta = null;
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// método get. Se utiliza para listar el registro de productos

				try {

					request.setAttribute("productos", dao.getAll());

					mensajeAlerta = new Alerta(Alerta.TIPO_INFO, "Productos en la base de datos: " + dao.getAll().size());

					

				} catch (Exception e) {

					mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al mostrar la lista de productos");

					LOG.error("error en el get", e);

				} finally {

					request.setAttribute("mensajeAlerta", mensajeAlerta);

					request.getRequestDispatcher(VIEW_LISTA).forward(request, response);
				}
	}

}
