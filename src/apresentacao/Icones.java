package apresentacao;

public enum Icones {
	LOGOTIPO("/logotipo.png");
	
	private String caminhoImagem;
	
	Icones(String caminhoImagem){
		this.caminhoImagem = caminhoImagem;
	}
	
	public String getCaminhoImagem(){
		return caminhoImagem;
	}

}
