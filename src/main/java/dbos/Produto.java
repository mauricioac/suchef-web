package dbos;

import java.io.Serializable;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = -3405640758509871963L;
	
	private int id;
	private int filiais_id;
	private String ref;
	private String nome;
	private String descricao;
	private String imagem;
	private float preco;
	
	public Produto(int id, int filiais_id, String ref, String nome, String descricao, String imagem, float preco) {
		super();
		this.id = id;
		this.filiais_id = filiais_id;
		this.ref = ref;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
	}
	
	public Produto(int filiais_id, String ref, String nome, String descricao, String imagem, float preco) {
		super();
		this.filiais_id = filiais_id;
		this.ref = ref;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
	}
	
	public Produto(String ref, String nome, String descricao, String imagem, float preco) {
		super();
	
		this.ref = ref;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFiliais_id() {
		return filiais_id;
	}
	
	public void setFiliais_id(int filiais_id) {
		this.filiais_id = filiais_id;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.add("id", new JsonPrimitive(getId()));
		json.add("filiais_id", new JsonPrimitive(getFiliais_id()));
		json.add("nome", new JsonPrimitive(getNome()));
		json.add("ref", new JsonPrimitive(getRef()));
		json.add("preco", new JsonPrimitive(getPreco()));
		json.add("descricao", new JsonPrimitive(getDescricao() != null ? getDescricao() : ""));
		json.add("imagem", new JsonPrimitive(getImagem() != null ? getImagem() : ""));
		
		return json;
	}
}
