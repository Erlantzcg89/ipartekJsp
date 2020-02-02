package com.ipartek.formacion.uf2215erlantz.model.controller;

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

					LOG.trace("recurso no encontrado");

					try (PrintWriter out = response.getWriter()) {
						
						response.setStatus(404);
						out.print("Recurso no encontrado");
						out.flush();
					}
	
			} // recurso no encontrado

		} catch (Exception e) {
			LOG.error(e);
		}
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en deDelete");

		String nombre = (request.getParameter("nombre") == null) ? "" : request.getParameter("nombre");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");
		LOG.debug("Parámetro nombre: *" + nombre + "*");
		
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
