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

import logica.LeitorArquivos;

public class MenuInicial {
	private JPanel menuInicial;
	private AcoesDeTela execucaoPrograma;
	
	public MenuInicial(AcoesDeTela tela){
		this.execucaoPrograma = tela;
		gerarMenuInicial();
		gerarBotaoIniciar();
		gerarBotaoSair();
		gerarBotaoSobre();
		gerarLogotipo();
		gerarNomePrograma();
	}
	
	private void gerarMenuInicial(){
		menuInicial = new JPanel();
		menuInicial.setLayout(null);
	}
	
	private void gerarBotaoIniciar(){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton iniciar = new JButton();
		iniciar.setForeground(Color.BLUE);
		iniciar.setText("Iniciar");
		iniciar.setToolTipText("Para Iniciar, Clique aqui");
		iniciar.setFont(font);
		iniciar.setBounds(350, 225, 150, 50);
		iniciar.requestFocus();
		iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.botaoIniciar();
				
			}
		});
		menuInicial.add(iniciar);
	}
	
	private void gerarBotaoSair(){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton sair = new JButton();
		sair.setForeground(Color.BLACK);
		sair.setText("Sair");
		sair.setToolTipText("Para Fechar o programa, Clique aqui");
		sair.setFont(font);
		sair.setBounds(350, 325, 150, 50);
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.botaoSair();
				
			}
		});
		menuInicial.add(sair);
	}
	
	private void gerarBotaoSobre(){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton sobre = new JButton();
		sobre.setForeground(Color.RED);
		sobre.setText("Sobre");
		sobre.setToolTipText("Para Mais Informa��es, Clique aqui!");
		sobre.setFont(font);
		sobre.setBounds(350, 425, 150, 50);
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LeitorArquivos arq = new LeitorArquivos();
				arq.lerArquivoDeConfig("/sobre.txt");
				ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
				image.setImage(image.getImage().getScaledInstance(100, 120, 100));
				JOptionPane.showMessageDialog(menuInicial, arq.lerArquivoDeConfig("/sobre.txt"), "Sobre", 0, image);
				
			}
		});
		menuInicial.add(sobre);
	}
	
	private void gerarLogotipo(){
		ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		image.setImage(image.getImage().getScaledInstance(150, 150, 100));
		JLabel logotipo = new JLabel(image);
		logotipo.setBounds(20, 10, 150, 150);
		menuInicial.add(logotipo);
	}
	
	private void gerarNomePrograma(){
		JLabel nomePrograma = new JLabel("<html>Chave de Identificação<br> <center>de Espécies</center></html>");
		Font font = new Font(Font.DIALOG, Font.BOLD, 28);
		nomePrograma.setFont(font);
		nomePrograma.setBounds(270, 50, 400, 100);
		menuInicial.add(nomePrograma);
	}
	
	public JPanel getMenuInicial(){
		return menuInicial;
	}

}
