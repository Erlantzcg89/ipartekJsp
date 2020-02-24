package com.ipartek.formacion.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/api/*" })
public class SeguridadFilter implements Filter {
	
	private final static Logger LOG = LogManager.getLogger(SeguridadFilter.class);

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		LOG.trace("init");		
		ServletContext sc = fConfig.getServletContext(); 
		sc.setAttribute("numeroUsuariosIndebidos", 0);    	
		sc.setAttribute("ips", new HashSet<String>());
	}

  
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		if( "GET".equalsIgnoreCase( req.getMethod() ) ){
			// dejamos continuar
			LOG.trace("acceso permitido");
			chain.doFilter(request, response);
			
			
		}else {
			
			HttpSession session = req.getSession();
			Usuario usuarioSession = (Usuario) session.getAttribute("usuarioLogeado");
			
			
			if (  usuarioSession != null ) {
			
				// dejamos continuar
				LOG.trace("acceso permitido " + usuarioSession);
				chain.doFilter(request, response);
									
			}else {

				//acceso denegado
				LOG.warn("acceso denegado");
				res.setStatus(304);
				

			}
			
			
			
		}
		
		
		
		
		
	}


}