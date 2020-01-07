package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Rol;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.utilidades.Alerta;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	private static Alerta mensajeAlerta = null;
	
	private static UsuarioDAO dao = null;
	
	private static final String VISTA_DASHBOARD = "backoffice/index.jsp";
	private static final String VISTA_MIPANEL = "mipanel/index.jsp";
	private static final String VISTA_LOGIN = "login.jsp";
	private static final String MSG_BIENVENIDO = "Bienvenido";
	private static final String MSG_REPETIR = "Credenciales Incorrectas, por favor prueba de nuevo";
	
	@Override
	public void destroy() {
		super.destroy();
		
		dao = null;
		mensajeAlerta = null;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		dao = UsuarioDAO.getInstance();
	}
	
	
	
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
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		// 2. logica de negocio
		
		Usuario usuario = dao.exist(nombre, password);

		if (usuario != null) {

			LOG.info("login correcto " + usuario);
			HttpSession session = request.getSession();
			
			session.setAttribute("usuarioLogeado", usuario);
			session.setMaxInactiveInterval(60*3); // 3min
			
			if ( usuario.getRol().getId() == Rol.ROL_ADMIN ) {
			
				vista = "seguridad/index.jsp";   // accedemos la BACK-OFFICE
				
			}else {
				
				vista = "mipanel/index.jsp";    // accedemos la FRONT-OFFICE
			}
			
			//VISTA_MIPANEL
			
			mensajeAlerta = new Alerta( Alerta.TIPO_SUCCESS, MSG_BIENVENIDO + ", " + usuario.getNombre());
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);

		} else {
			
			LOG.error("usuario null");
			
			mensajeAlerta = new Alerta( Alerta.TIPO_DANGER, MSG_REPETIR);
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);
			vista = VISTA_LOGIN;
			
		}
		
		// ir a JSP
		request.getRequestDispatcher(vista).forward(request, response);

	}

}