package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Emprestimo;
import model.Equipamento;
import model.Funcionario;

public class Banco {

	private String srtConexao;
	private Properties connectionPorps;

	public Banco() {
		connectionPorps = new Properties();
		srtConexao = "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g";
		connectionPorps.put("user", "bf109309");
		connectionPorps.put("password", "bf109309");
	}

	public boolean guardaFuncionario(Funcionario f) {

		try {
			Connection conexao = DriverManager.getConnection(srtConexao, "bf109309","bf109309");

			String sql = "INSERT INTO TRABFUNCIONARIOS"
					+ "(matricula, nome, senha, sexo, admissao, nascimento, endereco, salario)"
					+ "VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, f.getMatricula());
			stmt.setString(2, f.getNome());
			stmt.setString(3, f.getSenha());
			stmt.setString(4, f.getSexo());
			stmt.setDate(5, (Date) f.getDataAdmissao());
			stmt.setDate(6, (Date) f.getNascimento());
			stmt.setString(6, f.getEndereco());
			stmt.setDouble(8, f.getSalario());

			stmt.execute();
			conexao.close();
		} catch (SQLException e) {
			return false;
		}

		return true;

	}

	public boolean guardaEquipamento(Equipamento e) {

		try {
			Connection conexao = DriverManager.getConnection(srtConexao, connectionPorps);

			String sql = "INSERT INTO TRABEQUIPAMENTOS"
					+ "(identificacao, aquisicao, descricao, custo_diario, em_manutencao, tipo)"
					+ "VALUES(?,?,?,?,?,?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, e.getIdentificacao());
			stmt.setDate(2, (Date) e.getAquisicao());
			stmt.setString(3, e.getDescricao());
			stmt.setDouble(4, e.getCustoDiario());
			stmt.setString(5, e.getManutencao());
			stmt.setString(6, e.getTipo());

			stmt.execute();
			conexao.close();

		} catch (SQLException ex) {
			return false;
		}
		return true;

	}

	public boolean gardaEmprestimo(Emprestimo em) {
		// TODO Auto-generated method stub

		return false;

	}

	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		System.out.println("oioi");

		try {
			Connection conexao = DriverManager.getConnection(srtConexao, "bf109309", "bf109309");

			String sql = "SELECT matricula, nome, senha, sexo, admissao, nascimento, endereco, salario"
					+ "FROM trabfuncionarios"
					+ "ORDER BY nome";
			System.out.println("Conectou");

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				String matricula = result.getString("matricula");
				String nome = result.getString("nome");
				String senha = result.getString("senha");
				String sexo = result.getString("sexo");
				Date admissao = result.getDate("admissao");
				Date nascimento = result.getDate("nascimento");
				String endereco = result.getString("endereco");
				double salario = result.getDouble("salario");

				Funcionario f = new Funcionario(nome, senha, sexo, endereco, matricula, salario, admissao, nascimento);
				funcionarios.add(f);
			}

			result.close();
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			return null;
		}
		return funcionarios;
	}

	public List<Equipamento> getEquipamentos() {
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		try {
			Connection conexao = DriverManager.getConnection(srtConexao, connectionPorps);

			String sql = "SELECT identificacao, aquisicao, descricao, custo_diario, em_manutencao, tipo"
					+ "FROM trabequipamentos";

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int identificacao = result.getInt("identificacao");
				Date aquisicao = result.getDate("aquisicao");
				String descricao = result.getString("descricao");
				double custoDiario = result.getDouble("custo_diario");
				String emManutencao = result.getString("em_manutencao");
				String tipo = result.getString("tipo");

				Equipamento equi = new Equipamento(identificacao, aquisicao, descricao, custoDiario, emManutencao,
						tipo);

				equipamentos.add(equi);
			}

			result.close();
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			return null;
		}

		return equipamentos;
	}

	public List<Emprestimo> getEmprestimos() {
		// TODO Auto-generated method stub
		return null;
	}

}
