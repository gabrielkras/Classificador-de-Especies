package apresentacao;

import java.io.FileNotFoundException;

import logica.ConteudoMolossideos;
import logica.ExecucaoPrograma;
import logica.LeitorArquivos;
import interfaces.Conteudo;
import estrutura.Arvore;
import estrutura.Hash;
import estrutura.No;

/**
 * Programa Principal - Responsável por alimentar a arvore com as informações e 
 * executar o programa
 * @author Francisco Gonçalves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class Main {

	public static void main(String args[]) throws FileNotFoundException{
		Arvore arvoreMolossideos = new Arvore(null, null,new ConteudoMolossideos(null,"Raiz","Raiz"));
		Arvore.inserirNoEsquerdo(arvoreMolossideos.obterNoAtual(), new ConteudoMolossideos(null, "Teste", "Teste"));
		Arvore no1 = arvoreMolossideos.obterNoAtual();
		Arvore no1esq = Arvore.obterONoEsquerdo(no1);
		Arvore no1dir = Arvore.obterONoDireito(no1);
		//System.out.println(Arvore.obterConteudoDoNoAtual(no1dir).getDescricao());
		
		Hash h = new Hash(10);
		h.armazenarObjeto(new No(new ConteudoMolossideos(null,null,null),null,null), "1");
		System.out.println(h.retornarObjeto(""));
		LeitorArquivos leitor = new LeitorArquivos();
		Hash n = new Hash(100);
		leitor.carregarArquivos("C:/Users/Gabriel S. Kraszczuk/Documents/GitHub/TrabalhoED2/classificadores/Molossideos.txt", n);
		
		ExecucaoPrograma programa = new ExecucaoPrograma();
		programa.iniciarPrograma();
		
	}
}
