package com.ipartek.formacion.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class SesionesListener
 *
 */
@WebListener
public class SesionesListener implements HttpSessionListener, HttpSessionAttributeListener {

	private final static Logger LOG = Logger.getLogger(SesionesListener.class);

	/**
	 * Default constructor.
	 */
	public SesionesListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// cada vez que se crea una sesion
		LOG.trace("sessionCreated ");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// cada vez que se destruye una sesión
		LOG.trace("sessionDestroyed ");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

		LOG.debug("attributeAdded " + event.getName() + " " + event.getValue());

		// cada vez que se añade un atributo del tipo usuarioLogeado
		// a nivel de session
		// sumamos el atributo global numeroUsuariosConectados
		if ("usuarioLogeado".equals(event.getName())) {

			ServletContext sc = event.getSession().getServletContext();
			int num = (int) sc.getAttribute("numeroUsuariosConectados");
			sc.setAttribute("numeroUsuariosConectados", ++num);

		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

		LOG.debug("attributeRemoved " + event.getName() + " " + event.getValue());

		// cada vez que se quita un atributo usuarioLogeado
		// a nivel de session
		// se resta uno del numeroUsuariosConectados
		if ("usuarioLogeado".equals(event.getName())) {

			ServletContext sc = event.getSession().getServletContext();
			int num = (int) sc.getAttribute("numeroUsuariosConectados");
			sc.setAttribute("numeroUsuariosConectados", --num);

		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
