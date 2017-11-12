package helpers;

import javax.servlet.http.HttpServletRequest;

import dbos.Empresa;

public class SessionManager {
	
	public static boolean isAuthenticated(HttpServletRequest request) {
		Object o = request.getSession().getAttribute("authenticated");
		
		if (o == null) {
			return false;
		}
		
		return (Boolean) request.getSession().getAttribute("authenticated");
	}
	
	public static String nome(HttpServletRequest request) {
		if (request == null) {
			return "";
		}
		
		return empresa(request).getNome();
	}
	
	public static int id(HttpServletRequest request) {
		return empresa(request).getId();
	}
	
	public static Empresa empresa(HttpServletRequest request) {
		return (Empresa) request.getSession().getAttribute("empresa");
	}
	
	public static void setFlash(HttpServletRequest request, String mensagem) {
		request.getSession().setAttribute("flash", mensagem);
	}
	
	public static boolean hasFlash(HttpServletRequest request) {
		return request.getSession().getAttribute("flash") != null;
	}
	
	public static String getFlash(HttpServletRequest request) {
		String mensagem = (String) request.getSession().getAttribute("flash");
		request.getSession().removeAttribute("flash");
		
		return mensagem;
	}
}