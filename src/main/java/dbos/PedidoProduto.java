package dbos;

public class PedidoProduto {
	private int pedidos_id;
	private int produtos_id;
	private int quantidade;
	private float subtotal;
	
	public int getPedidos_id() {
		return pedidos_id;
	}
	
	public void setPedidos_id(int pedidos_id) {
		this.pedidos_id = pedidos_id;
	}
	
	public int getProdutos_id() {
		return produtos_id;
	}
	
	public void setProdutos_id(int produtos_id) {
		this.produtos_id = produtos_id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
}
