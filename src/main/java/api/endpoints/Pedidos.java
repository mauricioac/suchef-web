package api.endpoints;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.JsonArray;

import bd.BD;
import dbos.Usuario;

@Path("pedidos")
public class Pedidos {
	
	@POST
	@Path("{id}/produtos")
	@Produces("application/json")
	public Response criar(@HeaderParam("Authentication") String authentication) {
		try {
			String token = authentication.replace("token=", "");
			
			Usuario usuario = BD.USUARIOS.loginToken(token);
			
			
			return Response.ok("JSON").build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Response.status(401).build();
		}
		
	}
}