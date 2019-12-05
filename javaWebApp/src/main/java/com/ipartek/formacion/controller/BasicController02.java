package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController
 */
@WebServlet("/ejemplo02")
public class BasicController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NOMBRE = "pepe";
	private static final String PASSWORD = "1234";
	private static final String TETERA = "tetera";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Petición
		String userAgent = request.getHeader("User-Agent");
		String nombre = request.getParameter("nombre"); // pepe
		String password = request.getParameter("password"); // 1234
		Boolean isMovil = false;

		if (userAgent.toLowerCase().contains("mobile")) {
			isMovil = true;
		}

//		Atributos
		request.setAttribute("nombre", "" + nombre);
		request.setAttribute("password", "" + password);
		request.setAttribute("movil", isMovil.toString());

//		Respuestas
		if (TETERA.equals(nombre)) {
			response.setStatus(418);
			request.getRequestDispatcher("/privado/jsp/418.jsp").forward(request, response);
		}

		if (NOMBRE.equals(nombre) && PASSWORD.equals(password)) {
			response.setStatus(200);
		} else {
			response.setStatus(401);
			request.getRequestDispatcher("/privado/jsp/401.jsp").forward(request, response);

		}

		request.getRequestDispatcher("/privado/jsp/ejemplo02.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
