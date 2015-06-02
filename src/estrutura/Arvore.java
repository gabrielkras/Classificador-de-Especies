package estrutura;

import interfaces.Conteudo;

/**
 * Estrutura de Dados - Arvore Binária
 * Classe utilizada para armazenar as
 * informações de Chave Artificial para
 * Identificação de Molossídeos Brasileiros
 * @author Francisco Gonçalves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class Arvore {
	
	private Conteudo conteudoDoNo = null;
	private Arvore noAtual = null;
	private Arvore noEsquerdo = null;
	private Arvore noDireito = null;
	
	public Arvore(Arvore noEsquerdo, Arvore noDireito, Conteudo conteudoDoNo){
		this.noEsquerdo = noEsquerdo;
		this.noDireito = noDireito;
		this.noAtual = this;
		this.conteudoDoNo = conteudoDoNo;
	}
	/**
	 * Método que permite inserir o conteudo no nó esquerdo, com base no nó atual
	 * @param Arvore noAtual, Conteudo conteudoDoNo*/
	public static void inserirNoEsquerdo(Arvore noAtual, Conteudo conteudoDoNo){
		noAtual.setNoEsquerdo(conteudoDoNo);
	}
	/**
	 * Método que permite inserir o conteudo no nó direito, com base no nó atual
	 * @param Arvore noAtual, Conteudo conteudoDoNo*/
	public static void inserirNoDireito(Arvore noAtual, Conteudo conteudoDoNo){
		noAtual.setNoDireito(conteudoDoNo);
	}
	/**
	 * Método que permite recuperar o apontamento do nó direito da Arvore
	 * @param Arvore noAtual
	 * @return Arvore*/
	public static Arvore obterONoDireito(Arvore noAtual){
		return noAtual.getNoDireito();
	}
	/**
	 * Método que permite recuperar o apontamento do nó esquerdo da Arvore
	 * @param Arvore noAtual
	 * @return Arvore*/
	public static Arvore obterONoEsquerdo(Arvore noAtual){
		return noAtual.getNoEsquerdo();
	}
	/**
	 * Método que permite recuperar o conteudo do nó atual
	 * @param Arvore noAtual
	 * @return Conteudo*/
	public static Conteudo obterConteudoDoNoAtual(Arvore noAtual){
		return noAtual.getConteudo();
	}
	/**
	 * Método que retorna o nó atual
	 * @return Arvore*/
	public Arvore obterNoAtual(){
		return noAtual;
	}
	/**
	 * Retorna o conteudo do no atual
	 * @return Conteudo*/
	private Conteudo getConteudo(){
		return conteudoDoNo;
	}
	/**
	 * Retorna o objeto Arvore do nó direito
	 * @return Arvore*/
	private Arvore getNoDireito(){
		return noDireito;
	}
	/**
	 * Retorna o objeto Arvore do nó esquerdi
	 * @return Arvore*/
	private Arvore getNoEsquerdo(){
		return noEsquerdo;
	}
	/**
	 * Define os valores para o campo de Conteudo do no esquerdo
	 * @param Conteudo conteudoDoNo*/
	private void setNoEsquerdo(Conteudo conteudoDoNo){
		this.noEsquerdo = new Arvore(null,null,conteudoDoNo);
	}
	/**
	 * Define os valores para o campo de Conteudo do no direito
	 * @param Conteudo conteudoDoNo*/
	private void setNoDireito(Conteudo conteudoDoNo){
		this.noDireito = new Arvore(null, null, conteudoDoNo);
	}

}
