package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.LibroDAO;
import com.ipartek.formacion.utilidades.Alerta;

/**
 * Servlet implementation class BorrarLibroController
 */
@WebServlet("/backoffice/borrar")
public class BorrarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(BorrarLibroController.class);
	
	private static Alerta mensajeAlerta = null;

	private static final String VIEW_DASHBOARD = "index.jsp";
	
	private static LibroDAO dao;
	
	//parametros
	String pId;
	String pNombre;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarLibroController() {
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
		
		pId = request.getParameter("id");
		pNombre = request.getParameter("nombre");

		int idLibro = Integer.parseInt(pId);
		
		try {
					
			dao.delete(idLibro);

			mensajeAlerta = new Alerta(Alerta.TIPO_INFO, "Libro \"" + pNombre + "\" borrado con éxito");
		
		} catch (Exception e) {
			
			mensajeAlerta = new Alerta(Alerta.TIPO_DANGER, "Error al borrar el libro " + pNombre + "con id: " + pId);
			LOG.error("error al borrar el libro", e);
		}finally {
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);
			request.getRequestDispatcher(VIEW_DASHBOARD).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
