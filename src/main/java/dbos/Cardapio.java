package dbos;

public class Cardapio {
	private int id;
	private String nome;
	private String hora_inicio;
	private String hora_fim;
	private int empresas_id;
	
	public Cardapio(String nome, int empresas_id) {
		super();
		this.nome = nome;
		this.empresas_id = empresas_id;
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
	
	public String getHora_inicio() {
		return hora_inicio;
	}
	
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	
	public String getHora_fim() {
		return hora_fim;
	}
	
	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}
	
	public int getEmpresas_id() {
		return empresas_id;
	}
	
	public void setEmpresas_id(int empresas_id) {
		this.empresas_id = empresas_id;
	}
}
