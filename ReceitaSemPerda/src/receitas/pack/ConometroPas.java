package receitas.pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ConometroPas extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTempo;
    private JButton btnPlay, btnPause, btnZerar;
    private JButton btnProximo;
    private JButton btnInicio;

    //O construtor dessa classe vai receber o tempo cadastrado na receita, e o objeto da classe Utilidades criado anteriormente
    public ConometroPas(String tempo, Utilidades utils) {
    	setTitle("Cronometro");
    	setResizable(false);
    	setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        //Criar um objeto da classe que controla as ações, essa classe que estamos é só para declarar os elemetos da tela.
        CronometroDm cronometroC = new CronometroDm();

        lblTempo = new JLabel("00:00:00");
        lblTempo.setForeground(new Color(0, 0, 0));
        lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 54));
        lblTempo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTempo.setBounds(55, 105, 280, 80);
        getContentPane().add(lblTempo);

        JLabel lblMinutos = new JLabel("minuto(s)");
        lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMinutos.setBounds(192, 61, 98, 34);
        getContentPane().add(lblMinutos);
        
        JLabel lblTemp = new JLabel(tempo);
        lblTemp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTemp.setBounds(118, 61, 64, 34);
        getContentPane().add(lblTemp);        
        
        btnPlay = new JButton("Play");
        btnPlay.setBounds(55, 195, 80, 20);
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cronometroC.play();
            }
        });
        getContentPane().add(btnPlay);

        btnPause = new JButton("Pause");
        btnPause.setBounds(155, 195, 80, 20);
        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cronometroC.pause();
            }
        });
        getContentPane().add(btnPause);

        btnZerar = new JButton("Zerar");
        btnZerar.setBounds(255, 195, 80, 20);
        btnZerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblTempo.setText(cronometroC.zerar());
            	cronometroC.setTempo(0);
            }
        });
        getContentPane().add(btnZerar);
                             
        btnProximo = new JButton("Próximo");
        btnProximo.setBounds(255, 225, 80, 20);
        getContentPane().add(btnProximo);
        btnProximo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		utils.setAptoProximo(true);
				//Fecha janela atual
				dispose();
        	}
        });
        
        setSize(400, 292);
        //Centraliza a janela na tela.
        setLocationRelativeTo(null);
        setVisible(true);
        
        btnInicio = new JButton("Inicio");
        btnInicio.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				MainPrincipal principal = new MainPrincipal();
				principal.setVisible(true);
				//Fecha a Janela atual
				dispose();
        	}
        });
        btnInicio.setBounds(55, 225, 80, 20);
        
        //Executa a procedure para atualizar o tempo. Ela vai abrir uma nova thread para poder controlar o cronometro.
        cronometroC.atualizarTempo(lblTempo, tempo);
        getContentPane().add(btnInicio);
    }   
}
