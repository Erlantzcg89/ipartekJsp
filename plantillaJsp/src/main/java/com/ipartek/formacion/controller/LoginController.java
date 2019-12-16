package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vista = "";

		// 1. recibir parametros
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		String idioma = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");

		// 2. logica de negocio

		if ("admin".equalsIgnoreCase(usuario) && "admin".equalsIgnoreCase(contrasena)) {

			// recuperar session del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", "Administrador");
			session.setAttribute("idioma", idioma);
			session.setMaxInactiveInterval(-1); // nunca caduca

			String mensaje = "";

			switch (idioma) {
			case "Castellano":
				mensaje = (recuerdame == null) ? "Bienvenido" : "Bienvenido. Se guardará tu nombre";
				break;
			case "Euskera":
				mensaje = (recuerdame == null) ? "Ongietorri" : "Ongietorri. Zure izena gogoratuko da";
				break;
			case "English":
				mensaje = (recuerdame == null) ? "Wellcome" : "Wellcome. Your name will be saved";
				break;

			default:
				break;
			}

			request.setAttribute("mensaje", mensaje);
			vista = "privado/home";

		} else {

			request.setAttribute("mensaje", "Credenciales Incorrectas, por favor prueba de nuevo");
			vista = "index.jsp";
		}

		// ir a JSP
		request.getRequestDispatcher(vista).forward(request, response);

	}

}
