package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {

//	constantes
	private static final long serialVersionUID = 1L;

// inicialización del servlet en el constructor
	private ArrayList<Perro> perros = new ArrayList<Perro>();

	public PerrosController() {
		super();
		perros.add(new Perro("bubba", "mastín", "https://source.unsplash.com/100x100/?dog, mastin"));
		perros.add(new Perro("rataplan", "pastor aleman", "https://source.unsplash.com/100x100/?dog, sheppard"));
		perros.add(new Perro("mosca", "pastor belga", "https://source.unsplash.com/100x100/?dog, belgium"));
		perros.add(new Perro("txakur", "chiguaua", "https://source.unsplash.com/100x100/?dog, chiguagua"));
		perros.add(new Perro("lagun", "golden retriever", "https://source.unsplash.com/100x100/?dog, retriever"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// mandar el array de perros
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recibir datos del form

		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");

		// crear perro
		Perro perro = new Perro(nombre, raza);

		// guardar en lista
		perros.add(perro);

		// listar perros
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);

	}

}
