package estrutura;

import interfaces.Conteudo;

/**
 * Estrutura de Dados - Arvore Bin�ria
 * Classe utilizada para armazenar as
 * informa��es de Chave Artificial para
 * Identifica��o de Moloss�deos Brasileiros
 * @author Francisco Gon�alves da Mota Longhini
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
	 * M�todo que permite inserir o conteudo no n� esquerdo, com base no n� atual
	 * @param Arvore noAtual, Conteudo conteudoDoNo*/
	public static void inserirNoEsquerdo(Arvore noAtual, Conteudo conteudoDoNo){
		noAtual.setNoEsquerdo(conteudoDoNo);
	}
	/**
	 * M�todo que permite inserir o conteudo no n� direito, com base no n� atual
	 * @param Arvore noAtual, Conteudo conteudoDoNo*/
	public static void inserirNoDireito(Arvore noAtual, Conteudo conteudoDoNo){
		noAtual.setNoDireito(conteudoDoNo);
	}
	/**
	 * M�todo que permite recuperar o apontamento do n� direito da Arvore
	 * @param Arvore noAtual
	 * @return Arvore*/
	public static Arvore obterONoDireito(Arvore noAtual){
		return noAtual.getNoDireito();
	}
	/**
	 * M�todo que permite recuperar o apontamento do n� esquerdo da Arvore
	 * @param Arvore noAtual
	 * @return Arvore*/
	public static Arvore obterONoEsquerdo(Arvore noAtual){
		return noAtual.getNoEsquerdo();
	}
	/**
	 * M�todo que permite recuperar o conteudo do n� atual
	 * @param Arvore noAtual
	 * @return Conteudo*/
	public static Conteudo obterConteudoDoNoAtual(Arvore noAtual){
		return noAtual.getConteudo();
	}
	/**
	 * M�todo que retorna o n� atual
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
	 * Retorna o objeto Arvore do n� direito
	 * @return Arvore*/
	private Arvore getNoDireito(){
		return noDireito;
	}
	/**
	 * Retorna o objeto Arvore do n� esquerdi
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
