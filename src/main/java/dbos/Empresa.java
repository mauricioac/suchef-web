package dbos;

import java.io.Serializable;
import java.sql.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6702381419163072484L;
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String nome_responsavel;
	private String cpf_responsavel;
	private Date data_cadastro;
	private String logo;
	
	public Empresa(String nome, String email, String senha, String nome_responsavel, String cpf_responsavel) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nome_responsavel = nome_responsavel;
		this.cpf_responsavel = cpf_responsavel;
	}
	
	

	public Empresa(int id, String nome, String email, String senha, String nome_responsavel, String cpf_responsavel,
			Date data_cadastro, String logo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nome_responsavel = nome_responsavel;
		this.cpf_responsavel = cpf_responsavel;
		this.data_cadastro = data_cadastro;
		this.logo = logo;
	}



	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
	
	public String getCpf_responsavel() {
		return cpf_responsavel;
	}
	
	public void setCpf_responsavel(String cpf_responsavel) {
		this.cpf_responsavel = cpf_responsavel;
	}
	
	public Date getData_cadastro() {
		return data_cadastro;
	}
	
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.add("id", new JsonPrimitive(getId()));
		json.add("nome", new JsonPrimitive(getNome()));
		json.add("email", new JsonPrimitive(getEmail()));
		json.add("nome_responsavel", new JsonPrimitive(getNome_responsavel() != null ? getNome_responsavel() : ""));
		json.add("cpf_responsavel", new JsonPrimitive(getCpf_responsavel() != null ? getCpf_responsavel() : ""));
		json.add("logo", new JsonPrimitive(getLogo() != null ? getLogo() : ""));
		
		return json;
	}
}
