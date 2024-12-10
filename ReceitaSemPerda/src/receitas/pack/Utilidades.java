package receitas.pack;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Utilidades{
	
	private Boolean aptoProximo;
	private Boolean threadRodando;

	public Utilidades() {
		this.threadRodando = true;
		this.aptoProximo = false;
	}	
	
	public Boolean getThreadRodando() {
		return threadRodando;
	}

	public void setThreadRodando(Boolean threadRodando) {
		this.threadRodando = threadRodando;
	}	
	
	public Boolean getAptoProximo() {
		return this.aptoProximo;
	}

	public void setAptoProximo(Boolean aptoProximo) {
		this.aptoProximo = aptoProximo;
	}

	private String converterTexto(String texto, char caracter) {
		return texto.replace(caracter, ' ').trim();
	}
	
	public void tratarMensagem(String linha, Utilidades utils) {
		
		switch (linha.charAt(0)) {
		case '*':
			InstrucoesPas instrucoes = new InstrucoesPas(converterTexto(linha, '*'), utils);
			instrucoes.setVisible(true);
			break;
		case '&':
			instrucoes = new InstrucoesPas(converterTexto(linha, '&'), utils);
			instrucoes.setVisible(true);
			break;
		case '#':
			instrucoes = new InstrucoesPas(converterTexto(linha, '#'), utils);
			instrucoes.setVisible(true);
			break;
		case '$':
			ConometroPas cronometro = new ConometroPas(converterTexto(linha, '$'),utils);
			cronometro.setVisible(true);
			break;
		default:
			System.out.println(linha);
		}
	}
	
	public String getReceita(JFrame frameP){
		JFileChooser fileChooser = new JFileChooser();
		int retorno = fileChooser.showOpenDialog(frameP);
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
	    File arquivo = fileChooser.getSelectedFile();	
	    return arquivo.toString();
	    }
	    else {
		  return null;
		}
	}
	
}
