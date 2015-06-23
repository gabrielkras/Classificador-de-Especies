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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import logica.LeitorArquivos;
import enumeradores.Botao;
import enumeradores.Icones;

public class TelaDeClassificacao {
	
	private JPanel telaDeClassificacao;
	private AcoesDeTela execucaoPrograma;
	private List<ImageIcon> listaDeFigurasOpcao1 = new ArrayList<ImageIcon>();
	private int indiceDaFiguraAtualOpcao1 = 0;
	private JLabel containerImagemOpcao1;
	private JTextPane containerDescricaoOpcao1;
	private JTextPane containerDescricaoOpcao2;
	private List<ImageIcon> listaDeFigurasOpcao2 = new ArrayList<ImageIcon>();
	private int indiceDaFiguraAtualOpcao2 = 0;
	private JLabel containerImagemOpcao2;
	
	public TelaDeClassificacao(AcoesDeTela tela){
		this.execucaoPrograma = tela;
		gerarTelaDeClassificacao();
		gerarBotao(Botao.OPCAOA);
		gerarBotao(Botao.OPCAOB);
		gerarBotao(Botao.REINICIAR);
		gerarBotao(Botao.VOLTAR);
		gerarBotao(Botao.IMAGEM_ANTERIOR_OPCAOA);
		gerarBotao(Botao.PROXIMA_IMAGEM_OPCAOA);
		gerarBotao(Botao.IMAGEM_ANTERIOR_OPCAOB);
		gerarBotao(Botao.PROXIMA_IMAGEM_OPCAOB);
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
		telaDeClassificacao.add(containerScrollOpcao1);
		telaDeClassificacao.add(containerScrollOpcao2);
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
				case OPCAOA:
					execucaoPrograma.executarOpcao1();
					break;
				case OPCAOB:
					execucaoPrograma.executarOpcao2();
					break;
				case REINICIAR:
					execucaoPrograma.reiniciarClassificacao();
					break;
				case VOLTAR:
					execucaoPrograma.botaoVoltar();
					break;
				case PROXIMA_IMAGEM_OPCAOA:
					if(indiceDaFiguraAtualOpcao1 >= listaDeFigurasOpcao1.size()-1){
						indiceDaFiguraAtualOpcao1 = 0;
					}
					else{
						indiceDaFiguraAtualOpcao1++;
					}
					containerImagemOpcao1.setIcon(listaDeFigurasOpcao1.get(indiceDaFiguraAtualOpcao1));
					telaDeClassificacao.updateUI();
					break;
				case IMAGEM_ANTERIOR_OPCAOA:
					if(indiceDaFiguraAtualOpcao1 <= 0){
						indiceDaFiguraAtualOpcao1 = listaDeFigurasOpcao1.size()-1;
					}
					else{
						indiceDaFiguraAtualOpcao1--;
					}
					containerImagemOpcao1.setIcon(listaDeFigurasOpcao1.get(indiceDaFiguraAtualOpcao1));
					telaDeClassificacao.updateUI();
					break;
				case PROXIMA_IMAGEM_OPCAOB:
					if(indiceDaFiguraAtualOpcao2 >= listaDeFigurasOpcao2.size()-1){
						indiceDaFiguraAtualOpcao2 = 0;
					}
					else{
						indiceDaFiguraAtualOpcao2++;
					}
					containerImagemOpcao2.setIcon(listaDeFigurasOpcao2.get(indiceDaFiguraAtualOpcao2));
					telaDeClassificacao.updateUI();
					break;
				case IMAGEM_ANTERIOR_OPCAOB:
					if(indiceDaFiguraAtualOpcao2 <= 0){
						indiceDaFiguraAtualOpcao2 = listaDeFigurasOpcao2.size()-1;
					}
					else{
						indiceDaFiguraAtualOpcao2--;
					}
					containerImagemOpcao2.setIcon(listaDeFigurasOpcao2.get(indiceDaFiguraAtualOpcao2));
					telaDeClassificacao.updateUI();
					break;
					
				
				}
				
			}
		});
		telaDeClassificacao.add(buttom);
	}
	
	public void setDescricaoOpcao1(String descricao){
		containerDescricaoOpcao1.setText(descricao);
		containerDescricaoOpcao1.setCaretPosition(0);
	}
	public void setDescricaoOpcao2(String descricao){
		containerDescricaoOpcao2.setText(descricao);
		containerDescricaoOpcao2.setCaretPosition(0);
	}
	public void setImagemOpcao1(List<ImageIcon> image){
		limparListaDeFigurasOpcao1();
		for(ImageIcon elemento: image){
			elemento.setImage(elemento.getImage().getScaledInstance(256, 256, 100));
			listaDeFigurasOpcao1.add(elemento);
		}
		containerImagemOpcao1.setIcon(image.get(0));
		telaDeClassificacao.updateUI();
	}
	public void setImagemOpcao2(List<ImageIcon> image){
		limparListaDeFigurasOpcao2();
		for(ImageIcon elemento: image){
			elemento.setImage(elemento.getImage().getScaledInstance(256, 256, 100));
			listaDeFigurasOpcao2.add(elemento);
		}
		containerImagemOpcao2.setIcon(listaDeFigurasOpcao2.get(0));
		telaDeClassificacao.updateUI();
	}
	
	public JPanel getTelaDeClassificacao(){
		return telaDeClassificacao;
	}
	
	private void limparListaDeFigurasOpcao1(){
		listaDeFigurasOpcao1.clear();
		indiceDaFiguraAtualOpcao1 = 0;
	}
	
	private void limparListaDeFigurasOpcao2(){
		listaDeFigurasOpcao2.clear();
		indiceDaFiguraAtualOpcao2 = 0;
	}

}
