package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaFuncionarios extends AbstractTableModel {
	private List<Funcionario> funcionarios;
	
	public TabelaFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return funcionarios.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario f = funcionarios.get(rowIndex);
		
		switch(columnIndex){
		case 0:
			return f.getNome();
		case 1:
			return f.getMatricula();
		case 2:
			return f.getSexo();
		case 3:
			return f.getDataAdmissao();
		case 4:
			return f.getNascimento();
		case 5: 
			return f.getEndereco();
		case 6:
			return f.getSalario();
		}
		return null;
	}

}
