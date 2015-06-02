package apresentacao;

import logica.ConteudoMolossideos;
import interfaces.Conteudo;
import estrutura.Arvore;

/**
 * Programa Principal - Responsável por alimentar a arvore com as informações e 
 * executar o programa
 * @author Francisco Gonçalves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class Main {

	public static void main(String args[]){
		Arvore arvoreMolossideos = new Arvore(null, null,new ConteudoMolossideos(null,"Raiz","Raiz"));
		Arvore.inserirNoEsquerdo(arvoreMolossideos.obterNoAtual(), new ConteudoMolossideos(null, "Teste", "Teste"));
		Arvore no1 = arvoreMolossideos.obterNoAtual();
		Arvore no1esq = Arvore.obterONoEsquerdo(no1);
		Arvore no1dir = Arvore.obterONoDireito(no1);
		System.out.println(Arvore.obterConteudoDoNoAtual(no1dir).getDescricao());
		
	}
}
