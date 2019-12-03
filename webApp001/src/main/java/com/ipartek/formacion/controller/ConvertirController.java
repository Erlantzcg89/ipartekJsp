package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConvertirController
 */
@WebServlet("/convertir")
public class ConvertirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final double METROS_PIES = 3.28084;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConvertirController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			double metros = Double.parseDouble(request.getParameter("op1"));

			double pies = metros * METROS_PIES;

//			Envio si sale todo bien
			request.setAttribute("metros", "" + metros);
			request.setAttribute("pies", "" + pies);

			request.getRequestDispatcher("/ejemplos/jsp/conversor.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			String mensageError = "Introduce un número correcto";

//			Envio si hay error en el input
			request.setAttribute("mensageError", mensageError);

			request.getRequestDispatcher("/ejemplos/jsp/conversor.jsp").forward(request, response);
		} catch (Exception e) {
			String mensageError = "Introduce un número correcto";

//			Envio si hay error en el input
			request.setAttribute("mensageError", mensageError);

			request.getRequestDispatcher("/ejemplos/jsp/conversor.jsp").forward(request, response);
		}

	}

}
