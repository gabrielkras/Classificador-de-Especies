package apresentacao;

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
	
	public ImageIcon obterImagem(String caminho) throws IOException{
		return new ImageIcon(caminho);
	}

}
