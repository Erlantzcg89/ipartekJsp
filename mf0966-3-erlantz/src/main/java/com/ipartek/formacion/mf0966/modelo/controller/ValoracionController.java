package com.ipartek.formacion.mf0966.modelo.controller;

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
import com.ipartek.formacion.mf0966.modelo.ValoracionDAO;
import com.ipartek.formacion.mf0966.modelo.pojo.Valoracion;
import com.ipartek.formacion.mf0966.utilidades.Utilidades;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@WebServlet("/api/valoracion/*")
public class ValoracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = LogManager.getLogger(ValoracionController.class);
	ValoracionDAO dao;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = ValoracionDAO.getInstance();

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

		LOG.trace("entrando en GET");
		String pathInfo = request.getPathInfo();
		LOG.debug("PathInfo:*" + pathInfo + "*");

		try {
			if (pathInfo == null) { // recurso mal llamado

				LOG.trace("recurso no encontrado");

				try (PrintWriter out = response.getWriter()) {

					response.setStatus(404);
					out.print("Recurso no encontrado");
					out.flush();

				}

			} else if (pathInfo.equals("/")) { // listado completo

				LOG.trace("entrando en el getAll()");

				ArrayList<Valoracion> valoraciones = (ArrayList<Valoracion>) dao.getAll();

				if (!valoraciones.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();

						response.setStatus(200);
						out.print(json.toJson(valoraciones));
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

				Valoracion v = dao.getById(Utilidades.obtenerId(pathInfo));

				if (v != null) {

					String jsonResponseBody = new Gson().toJson(v);
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
		Valoracion v = null;
		v = gson.fromJson(reader, Valoracion.class);

		if (pathInfo == null) { // recurso mal llamado

			LOG.trace("recurso no encontrado");

			try (PrintWriter out = response.getWriter()) {

				response.setStatus(404);
				out.print("Recurso no encontrado");
				out.flush();

			}

		} else if (pathInfo.equals("/")) {
		
			try {
				
				v = dao.create(v);

				try (PrintWriter out = response.getWriter()) {
					response.setStatus(200);
					Gson json = new Gson();
					out.print(json.toJson(v));
					out.flush();
				}
				
			}catch (Exception e) {
			
				LOG.error(e);
			
				try (PrintWriter out = response.getWriter()) {
				
						response.setStatus(400);
						out.print("Parametros mal introducidos");
						out.flush();
				}
			}
			
		}else {

			LOG.trace("404");

			try (PrintWriter out = response.getWriter()) {
				
				response.setStatus(404);
				out.print("Recurso no encontrado");
				out.flush();
		}

		} // 404

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.trace("entrando en deDelete");

		String pathInfo = request.getPathInfo();

		LOG.debug("PathInfo:*" + pathInfo + "*");
		
		

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
		if (id >= 0) {
			Valoracion valoracion = null;
			try {
				valoracion = dao.delete(id);
			} catch (Exception e) {
				LOG.error(e);
			}

			if (valoracion == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				try (PrintWriter out = response.getWriter()) {

					Gson json = new Gson();
					out.print(json.toJson(valoracion));
					out.flush();

				}
			}
		}
	}

}
