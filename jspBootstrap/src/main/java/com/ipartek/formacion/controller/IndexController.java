package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({ "/" })
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
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

		HttpSession session = request.getSession();

		String loginAlert = "";

		if (session.getAttribute("usuarioLogeado") == null) {
			loginAlert = "<alert class=\"alert alert-dark alert-dismissible text-center usuario-logeado\"><a href=\"login\">Iniciar sesion</a></alert>";
		} else {
			loginAlert = "    <alert class=\"usuario-logeado alert alert-success\">\r\n" + "        <h4>Usuario\r\n"
					+ "            Logeado</h4>Nombre:<br>Idioma:<br><a href=\"logout\">cerrar\r\n"
					+ "            sesión</a>\r\n" + "    </alert>";
		}

		request.setAttribute("loginAlert", loginAlert);
		request.getRequestDispatcher("/bienvenida.jsp").forward(request, response);

	}

}
