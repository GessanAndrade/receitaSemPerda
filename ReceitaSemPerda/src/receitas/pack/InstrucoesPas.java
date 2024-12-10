package receitas.pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstrucoesPas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param linha 
	 * @param utils2 
	 */
	public InstrucoesPas(String linha, Utilidades utils) {
		setTitle("Instrução");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstrucao = new JLabel(linha);
		lblInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstrucao.setBounds(14, 20, 744, 286);
		contentPane.add(lblInstrucao);
			    
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utils.setAptoProximo(true);
				//Fecha janela atual
				dispose();
			}
		});
		btnProximo.setBounds(590, 316, 137, 42);
		contentPane.add(btnProximo);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPrincipal principal = new MainPrincipal();
				principal.setVisible(true);
				//Fecha a Janela atual
				dispose();
			}
		});
		btnInicio.setBounds(14, 316, 137, 42);
		contentPane.add(btnInicio);
		
		//Centraliza a janela na tela.
        setLocationRelativeTo(null);
	}

}
