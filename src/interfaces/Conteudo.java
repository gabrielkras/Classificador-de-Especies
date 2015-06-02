package interfaces;

import javax.swing.ImageIcon;

public interface Conteudo {
	
	void setImagem(ImageIcon imagem);
	void setDescricao(String descricao);
	void setNomeDaEspecie(String nomeDaEspecie);
	
	ImageIcon getImage();
	String getDescricao();
	String getNomeDaEspecie();

}
