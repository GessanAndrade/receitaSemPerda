package receitas.pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroReceitaPas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtTempo;
	private JTextField edtInformacao;

	/**
	 * Create the frame.
	 */
	public CadastroReceitaPas() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(10, 10, 45, 19);
		contentPane.add(lblTipo);
		
		JLabel lblInformao = new JLabel("Informação:");
		lblInformao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformao.setBounds(10, 43, 93, 26);
		contentPane.add(lblInformao);
		
		CadastroReceitaDm cadastro = new CadastroReceitaDm();
		
		edtTempo = new JTextField();
		edtTempo.setVisible(false);
		edtTempo.setBounds(98, 49, 54, 19);
		contentPane.add(edtTempo);
		edtTempo.setColumns(10);
		
		JLabel lblTempos = new JLabel("minuto(s)");
		lblTempos.setVisible(false);
		lblTempos.setBounds(162, 52, 67, 13);
		contentPane.add(lblTempos);
		
		edtInformacao = new JTextField();
		edtInformacao.setBounds(10, 79, 473, 19);
		contentPane.add(edtInformacao);
		edtInformacao.setColumns(10);
				
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox.getSelectedItem().toString()) {
				case "Título":
					edtTempo.setVisible(false);
					lblTempos.setVisible(false);
					edtInformacao.setVisible(true);
					break;
				case "Instrução":
					edtTempo.setVisible(false);
					lblTempos.setVisible(false);
					edtInformacao.setVisible(true);
					break;
				case "Ingrediente":
					edtTempo.setVisible(false);
					lblTempos.setVisible(false);
					edtInformacao.setVisible(true);
					break;
				case "Tempo":
					edtTempo.setVisible(true);
					lblTempos.setVisible(true);
					edtInformacao.setVisible(false);
					break;
				default:
				  System.out.println("Seleção inválida.");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Título", "Ingrediente", "Instrução", "Tempo"}));
		comboBox.setBounds(51, 11, 101, 21);
		contentPane.add(comboBox);	
		
		JButton bntInserir = new JButton("Inserir Item");
		bntInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem().toString() == "Título") {
					cadastro.setTitulo(edtInformacao.getText());
				}
				
				if (edtInformacao.isVisible()) { 
				cadastro.adicionarItem(edtInformacao.getText() , comboBox.getSelectedItem().toString());
					edtInformacao.setText("");
				}
				
				if (edtTempo.isVisible()) { 
					cadastro.adicionarItem(edtTempo.getText() , comboBox.getSelectedItem().toString());
					edtTempo.setText("");
				}
			}
		});
		bntInserir.setBounds(243, 108, 101, 21);
		contentPane.add(bntInserir);
		
		JButton btnGravarReceita = new JButton("Gravar Receita");
		btnGravarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro.gravarReceita();
			}
		});
		btnGravarReceita.setBounds(354, 108, 129, 21);
		contentPane.add(btnGravarReceita);
		
		JButton bntReceita = new JButton("Inicio");
		bntReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPrincipal principal = new MainPrincipal();
				principal.setVisible(true);
				//Fecha a Janela atual
				dispose();
			}
		});
		bntReceita.setBounds(10, 108, 93, 21);
		contentPane.add(bntReceita);

		//Centraliza a janela na tela.
        setLocationRelativeTo(null);
	}
}
