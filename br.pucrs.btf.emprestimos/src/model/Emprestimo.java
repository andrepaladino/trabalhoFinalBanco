package model;

import java.time.LocalDate;

public class Emprestimo {
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private String identificacao;
	
	private Equipamento equipamento;
	private Funcionario funcionario; 
	
	public Emprestimo(LocalDate dataInicial, LocalDate dataFinal, String identificacao,
			Equipamento equipamento, Funcionario funcionario){
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.identificacao = identificacao;
		this.equipamento = equipamento;
		this.funcionario = funcionario;
		
	}
	
	
	
}
