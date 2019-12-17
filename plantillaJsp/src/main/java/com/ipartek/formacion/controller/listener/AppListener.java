package com.ipartek.formacion.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.ProductoDAO;
import com.ipartek.formacion.modelo.pojos.Producto;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {

	private final static Logger LOG = Logger.getLogger(AppListener.class);

	private ProductoDAO gestorProductos = ProductoDAO.getInstance();

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
		
		LOG.info("La App se abre");

		ServletContext sc = sce.getServletContext();
		sc.setAttribute("numeroUsuariosConectados", 0); // atributo global usuariosConectados a 0
    	
    	Producto vodka = new Producto(++ProductoDAO.indice, "vodka");
    	Producto ginebra = new Producto(++ProductoDAO.indice, "ginebra");
    	Producto frenadol = new Producto(++ProductoDAO.indice, "frenadol");
    	Producto aspirina = new Producto(++ProductoDAO.indice, "aspirina");
    	Producto harina = new Producto(++ProductoDAO.indice, "harina");
    	Producto azucar = new Producto(++ProductoDAO.indice, "azucar");
    	Producto whiskey = new Producto(++ProductoDAO.indice, "whiskey");
    	Producto ron = new Producto(++ProductoDAO.indice, "ron");
    	Producto reflex = new Producto(++ProductoDAO.indice, "reflex");
    	Producto donsimon = new Producto(++ProductoDAO.indice, "donsimon");
    	
    	try {
			gestorProductos.create(vodka);
			gestorProductos.create(ginebra);
			gestorProductos.create(frenadol);
			gestorProductos.create(aspirina);
			gestorProductos.create(harina);
			gestorProductos.create(azucar);
			gestorProductos.create(whiskey);
			gestorProductos.create(ron);
			gestorProductos.create(reflex);
			gestorProductos.create(donsimon);
			
		} catch (Exception e) {
			LOG.error("error al crear objetos");
		}
    	
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
