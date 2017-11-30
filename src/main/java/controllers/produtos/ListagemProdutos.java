package controllers.produtos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Produto;
import helpers.SessionManager;

/**
 * Servlet implementation class ListagemProdutos
 */
@WebServlet("/produtos")
public class ListagemProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemProdutos() {
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
                
                request.setAttribute("title", "Produtos");
		
		try {
			ArrayList<Produto> produtos = BD.PRODUTOS.getProdutos(SessionManager.id(request));
			
			request.setAttribute("produtos", produtos);
			request.getRequestDispatcher("/produtos/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
