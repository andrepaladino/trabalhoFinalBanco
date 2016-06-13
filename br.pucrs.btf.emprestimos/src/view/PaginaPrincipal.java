package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Gerenciador;
import model.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PaginaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Gerenciador gerenciador;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField_1;
	private JTable table_1;
	private DefaultTableModel model2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					PaginaPrincipal frame = new PaginaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaginaPrincipal() {
		gerenciador = new Gerenciador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Funcionários", null, panel_1, null);
		
		JButton btnCadastro = new JButton("Cadastrar");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBuscar_actionPerformed(arg0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
							.addComponent(btnCadastro)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar))
						.addComponent(btnCadastro))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		
		table = new JTable();
		
		Object[] colunas = {"Nome", "Matricula", "Sexo", "Admissao", "Nascimento", "Endereco", "Salario"};
		model = new DefaultTableModel(colunas, 0);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		for (Funcionario f : gerenciador.getFuncionarios("")) {
			Object[] linha = {f.getNome(), f.getMatricula(), f.getSexo(), 
					f.getDataAdmissao(), f.getNascimento(), f.getEndereco(), f.getSalario()};
			
			model.addRow(linha);
		}
		
		
		
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Equipamentos", null, panel_2, null);
		
		JButton btnCadastro2 = new JButton("Cadastro");
		btnCadastro2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNewButton_actionPerformed(arg0);
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBuscar_1_actionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar_1)
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addComponent(btnCadastro2)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastro2)
						.addComponent(btnBuscar_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		Object[] colunas2 = {"Identificacao", "Descricao", "Aquisicao", "Custo D", "Manutencao", "Tipo"};
		model2 = new DefaultTableModel(colunas2, 0);
		table_1 = new JTable(model2);
		scrollPane_1.setViewportView(table_1);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("");
		tabbedPane.addTab("Emprestimos", null, panel_3, null);
		
		JButton btnCadastro_1 = new JButton("Cadastro");
		btnCadastro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCadastro_1_actionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(631, Short.MAX_VALUE)
					.addComponent(btnCadastro_1)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCadastro_1)
					.addContainerGap(360, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCadastro_actionPerformed(arg0);
			}
		});
		panel.setLayout(gl_panel);
	}

	protected void do_btnCadastro_actionPerformed(ActionEvent arg0) {
		PaginaFuncionario p = new PaginaFuncionario();
		p.setVisible(true);
		p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		PaginaEquipamento p = new PaginaEquipamento();
		p.setVisible(true);
		p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		Object[] colunas = {"Nome", "Matricula", "Sexo", "Admissao", "Nascimento", "Endereco", "Salario"};
		model = new DefaultTableModel(colunas, 0);
		table.setModel(model);
		
		
		List<Funcionario> funcs = gerenciador.getFuncionarios(textField.getText());
		if(funcs.isEmpty()){
			JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado.");
		}else
		for (Funcionario f : funcs) {
			Object[] linha = {f.getNome(), f.getMatricula(), f.getSexo(), 
					f.getDataAdmissao(), f.getNascimento(), f.getEndereco(), f.getSalario()};
			
			model.addRow(linha);
		}
	}
	protected void do_btnBuscar_1_actionPerformed(ActionEvent arg0) {
		Object[] colunas2 = {"Identificacao", "Descricao", "Aquisicao", "Custo D", "Manutencao", "Tipo"};
		model2 = new DefaultTableModel(colunas2, 0);
		table.setModel(model2);
	}
	protected void do_btnCadastro_1_actionPerformed(ActionEvent arg0) {
		PaginaEmprestimo p = new PaginaEmprestimo();
		p.setVisible(true);
		p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
	}
}
