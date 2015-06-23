package apresentacao;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import enumeradores.Icones;

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
		ImageIcon image;
		try{
			image = new ImageIcon(ImageIO.read(new File(caminho)));
		}
		catch(Exception e){
			image = obterImagem(Icones.SEMIMAGEM);
		}
		return image;
	}

}
