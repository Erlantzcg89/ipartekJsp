package com.ipartek.formacion.supermercado.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

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
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 


    	ProductoDAO gestorProductos = ProductoDAO.getInstance();
    	
    	Producto vodka = new Producto(++ProductoDAO.indice, "vodka", 14.50, "https://source.unsplash.com/100x100/?vodka", "Botella de Absolut version navidad 2020", 20);
    	Producto ginebra = new Producto(++ProductoDAO.indice, "ginebra", 20.99, "https://source.unsplash.com/100x100/?gin", "Ginebra destilada de calidad", 0);
    	Producto frenadol = new Producto(++ProductoDAO.indice, "frenadol", 9.99, "https://source.unsplash.com/100x100/?medicine", "Polvos de Frenadol para el catarro", 0);
    	Producto aspirina = new Producto(++ProductoDAO.indice, "aspirina", 15.49, "https://source.unsplash.com/100x100/?aspirin", "Efectiva para el dolor de cabeza", 0);
    	Producto harina = new Producto(++ProductoDAO.indice, "harina", 3.75, "https://source.unsplash.com/100x100/?coke", "Harina de trigo", 20);
    	Producto azucar = new Producto(++ProductoDAO.indice, "azucar", 3.25, "https://source.unsplash.com/100x100/?sugar", "Refinada y de química compuesta", 0);
    	Producto whiskey = new Producto(++ProductoDAO.indice, "whiskey", 14.50, "https://source.unsplash.com/100x100/?whiskey", "Mejor tomar con hielos a lo Bertin Osborne", 0);
    	Producto ron = new Producto(++ProductoDAO.indice, "ron", 29.99, "https://source.unsplash.com/100x100/?rum", "Ron del salvador especial para piratas", 0);
    	Producto reflex = new Producto(++ProductoDAO.indice, "reflex", 6.69, "https://source.unsplash.com/100x100/?spry", "Espray para las articulaciones resacosas", 20);
    	Producto donsimon = new Producto(++ProductoDAO.indice, "donsimon", 1.99, "https://source.unsplash.com/100x100/?wine", "Si no tienes más presupuesto este es tu vino", 0);

    	
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
	
}
