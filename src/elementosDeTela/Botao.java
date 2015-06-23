package elementosDeTela;

import java.awt.Color;
import java.awt.Font;

public enum Botao {
	OPCAOA("OPÇÃO A","Clique aqui para executar a OPÇÃO A",
			new Posicao(70,500), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.BLUE),
	OPCAOB("OPÇÃO B", "Clique aqui para executar a OPÇÃO B",
			new Posicao(570,500), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.BLUE),
	PROXIMA_IMAGEM_OPCAOA(">", "Ir para a Próxima Imagem",
			new Posicao(231, 289), new Dimensao(50,30),
			new Font("SansSerif", Font.BOLD, 15),Color.BLACK),
	IMAGEM_ANTERIOR_OPCAOA("<", "Voltar para a Imagem Anterior",
			new Posicao(25, 289), new Dimensao(50,30),
			new Font("SansSerif",Font.BOLD,15),Color.BLACK),
	PROXIMA_IMAGEM_OPCAOB(">", "Ir para a Próxima Imagem",
			new Posicao(721, 289), new Dimensao(50,30),
			new Font("SansSerif", Font.BOLD, 15),Color.BLACK),
	IMAGEM_ANTERIOR_OPCAOB("<", "Voltar para a Imagem Anterior",
			new Posicao(515, 289), new Dimensao(50,30),
			new Font("SansSerif",Font.BOLD,15),Color.BLACK),
	INICIAR("Iniciar", "Para Iniciar, Clique Aqui",
			new Posicao(350,225), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.BLUE),
	INICIAR_CLASSIFICACAO("INICIAR CLASSIFICAÇÃO", "Para Iniciar, Clique Aqui",
			new Posicao(250,500), new Dimensao(300,50),
			new Font("SansSerif", Font.BOLD, 20),Color.RED),
	REINICIAR("<html><center>REINICIAR<br>CLASSIFICAÇÃO</center></html>", "Para fechar o programa, Clique Aqui",
			new Posicao(325,25), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 15), Color.BLACK),
	SAIR("Sair", "Para fechar o programa, Clique Aqui!",
			new Posicao(350,325), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.BLACK ),
	VOLTAR("Voltar", "Clique aqui para voltar ao menu inicial",
			new Posicao(325,100), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.RED ),
	SOBRE("Sobre", "Para Mais Informações, Clique Aqui!",
			new Posicao(350,425), new Dimensao(150,50),
			new Font("SansSerif", Font.BOLD, 20),Color.RED);
	
	private String textoBotao;
	private String textoDicaDoBotao;
	private Posicao posicao;
	private Dimensao dimensao;
	private Font font;
	private Color corDoTexto;
	
	Botao(String textoBotao, String textoDicaBotao, 
			Posicao posicao, Dimensao dimensao, Font font, Color corDoTexto){
		this.textoBotao = textoBotao;
		this.textoDicaDoBotao = textoDicaBotao;
		this.posicao = posicao;
		this.dimensao = dimensao;
		this.font = font;
		this.corDoTexto = corDoTexto;
	}
	
	public String getTextoBotao(){
		return textoBotao;
	}
	
	public String getTextoDicaDoBotao(){
		return textoDicaDoBotao;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	public Dimensao getDimensao(){
		return dimensao;
	}
	
	public Font getFont(){
		return font;
	}
	
	public Color getCorDoTexto(){
		return corDoTexto;
	}

}
