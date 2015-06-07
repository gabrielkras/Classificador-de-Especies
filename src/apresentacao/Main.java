package apresentacao;

import java.io.FileNotFoundException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.ConteudoNo;
import logica.ExecucaoPrograma;
import logica.LeitorArquivos;
import interfaces.Conteudo;
import estrutura.Arvore;
import estrutura.Hash;
import estrutura.No;

/**
 * Programa Principal - Respons�vel por alimentar a arvore com as informa��es e 
 * executar o programa
 * @author Francisco Gon�alves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class Main {

	public static void main(String args[]) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (InstantiationException e) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (IllegalAccessException e) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		ExecucaoPrograma programa = new ExecucaoPrograma();
		programa.iniciarPrograma();
		
	}
}
