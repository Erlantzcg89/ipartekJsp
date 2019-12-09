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
@WebServlet("/perros")
public class PerrosController extends HttpServlet {

//	constantes
	private final static Logger LOG = Logger.getLogger(PerrosController.class);
	private String mensaje = "";
	private static final long serialVersionUID = 1L;

//	Array de perros
	private List<Perro> perros = new ArrayList<Perro>();

	public PerrosController() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		LOG.trace("init del servlet");
		super.init(config);

//		Iniciamos el array de perros en el init
		perros.add(new Perro("bubba", "mastín", "https://source.unsplash.com/100x100/?dog, mastin"));
		perros.add(new Perro("rataplan", "pastor aleman", "https://source.unsplash.com/100x100/?dog, sheppard"));
		perros.add(new Perro("mosca", "pastor belga", "https://source.unsplash.com/100x100/?dog, belgium"));
		perros.add(new Perro("txakur", "chiguaua", "https://source.unsplash.com/100x100/?dog, chiguagua"));
		perros.add(new Perro("lagun", "golden retriever", "https://source.unsplash.com/100x100/?dog, retriever"));
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
		request.getRequestDispatcher("perros.jsp").forward(request, response);
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

		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");

		// crear perro
		Perro perro = new Perro(nombre, raza);

		// guardar en lista
		perros.add(perro);

	}

}
