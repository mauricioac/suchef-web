package controllers.filiais;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.MeuResultSet;
import dbos.Filial;
import helpers.SessionManager;

/**
 * Servlet implementation class Listagem
 */
@WebServlet("/filiais")
public class Listagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!SessionManager.isAuthenticated(request)) {
			response.sendRedirect("/login");
			return;
		}
                
                request.setAttribute("title", "Filiais");
		
		try {
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(SessionManager.id(request));
			
			request.setAttribute("filiais", filiais);
			request.getRequestDispatcher("/filiais/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}