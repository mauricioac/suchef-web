package api.endpoints;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bd.BD;
import dbos.Empresa;
import dbos.Filial;
import dbos.Produto;
import dbos.Usuario;

@Path("/filiais")
public class Filiais {
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response show(@HeaderParam("Authentication") String authentication, @PathParam("id") String id) {
		try {
			String token = authentication.replace("token=", "");
			
			Usuario usuario = BD.USUARIOS.loginToken(token);
			
			Filial filial = BD.FILIAIS.getFilial(Integer.parseInt(id));
			
			JsonObject jsonFilial = filial.toJson();

			return Response.ok(jsonFilial.toString()).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Response.status(401).build();
		}
	}
	
	@GET
	@Path("{id}/produtos")
	@Produces("application/json")
	public Response produtos(@HeaderParam("Authentication") String authentication, @PathParam("id") String id) {
		try {
			String token = authentication.replace("token=", "");
			
			Usuario usuario = BD.USUARIOS.loginToken(token);
			
			Filial filial = BD.FILIAIS.getFilial(Integer.parseInt(id));
			
			ArrayList<Produto> produtos = BD.PRODUTOS.getProdutosFilial(filial.getId());
			JsonArray produtosJson = new JsonArray();
			
			for (Produto p : produtos) {
				produtosJson.add(p.toJson());
			}
			
			return Response.ok(produtosJson.toString()).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Response.status(401).build();
		}
	}
}
