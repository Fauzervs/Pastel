package br.edu.senaisp.Pastel.model;

public class Sabor {
	
	private int id;
	private String sabor;
	private String descricao;
	public Sabor(int id, String sabor, String descricao) {
		super();
		this.id = id;
		this.sabor = sabor;
		this.descricao = descricao;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
