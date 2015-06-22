package apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import interfaces.AcoesDeTela;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TelaDeClassificacao {
	
	private JPanel telaDeClassificacao;
	private AcoesDeTela execucaoPrograma;
	private List<JLabel> listaDeFigurasOpcao1 = new ArrayList<JLabel>();
	private JLabel containerImagemOpcao1;
	private JTextPane containerDescricaoOpcao1;
	private JTextPane containerDescricaoOpcao2;
	private List<JLabel> listaDeFigurasOpcao2 = new ArrayList<JLabel>();
	private JLabel containerImagemOpcao2;
	
	public TelaDeClassificacao(AcoesDeTela tela){
		this.execucaoPrograma = tela;
		gerarTelaDeClassificacao();
		gerarBotaoOpcao1();
		gerarBotaoOpcao2();
		gerarBotaoReiniciar();
		gerarBotaoSair();
		gerarContainerImagemOpcao1e2();
		gerarContainerDescricaoOpcao1e2();
		
	}
	
	private void gerarTelaDeClassificacao(){
		telaDeClassificacao = new JPanel();
		telaDeClassificacao.setLayout(null);
	}
	
	private void gerarContainerImagemOpcao1e2(){
		containerImagemOpcao1 = new JLabel();
		containerImagemOpcao1.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		containerImagemOpcao1.setBounds(25,25,256,256);
		containerImagemOpcao2 = new JLabel();
		containerImagemOpcao2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		containerImagemOpcao2.setBounds(515,25,256,256);
		telaDeClassificacao.add(containerImagemOpcao1);
		telaDeClassificacao.add(containerImagemOpcao2);
	}
	
	private void gerarContainerDescricaoOpcao1e2(){
		Font font = new Font("SansSerif",Font.BOLD,15);
		SimpleAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setAlignment(sa, StyleConstants.ALIGN_JUSTIFIED);
		containerDescricaoOpcao1 = new JTextPane();
		containerDescricaoOpcao1.getStyledDocument().setParagraphAttributes(0, 290, sa, false);
		containerDescricaoOpcao1.setEditable(false);
		containerDescricaoOpcao1.setFont(font);
		containerDescricaoOpcao1.setOpaque(false);
		containerDescricaoOpcao1.setCaretPosition(0);
		containerDescricaoOpcao2 = new JTextPane();
		containerDescricaoOpcao2.getStyledDocument().setParagraphAttributes(0, 290, sa, false);
		containerDescricaoOpcao2.setEditable(false);
		containerDescricaoOpcao2.setFont(font);
		containerDescricaoOpcao2.setOpaque(false);
		containerDescricaoOpcao2.setCaretPosition(0);
		JScrollPane containerScrollOpcao1 = new JScrollPane(containerDescricaoOpcao1);
		JScrollPane containerScrollOpcao2 = new JScrollPane(containerDescricaoOpcao2);
		containerScrollOpcao1.setBounds(25,325,256,150);
		containerScrollOpcao2.setBounds(515,325,256,150);
		//containerScrollOpcao1.setVisible(true);
		telaDeClassificacao.add(containerScrollOpcao1);
		//telaDeClassificacao.add(containerDescricaoOpcao1);
		telaDeClassificacao.add(containerScrollOpcao2);
	}
	
	private void gerarBotaoOpcao1(){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton opcao1 = new JButton();
		opcao1.setForeground(Color.BLUE);
		opcao1.requestFocus();
		opcao1.setText("OPÇÃO A");
		opcao1.setToolTipText("Clique aqui para executar a OPÇÃO A");
		opcao1.setFont(font);
		opcao1.setBounds(70, 500, 150, 50);
		opcao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.executarOpcao1();
				
			}
		});
		telaDeClassificacao.add(opcao1);
	}
	
	private void gerarBotaoOpcao2(){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton opcao2 = new JButton();
		opcao2.setForeground(Color.BLUE);
		opcao2.setText("OPÇÃO B");
		opcao2.setToolTipText("Clique aqui para executar a OPÇÃO B");
		opcao2.setFont(font);
		opcao2.setBounds(570, 500, 150, 50);
		opcao2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.executarOpcao2();
				
			}
		});
		telaDeClassificacao.add(opcao2);
	}
	
	private void gerarBotaoManipulacaoImagem(String nomeBotao,
			String textoDicaDoBotao, int posicaoX, int posicaoY){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton imagem = new JButton();
		imagem.setForeground(Color.BLUE);
		imagem.setText(nomeBotao);
		imagem.setToolTipText(textoDicaDoBotao);
		imagem.setFont(font);
		imagem.setBounds(posicaoX, posicaoY, 150, 50);
		imagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.executarOpcao2();
				
			}
		});
		telaDeClassificacao.add(imagem);
	}
	
	
	private void gerarBotaoSair(){
		Font font = new Font("SansSerif", Font.BOLD, 15);
		JButton sair = new JButton();
		sair.setForeground(Color.RED);
		sair.setText("SAIR");
		sair.setToolTipText("<html>Se você clicar aqui <br> o programa será <font color='red'> <b> ENCERRADO </b> </font></html>");
		sair.setFont(font);
		sair.setBounds(325, 100, 150, 50);
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.botaoSair();
				
			}
		});
		telaDeClassificacao.add(sair);
	}
	
	private void gerarBotaoReiniciar(){
		Font font = new Font("SansSerif", Font.BOLD, 15);
		JButton reiniciar = new JButton();
		reiniciar.setForeground(Color.BLACK);
		reiniciar.setText("<html> <center>REINICIAR<br>CLASSIFICAÇÃO<center></html>");
		reiniciar.setToolTipText("Clique aqui para reiniciar a classificação");
		reiniciar.setFont(font);
		reiniciar.setBounds(325, 25, 150, 50);
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execucaoPrograma.reiniciarClassificacao();
				
			}
		});
		telaDeClassificacao.add(reiniciar);
	}
	
	public void setDescricaoOpcao1(String descricao){
		containerDescricaoOpcao1.setText(descricao);
		containerDescricaoOpcao1.setCaretPosition(0);
	}
	public void setDescricaoOpcao2(String descricao){
		containerDescricaoOpcao2.setText(descricao);
		containerDescricaoOpcao2.setCaretPosition(0);
	}
	public void setImagemOpcao1(ImageIcon image){
		image.setImage(image.getImage().getScaledInstance(256, 256, 100));
		containerImagemOpcao1.setIcon(image);
		telaDeClassificacao.updateUI();
	}
	public void setImagemOpcao2(ImageIcon image){
		image.setImage(image.getImage().getScaledInstance(256, 256, 100));
		containerImagemOpcao2.setIcon(image);
		telaDeClassificacao.updateUI();
	}
	
	public JPanel getTelaDeClassificacao(){
		return telaDeClassificacao;
	}

}
