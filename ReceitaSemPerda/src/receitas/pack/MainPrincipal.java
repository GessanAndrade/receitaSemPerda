package receitas.pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String caminho;
	private int temDados;
	private String HOST = ".\\receitas";

	/**
	 * Launch the application.
	 * @param btnIniciar 
	 */
	private void alimentarComboboxReceitas(String diretorio, JComboBox<String> comboBox, JButton btnIniciar) {
        // Limpa o JComboBox
        comboBox.removeAllItems();
        temDados = 0;
        
        // Lê os arquivos da pasta
        File dir = new File(diretorio);
        if (dir.exists()) {
            for (File arquivo : dir.listFiles()) {
                if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                    // Adiciona o nome do arquivo ao JComboBox
                    comboBox.addItem(arquivo.getName().replace(".txt", ""));
                    temDados = 1;
                }
            }
        }
        
        if (temDados == 0) {
        	btnIniciar.setEnabled(false);
        	comboBox.setEnabled(false);
        }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPrincipal frame = new MainPrincipal();
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
	public MainPrincipal() {
		setTitle("Tela inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Utilidades utils = new Utilidades();
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getCaminho() != null) {
					//Inicia a thread principal, que vai ficar rodando durante todo o programa. 
					ThreadPrincipal thread = new ThreadPrincipal(getCaminho(), utils);		
					
					thread.start();
					//Fecha a Janela atual
					dispose();
				}
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 58));
		btnIniciar.setBounds(50, 429, 291, 79);
		contentPane.add(btnIniciar);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroReceitaPas cadastro = new CadastroReceitaPas();
				cadastro.setVisible(true);
				//Fecha a janela atual
				dispose();		
			}
		});
		
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 58));
		btnCadastro.setBounds(351, 429, 291, 79);
		contentPane.add(btnCadastro);
		
		JComboBox<String> comboBoxReceitas = new JComboBox<String>();
		comboBoxReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCaminho(HOST+"\\"+comboBoxReceitas.getSelectedItem().toString()+".txt");
			}
		});
		comboBoxReceitas.setBounds(50, 336, 592, 47);
		contentPane.add(comboBoxReceitas);
		
		alimentarComboboxReceitas(HOST, comboBoxReceitas, btnIniciar);
		
		JLabel lblNewLabel = new JLabel("RSP");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 99));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 10, 592, 316);
		contentPane.add(lblNewLabel);
		
		//Centraliza a janela na tela.
        setLocationRelativeTo(null);
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
