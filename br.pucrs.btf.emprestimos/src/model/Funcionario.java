package model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {
	private String matricula;
	private String nome;
	private String senha;
	private String sexo;
	private Date dataAdmissao;
	private Date nascimento;
	private String endereco;
	private double salario;
	
	public Funcionario(String nome, String senha, String sexo, String endereco, 
			String matricula, double salario, Date dataAdmissao, Date nascimento){
		//ATENÇÂO VERIFICAR OS NOTNULL NO SCRIPT SQL
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.dataAdmissao = dataAdmissao;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public String getSexo() {
		return sexo;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public Date getNascimento() {
		return nascimento;
	}
	
	

}
