package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletContext;
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
 * Servlet implementation class CrearLibroController
 */
@WebServlet("/backoffice/crear")
public class CrearLibroController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	// Declaración de variables para el uso del controlador

	private final static Logger LOG = Logger.getLogger(CrearLibroController.class);

	private static Alerta mensajeAlerta = null;

	private static String vista = "";
	private static final String VIEW_NUEVO = "libros/nuevo-libro.jsp";

	private static LibroDAO dao;

	String pNombre;
	String pPrecio;
	String pDescuento;
	String pAutor;
	String pImagen;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearLibroController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// inicio del controlador

		dao = LibroDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();

		// destrucción del controlador
		
		dao = null;
		mensajeAlerta = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// método post. Se utiliza para crear nuevos libros

		pNombre = request.getParameter("nombre");
		pPrecio = request.getParameter("precio");
		pDescuento = request.getParameter("descuento");
		pAutor = request.getParameter("autor");
		pImagen = request.getParameter("imagen");

		mensajeAlerta = null;

		String nombreLibro = "";
		Double precioLibro = 0.00;
		int descuentoLibro = 0;
		String autorLibro = "";
		String imagenLibro = "";

		String mensajeValidacion = "";
		Boolean errorValidacion = false;

		vista = VIEW_NUEVO;
		
		if ("".equals(pAutor)) {

			autorLibro = "desconocido";

		}else {
			autorLibro = pAutor;
		}
		
		request.setAttribute("autorLibro", autorLibro);
		
		if ("".equals(pImagen)) {

			imagenLibro = "desconocida";

		}else {
			imagenLibro = pImagen;
		}
		
		request.setAttribute("imagenLibro", imagenLibro);

		if ("".equals(pNombre)) {

			mensajeValidacion += "Por favor, rellena el campo nombre. ";
			errorValidacion = true;

		} else if (pNombre.length() < 2 || pNombre.length() > 150) {

			mensajeValidacion += "El nombre debe tener entre 2 y 150 caractéres. ";
			errorValidacion = true;
			request.setAttribute("nombreLibro", pNombre);

		} else {
			nombreLibro = pNombre;

			request.setAttribute("nombreLibro", nombreLibro);
		}

		if ("".equals(pPrecio)) {

			mensajeValidacion += "Por favor, rellena el campo precio. ";
			errorValidacion = true;

		} else if (Double.parseDouble(pPrecio) <= 0) {

			mensajeValidacion += "El precio es un numero separado por punto y mayor que 0. ";
			errorValidacion = true;
			request.setAttribute("precioLibro", pPrecio);
		} else {
			precioLibro = Double.parseDouble(pPrecio);

			request.setAttribute("precioLibro", precioLibro);
		}

		if ("".equals(pDescuento)) {

			mensajeValidacion += "El descuento por defecto es  del 0%. ";

		} else if (Integer.parseInt(pDescuento) < 0 || Integer.parseInt(pDescuento) > 100) {

			mensajeValidacion += "El descuento es un número entre 0 y 100. ";
			errorValidacion = true;
			request.setAttribute("descuentoLibro", pDescuento);
		} else {
			descuentoLibro = Integer.parseInt(pDescuento);

			request.setAttribute("descuentoLibro", descuentoLibro);
		}

		request.setAttribute("mensajeValidacion", mensajeValidacion);

		if (!errorValidacion) {

			try {

				Libro libroNuevo = new Libro(++LibroDAO.indice, nombreLibro, precioLibro, descuentoLibro, autorLibro, imagenLibro);
				dao.create(libroNuevo);

				mensajeAlerta = new Alerta(Alerta.TIPO_INFO, "Libro \"" + nombreLibro + "\" creado con éxito");

			} catch (Exception e) {

				mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al crear el libro " + nombreLibro);

				LOG.error("error en el post", e);

			}
		}
		
		request.setAttribute("mensajeAlerta", mensajeAlerta);

		request.getRequestDispatcher(vista).forward(request, response);
	}

}
