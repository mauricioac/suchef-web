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
 * Servlet implementation class EditarFilial
 */
@WebServlet("/filiais/edit")
public class EditarFilial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarFilial() {
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
                
                request.setAttribute("title", "Editar filial");
		
		try {
			Filial filial = BD.FILIAIS.getFilial(Integer.parseInt(request.getParameter("id")));
			if (filial == null) {
				response.sendRedirect("/filiais");
				return;
			}
			
			request.setAttribute("filial", filial);
			request.getRequestDispatcher("/filiais/edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/filiais");
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
              
                request.setAttribute("title", "Editar filial");
		
		Filial filial;
		
		try {
			System.out.println(request.getParameter("id"));
			filial = BD.FILIAIS.getFilial(Integer.parseInt(request.getParameter("id")));
			if (filial == null) {
				response.sendRedirect("/filiais");
				return;
			}
		} catch (Exception e) {
			doGet(request, response);
			return;
		}
			
		filial.setNome(request.getParameter("nome"));
		filial.setLogradouro(request.getParameter("logradouro"));
		filial.setMunicipio(request.getParameter("municipio"));
		filial.setNumero(request.getParameter("numero"));
		filial.setUf(request.getParameter("uf"));
		filial.setComplemento(request.getParameter("complemento"));
		filial.setTelefone1(request.getParameter("telefone1"));
		filial.setTelefone2(request.getParameter("telefone2"));
		filial.setTelefone3(request.getParameter("telefone3"));
		
		
		try {
			BD.FILIAIS.alterar(filial);
			
			response.sendRedirect("/filiais");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("filial", filial);
			request.getRequestDispatcher("/filiais/edit.jsp").forward(request, response);
		}
	}

}

	