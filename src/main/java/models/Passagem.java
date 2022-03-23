package models;

public class Passagem {
	private int idPass;
	private String embarque;
	private String desembarque;
	private double preco;
	private int idCliente;
	private Cliente cliente;
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdPass(int idPass) {
		this.idPass = idPass;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdPass() {
		return idPass;
	}
	
	public String getEmbarque() {
		return embarque;
	}
	public void setEmbarque(String embarque) {
		this.embarque = embarque;
	}
	
	public String getDesembarque() {
		return desembarque;
	}
	public void setDesembarque(String desembarque) {
		this.desembarque = desembarque;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
