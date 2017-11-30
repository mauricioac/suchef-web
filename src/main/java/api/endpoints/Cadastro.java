package api.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import bd.BD;
import dbos.Usuario;
import helpers.DateHelper;
import java.sql.Date;
import javassist.bytecode.DuplicateMemberException;
import utils.PasswordGenerator;
import utils.TokenGenerator;

@Path("cadastro")
public class Cadastro {
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrar(String body) {
		try {
			JsonObject data = new Gson().fromJson(body, JsonObject.class).getAsJsonObject();
			String email = data.get("email").getAsString();
			String nome = data.get("nome").getAsString();
			String cpf = data.get("cpf").getAsString();
			String status = "A";
			String tokenAPI = TokenGenerator.generate();
			String senha = PasswordGenerator.get_SHA_512_SecurePassword(data.get("senha").getAsString());
			
			// String email, String nome, String cpf, String senha, String data_cadastro, String status,String token_api
			Usuario usuario = new Usuario(email, nome, cpf, senha, status, tokenAPI);
			
			if (BD.USUARIOS.cpfCadastrado(cpf)) {
				throw new DuplicateMemberException("Usuário já existente com este CPF");
			}
			
			if (BD.USUARIOS.emailCadastrado(email)) {
				throw new DuplicateMemberException("Usuário já existente com este email");
			}
			
			BD.USUARIOS.incluir(usuario);
			
			return Response.ok(usuario.toJson()).build();
		} catch (DuplicateMemberException de) {
			de.printStackTrace();
			return Response.status(422).entity("{\"error\": \"" + de.getMessage() + "\"}").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("{\"error\": \"Erro ao cadastrar usuário\"}").build();
		}
	}
}
