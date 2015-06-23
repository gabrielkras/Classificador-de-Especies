package apresentacao;

import interfaces.AcoesDeTela;

import javax.swing.JPanel;

public class TelaDeSelecao {
	private JPanel telaDeSelecao;
	private AcoesDeTela execucaoPrograma;
	
	public TelaDeSelecao(){
		gerarTelaDeSelecao();
	}
	
	private void gerarTelaDeSelecao(){
		telaDeSelecao = new JPanel();
		telaDeSelecao.setLayout(null);
	}

}
