package logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import interfaces.Conteudo;

public class ConteudoNo implements Conteudo {
	
	private List<ImageIcon> imagem;
	private String descricao;
	private String nomeDaEspecie;
	
	public ConteudoNo(List<ImageIcon> imagem, String descricao, String nomeDaEspecie) {
		this.imagem = new ArrayList<ImageIcon>(imagem);
		this.descricao = descricao;
		this.nomeDaEspecie = nomeDaEspecie;
	}

	@Override
	public void setListaImagem(List<ImageIcon> imagem) {
		this.imagem = new ArrayList<ImageIcon>(imagem);
		
	}

	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public void setNomeDaEspecie(String nomeDaEspecie) {
		this.nomeDaEspecie = nomeDaEspecie;
	}

	@Override
	public List<ImageIcon> getListaImage() {
		return new ArrayList<ImageIcon>(this.imagem);
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String getNomeDaEspecie() {
		return this.nomeDaEspecie;
	}

}
