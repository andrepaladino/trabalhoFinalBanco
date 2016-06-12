package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import model.Emprestimo;
import model.Equipamento;
import model.Funcionario;

public class Gerenciador {
	private List<Funcionario> funcionarios;
	private List<Equipamento> equipamentos;

	private List<Emprestimo> emprestimos;
	private Banco banco;

	public Gerenciador() {
		banco = new Banco();
		funcionarios = new ArrayList<Funcionario>();
		equipamentos = new ArrayList<Equipamento>();
	}

	public boolean addFuncionario(String nome, String senha, String sexo, String endereco, String matricula,
			double salario, Date dataAdmissao, Date nascimento) {

		Funcionario f = new Funcionario(nome, senha, sexo, endereco, matricula, salario, dataAdmissao, nascimento);

		boolean guardou = false;

		if (banco.guardaFuncionario(f)) {
			funcionarios.add(f);
			guardou = true;
		}

		return guardou;
	}

	public boolean addEquipamento(int identificacao, Date aquisicao, String descricao, double custoDiario,
			String manutencao, String tipo) {
		boolean guardou = false;
		Equipamento e = new Equipamento(identificacao, aquisicao, descricao, custoDiario, manutencao, tipo);

		if (banco.guardaEquipamento(e)) {
			equipamentos.add(e);
			guardou = true;
		}

		return guardou;
	}

	public void addEmprestimo(LocalDate dataInicial, LocalDate dataFinal, String identificacao, Equipamento equipamento,
			Funcionario funcionario) {

		Emprestimo em = new Emprestimo(dataInicial, dataFinal, identificacao, equipamento, funcionario);

		emprestimos.add(em);
		banco.gardaEmprestimo(em);
	}

	public boolean carregaDados() {
		funcionarios = banco.getFuncionarios("");
		equipamentos = banco.getEquipamentos("");
		emprestimos = banco.getEmprestimos();
		return false;
	}

	public List<Funcionario> getFuncionarios(String nome) {
		return banco.getFuncionarios("%" + nome + "%");

	}

	public List<Equipamento> getEquipamentos(String desc) {
		if (desc.equals("")) {
			equipamentos = banco.getEquipamentos(desc);
			return equipamentos;
		}

		return Collections.emptyList();

	}

}
