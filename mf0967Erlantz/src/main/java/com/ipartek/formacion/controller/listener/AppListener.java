package com.ipartek.formacion.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.LibroDAO;
import com.ipartek.formacion.modelo.pojos.Libro;
import com.ipartek.formacion.utilidades.Alerta;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {

	private final static Logger LOG = Logger.getLogger(AppListener.class);

	private LibroDAO dao = LibroDAO.getInstance();

	/**
	 * Default constructor.
	 */
	public AppListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		
		Alerta mensajeAlerta = null;
		
		LOG.info("La App se abre");

		ServletContext sc = sce.getServletContext();
		sc.setAttribute("numeroUsuariosConectados", 0); // atributo global usuariosConectados a 0
    	
    	Libro libro1 = new Libro(++LibroDAO.indice, "El quijote", 12.0, 0, "Miguel de Cervantes", "");
    	Libro libro2 = new Libro(++LibroDAO.indice, "Superman", 19.99, 10, "Autor 2", "");
    	Libro libro3 = new Libro(++LibroDAO.indice, "Mortadelo y Filemon", 12.0, 0, "Escritor de humor", "");
    	
    	try {
			dao.create(libro1);
			dao.create(libro2);
			dao.create(libro3);
			
		} catch (Exception e) {
			LOG.error("error al crear objetos");
		}
    	
		sc.setAttribute("libros", dao.getAll());
		sc.setAttribute("mensajeAlertaListado", new Alerta(Alerta.TIPO_INFO, "Libros en el registro: " + dao.getAll().size()));
		
		
		
    	
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("numeroUsuariosConectados", 0);
		
		LOG.info("La App se cierra");
	}

}