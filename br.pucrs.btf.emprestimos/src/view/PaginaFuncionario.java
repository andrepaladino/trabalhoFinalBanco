package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.Gerenciador;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class PaginaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JPasswordField passwordField;
	private JTextField textFieldEndereco;
	private JTextField textFieldUF;
	private JTextField textFieldCidade;
	private JFormattedTextField formattedTextFieldNasc;
	private JFormattedTextField formattedTextFieldAdm;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private Gerenciador gerenciador;
	private JFormattedTextField formattedTextFieldSalario;
	private JTextField textField;
	private DateTimeFormatter formatDatas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaFuncionario frame = new PaginaFuncionario();
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
	public PaginaFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		gerenciador = new Gerenciador();

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(359))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel lblCadastroFuncionrio = new JLabel("Cadastro Funcion\u00E1rio");
		lblCadastroFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula:");

		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);

		rdbtnMasculino = new JRadioButton("Masculino");

		rdbtnMasculino.setSelected(true);

		rdbtnFeminino = new JRadioButton("Feminino");

		ButtonGroup bt = new ButtonGroup();
		bt.add(rdbtnFeminino);
		bt.add(rdbtnMasculino);

		JLabel lblSenha = new JLabel("Senha:");

		passwordField = new JPasswordField();

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");

		JLabel lblDataDeAdmisso = new JLabel("Data de Admiss\u00E3o:");

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");

		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);

		JLabel lblUF = new JLabel("UF:");

		textFieldUF = new JTextField();
		textFieldUF.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");

		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCadastrar_actionPerformed(arg0);
			}
		});

		try {
			formattedTextFieldNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			formattedTextFieldAdm = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblSalario = new JLabel("Sal\u00E1rio:");

		DecimalFormat formatoSalario = new DecimalFormat("###,###,###.00");
		NumberFormatter formatador = new NumberFormatter(formatoSalario);
		formatador.setFormat(formatoSalario);
		formatador.setAllowsInvalid(false);

		formattedTextFieldSalario = new JFormattedTextField();
		formattedTextFieldSalario.setFormatterFactory(new DefaultFormatterFactory(formatador));

		JLabel lblNmero = new JLabel("N\u00FAmero:");

		JLabel lblNmero_1 = new JLabel("N\u00FAmero:");

		textField = new JTextField();
		textField.setColumns(10);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblCadastroFuncionrio)
							.addComponent(lblNome)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
							.addComponent(lblMatricula)
							.addComponent(textFieldMatricula, 301, 301, 301))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rdbtnMasculino)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnFeminino))
						.addComponent(lblSenha)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo))
							.addGap(70)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUF)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(textFieldUF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataDeNascimento)
								.addComponent(formattedTextFieldNasc, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataDeAdmisso)
								.addComponent(formattedTextFieldAdm, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textFieldCidade, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNmero_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(469))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCidade)
					.addPreferredGap(ComponentPlacement.RELATED, 621, Short.MAX_VALUE)
					.addComponent(lblNmero)
					.addGap(71))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnCadastrar)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblSalario)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(formattedTextFieldSalario, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCadastroFuncionrio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMatricula)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnMasculino)
						.addComponent(rdbtnFeminino))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeNascimento)
						.addComponent(lblDataDeAdmisso))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(formattedTextFieldNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldAdm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUF)
						.addComponent(lblEndereo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(lblNmero)
						.addComponent(lblNmero_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSalario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextFieldSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(btnCadastrar))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	protected void do_btnCadastrar_actionPerformed(ActionEvent arg0) {
		
		boolean podeGuardar = true;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		Date dataAdmissao = null;
		Date nascimento = null;

		if(textFieldNome.getText().length() <= 1){
			JOptionPane.showMessageDialog(textFieldNome, "Insira um nome válido");
			podeGuardar = false;
		}
		
		if(textFieldMatricula.getText().length() < 9){
			JOptionPane.showMessageDialog(textFieldMatricula, "Insira uma matrícula válida");
			podeGuardar = false;
		}
		if(textFieldEndereco.getText().length() <= 1 || textFieldCidade.getText().length() <= 1 || textFieldUF.getText().length() < 2
				|| textFieldUF.getText().length() > 2){
			JOptionPane.showMessageDialog(null, "Insira dados corretos nos campos de endereço");
			podeGuardar = false;
		}
		try{
			dataAdmissao = sdf.parse(formattedTextFieldNasc.getText());
		}catch(ParseException e){
			JOptionPane.showMessageDialog(null, "Insira uma data de nascimento válida");
			podeGuardar = false;
		}
		try{
			nascimento = sdf.parse(formattedTextFieldAdm.getText());
		}catch(ParseException e){
			JOptionPane.showMessageDialog(null, "Insira uma data de admissão válida");
			podeGuardar = false;
		}

		String nome = textFieldNome.getText();
		@SuppressWarnings("deprecation")
		String senha = passwordField.getText();
		String sexo;

		if(rdbtnMasculino.isSelected()){
			sexo = "M";
		}else{
			sexo = "F";
		}

		String matricula = textFieldMatricula.getText();
		
		double salario = 0.0;

		try{
			if(formattedTextFieldSalario.getText().contains(".")){
				salario = Double.parseDouble((formattedTextFieldSalario.getText().replace(".", "").replace(",", ".")));
			}else{
				salario = Double.parseDouble((formattedTextFieldSalario.getText().replace(",", ".")));
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Insira um salário");
			podeGuardar = false;
		}

		String endereco = textFieldEndereco.getText() + ", " +  textField.getText() + " " + textFieldCidade.getText() + " - " + textFieldUF.getText().toUpperCase();
		
		if(podeGuardar){
			if(gerenciador.addFuncionario(nome, senha, sexo, endereco, matricula, salario, dataAdmissao, nascimento)){
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
				limpaTela();
			}else{
				JOptionPane.showConfirmDialog(null, "Verifique os campos e tente o cadastro novamente");
				limpaTela();
			}
		}
	}
	
	private void limpaTela(){
		textFieldNome.setText("");
		textFieldMatricula.setText("");
		rdbtnMasculino.setSelected(true);
		passwordField.setText("");
		formattedTextFieldAdm.setText("");
		formattedTextFieldNasc.setText("");
		textFieldEndereco.setText("");
		textFieldUF.setText("");
		textFieldCidade.setText("");
		textField.setText("");
		formattedTextFieldSalario.setText("");
	}
}
