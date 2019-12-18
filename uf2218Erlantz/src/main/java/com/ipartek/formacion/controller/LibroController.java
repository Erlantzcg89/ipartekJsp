package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.LibroDAO;
import com.ipartek.formacion.modelo.pojos.Libro;
import com.ipartek.formacion.utilidades.Alerta;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/libros")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(LibroController.class);

	private static Alerta mensajeAlerta = null;

	private static String vista = "";
	private static final String VIEW_LISTA = "libros/index.jsp";
	private static final String VIEW_NUEVO = "libros/nuevo-libro.jsp";

	private static LibroDAO dao;

	String pNombre;
	String pPrecio;
	String pDescuento;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibroController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();

		dao = LibroDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();

		dao = null;
		mensajeAlerta = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			request.setAttribute("libros", dao.getAll());
			
			mensajeAlerta = new Alerta(Alerta.TIPO_SUCCESS, "Libros en el registro: " + dao.getAll().size());
			
			vista = VIEW_LISTA;
			
		}catch(Exception e){
		
		mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al mostrar la lista de libros");
			
		LOG.error("error en el get", e);
		
		}finally{
		
		request.setAttribute("mensajeAlerta", mensajeAlerta);
			
		request.getRequestDispatcher(vista).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pNombre = request.getParameter("nombre");
		pPrecio = request.getParameter("precio");
		pDescuento = request.getParameter("descuento");
		
		String nombreLibro = pNombre;
		Double precioLibro = 0.00;
		int descuentoLibro = 0;
		
		try {
			
			Libro productoNuevo = new Libro(++LibroDAO.indice, nombreLibro, precioLibro, descuentoLibro);
			dao.create(productoNuevo);
			
			mensajeAlerta = new Alerta(Alerta.TIPO_SUCCESS, "Libro " + nombreLibro + " creado con éxito");
			
			vista = VIEW_NUEVO;
			
		}catch(Exception e){
			
		mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al crear el libro " + nombreLibro);
			
		LOG.error("error en el post", e);
		
		}finally{

		request.setAttribute("mensajeAlerta", mensajeAlerta);	
			
		request.getRequestDispatcher(vista).forward(request, response);
		}

	}

}
