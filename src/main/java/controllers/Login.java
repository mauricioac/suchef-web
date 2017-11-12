package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Empresa;
import helpers.SessionManager;
import utils.PasswordGenerator;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionManager.isAuthenticated(request)) {
			SessionManager.setFlash(request, "Você já está logado no sistema!");
			response.sendRedirect("/produtos");
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String email = request.getParameter("email");
			String senha = PasswordGenerator.get_SHA_512_SecurePassword(request.getParameter("senha"));
			
			System.out.println(email + " , " + senha);
			
			Empresa empresa = BD.EMPRESAS.login(email, senha);
			
			request.getSession().setAttribute("authenticated", true);
			request.getSession().setAttribute("empresa", empresa);
			
			SessionManager.setFlash(request, "Você logou no sistema com sucesso!");
			response.sendRedirect("/produtos");
		} catch (Exception e) {
			e.printStackTrace();

			SessionManager.setFlash(request, "Email e/ou senha inálidos.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
