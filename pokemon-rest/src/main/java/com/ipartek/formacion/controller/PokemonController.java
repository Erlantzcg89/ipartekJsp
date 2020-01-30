package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.formacion.model.PokemonDAO;
import com.ipartek.formacion.model.pojo.Pokemon;
import com.ipartek.formacion.model.utilidades.Utilidades;

@WebServlet("/api/pokemon/*")
public class PokemonController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LogManager.getLogger(PokemonController.class);
	PokemonDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PokemonController() {

		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = PokemonDAO.getInstance();

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

		dao = null;

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entrando en service");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		super.service(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entrando en el GET");

		String nombre = (request.getParameter("nombre") == null) ? "" : request.getParameter("nombre");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");

		try {
			if (pathInfo == null) {

				LOG.trace("recurso no encontrado");

				try (PrintWriter out = response.getWriter()) {
					out.print("<h1>No se encuentra el recurso.</h1>");
					out.flush();

					response.setStatus(404);
				}

			} else if (!nombre.equals("")) {

				LOG.trace("entrando en getAllNombre()");

				ArrayList<Pokemon> pokemonsNombre = (ArrayList<Pokemon>) dao.getAllNombre(nombre);

				if (!pokemonsNombre.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						out.print(json.toJson(pokemonsNombre));
						out.flush();

						response.setStatus(200);
					}

				} else {

					LOG.trace("No content");

					try (PrintWriter out = response.getWriter()) {
						out.print("<h1>No content.</h1>");
						out.flush();

						response.setStatus(204);
					}

				}

			} else if (pathInfo.equals("/")) {

				LOG.trace("entrando en el getAll()");

				ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) dao.getAll();

				if (!pokemons.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						out.print(json.toJson(pokemons));
						out.flush();

						response.setStatus(200);
					}

				} else {

					LOG.trace("No content");

					try (PrintWriter out = response.getWriter()) {
						out.print("<h1>No content.</h1>");
						out.flush();

						response.setStatus(204);
					}

				}

			} else {

				int id = Utilidades.obtenerId(pathInfo);

				if (id != -1) {

					LOG.trace("entrando en getById()");

					Pokemon p = dao.getById(id);

					if (p != null) {

						try (PrintWriter out = response.getWriter()) {
							String jsonResponseBody = new Gson().toJson(p);
							out.print(jsonResponseBody.toString());
							out.flush();

							response.setStatus(200);
						}

					} else {

						LOG.trace("recurso no encontrado");

						try (PrintWriter out = response.getWriter()) {
							out.print("<h1>No se encuentra el recurso.</h1>");
							out.flush();

							response.setStatus(404);
						}

					} // pokemon por id no encontrado

				} // id -1 (incorrecta)

			} // buscar por id

		} catch (Exception e) {
			LOG.error(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
