package com.ipartek.formacion.controller.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {

	private final static Logger LOG = Logger.getLogger(AppListener.class);

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

		// sc == applicationScope
		// servlet context
		// aquí trabajamos con atributos de contexto:
		// ${applicationScope.variableAplicacion}
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("numeroUsuariosConectados", 0);

		// atributo applicationSope o ServletContext
		HashMap<String, String> hmDeportes = new HashMap<String, String>();
		hmDeportes.put("1", "Surf");
		hmDeportes.put("2", "Bodyboard");
		hmDeportes.put("3", "Quidditch");
		hmDeportes.put("4", "Jugger");
		hmDeportes.put("5", "Soffing");
		sc.setAttribute("hmDeportes", hmDeportes);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("La App se cierra");
	}

}
