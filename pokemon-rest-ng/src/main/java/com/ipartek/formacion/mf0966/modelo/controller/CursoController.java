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
import com.ipartek.formacion.mf0966.modelo.CursoDAO;
import com.ipartek.formacion.mf0966.modelo.pojo.Curso;
import com.ipartek.formacion.mf0966.utilidades.Utilidades;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@WebServlet("/api/curso/*")
public class CursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final static Logger LOG = LogManager.getLogger(CursoController.class);
	CursoDAO dao;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		dao = CursoDAO.getInstance();
		
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

			} else if (pathInfo.equals("/")) { // getAll

				LOG.trace("entrando en el getAll()");

				ArrayList<Curso> cursos = (ArrayList<Curso>) dao.getAll();

				if (!cursos.isEmpty()) {

					try (PrintWriter out = response.getWriter()) {
						Gson json = new Gson();
						
						response.setStatus(200);
						out.print(json.toJson(cursos));
						out.flush();
					}

				} else { // getAll listado vacio

					LOG.trace("Listado vacio");

					try (PrintWriter out = response.getWriter()) {
						
						response.setStatus(204);
						out.print("Listado vacio");
						out.flush();
					}

				}

			} else { // get by id

				LOG.trace("entrando en getById");

				PrintWriter out = response.getWriter();

				Curso c = dao.getById(Utilidades.obtenerId(pathInfo));

				if (c != null) {

					String jsonResponseBody = new Gson().toJson(c); 
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
		
	}// deGET

}
