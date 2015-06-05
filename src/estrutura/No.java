package estrutura;

import interfaces.Conteudo;

/**
 * Classe N�, Estrutura basica para arvore de classifica��o de Especies
 * @autor Francisco Gon�alves da Mota Longhini
 * @author Gabriel Sousa Kraszczuk*/
public class No {
	
	private Conteudo conteudo = null;
	private String noEsquerdo = null;
	private String noDireito = null;
	
	public No(Conteudo conteudo, String noEsquerdo, String noDireito){
		this.conteudo = conteudo;
		this.noEsquerdo = noEsquerdo;
		this.noDireito = noDireito;
	}
	
	public String getNoEsquerdo(){
		return noEsquerdo;
	}
	
	public String getNoDireito(){
		return noDireito;
	}
	
	public Conteudo getConteudo(){
		return conteudo;
	}

}
