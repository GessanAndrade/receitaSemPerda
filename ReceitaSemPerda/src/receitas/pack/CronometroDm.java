package receitas.pack;

import java.awt.Color;

import javax.swing.JLabel;

public class CronometroDm {
    private int tempo;
    private boolean rodando;

    public CronometroDm(){
       this.tempo = 0;
       this.rodando = false;
    }
    
    public int getTempo() {
		return tempo;
	}

	public boolean isRodando() {
		return rodando;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public void play() {
        rodando = true;
    }

    public void pause() {
        rodando = false;
    }

    public String zerar() {
        this.tempo = 0;
        rodando = false;
        return "00:00:00";
    }
    
    public void atualizarTempo(JLabel lblTempo, String linha) {
    	//Criação do objeto que da Thread. Runnable cria um metodo abstrato run, que você vai implmentar abaixo, ele é o coração de execução da thread.
    	Thread thread = new Thread(new Runnable() {
    		//Run() é o método principal da thread, nele em que as coisas acontecem.
            public void run() {
            	while (true) {
                	if (isRodando()) {
                		tempo++;
                        String tempoStr = String.format("%02d:%02d:%02d", (tempo / 3600), (tempo % 3600) / 60, tempo % 60);
                        lblTempo.setText(tempoStr);
                        
                        if (((tempo % 3600) / 60) == Integer.parseInt(linha)) {
                        	//Muda a cor do label de tempo lá da tela do cronometro.
                        	lblTempo.setForeground(new Color(0, 255, 0));
                        	pause();
                        }
                    }
                    try {
                    	//1s de pausa da thread a cada ciclo.
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }      
}
