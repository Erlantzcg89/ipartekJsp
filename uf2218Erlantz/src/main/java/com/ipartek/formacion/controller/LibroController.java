package com.ipartek.formacion.controller;

import java.io.IOException;
import java.math.BigDecimal;

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

		} catch (Exception e) {

			mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al mostrar la lista de libros");

			LOG.error("error en el get", e);

		} finally {

			request.setAttribute("mensajeAlerta", mensajeAlerta);

			request.getRequestDispatcher(vista).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pNombre = request.getParameter("nombre");
		pPrecio = request.getParameter("precio");
		pDescuento = request.getParameter("descuento");
		
		String nombreLibro = "";
		Double precioLibro;
		int descuentoLibro;

		String mensajeValidacion = "";
		Boolean errorValidacion = false;

		vista = VIEW_NUEVO;

		if ("".equals(pNombre)) {

			mensajeValidacion += "Por favor, rellena el campo nombre. ";
			errorValidacion = true;

		} else if (pNombre.length() < 2 || pNombre.length() > 150) {

			mensajeValidacion += "El nombre debe tener entre 2 y 150 caractéres. ";
			errorValidacion = true;

		} else {
			nombreLibro = pNombre;
			
			request.setAttribute("nombreLibro", nombreLibro);
		}

		if ("".equals(pPrecio)) {

			mensajeValidacion += "Por favor, rellena el campo precio. ";
			errorValidacion = true;

		} else if (BigDecimal.valueOf(Double.parseDouble(pPrecio)).scale() > 1) {
			
			mensajeValidacion += "El precio es numero de dos decimales. ";
			errorValidacion = true;
		} else {
			precioLibro = Double.parseDouble(pPrecio);
			
			request.setAttribute("precioLibro", precioLibro);
		}

		if ("".equals(pDescuento)) {

			mensajeValidacion += "El descuento por defecto es  del 0%. ";

		} else if (Integer.parseInt(pDescuento) < 0 || Integer.parseInt(pDescuento) > 100) {
			
			mensajeValidacion += "El descuento es un número entre 0 y 100. ";
			errorValidacion = true;
		} else {
			descuentoLibro = Integer.parseInt(pDescuento);

			request.setAttribute("descuentoLibro", descuentoLibro);
		}

		request.setAttribute("mensajeValidacion", mensajeValidacion);

		if (!errorValidacion) {

			try {


				Libro libroNuevo = new Libro(++LibroDAO.indice, nombreLibro, precioLibro, descuentoLibro);
				dao.create(libroNuevo);

				mensajeAlerta = new Alerta(Alerta.TIPO_SUCCESS, "Libro " + nombreLibro + " creado con éxito");

			} catch (Exception e) {

				mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al crear el libro " + nombreLibro);

				LOG.error("error en el post", e);

			}
		}

		request.setAttribute("mensajeAlerta", mensajeAlerta);

		request.getRequestDispatcher(vista).forward(request, response);

	}

}
