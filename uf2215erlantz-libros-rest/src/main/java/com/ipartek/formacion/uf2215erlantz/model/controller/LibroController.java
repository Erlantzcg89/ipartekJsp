package com.ipartek.formacion.uf2215erlantz.model.controller;

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

import com.ipartek.formacion.uf2215erlantz.model.LibroDAO;
import com.ipartek.formacion.uf2215erlantz.model.pojo.Libro;
import com.ipartek.formacion.uf2215erlantz.utilidades.Utilidades;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/api/libro/*")
public class LibroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LogManager.getLogger(LibroController.class);
	LibroDAO dao;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		dao = LibroDAO.getInstance();
		
	}

	public void destroy() {

		dao = null;
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOG.trace("entrando en service");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		super.service(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOG.trace("entrando en GET");

		String nombre = (request.getParameter("nombre") == null) ? "" : request.getParameter("nombre");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");
		LOG.debug("Parámetro nombre: *" + nombre + "*");

		try {
			if (pathInfo == null) { // recurso mal llamado

				LOG.trace("recurso no encontrado");

				try (PrintWriter out = response.getWriter()) {
					
					response.setStatus(404);
					out.print("Recurso no encontrado");
					out.flush();

				}

			} else if (!nombre.equals("")) {  // parámetro nombre

				LOG.trace("entrando en getAllNombre()");

				ArrayList<Libro> librosNombre = (ArrayList<Libro>) dao.getAllNombre(nombre);

				if (!librosNombre.isEmpty()) { // lista no vacia

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						
						response.setStatus(200);
						out.print(json.toJson(librosNombre));
						out.flush();
					}

				} else { // lista con filtro por nombre vacia

					LOG.trace("No content");

					try (PrintWriter out = response.getWriter()) {
						
						response.setStatus(204);
						out.print("Lista Vacia");
						out.flush();
					}

				}

			} else if (pathInfo.equals("/")) { // listado completo

				LOG.trace("entrando en el getAll()");

				ArrayList<Libro> libros = (ArrayList<Libro>) dao.getAll();

				if (!libros.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						
						response.setStatus(200);
						out.print(json.toJson(libros));
						out.flush();
					}

				} else { // listado vacio

					LOG.trace("Listado vacio");

					try (PrintWriter out = response.getWriter()) {
						
						response.setStatus(204);
						out.print("Listado vacio");
						out.flush();
					}

				}

			} else {

				LOG.trace("entrando en getById");

				PrintWriter out = response.getWriter();

				Libro l = dao.getById(Utilidades.obtenerId(pathInfo));

				if (l != null) {

					String jsonResponseBody = new Gson().toJson(l); 
					response.setStatus(200);
					out.print(jsonResponseBody.toString());
					out.flush();

				} else { // -1
					
					response.setStatus(404);
					out.print("<h1>Error 404</h1>");
					out.flush();

				}
			} // getById

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
		Libro libro = null;
		libro = gson.fromJson(reader, Libro.class);
		int status = 0;

		try {
			libro = dao.create(libro);
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
			out.print(json.toJson(libro));
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
		Libro libro = null;
		libro = gson.fromJson(reader, Libro.class);
		int status = 0;

		try {
			int id = Utilidades.obtenerId(request.getPathInfo());
			libro = dao.update(id, libro);
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
				out.print(json.toJson(libro));
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
			Libro libro = null;
			try {
				libro = dao.delete(id);
			} catch (Exception e) {
				LOG.error(e);
			}

			if(libro == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				try (PrintWriter out = response.getWriter()) {

					Gson json = new Gson();
					out.print(json.toJson(libro));
					out.flush();

				}
			}
		}
	}
	
	

}
