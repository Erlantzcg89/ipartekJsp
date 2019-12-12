package com.ipartek.formacion.controller.privado;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioDeportesController
 */
@WebServlet("/privado/deportes")
public class FormularioDeportesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioDeportesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recibir names del formulario
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String[] deportes = request.getParameterValues("deportes");

		// preparar atributos
		request.setAttribute("nombre", nombre);
		request.setAttribute("email", email);
		request.setAttribute("deportes", deportes);

		// ir a vista
		request.getRequestDispatcher("/privado/formulario-deportes.jsp").forward(request, response);

	}

}
