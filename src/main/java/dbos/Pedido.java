package dbos;

public class Pedido {
	private int id;
	private int usuarios_id;
	private int enderecos_id;
	private String datahora;
	private String observacoes;
	private float total;
	private String forma_pagamento;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUsuarios_id() {
		return usuarios_id;
	}
	
	public void setUsuarios_id(int usuarios_id) {
		this.usuarios_id = usuarios_id;
	}
	
	public int getEnderecos_id() {
		return enderecos_id;
	}
	
	public void setEnderecos_id(int enderecos_id) {
		this.enderecos_id = enderecos_id;
	}
	
	public String getDatahora() {
		return datahora;
	}
	
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	public String getForma_pagamento() {
		return forma_pagamento;
	}
	
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
}
