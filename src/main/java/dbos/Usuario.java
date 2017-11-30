package dbos;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.sql.Date;

public class Usuario {
	private int id;
	private String email;
	private String nome;
	private String cpf;
	private String senha;
	private Date data_cadastro;
	private String status;
	private String token_api;
	
	
	
	public Usuario(String email, String nome, String cpf, String senha, String status,
			String token_api) {
		super();
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.status = status;
		this.token_api = token_api;
	}

	public Usuario(int id, String email, String nome, String cpf, String senha, Date data_cadastro, String status,
			String token_api) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.data_cadastro = data_cadastro;
		this.status = status;
		this.token_api = token_api;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getData_cadastro() {
		return data_cadastro;
	}
	
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTokenAPI() {
		return token_api;
	}
	
	public void setTokenAPI(String token) {
		this.token_api = token;
	}
	
	public String toJson() {
		JsonObject json = new JsonObject();
		json.add("nome", new JsonPrimitive(getNome()));
		json.add("email", new JsonPrimitive(getEmail()));
		json.add("cpf", new JsonPrimitive(getCpf()));
		json.add("data_cadastro", new JsonPrimitive(getData_cadastro() == null ? "" : getData_cadastro().toString()));
		json.add("token_api", new JsonPrimitive(getTokenAPI()));
		json.add("status", new JsonPrimitive(getStatus()));
		
		return json.toString();
	}
}
