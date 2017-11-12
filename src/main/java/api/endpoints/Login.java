package api.endpoints;

import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import bd.BD;
import dbos.Empresa;
import dbos.Usuario;
import utils.PasswordGenerator;

@Path("login")
public class Login {
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response post(String body) {
		try {
			JsonObject data = new Gson().fromJson(body, JsonObject.class).getAsJsonObject();
			String email = data.get("email").getAsString();
			String senha = PasswordGenerator.get_SHA_512_SecurePassword(data.get("senha").getAsString());
			
			Usuario usuario = BD.USUARIOS.login(email, senha);
			
			return Response.ok(usuario.toJson()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(404).build();
		}
	}
}