package receitas.pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreadPrincipal extends Thread{
	private String caminho;
	private Utilidades utils;
	
	public ThreadPrincipal(String caminho, Utilidades utils) {
		this.caminho = caminho;
		this.utils = utils;
	}
	
	public void run() {
		 	 
		  try {
			//Cria um objeto a partir da leitura do txt da variavel caminho.  
			FileReader arquivo = new FileReader(caminho);
			
			//Esse txt é bufferizado na memória.
			try (BufferedReader bufferArquivo = new BufferedReader(arquivo)) {
				//Inicia a variável com a próxima linha.
				String linha = bufferArquivo.readLine();
				
				utils.setAptoProximo(true);
				
				while ((linha != null) && (utils.getThreadRodando())) {
			        					
					if (utils.getAptoProximo()) {
				    	utils.tratarMensagem(linha, utils);
					    linha = bufferArquivo.readLine();
					    utils.setAptoProximo(false);
					    
					    if (linha == null) {
					    	utils.setThreadRodando(false);
					    }
					    
					}
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Fecha o objeto bufferizado
				bufferArquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
