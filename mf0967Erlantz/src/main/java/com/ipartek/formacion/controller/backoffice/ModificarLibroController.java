package com.ipartek.formacion.controller.backoffice;

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
 * Servlet implementation class ModificarLibroController
 */
@WebServlet("/backoffice/modificar")
public class ModificarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(BorrarLibroController.class);
	
	private static Alerta mensajeAlerta = null;
	
	String vista = "";

	private static final String VIEW_DASHBOARD = "index.jsp";
	private static final String VIEW_MODIFICAR = "libros/modificar-libro.jsp";
	
	private static LibroDAO dao;
	
	//parametros
	String pId;
	String pNombre;
	String pPrecio;
	String pDescuento;
	String pAutor;
	String pImagen;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarLibroController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// si es un get es para enseñar el formulario de modificar
		
		pId = request.getParameter("id");
		pNombre = request.getParameter("nombre");
		pPrecio = request.getParameter("precio");
		pDescuento = request.getParameter("descuento");
		pAutor = request.getParameter("autor");
		pImagen = request.getParameter("imagen");
		
		try {
					
			//enviarle para que rellene el form
			
			request.setAttribute("id", pId);
			request.setAttribute("nombre", pNombre);
			request.setAttribute("precio", pPrecio);
			request.setAttribute("descuento", pDescuento);
			request.setAttribute("autor", pAutor);
			request.setAttribute("imagen", pImagen);
		
		} catch (Exception e) {
			
			LOG.error("error", e);
		}finally {
			
			request.getRequestDispatcher(VIEW_MODIFICAR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// método post. Se utiliza para modificar libros

		pId = request.getParameter("id");
		pNombre = request.getParameter("nombre");
		pPrecio = request.getParameter("precio");
		pDescuento = request.getParameter("descuento");
		pAutor = request.getParameter("autor");
		pImagen = request.getParameter("imagen");
		
		mensajeAlerta = null;
		
		
		int idLibro = Integer.parseInt(pId);
		String nombreLibro = pNombre;
		Double precioLibro = Double.parseDouble(pPrecio);
		int descuentoLibro = Integer.parseInt(pDescuento);
		String autorLibro = pAutor;
		String imagenLibro = pImagen;
		

			vista = VIEW_DASHBOARD;

			try {
				
				Libro libroModificado = new Libro(idLibro, nombreLibro, precioLibro, descuentoLibro, autorLibro, imagenLibro);

				dao.update(idLibro, libroModificado);
				//hacer la modificacion

				mensajeAlerta = new Alerta(Alerta.TIPO_INFO, "Libro \"" + nombreLibro + "\" modificado con éxito");

			} catch (Exception e) {

				mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al modificar el libro " + nombreLibro);

				LOG.error("error en el post", e);
				e.printStackTrace();

			}

		request.setAttribute("mensajeAlerta", mensajeAlerta);

		request.getRequestDispatcher(vista).forward(request, response);
	}

}