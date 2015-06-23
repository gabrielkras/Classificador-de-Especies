package elementosDeTela;

public class Dimensao {
	private int altura;
	private int largura;
	
	public Dimensao(int largura, int altura){
		this.altura = altura;
		this.largura = largura;
	}
	
	public void setAltura(int altura){
		this.altura = altura;
	}
	
	public void setLargura(int largura){
		this.largura = largura;
	}
	
	public int getAltura(){
		return altura;
	}
	
	public int getLargura(){
		return largura;
	}

}
