package dbos;

import java.io.Serializable;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Filial implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3405640758509871963L;
	
	
	private int id;
	private int empresas_id;
	private String nome;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String uf;
	private String municipio;
	private String logradouro;
	private String numero;
	private String complemento;
	
	public Filial(int empresas_id, String nome) {
		super();
		this.empresas_id = empresas_id;
		this.nome = nome;
	}

	public Filial(int id, int empresas_id, String nome, String telefone1, String telefone2, String telefone3, String uf,
			String municipio, String logradouro, String numero, String complemento) {
		super();
		this.id = id;
		this.empresas_id = empresas_id;
		this.nome = nome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.uf = uf;
		this.municipio = municipio;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public Filial(int empresas_id, String nome, String telefone1, String telefone2, String telefone3, String uf,
			String municipio, String logradouro, String numero, String complemento) {
		super();
		this.empresas_id = empresas_id;
		this.nome = nome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.uf = uf;
		this.municipio = municipio;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmpresas_id() {
		return empresas_id;
	}
	
	public void setEmpresas_id(int empresas_id) {
		this.empresas_id = empresas_id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone1() {
		return telefone1;
	}
	
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	public String getTelefone2() {
		return telefone2;
	}
	
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	public String getTelefone3() {
		return telefone3;
	}
	
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.add("id", new JsonPrimitive(getId()));
		json.add("empresas_id", new JsonPrimitive(getEmpresas_id()));
		json.add("nome", new JsonPrimitive(getNome() != null ? getNome() : ""));
		json.add("telefone1", new JsonPrimitive(getTelefone1() != null ? getTelefone1() : ""));
		json.add("telefone2", new JsonPrimitive(getTelefone2() != null ? getTelefone2() : ""));
		json.add("telefone3", new JsonPrimitive(getTelefone3() != null ? getTelefone3() : ""));
		json.add("uf", new JsonPrimitive(getUf() != null ? getUf() : ""));
		json.add("municipio", new JsonPrimitive(getMunicipio() != null ? getMunicipio() : ""));
		json.add("logradouro", new JsonPrimitive(getLogradouro() != null ? getLogradouro() : ""));
		json.add("numero", new JsonPrimitive(getNumero() != null ? getNumero() : ""));
		json.add("complemento", new JsonPrimitive(getComplemento() != null ? getComplemento() : ""));
		
		return json;
	}
}
