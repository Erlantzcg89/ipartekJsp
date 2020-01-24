package com.ipartek.formacion.supermercado.controller;

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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.utils.Utilidades;

/**
 * Servlet implementation class ProductoRestController
 */
@WebServlet({ "/producto/*" })
public class ProductoRestController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LogManager.getLogger(ProductoRestController.class);
	private ProductoDAO productoDao;
	private int status;
	private String columna = "";

	public void init(ServletConfig config) throws ServletException {

		productoDao = ProductoDAO.getInstance();

	}

	public void destroy() {

		productoDao = null;

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.service(req, resp); // llama a doGet, doPost, doPut, doDelete

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("peticion GET");

		String pathInfo = request.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		try {

			// si el pathInfo esta vacio devolvemos la lista
			if (pathInfo.equals("/")) {

				LOG.trace("entrando en getAll");
				ArrayList<Producto> lista = (ArrayList<Producto>) productoDao.getAll();

				if (lista.size() <= 0) {
					// 404
					status = HttpServletResponse.SC_NOT_FOUND;
				} else {
					// 200
					status = HttpServletResponse.SC_OK;
				}

				// resonse header
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body
				String jsonResponseBody = new Gson().toJson(lista); // conversion de Java a Json
				out.print(jsonResponseBody.toString());
				out.flush(); // termina de escribir datos en response body

			} else {

				if (request.getParameter("_columna") != null) {
					
					columna = request.getParameter("_columna");
					
					LOG.trace("ordenando por nombre");
					
					ArrayList<Producto> lista = (ArrayList<Producto>) productoDao.getAllOrdered(columna);

					if (lista.size() <= 0) {
						// 404
						status = HttpServletResponse.SC_NOT_FOUND;
					} else {
						// 200
						status = HttpServletResponse.SC_OK;
					}

					// resonse header
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");

					// response body
					PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body
					String jsonResponseBody = new Gson().toJson(lista); // conversion de Java a Json
					out.print(jsonResponseBody.toString());
					out.flush(); // termina de escribir datos en response body
					

				} else {

					LOG.trace("entrando en getById");

					// resonse header
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");

					PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body

					Producto p = productoDao.getById(Utilidades.obtenerId(pathInfo));

					if (p != null) {

						// response body
						String jsonResponseBody = new Gson().toJson(p); // conversion de Java a Json
						out.print(jsonResponseBody.toString());
						out.flush(); // termina de escribir datos en response body

						status = HttpServletResponse.SC_OK;

					} else { // -1
						// Si no existe 404
						out.print("<h1>Error 404</h1>");
						out.flush();

						status = HttpServletResponse.SC_NOT_FOUND;

					}
				}

			}

			response.setStatus(status);

		} catch (Exception e) {

			LOG.error(e);

			// resonse header
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body
			out.print("<h1>Error 404</h1>");
			out.flush();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("peticion POST");

		String pathInfo = request.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		try {

			// si el pathInfo esta vacio devolvemos la lista
			if (!pathInfo.equals("/")) {

				// 400
				LOG.trace("*/* uri mal formulada estado: 400");
				status = HttpServletResponse.SC_BAD_REQUEST;

				// resonse header
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body
				out.print("*/* uri mal formulada estado: 400");
				out.flush(); // termina de escribir datos en response body

			} else {

				// resonse header
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");

				PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body

				// rellenar el producto

				// convertir json del request body a Objeto
				BufferedReader reader = request.getReader();
				Gson gson = new Gson();
				Producto pojo = gson.fromJson(reader, Producto.class);

				Producto p = productoDao.create(pojo);

				if (p != null) {

					// response body
					String jsonResponseBody = new Gson().toJson(p); // conversion de Java a Json
					out.print(jsonResponseBody.toString());
					out.flush(); // termina de escribir datos en response body

					status = HttpServletResponse.SC_OK;

				} else { // -1
					// Si no existe 404
					out.print("<h1>Error 404</h1>");
					out.flush();

					status = HttpServletResponse.SC_NOT_FOUND;

				}

			}

			response.setStatus(status);

		} catch (Exception e) {

			LOG.error(e);

		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LOG.trace("peticion PUT");

		String pathInfo = req.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		try {

			// si el pathInfo esta vacio devolvemos la lista
			if (pathInfo.equals("/")) {

				// 400
				LOG.trace("*/* uri mal formulada estado: 400");
				status = HttpServletResponse.SC_BAD_REQUEST;

				// resonse header
				resp.setContentType("application/json");
				resp.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = resp.getWriter(); // out se encarga de poder escribir datos en el body
				out.print("*/* uri mal formulada estado: 400");
				out.flush(); // termina de escribir datos en response body

			} else {

				LOG.trace("entrando en PUT by ID");

				// resonse header
				resp.setContentType("application/json");
				resp.setCharacterEncoding("utf-8");

				PrintWriter out = resp.getWriter(); // out se encarga de poder escribir datos en el body

				// rellenar el producto

				// convertir json del request body a Objeto
				BufferedReader reader = req.getReader();
				Gson gson = new Gson();
				Producto pojo = gson.fromJson(reader, Producto.class);

				Producto p = productoDao.update(Utilidades.obtenerId(pathInfo), pojo);

				if (p != null) {

					// response body
					String jsonResponseBody = new Gson().toJson(p); // conversion de Java a Json
					out.print(jsonResponseBody.toString());
					out.flush(); // termina de escribir datos en response body

					status = HttpServletResponse.SC_OK;

				} else { // -1
					// Si no existe 404
					out.print("<h1>Error 404</h1>");
					out.flush();

					status = HttpServletResponse.SC_NOT_FOUND;

				}

			}

			resp.setStatus(status);

		} catch (Exception e) {

			LOG.error(e);

		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LOG.trace("peticion DELETE");

		String pathInfo = req.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		try {

			// si el pathInfo esta vacio devolvemos error uri mal formada
			if (pathInfo.equals("/")) {

				// 400
				LOG.trace("*/* uri mal formulada estado: 400");
				status = HttpServletResponse.SC_BAD_REQUEST;

				// resonse header
				resp.setContentType("application/json");
				resp.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = resp.getWriter(); // out se encarga de poder escribir datos en el body
				out.print("*/* uri mal formulada estado: 400");
				out.flush(); // termina de escribir datos en response body

			} else {

				LOG.trace("entrando en deleteById");

				Producto p = productoDao.delete(Utilidades.obtenerId(pathInfo));

				// resonse header
				resp.setContentType("application/json");
				resp.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = resp.getWriter(); // out se encarga de poder escribir datos en el body
				String jsonResponseBody = new Gson().toJson(p); // conversion de Java a Json
				out.print(jsonResponseBody.toString());
				out.flush(); // termina de escribir datos en response body

				status = HttpServletResponse.SC_OK;

			}

			resp.setStatus(status);

		} catch (Exception e) {

			LOG.error(e);

		}

	}

}
