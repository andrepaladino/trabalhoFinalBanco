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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaEquipamento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDesc;
	private JTextField textFieldID;
	private JFormattedTextField formattedTextFieldData;
	private JLabel lblEmManuteno;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnExterno;
	private JRadioButton rdbtnMvel;
	private JRadioButton rdbtnFixo;
	private JFormattedTextField formattedTextFieldCusto;
	private JRadioButton rdbtnSim;
	private Gerenciador gerenciador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaEquipamento frame = new PaginaEquipamento();
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
	public PaginaEquipamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Cadastro Equipamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		
		JLabel lblIdentificao = new JLabel("Identifica\u00E7\u00E3o:");
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		
		JLabel lblDataDeAquisio = new JLabel("Data de Aquisi\u00E7\u00E3o:");
		
		try{
			formattedTextFieldData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		
		lblEmManuteno = new JLabel("Em Manuten\u00E7\u00E3o:");
		
		rdbtnSim = new JRadioButton("Sim");
		
		rdbtnNo = new JRadioButton("N\u00E3o");
		
		ButtonGroup bt = new ButtonGroup();
		bt.add(rdbtnSim);
		bt.add(rdbtnNo);
		JLabel lblTipo = new JLabel("Tipo:");
		
		rdbtnExterno = new JRadioButton("Externo");
		
		rdbtnMvel = new JRadioButton("M\u00F3vel");
		
		rdbtnFixo = new JRadioButton("Fixo");
		
		ButtonGroup bt2 = new ButtonGroup();
		bt2.add(rdbtnExterno);
		bt2.add(rdbtnMvel);
		bt2.add(rdbtnFixo);
		
		JLabel lblCustoDirio = new JLabel("Custo Di\u00E1rio:");
		
		DecimalFormat formatoCusto = new DecimalFormat("###,###,###.00");
		NumberFormatter formatador = new NumberFormatter(formatoCusto);
		formatador.setFormat(formatoCusto);
		formatador.setAllowsInvalid(false);
		
		formattedTextFieldCusto = new JFormattedTextField();
		formattedTextFieldCusto.setFormatterFactory(new DefaultFormatterFactory(formatador));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCadastrar_actionPerformed(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblDescrio)
						.addComponent(textFieldDesc, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
						.addComponent(lblIdentificao)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataDeAquisio)
						.addComponent(formattedTextFieldData, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEmManuteno)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnSim)
							.addGap(18)
							.addComponent(rdbtnNo))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTipo)
							.addGap(18)
							.addComponent(rdbtnExterno)
							.addGap(18)
							.addComponent(rdbtnMvel)
							.addGap(18)
							.addComponent(rdbtnFixo))
						.addComponent(lblCustoDirio)
						.addComponent(formattedTextFieldCusto, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescrio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIdentificao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataDeAquisio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmManuteno)
						.addComponent(rdbtnSim)
						.addComponent(rdbtnNo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(rdbtnExterno)
						.addComponent(rdbtnMvel)
						.addComponent(rdbtnFixo))
					.addGap(18)
					.addComponent(lblCustoDirio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextFieldCusto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	protected void do_btnCadastrar_actionPerformed(ActionEvent arg0) {
		boolean podeGuardar = true;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		Date data = null;
		
		String desc = textFieldDesc.getText();
		int ID = Integer.parseInt(textFieldID.getText());

		if(desc.length() <= 1){
			JOptionPane.showMessageDialog(null, "Insira uma descrição");
			podeGuardar = false;
		}
		
		if(textFieldID.getText().length() < 9){
			JOptionPane.showMessageDialog(null, "Insira uma matrícula válida");
			podeGuardar = false;
		}
		
		try{
			data = sdf.parse(formattedTextFieldData.getText());
		}catch(ParseException e){
			JOptionPane.showMessageDialog(null, "Insira uma data de aquisição válida");
			podeGuardar = false;
		}
		
		String emManutencao;
		if(rdbtnSim.isSelected()){
			emManutencao = "S";
		}else{
			emManutencao = "N";
		}
		String tipo;
		if(rdbtnExterno.isSelected()){
			tipo = "E";
		}else if(rdbtnFixo.isSelected()){
			tipo = "F";
		}else{
			tipo = "M";
		}
		
		double custoDiario = 0.0;
		
		try{
			if(formattedTextFieldCusto.getText().contains(".")){
				custoDiario = Double.parseDouble((formattedTextFieldCusto.getText().replace(".", "").replace(",", ".")));
			}else{
				custoDiario = Double.parseDouble((formattedTextFieldCusto.getText().replace(",", ".")));
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Insira um custo diário");
			podeGuardar = false;
		}
		
		if(podeGuardar){
			if(gerenciador.addEquipamento(ID, data, desc, custoDiario, emManutencao, tipo)){
				JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso!");
				limpaTela();
			}else{
				JOptionPane.showConfirmDialog(null, "Verifique os campos e tente o cadastro novamente");
				limpaTela();
			}
		}
	}

	private void limpaTela() {
		textFieldDesc.setText("");
		textFieldID.setText("");
		rdbtnNo.setSelected(true);
		rdbtnExterno.setSelected(true);
		formattedTextFieldCusto.setText("");
		formattedTextFieldCusto.setText("");
	}
}
