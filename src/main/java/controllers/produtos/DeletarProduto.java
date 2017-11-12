package controllers.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Produto;
import helpers.SessionManager;

/**
 * Servlet implementation class DeletarProduto
 */
@WebServlet("/produtos/destroy")
public class DeletarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarProduto() {
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
			Produto produto = BD.PRODUTOS.getProduto(Integer.parseInt(request.getParameter("id")));
			if (produto == null) {
				response.sendRedirect("/produtos");
				return;
			}
			
			BD.PRODUTOS.excluir(produto.getId());
			
			response.sendRedirect("/produtos");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/produtos");
			return;
		}
	}
}
