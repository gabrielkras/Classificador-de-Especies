package logica;

import interfaces.Conteudo;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.ws.Response;

import elementosDeTela.FabricaDeImagens;
import elementosDeTela.Icones;
import estrutura.Hash;
import estrutura.No;

public class LeitorArquivos {
	
	public void carregarArquivos(String caminhoDoArquivo, Hash ambiente) throws FileNotFoundException{
		Scanner scan = new Scanner(new FileReader(caminhoDoArquivo));
		ImageIcon image = null;
		List<ImageIcon> listaDeImagens = new ArrayList<ImageIcon>();
		
		scan.useDelimiter("\\||\\n");
		
		while(scan.hasNext()){
			String identificador = scan.next();
			String descricao = scan.next();
			String caminho = scan.next();
			String direcao1 = scan.next();
			String direcao2 = scan.next();
			String nomeDaEspecie = scan.next();
			String[] imagens = caminho.split("#");
			int quantidadeDeImagens = imagens.length;
			
			for(int k = 0; k<quantidadeDeImagens; k++){
				image = new FabricaDeImagens().obterImagem(imagens[k]);
				listaDeImagens.add(image);
				image = null;
			}
			listaDeImagens.toString();
			ambiente.armazenarObjeto(new No(new ConteudoNo(listaDeImagens,descricao,nomeDaEspecie),
					direcao1, direcao2), identificador);
			listaDeImagens.clear();
			imagens = null;
		}
	}
	
	public String lerArquivoDeConfig(String nomeArquivo){
		String informacoes = "";
		InputStream arquivo = getClass().getResourceAsStream(nomeArquivo);
		Scanner leitor = new Scanner(arquivo);
		while(leitor.hasNext()){
			informacoes += leitor.nextLine();
		}
		return informacoes;
	}

}
