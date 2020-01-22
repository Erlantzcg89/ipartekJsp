package com.ipartek.formacion.supermercado.controller;

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
				
				if(lista.size() <= 0) {
					// 404
					status = HttpServletResponse.SC_NOT_FOUND;	
				}else {
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



			}else{
				
				LOG.trace("entrando en getById");
				
				Producto p = productoDao.getById(Utilidades.obtenerId(pathInfo));
				
				//TODO si no existe 404
				
				// resonse header
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");

				// response body
				PrintWriter out = response.getWriter(); // out se encarga de poder escribir datos en el body
				String jsonResponseBody = new Gson().toJson(p); // conversion de Java a Json
				out.print(jsonResponseBody.toString());
				out.flush(); // termina de escribir datos en response body
				
				status = HttpServletResponse.SC_OK;
				
			}
			
			response.setStatus(status);

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

		LOG.trace("peticion POST");

		String pathInfo = request.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LOG.trace("peticion PUT");

		String pathInfo = req.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");

		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LOG.trace("peticion DELETE");

		String pathInfo = req.getPathInfo();

		LOG.debug("mirar pathInfo:*" + pathInfo + "* para saber si es listado o detalle");


		try {

			// si el pathInfo esta vacio devolvemos error uri mal formada
			if (pathInfo.equals("/")) {
				
				
				
			}else{
				
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
