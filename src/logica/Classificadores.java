package logica;

public enum Classificadores {
	
	MOLOSSIDEOS("classificadores/molossideos/Molossideos.txt");
	
	private String caminhoEstruturaClassificacao;
	
	Classificadores(String caminhoEstruturaClassificacao){
		this.caminhoEstruturaClassificacao = caminhoEstruturaClassificacao;
	}
	
	String obterCaminhoEstruturaEspecie(){
		return caminhoEstruturaClassificacao;
	}

}
