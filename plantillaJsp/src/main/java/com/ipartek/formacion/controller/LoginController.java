package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.SesionesListener;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private static final String USUARIO_ADMIN = "admin";
	private static final String PASSWORD_ADMIN = "admin";
	private static final String VISTA_LISTAR = "seguridad/productos?accion=listar";
	private static final String VISTA_LOGIN = "login.jsp";
	private static final String MSG_BIENVENIDO = "Bienvenido al Dashboard";
	private static final String MSG_REPETIR = "Credenciales Incorrectas, por favor prueba de nuevo";
	

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
		String mensaje = "";

		// 1. recibir parametros
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
//		String idioma = request.getParameter("idioma");
//		String recuerdame = request.getParameter("recuerdame");

		// 2. logica de negocio

		if (USUARIO_ADMIN.equalsIgnoreCase(nombre) && PASSWORD_ADMIN.equalsIgnoreCase(password)) {

			// recuperar session del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", "Administrador");
//			session.setAttribute("idioma", idioma);
			session.setMaxInactiveInterval(-1); // nunca caduca

			

//			switch (idioma) {
//			case "Castellano":
//				mensaje = (recuerdame == null) ? "Bienvenido" : "Bienvenido. Se guardará tu nombre";
//				break;
//			case "Euskera":
//				mensaje = (recuerdame == null) ? "Ongietorri" : "Ongietorri. Zure izena gogoratuko da";
//				break;
//			case "English":
//				mensaje = (recuerdame == null) ? "Wellcome" : "Wellcome. Your name will be saved";
//				break;
//
//			default:
//				break;
//			}
			
			mensaje = MSG_BIENVENIDO;
			vista = VISTA_LISTAR;

		} else {
			
			mensaje = MSG_REPETIR;
			vista = VISTA_LOGIN;
			
		}
		
		request.setAttribute("mensaje", mensaje);
		
		LOG.debug("vamos a la vista");
		
		// ir a JSP
		request.getRequestDispatcher(vista).forward(request, response);

	}

}
