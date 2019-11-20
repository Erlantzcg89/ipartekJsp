package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/sumar")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculadoraController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean error = false;
		double resultado = 0.0;
		String enviar = "";

		// recibir parametros del formulario
		String num1 = request.getParameter("op1");
		String num2 = request.getParameter("op2");
		String operacion = request.getParameter("op3");

		// realizar calculos
		try {
			switch (operacion) {
			case "+":
				resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
				break;
			case "-":
				resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
				break;
			case "*":
				resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
				break;
			case "/":
				resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
				break;
			default:
				enviar = "Seleccione una operación";
				break;

			}
		} catch (Exception e) {
			error = true;
		}

		// enviar datos a la vista
		if (!error) {
			enviar = "" + resultado;
		} else {
			enviar = "Error grave, escondase en un lugar seguro";
		}
		request.setAttribute("enviar", "" + enviar);
		request.setAttribute("op1", "" + num1);
		request.setAttribute("op2", "" + num2);
		request.setAttribute("op3", operacion);

		// ir a vista
		request.getRequestDispatcher("/ejemplos/jsp/resultado.jsp").forward(request, response);

	}

}
