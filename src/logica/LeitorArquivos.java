package logica;

import interfaces.Conteudo;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.ws.Response;

import apresentacao.FabricaDeImagens;
import apresentacao.Icones;
import estrutura.Hash;
import estrutura.No;

/**
 * Classe responsável por efetuar a leitura da estrutura armazenada em
 * arquivo.
 * @author Francisco Gonçalves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class LeitorArquivos {
	
	public void carregarArquivos(String caminhoDoArquivo, Hash ambiente) throws FileNotFoundException{
		Scanner scan = new Scanner(new FileReader(caminhoDoArquivo));
		ImageIcon image = null;
		
		scan.useDelimiter("\\||\\n");
		
		while(scan.hasNext()){
			String identificador = scan.next();
			String descricao = scan.next();
			String caminho = scan.next();
			String direcao1 = scan.next();
			String direcao2 = scan.next();
			String nomeDaEspecie = scan.next();
			image = new FabricaDeImagens().obterImagem(caminho);
			ambiente.armazenarObjeto(new No(new ConteudoNo(image,descricao,nomeDaEspecie),
					direcao1, direcao2), identificador);
			System.out.println(identificador);
			System.out.println(descricao);
			System.out.println(caminho);
			System.out.println(direcao1);
			System.out.println(direcao2);
			System.out.println(nomeDaEspecie);
			
		}
	}
	
	public String lerArquivoDeConfig(String nomeArquivo){
		String informacoes = "";
		InputStream arquivo = getClass().getResourceAsStream(nomeArquivo);
		Scanner leitor = new Scanner(arquivo);
		while(leitor.hasNext()){
			informacoes += leitor.nextLine();
		}
		System.out.println(informacoes);
		return informacoes;
	}

}
