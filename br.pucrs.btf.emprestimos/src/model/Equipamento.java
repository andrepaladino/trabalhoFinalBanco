package model;

import java.util.Date;

public class Equipamento {
	private int identificacao;
	private Date aquisicao;
	private String descricao;
	private double custoDiario;
	private String manutencao;
	private String tipo;
	
	public Equipamento(int identificacao, Date aquisicao, String descricao, double custoDiario, 
			String manutencao, String tipo){
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getCustoDiario() {
		return custoDiario;
	}
	public void setCustoDiario(double custoDiario) {
		this.custoDiario = custoDiario;
	}
	public String getManutencao() {
		return manutencao;
	}
	public void setManutencao(String manutencao) {
		this.manutencao = manutencao;
	}
	public int getIdentificacao() {
		return identificacao;
	}
	public Date getAquisicao() {
		return aquisicao;
	}
	public String getTipo() {
		return tipo;
	}

}
