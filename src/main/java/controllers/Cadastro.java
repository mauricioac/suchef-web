package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.CryptoPrimitive;
import java.sql.Date;
import java.sql.Time;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import dbos.Cardapio;
import dbos.Empresa;
import dbos.Filial;
import helpers.SessionManager;
import utils.PasswordGenerator;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (SessionManager.isAuthenticated(request)) {
			response.sendRedirect("/produtos");
		} else  {
                    request.setAttribute("title", "Cadastro");
			request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("title", "Cadastro");	
            try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String nome_responsavel = request.getParameter("nome_responsavel");
			String cpf_responsavel = request.getParameter("cpf_responsavel");
			String senha = request.getParameter("senha");
			String confirmacao_senha = request.getParameter("confirmacao_senha");
			
			if (!senha.equals(confirmacao_senha)) {
				request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
			} else {
				senha = PasswordGenerator.get_SHA_512_SecurePassword(senha);
				
				Empresa empresa = new Empresa(nome, email, senha, nome_responsavel, cpf_responsavel);

				empresa.setData_cadastro(new Date(0));

				BD.EMPRESAS.incluir(empresa);
				
//				System.out.println(empresa.getId());
//				
//				Filial f1 = new Filial(empresa.getId(), "Filial 1");
//				
//				BD.FILIAIS.incluir(f1);
//				
//				Cardapio cp = new Cardapio("Cardapio padrao", empresa.getId());
//				
//				BD.CARDAPIOS.incluir(cp);
				
				response.sendRedirect("/login.jsp");
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			out.append(e.getStackTrace().toString());
		}
	}

}
