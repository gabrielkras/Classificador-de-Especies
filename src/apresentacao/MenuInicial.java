package apresentacao;

import interfaces.AcoesDeTela;
import interfaces.SaidaPrograma;

import java.awt.Color;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import enumeradores.Botao;
import enumeradores.Icones;
import logica.LeitorArquivos;

public class MenuInicial {
	private JPanel menuInicial;
	private AcoesDeTela execucaoPrograma;
	
	public MenuInicial(AcoesDeTela tela){
		this.execucaoPrograma = tela;
		gerarMenuInicial();
		gerarBotao(Botao.INICIAR);
		gerarBotao(Botao.SAIR);
		gerarBotao(Botao.SOBRE);
		gerarLogotipo();
		gerarNomePrograma();
	}
	
	private void gerarMenuInicial(){
		menuInicial = new JPanel();
		menuInicial.setLayout(null);
	}
	
	private void gerarBotao(final Botao botao){
		int x = botao.getPosicao().getX();
		int y = botao.getPosicao().getY();
		int altura = botao.getDimensao().getAltura();
		int largura= botao.getDimensao().getLargura();
		JButton buttom = new JButton();
		buttom.setForeground(botao.getCorDoTexto());
		buttom.setText(botao.getTextoBotao());
		buttom.setToolTipText(botao.getTextoDicaDoBotao());
		buttom.setFont(botao.getFont());
		buttom.setBounds(x,y,largura,altura);
		buttom.requestFocus();
		buttom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(botao){
				case INICIAR:
					execucaoPrograma.botaoIniciar();
					break;
				case SAIR:
					execucaoPrograma.botaoSair();
					break;
				case SOBRE:
					LeitorArquivos arq = new LeitorArquivos();
					arq.lerArquivoDeConfig("/sobre.txt");
					ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
					image.setImage(image.getImage().getScaledInstance(100, 120, 100));
					JOptionPane.showMessageDialog(menuInicial, arq.lerArquivoDeConfig("/sobre.txt"), "Sobre", 0, image);
					break;
				}
				
			}
		});
		menuInicial.add(buttom);
	}
	
	private void gerarLogotipo(){
		ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		image.setImage(image.getImage().getScaledInstance(150, 150, 100));
		JLabel logotipo = new JLabel(image);
		logotipo.setBounds(20, 10, 150, 150);
		menuInicial.add(logotipo);
	}
	
	private void gerarNomePrograma(){
		JLabel nomePrograma = new JLabel("<html><center>Chave Artificial para <br> Identificação de Espécies</center></html>");
		Font font = new Font(Font.DIALOG, Font.BOLD, 28);
		nomePrograma.setFont(font);
		nomePrograma.setBounds(270, 50, 400, 100);
		menuInicial.add(nomePrograma);
	}
	
	public JPanel getMenuInicial(){
		return menuInicial;
	}

}
