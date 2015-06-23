package apresentacao;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementosDeTela.FabricaDeImagens;
import elementosDeTela.Icones;
import interfaces.AcoesDeTela;
import interfaces.SaidaPrograma;

public class TelaPrograma {
	
	private JFrame frame;
	private JPanel container;
	private AcoesDeTela execucaoDoPrograma;
	
	public TelaPrograma(AcoesDeTela execucaoDoPrograma){
		this.execucaoDoPrograma = execucaoDoPrograma;
		gerarFrame();
	}
	
	public void iniciarPrograma(){
		frame.setVisible(true);
		habilitarMenuInicial();
	}
	
	private void gerarFrame(){
		container = new JPanel();
		container.setSize(800, 600);
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		frame = new JFrame("Chave Artificial para Identificação de Espécies");
		frame.setSize(800,600);
		ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		frame.setIconImage(image.getImage());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(container);
	}
	
	public void habilitarMenuInicial(){
		container.removeAll();
		MenuInicial menu = new MenuInicial(execucaoDoPrograma);
		container.add(menu.getMenuInicial());
		container.updateUI();
	}
	
	public TelaDeClassificacao habilitarTelaDeClassificao(){
		container.removeAll();
		TelaDeClassificacao tela = new TelaDeClassificacao(execucaoDoPrograma);
		container.add(tela.getTelaDeClassificacao());
		container.updateUI();
		return tela;
	}
	
	public void habilitarTelaDeSelecao(){
		container.removeAll();
		TelaDeSelecao telaDeSelecao = new TelaDeSelecao(execucaoDoPrograma);
		container.add(telaDeSelecao.getTelaDeSelecao());
		container.updateUI();
	}
	
	public JFrame getFrame(){
		return frame;
	}



}
