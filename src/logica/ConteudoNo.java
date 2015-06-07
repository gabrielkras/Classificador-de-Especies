package logica;

import javax.swing.ImageIcon;

import interfaces.Conteudo;

public class ConteudoNo implements Conteudo {
	
	private ImageIcon imagem;
	private String descricao;
	private String nomeDaEspecie;
	
	public ConteudoNo(ImageIcon imagem, String descricao, String nomeDaEspecie) {
		this.imagem = imagem;
		this.descricao = descricao;
		this.nomeDaEspecie = nomeDaEspecie;
	}

	@Override
	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
		
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
	public ImageIcon getImage() {
		return this.imagem;
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
