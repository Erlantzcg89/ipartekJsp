package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController
 */
@WebServlet("/privado/servlet-pinta")
public class BasicController01 extends HttpServlet {
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

//		petición
		String userAgent = request.getHeader("User-Agent");
		String nombre = request.getParameter("nombre"); // pepe
		String password = request.getParameter("password"); // 1234
		Boolean isMovil = false;

		if (userAgent.toLowerCase().contains("mobile")) {
			isMovil = true;
		}

		if (NOMBRE.equals(nombre) && PASSWORD.equals(password)) {
			response.setStatus(200);
		} else {
			response.setStatus(401);
		}

		if (TETERA.equals(nombre)) {
			response.setStatus(418);
		}

//		respuesta
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>ejemplo1</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<a href=\"index.jsp\"><span>Inicio<span></a>");
		out.print("<h1>Servlet pintando html</h1>");
		out.print(
				"<p>El servlet es el controlador, el protocolo http funciona con request y response, y java así como otros lenguajes tienen los objetos y métodos para trabajar con este modelo.</p>");
		out.print(
				"<p>Introduce los parámetros nombre y password por la url:<br>\"&nbsp;?nombre= & password=&nbsp;\"</p>");
		out.print("<ol><li>Tu navegador es: " + userAgent + "</li><li>Nombre: " + nombre + "</li>" + "<li>Es movil: "
				+ isMovil.toString() + "</li></ol>");
		out.print("</body>");
		out.print("</html>");

//		por defecto respondemos con 200

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
