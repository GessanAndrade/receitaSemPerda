package receitas.pack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroReceitaDm {

	private List<String> lista;
	private String titulo;
	
	public CadastroReceitaDm() {
		List<String> listaBase = new ArrayList<>();
		lista = listaBase;
		lista.clear();
		this.titulo = "receita";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void adicionarItem(String item, String tipo) {
		   
		  if (! item.trim().isEmpty()) {
			switch (tipo) {
			case "Título":
				lista.add("*"+item);
				break;
			case "Tempo":
				lista.add("$"+item);
				break;
			case "Ingrediente":
				lista.add("&"+item);
				break;
			case "Instrução":
				lista.add("#"+item);
				break;
			}
			JOptionPane.showMessageDialog(null, "Item adicionado com sucesso.");
		}
		
	}
	
	public void gravarReceita(){

        String arquivo = ".\\receitas\\"+this.titulo+".txt";
        
        if (! lista.isEmpty()) {
        	//Bufferiza o arquivo para que haja inserções de informações nele.
	        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(arquivo))) {
	        	//Corre a List() e adiciona cada item dela.
	            for (String linha : lista) {
	            	//Adiciona a linha no arquivo
	                buffer.write(linha);
	                //Pula uma linha, para que a próxima inserção seja na linha de baixo
	                buffer.newLine();
	            }
	            JOptionPane.showMessageDialog(null, "Receita gravada com sucesso!");
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Erro ao gravar a receita: " + e.getMessage());
	        }
        }

	}
}
