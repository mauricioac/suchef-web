package controllers.filiais;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Filial;
import helpers.SessionManager;

/**
 * Servlet implementation class DeletarFilial
 */
@WebServlet("/filiais/destroy")
public class DeletarFilial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarFilial() {
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
		
		try {
			Filial filial = BD.FILIAIS.getFilial(Integer.parseInt(request.getParameter("id")));
			if (filial == null) {
				response.sendRedirect("/filiais");
				return;
			}
			
			BD.FILIAIS.excluir(filial.getId());
			
			response.sendRedirect("/filiais");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/filiais");
			return;
		}
	}

}
