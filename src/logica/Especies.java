package logica;

public enum Especies {
	
	MOLOSSIDEOS("classificadores/molossideos/MolossideosFinal.txt");
	
	private String caminhoEstruturaClassificacao;
	
	Especies(String caminhoEstruturaClassificacao){
		this.caminhoEstruturaClassificacao = caminhoEstruturaClassificacao;
	}
	
	String obterCaminhoEstruturaEspecie(){
		return caminhoEstruturaClassificacao;
	}

}
