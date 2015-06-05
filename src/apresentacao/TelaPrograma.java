package apresentacao;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.AcoesDeTela;
import interfaces.SaidaPrograma;

public class TelaPrograma implements SaidaPrograma, AcoesDeTela {
	
	private JFrame frame;
	private JPanel container;
	
	public TelaPrograma(){
		frame = new JFrame("Classificador");
		MenuInicial menu = new MenuInicial(this);
		//container = new JPanel();
		//container.setLayout(new FlowLayout(FlowLayout.LEFT,370,200));
		//container.add(menu.getMenuInicial());
		frame.setSize(800,600);
		frame.add(menu.getMenuInicial());
		ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		frame.setIconImage(image.getImage());
		//frame.add(new JLabel(new FabricaDeImagens().obterImagem(Icones.LOGOTIPO)));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void iniciarPrograma() {
		frame.setVisible(true);
		
	}

	@Override
	public void finalizarPrograma() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carregarArquivo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void botaoIniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void botaoSair() {
		Runtime.getRuntime().exit(0);
		
	}

	@Override
	public void executarOpcao1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executarOpcao2() {
		// TODO Auto-generated method stub
		
	}

}
