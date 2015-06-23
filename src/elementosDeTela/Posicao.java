package elementosDeTela;

public class Posicao {
	private int posicaoEixoX;
	private int posicaoEixoY;
	
	public Posicao(int x, int y){
		this.posicaoEixoX = x;
		this.posicaoEixoY = y;
	}
	
	public void setX(int x){
		this.posicaoEixoX = x;
	}
	
	public void setY(int y){
		this.posicaoEixoY = y;
	}
	
	public int getX(){
		return posicaoEixoX;
	}
	
	public int getY(){
		return posicaoEixoY;
	}

}
