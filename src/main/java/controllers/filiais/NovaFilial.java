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
 * Servlet implementation class NovaFilial
 */
@WebServlet("/filiais/new")
public class NovaFilial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaFilial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/filiais/new.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String logradouro = request.getParameter("logradouro");
			String municipio = request.getParameter("municipio");
			String numero = request.getParameter("numero");
			String uf = request.getParameter("uf");
			String complemento = request.getParameter("complemento");
			String telefone1 = request.getParameter("telefone1");
			String telefone2 = request.getParameter("telefone2");
			String telefone3 = request.getParameter("telefone3");
			
			Filial f = new Filial(SessionManager.id(request), nome, telefone1, telefone2, telefone3, uf, municipio, logradouro, numero, complemento);
			
			BD.FILIAIS.incluir(f);
			
			response.sendRedirect("/filiais");
			return;
		} catch (Exception e) {
			request.getRequestDispatcher("/filiais/new.jsp").forward(request, response);
		}
	}

}