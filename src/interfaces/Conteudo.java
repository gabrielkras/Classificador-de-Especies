package interfaces;

import java.util.List;

import javax.swing.ImageIcon;

public interface Conteudo {
	
	void setListaImagem(List<ImageIcon> imagem);
	void setDescricao(String descricao);
	void setNomeDaEspecie(String nomeDaEspecie);
	
	List<ImageIcon> getListaImage();
	String getDescricao();
	String getNomeDaEspecie();

}
