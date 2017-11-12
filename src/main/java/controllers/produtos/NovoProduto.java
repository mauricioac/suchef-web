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
 * Servlet implementation class NovoProduto
 */
@WebServlet("/produtos/new")
public class NovoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(SessionManager.id(request));
			
			request.setAttribute("filiais", filiais);
			request.getRequestDispatcher("/produtos/new.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(SessionManager.id(request));
			request.setAttribute("filiais", filiais);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
		int filiais_id = Integer.parseInt(request.getParameter("filiais_id"));	
		String ref = request.getParameter("ref");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String imagem = request.getParameter("imagem");
		float preco = Float.parseFloat(request.getParameter("preco"));
		
		Produto p = new Produto(filiais_id, ref, nome, descricao, imagem, preco);
		
		BD.PRODUTOS.incluir(p);
		
		response.sendRedirect("/produtos");
		
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/produtos/new.jsp").forward(request, response);
		}
	}

}
