package com.ipartek.formacion.controller;

import java.io.BufferedReader;
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
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

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
		LOG.debug("Parámetro");

		try {
			if (pathInfo == null) {

				LOG.trace("recurso no encontrado");

				try (PrintWriter out = response.getWriter()) {
					out.print("Recurso no encontrado");
					out.flush();

					response.setStatus(404);
				}

			} else if (!nombre.equals("")) {  // ?nombre=

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
						out.print("Lista Vacia");
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
						out.print("Lista Vacia");
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
							out.print("Recurso no encontrado");
							out.flush();

							response.setStatus(404);
						}

					} // pokemon por id no encontrado

				} else {

					LOG.trace("recurso no encontrado");

					try (PrintWriter out = response.getWriter()) {
						out.print("Recurso no encontrado");
						out.flush();

						response.setStatus(404);
					}
				} // id -1 (no es una id válida)
			} // buscar por id

		} catch (Exception e) {
			LOG.error(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en doPost");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");

		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		Pokemon pokemon = null;
		pokemon = gson.fromJson(reader, Pokemon.class);
		int status = 0;

		try {
			pokemon = dao.create(pokemon);
			status = HttpServletResponse.SC_NO_CONTENT;
		}catch(MySQLIntegrityConstraintViolationException e) {
			LOG.error("libro duplicado");
			status = HttpServletResponse.SC_CONFLICT;
		}
		catch (Exception e) {
			LOG.error(e);
			status = HttpServletResponse.SC_BAD_REQUEST;
			e.printStackTrace();
		}

		if(status >= 200 && status < 300) {
		
			try (PrintWriter out = response.getWriter()) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			Gson json = new Gson();
			out.print(json.toJson(pokemon));
			out.flush();

		}
		} else {
			response.setStatus(status);
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en deDelete");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");
		
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		Pokemon pokemon = null;
		pokemon = gson.fromJson(reader, Pokemon.class);
		int status = 0;

		try {
			int id = Utilidades.obtenerId(request.getPathInfo());
			pokemon = dao.update(id, pokemon);
			status = HttpServletResponse.SC_OK;
		}catch(MySQLIntegrityConstraintViolationException e) {
			LOG.error("libro duplicado");
			status = HttpServletResponse.SC_CONFLICT;
		}
		catch (Exception e) {
			LOG.error(e);
			status = HttpServletResponse.SC_BAD_REQUEST;
		}

		if(status >= 200 && status < 300) {
			try (PrintWriter out = response.getWriter()) {
				response.setStatus(status);
				Gson json = new Gson();
				out.print(json.toJson(pokemon));
				out.flush();

			}
		} else {
			response.setStatus(status);
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en deDelete");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");

		
		int id = -1;
		
		try {
			id = Utilidades.obtenerId(request.getPathInfo());
		} catch (Exception e) {
			LOG.error(e);
		}
		if(id >= 0) {
			Pokemon pokemon = null;
			try {
				pokemon = dao.delete(id);
			} catch (Exception e) {
				LOG.error(e);
			}

			if(pokemon == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				try (PrintWriter out = response.getWriter()) {

					Gson json = new Gson();
					out.print(json.toJson(pokemon));
					out.flush();

				}
			}
		}
	}

}
