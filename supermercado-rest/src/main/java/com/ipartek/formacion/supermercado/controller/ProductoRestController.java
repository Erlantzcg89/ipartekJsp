package com.ipartek.formacion.supermercado.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.pojo.ResponseMensaje;
import com.ipartek.formacion.supermercado.utils.Utilidades;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@WebServlet( { "/producto/*" } )
public class ProductoRestController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LogManager.getLogger(ProductoRestController.class);
	private String pathInfo;
	private int idProducto;
	private int statusCode;
	private Object reponseBody;
	private ValidatorFactory factory;
	private Validator validator;
	private ProductoDAO productoDao;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		productoDao = ProductoDAO.getInstance();		
		factory  = Validation.buildDefaultValidatorFactory();
		validator  = factory.getValidator();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		productoDao = null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//TODO mostrar parametros URL
		LOG.debug( request.getMethod() + " " + request.getRequestURL()   );
		
		// prepara la response		
		response.setContentType("application/json"); 
		response.setCharacterEncoding("utf-8");
		
		reponseBody = null;
		pathInfo = request.getPathInfo();
		
		try { 
			idProducto = -1;
			idProducto = Utilidades.obtenerId(pathInfo);
			
		    // llama a doGEt, doPost, doPut, doDelete
			super.service(request, response);  
			
		}catch (Exception e) {
			
			statusCode =  HttpServletResponse.SC_BAD_REQUEST;
			reponseBody = new ResponseMensaje(e.getMessage());		
			
					
		}finally {	
			
			response.setStatus( statusCode );
			
			if ( reponseBody != null ) {
				// response body
				PrintWriter out = response.getWriter();		               // out se encarga de poder escribir datos en el body
				String jsonResponseBody = new Gson().toJson(reponseBody);  // conversion de Java a Json
				out.print(jsonResponseBody.toString()); 	
				out.flush();  
			}	
		}	
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// detalle
		if ( idProducto != -1 ) {	
			
			reponseBody = productoDao.getById(idProducto);
			if ( reponseBody != null ) {
				statusCode = HttpServletResponse.SC_OK;
			}else {
				reponseBody = null;
				statusCode = HttpServletResponse.SC_NOT_FOUND;
			}
			
		// listado	
		}else {			
			ArrayList<Producto> productos  = (ArrayList<Producto>) productoDao.getAll();
			reponseBody = productos;
			if (  productos.isEmpty()  ) {					
				statusCode = HttpServletResponse.SC_NO_CONTENT;
			}else {
				statusCode = HttpServletResponse.SC_OK;
			}
		}			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// convertir json del request body a Objeto
			BufferedReader reader = request.getReader();               
			Gson gson = new Gson();
			Producto producto = gson.fromJson(reader, Producto.class);
			LOG.debug(" Json convertido a Objeto: " + producto);
		
			//validar objeto
			Set<ConstraintViolation<Producto>>  validacionesErrores = validator.validate(producto);		
			if ( validacionesErrores.isEmpty() ) {
		
				Producto productoGuardar = null;
				// modificar producto
				if ( idProducto == -1 ) {
					productoGuardar = productoDao.update(idProducto, producto);
					statusCode =  HttpServletResponse.SC_OK;
					
				// crear nuevo producto	
				}else {
					productoGuardar = productoDao.create(producto);
					statusCode =  HttpServletResponse.SC_CREATED;
				}				
				
				reponseBody = productoGuardar;
				
			}else {
				
				statusCode =  HttpServletResponse.SC_BAD_REQUEST;				
				ResponseMensaje responseMensaje = new ResponseMensaje("valores no correctos");
				ArrayList<String> errores = new ArrayList<String>();
				for (ConstraintViolation<Producto> error : validacionesErrores) {					 
					errores.add( error.getPropertyPath() + " " + error.getMessage() );
				}				
				responseMensaje.setErrores(errores);				
				reponseBody = responseMensaje;
				
				
			}	
			
		}catch ( MySQLIntegrityConstraintViolationException e) {	
			
			statusCode =  HttpServletResponse.SC_CONFLICT;
			reponseBody = new ResponseMensaje("nombre de producto repetido");
			
		} catch (Exception e) {
			
			statusCode =  HttpServletResponse.SC_BAD_REQUEST;
			reponseBody = new ResponseMensaje(e.getMessage());		
		}
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Producto pEliminado = productoDao.delete(idProducto);
			statusCode =  HttpServletResponse.SC_OK;
			reponseBody = pEliminado;
			
			
		} catch (Exception e) {
			
			statusCode =  HttpServletResponse.SC_NOT_FOUND;
			reponseBody = new ResponseMensaje(e.getMessage());		
		}
		
		
	}

	

	
}