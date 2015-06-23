package apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.AcoesDeTela;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import logica.Classificadores;
import logica.LeitorArquivos;
import elementosDeTela.Botao;
import elementosDeTela.FabricaDeImagens;
import elementosDeTela.Icones;

public class TelaDeSelecao {
	private JPanel telaDeSelecao;
	private JRadioButton botaoRadioMolossideos;
	private JRadioButton botaoRadioOutroClassificador;
	private ButtonGroup grupoClassificadores;
	private AcoesDeTela execucaoPrograma;
	
	public TelaDeSelecao(AcoesDeTela execucaoPrograma){
		this.execucaoPrograma = execucaoPrograma;
		gerarTelaDeSelecao();
		gerarLogotipoNaTela();
		gerarTituloDaPagina();
		gerarBotaoDeSelecao();
		gerarBotao(Botao.INICIAR_CLASSIFICACAO);
	}
	
	private void gerarTelaDeSelecao(){
		telaDeSelecao = new JPanel();
		telaDeSelecao.setLayout(null);
	}
	
	private void gerarLogotipoNaTela(){
		ImageIcon logotipo = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		logotipo.setImage(logotipo.getImage().getScaledInstance(150, 150, 100));
		JLabel logotipoContainer = new JLabel();
		logotipoContainer.setIcon(logotipo);
		logotipoContainer.setBounds(25,25,150,150);
		telaDeSelecao.add(logotipoContainer);
	}
	
	private void gerarTituloDaPagina(){
		JLabel tituloDaPagina = new JLabel("<html><center>Classificadores</center></html>");
		Font font = new Font(Font.DIALOG, Font.BOLD, 28);
		tituloDaPagina.setFont(font);
		tituloDaPagina.setBounds(325, 50, 400, 100);
		telaDeSelecao.add(tituloDaPagina);
	}
	
	private void gerarBotaoDeSelecao(){
		botaoRadioMolossideos = new JRadioButton();
		grupoClassificadores = new ButtonGroup();
		Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
		botaoRadioMolossideos.setText("Molossideos");
		botaoRadioMolossideos.setFont(font);
		botaoRadioMolossideos.setForeground(Color.BLUE);
		botaoRadioMolossideos.setBounds(275,200, 300,50);
		grupoClassificadores.add(botaoRadioMolossideos);
		telaDeSelecao.add(botaoRadioMolossideos);
		botaoRadioOutroClassificador = new JRadioButton();
		botaoRadioOutroClassificador.setText("Outro Classificador");
		botaoRadioOutroClassificador.setFont(font);
		botaoRadioOutroClassificador.setForeground(Color.BLACK);
		botaoRadioOutroClassificador.setBounds(275,250, 300,50);
		grupoClassificadores.add(botaoRadioOutroClassificador);
		telaDeSelecao.add(botaoRadioOutroClassificador);
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
				case INICIAR_CLASSIFICACAO:
					if(botaoRadioMolossideos.isSelected()){
						execucaoPrograma.escolherClassificador(Classificadores.MOLOSSIDEOS);
					}
					else if(botaoRadioOutroClassificador.isSelected()){
						execucaoPrograma.escolherClassificador(null);
					}
					else{
						JOptionPane.showMessageDialog(telaDeSelecao.getParent(), new LeitorArquivos().lerArquivoDeConfig("/MSG-ERRO-02.txt")
								, "Chave Artificial para Identificação de Espécies", 2);
					}
					break;
				}
			}
		});
		telaDeSelecao.add(buttom);
	}
	
	public JPanel getTelaDeSelecao(){
		return telaDeSelecao;
	}

}
