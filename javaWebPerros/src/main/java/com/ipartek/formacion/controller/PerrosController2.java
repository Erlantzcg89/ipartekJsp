package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros2")
public class PerrosController2 extends HttpServlet {

//	constantes
	private int contador = 0;
	private final static Logger LOG = Logger.getLogger(PerrosController.class);
	private String mensaje = "";
	private static final long serialVersionUID = 1L;

//	Array de perros
	private List<Perro> perros = new ArrayList<Perro>();

	@Override
	public void init(ServletConfig config) throws ServletException {

		LOG.trace("init del servlet");
		super.init(config);

//		if() {
//			
//		}

//		Iniciamos el array de perros en el init
		perros.add(new Perro(1, "bubba", "mastín", "https://source.unsplash.com/100x100/?dog, mastin"));
		perros.add(new Perro(2, "rataplan", "pastor aleman", "https://source.unsplash.com/100x100/?dog, sheppard"));
		perros.add(new Perro(3, "mosca", "pastor belga", "https://source.unsplash.com/100x100/?dog, belgium"));
		perros.add(new Perro(4, "txakur", "chiguaua", "https://source.unsplash.com/100x100/?dog, chiguagua"));
		perros.add(new Perro(5, "lagun", "golden retriever", "https://source.unsplash.com/100x100/?dog, retriever"));

		contador = 6;
	}

	@Override
	public void destroy() {
		LOG.trace("destroy del servlet");
//		Se limpia el array en el destroy
		perros = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("Antes del service");

		String mensaje = "";

		super.service(request, response);// Aquí ejecuta get o post

		LOG.trace("Después del service");

//		enviar mensage y lista al jsp

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros-jstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("metodo Get");

//		get recibe el id, adoptar y editar
		int id = (request.getParameter("id") == null) ? 0 : Integer.parseInt(request.getParameter("id"));
		boolean adoptar = (request.getParameter("adoptar") == null) ? false : true;
		boolean editar = (request.getParameter("editar") == null) ? false : true;

		LOG.debug("id= " + id + " adoptar=" + adoptar + " editar=" + editar);

//		si el id es mayor que cero buscamos el perro para modificar o adoptar
		if (id > 0) {

			Perro perro = null;
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}

			if (adoptar) {
				perros.remove(perro);
				mensaje = "Ya has adoptado al perro, gracias";
			}

			if (editar) {
				request.setAttribute("perroEditar", perro);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("metodo Post");
		// recibir datos del form

		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");

		// TODO validar parametros

		if (id > 0) {

			LOG.trace("Modificar el perro");
			Perro perro = null;
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}
			perro.setNombre(nombre);
			perro.setRaza(raza);

			mensaje = "Perro modificado con exito";

		} else {

			LOG.trace("Crear perro nuevo");

			// crear perro
			Perro p = new Perro();
			p.setNombre(nombre);
			p.setRaza(raza);
			p.setId(contador);
			contador++;

			mensaje = "Gracias por dar de alta un nuevo perro";

			// guardar en lista
			perros.add(p);

		}

	}

}
