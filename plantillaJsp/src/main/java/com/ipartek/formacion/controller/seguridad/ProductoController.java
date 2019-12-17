package com.ipartek.formacion.controller.seguridad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.clases.Alerta;
import com.ipartek.formacion.controller.listener.SesionesListener;
import com.ipartek.formacion.modelo.dao.ProductoDAO;
import com.ipartek.formacion.modelo.pojos.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/seguridad/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(SesionesListener.class);
	
	private static Alerta mensajeAlerta = null;
	
	private static String vista = "";
	private static final String VIEW_LISTA = "productos/index.jsp";
	private static final String VIEW_NUEVO = "productos/nuevo-producto.jsp";
	private static final String VIEW_DETALLE = "productos/detalle-producto.jsp";
	
	private static final String ACCION_LISTAR = "listar";
	private static final String ACCION_NUEVO = "nuevo";
	private static final String ACCION_CREAR_NUEVO = "crear-nuevo";
	private static final String ACCION_MODIFICAR = "modificar";
	private static final String ACCION_BORRAR = "borrar";
	
	private static ProductoDAO dao;
	
	String pAccion;
	String pId;
	String pNombre;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	dao = ProductoDAO.getInstance();
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	
    	dao = null;
    	mensajeAlerta = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pAccion = request.getParameter("accion");
		pId = request.getParameter("id");
		pNombre = request.getParameter("nombre");
		
		try {
			
			switch (pAccion) {
			case ACCION_LISTAR:
				listar(request, response);
				break;
			case ACCION_NUEVO:	
				nuevo(request, response);
				break;
			case ACCION_CREAR_NUEVO:
				crearNuevo(request, response, pNombre);
				break;
			case ACCION_MODIFICAR:	
				detalle(request, response);
				
			case ACCION_BORRAR:	
				detalle(request, response);
			default:
				listar(request, response);
				break;
			}
			
			
			
			
		}catch (Exception e) {
			// TODO log
			e.printStackTrace();
			
		}finally {
			
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	}
	
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("productos", dao.getAll());
		vista = VIEW_LISTA;
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) {

		vista = VIEW_NUEVO;
	}
	
	private void crearNuevo(HttpServletRequest request, HttpServletResponse response, String nombreProducto) {

		// crear el producto nuevo y meterlo en el array con el objeto dao
		
		Producto productoNuevo = new Producto(++ProductoDAO.indice, nombreProducto);
		
    	try {
    		
			dao.create(productoNuevo);
			
		} catch (Exception e) {
			LOG.error("error al crear objetos");
		}
		
		mensajeAlerta = new Alerta( Alerta.TIPO_SUCCESS, "Producto " + nombreProducto + " creado con éxito");
		
		request.setAttribute("mensajeAlerta", mensajeAlerta);
		vista = VIEW_NUEVO;
	}
	
	private void detalle(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("productos", dao.getAll());
		vista = VIEW_DETALLE;
	}


}
