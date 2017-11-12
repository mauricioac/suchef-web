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

@Path("restaurantes")
public class Restaurantes {
	
	@GET
	@Produces("application/json")
	public Response index(@HeaderParam("Authentication") String authentication) {
		try {
			String token = authentication.replace("token=", "");
			
			Usuario usuario = BD.USUARIOS.loginToken(token);
			
			ArrayList<Empresa> restaurantes = BD.EMPRESAS.getEmpresas();

			JsonArray empresas = new JsonArray();
			
			for (Empresa e : restaurantes) {
				JsonObject jsonEmpresa = e.toJson();
				
				ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(e.getId());
				JsonArray farray = new JsonArray();
				
				for (Filial f : filiais) {
					farray.add(f.toJson());
				}
				
				jsonEmpresa.add("filiais", farray);
				
				empresas.add(jsonEmpresa);
			}
			
			
			return Response.ok(empresas.toString()).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Response.status(401).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response show(@HeaderParam("Authentication") String authentication, @PathParam("id") String id) {
		try {
			String token = authentication.replace("token=", "");
			
			Usuario usuario = BD.USUARIOS.loginToken(token);
			
			System.out.println(Integer.parseInt(id));
			Empresa e = BD.EMPRESAS.getEmpresa(Integer.parseInt(id));
			
			JsonObject jsonEmpresa = e.toJson();
			
			ArrayList<Filial> filiais = BD.FILIAIS.getFiliais(e.getId());
			JsonArray farray = new JsonArray();
			
			for (Filial f : filiais) {
				farray.add(f.toJson());
			}
			
			jsonEmpresa.add("filiais", farray);
			
			return Response.ok(jsonEmpresa.toString()).build();
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
			
			System.out.println(Integer.parseInt(id));
			Empresa e = BD.EMPRESAS.getEmpresa(Integer.parseInt(id));
			
			ArrayList<Produto> produtos = BD.PRODUTOS.getProdutos(e.getId());
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
