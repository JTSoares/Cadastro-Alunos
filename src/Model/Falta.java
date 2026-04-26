package Model;

public class Falta {
	
	//***********************ATRIBUTOS***********************
	private String data; 
	private int quantidade; 
	
	//***********************CONSTRUTOR***********************
	public Falta(String data, int qtd) {
		this.setData(data);
		this.setQuantidade(qtd);
		
	}
	
	//***********************GET E SET***********************

	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
