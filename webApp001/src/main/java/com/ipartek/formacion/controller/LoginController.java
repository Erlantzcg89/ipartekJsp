package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/LoginController", "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

		String contra = "1234";
		String usuario = "pepito";
		Boolean login = false;
		Boolean error = false;

		// recibir parametros del formulario
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String idioma = request.getParameter("idioma");
		int recuerdame = 0;

		if (request.getParameter("recuerdame") != null) {
			recuerdame = Integer.parseInt(request.getParameter("recuerdame"));
		}

		// procesar el login
		try

		{

			if ((nombre.equals(usuario)) && (password.equals(contra))) {
				login = true;
			}

		} catch (Exception e) {
			error = true;
		}

		// dos caminos para login y fallo
		if (login) {

			// preparar atributos
			request.setAttribute("nombre", nombre);
			request.setAttribute("password", password);
			request.setAttribute("idioma", idioma);
			request.setAttribute("recuerdame", recuerdame);

			// ir a vista
			request.getRequestDispatcher("procesarLogin.jsp").forward(request, response);

		} else {

			// preparar atributos
			request.setAttribute("nombre", nombre);
			request.setAttribute("password", password);
			request.setAttribute("error", error);

			// ir a vista
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
