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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PaginaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Gerenciador gerenciador;
	private JTable table;

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
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		
		table = new JTable();
		table.setToolTipText("");
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Equipamentos", null, panel_2, null);
		
		JButton btnCadastro2 = new JButton("Cadastro");
		btnCadastro2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNewButton_actionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(314)
					.addComponent(btnCadastro2))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(btnCadastro2))
		);
		panel_2.setLayout(gl_panel_2);
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
}
