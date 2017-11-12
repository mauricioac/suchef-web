package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbos.Empresa;
import helpers.SessionManager;

/**
 * Servlet implementation class MinhaConta
 */
@WebServlet("/minha_conta")
public class MinhaConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinhaConta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!SessionManager.isAuthenticated(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		request.getRequestDispatcher("/minha_conta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!SessionManager.isAuthenticated(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		try {
			Empresa empresa = SessionManager.empresa(request);
		} catch (Exception e) {
			
		}
	}

}