package elementosDeTela;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FabricaDeImagens {
	
	public ImageIcon obterImagem(Icones imagem){
		try{
			return new ImageIcon(ImageIO.read(getClass().getResourceAsStream(imagem.getCaminhoImagem())));
		}
		catch(IOException e){
			return null;
		}
	}
	
	public ImageIcon obterImagem(String caminho){
		if(obterImagemInterna(caminho) != null){
			return obterImagemInterna(caminho);
		}
		else if(obterImagemExterna(caminho) != null){
			return obterImagemExterna(caminho);
		}
		else{
			return obterImagem(Icones.SEMIMAGEM);
		}
		
	}
	
	private ImageIcon obterImagemInterna(String caminho){
		ImageIcon image;
		try{
			image = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(caminho)));
		}
		catch(Exception e){
			image = null;
		}
		return image;
	}
	
	private ImageIcon obterImagemExterna(String caminho){
		ImageIcon image;
		try{
			image = new ImageIcon(ImageIO.read(new File(caminho)));
		}
		catch(Exception e){
			image = null;
		}
		return image;
	}

}
