package com.ipartek.formacion.supermercado.controller.seguridad;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class SeguridadBackofficeFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/seguridad/*" })
public class SeguridadBackofficeFilter implements Filter {
	
	private final static Logger LOG = Logger.getLogger(SeguridadBackofficeFilter.class);


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Usuario uLogeado = (Usuario) session.getAttribute("usuarioLogeado");
		
		if ( uLogeado != null && uLogeado.getRol().getId() == Rol.ROL_ADMIN ) {
		
			chain.doFilter(request, response);
			
		}else{
			
			LOG.warn("acceso denegado por seguridad " + uLogeado);
			session.invalidate();
			res.sendRedirect( req.getContextPath() +  "/login.jsp");
				
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
