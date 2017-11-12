package dbos;

public class Promocao {
	private int id;
	private int empresas_id;
	private String codigo;
	private float porcentagem;
	private String inicio;
	private String fim;
	
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
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public float getPorcentagem() {
		return porcentagem;
	}
	
	public void setPorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public String getInicio() {
		return inicio;
	}
	
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	
	public String getFim() {
		return fim;
	}
	
	public void setFim(String fim) {
		this.fim = fim;
	}
}
