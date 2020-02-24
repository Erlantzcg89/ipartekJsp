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
import com.ipartek.formacion.model.HabilidadDAO;
import com.ipartek.formacion.model.pojo.Habilidad;
import com.ipartek.formacion.model.utilidades.Utilidades;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@WebServlet("/api/habilidad/*")
public class HabilidadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final static Logger LOG = LogManager.getLogger(HabilidadController.class);
	HabilidadDAO dao;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = HabilidadDAO.getInstance();

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

				ArrayList<Habilidad> habilidadesNombre = (ArrayList<Habilidad>) dao.getAllNombre(nombre);

				if (!habilidadesNombre.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						out.print(json.toJson(habilidadesNombre));
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

				ArrayList<Habilidad> habilidades = (ArrayList<Habilidad>) dao.getAll();

				if (!habilidades.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						out.print(json.toJson(habilidades));
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

					Habilidad h = dao.getById(id);

					if (h != null) {

						try (PrintWriter out = response.getWriter()) {
							String jsonResponseBody = new Gson().toJson(h);
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
		Habilidad habilidad = null;
		habilidad = gson.fromJson(reader, Habilidad.class);
		int status = 0;

		try {
			habilidad = dao.create(habilidad);
			status = HttpServletResponse.SC_CREATED;
		}catch(MySQLIntegrityConstraintViolationException e) {
			LOG.error("entrada duplicada");
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
			out.print(json.toJson(habilidad));
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
		Habilidad habilidad = null;
		habilidad = gson.fromJson(reader, Habilidad.class);
		int status = 0;

		try {
			habilidad = dao.update(habilidad);
			status = HttpServletResponse.SC_OK;
		}catch(MySQLIntegrityConstraintViolationException e) {
			LOG.error("entrada duplicada");
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
				out.print(json.toJson(habilidad));
				out.flush();

			}
		} else {
			response.setStatus(status);
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en doDelete");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");

		
		int id = -1;
		
		try {
			id = Utilidades.obtenerId(request.getPathInfo());
		} catch (Exception e) {
			LOG.error(e);
		}
		if(id >= 0) {
			Habilidad habilidad = null;
			try {
				habilidad = dao.delete(id);
			} catch (Exception e) {
				LOG.error(e);
			}

			if(habilidad == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				try (PrintWriter out = response.getWriter()) {

					Gson json = new Gson();
					out.print(json.toJson(habilidad));
					out.flush();

				}
			}
		}
	}

}
