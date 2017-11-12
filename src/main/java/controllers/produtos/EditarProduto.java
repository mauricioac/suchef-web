package controllers.produtos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Filial;
import dbos.Produto;
import helpers.SessionManager;

/**
 * Servlet implementation class EditarProduto
 */
@WebServlet("/produtos/edit")
public class EditarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProduto() {
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
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(SessionManager.id(request));
			request.setAttribute("filiais", filiais);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Produto produto = BD.PRODUTOS.getProduto(Integer.parseInt(request.getParameter("id")));
			if (produto == null) {
				response.sendRedirect("/produtos");
				return;
			}
			
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("/produtos/edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/produtos");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!SessionManager.isAuthenticated(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		try {
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(SessionManager.id(request));
			request.setAttribute("filiais", filiais);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Produto produto;
		
		try {
			produto = BD.PRODUTOS.getProduto(Integer.parseInt(request.getParameter("id")));
			if (produto == null) {
				response.sendRedirect("/produtos");
				return;
			}
		} catch (Exception e) {
			doGet(request, response);
			return;
		}
			
		produto.setFiliais_id(Integer.parseInt(request.getParameter("filiais_id")));	
		produto.setRef(request.getParameter("ref"));
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setImagem(request.getParameter("imagem"));
		produto.setPreco(Float.parseFloat(request.getParameter("preco")));
		
		System.out.println(produto.getId());
		
		try {
			BD.PRODUTOS.alterar(produto);
			
			response.sendRedirect("/produtos");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("/produtos/edit.jsp").forward(request, response);
		}
	}

}
