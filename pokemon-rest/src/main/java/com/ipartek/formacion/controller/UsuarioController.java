package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.formacion.model.UsuarioDAO;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/api/usuario/*")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LogManager.getLogger(UsuarioDAO.class);
	UsuarioDAO dao;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = UsuarioDAO.getInstance();

	}

	public void destroy() {

		dao = null;

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entrando en service");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		super.service(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entrando en el GET");

		String nombre = (request.getParameter("nombre") == null) ? "" : request.getParameter("nombre");
		String password = (request.getParameter("password") == null) ? "" : request.getParameter("password");
		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");
		LOG.debug("Parámetro");

		try {
			if (pathInfo == null) {

				LOG.trace("recurso no encontrado");

				try (PrintWriter out = response.getWriter()) {
					out.print("Recurso no encontrado");
					out.flush();

					response.setStatus(404);
				}

			} else if (!nombre.equals("") && !nombre.equals("")) { // ?nombre=

				LOG.trace("entrando en getLogin()");

				Usuario usuario = dao.getLogin(nombre, password);

				if (usuario != null) {
					
					// crear sesion
					HttpSession session = request.getSession();
					session.setAttribute("usuarioLogeado", usuario);
					session.setMaxInactiveInterval( -1 );

					try (PrintWriter out = response.getWriter()) {
						
						response.setStatus(200);
						Gson json = new Gson();
						out.print(json.toJson(usuario));
						out.flush();

						
					}

				} else {

					LOG.trace("No encontrado");

					try (PrintWriter out = response.getWriter()) {
						out.print("No encontrado");
						out.flush();

						response.setStatus(404);
					}

				}

			} else {

				LOG.trace("No content");

				try (PrintWriter out = response.getWriter()) {
					out.print("Recurso no encontrado");
					out.flush();

					response.setStatus(204);
				}

			}

		} catch (Exception e) {
			LOG.error(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}