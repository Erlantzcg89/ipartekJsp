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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductoRestController
 */
@WebServlet({ "/producto/*" })
public class ProductoRestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private final static Logger LOG = Logger.getLogger(ProductoRestController.class);
    private ProductoDAO productoDao;

    
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		LOG.trace("peticion GET");
		
		String pathInfo = request.getPathInfo();
		
		LOG.debug("mirar pathInfo:" + pathInfo + " para saber si es listado o detalle" );
		
		//obtener productos de la BD
		ArrayList<Producto> lista = (ArrayList<Producto>) productoDao.getAll();
		
		//objeto de prueba hasta que corrija el dao
		Producto productoPrueba1 = new Producto();
		productoPrueba1.setNombre("cafe");
		
		lista.add(productoPrueba1);
		
		// prepara la response		
		response.setContentType("application/json"); 
		response.setCharacterEncoding("utf-8");
		
		// response body
		PrintWriter out = response.getWriter();		               // out se encarga de poder escribir datos en el body
		String jsonResponseBody = new Gson().toJson(lista);		   // conversion de Java a Json
		out.print(jsonResponseBody.toString()); 	
		out.flush();                                               // termina de escribir datos en response body
		
		// response status code
		// 		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		response.setStatus( HttpServletResponse.SC_OK );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
