package logica;

import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import apresentacao.FabricaDeImagens;
import apresentacao.Icones;
import apresentacao.TelaDeClassificacao;
import apresentacao.TelaPrograma;
import estrutura.Hash;
import estrutura.No;
import interfaces.AcoesDeTela;
import interfaces.SaidaPrograma;

public class ExecucaoPrograma implements AcoesDeTela, SaidaPrograma{
	
	private TelaPrograma telaDoPrograma;
	private TelaDeClassificacao telaDeClassificacao;
	private FabricaDeImagens fabrica = new FabricaDeImagens();
	private LeitorArquivos estruturaArquivos;
	private Hash elementosDaEstrutura;
	private No opcaoA;
	private No opcaoB;
	
	public ExecucaoPrograma(){
		telaDoPrograma = new TelaPrograma(this);
		estruturaArquivos = new LeitorArquivos();
		elementosDaEstrutura = new Hash(1000);
	}
	
	public void iniciarPrograma(){
		telaDoPrograma.iniciarPrograma();
	}

	@Override
	public void botaoIniciar() {
		carregarArquivo();
		
	}

	@Override
	public void botaoSair() {
		Runtime.getRuntime().exit(0);
		
	}

	@Override
	public void executarOpcao1() {
		try{
			if((elementosDaEstrutura.retornarObjeto(opcaoA.getNoEsquerdo()) == null)
					&& (elementosDaEstrutura.retornarObjeto(opcaoA.getNoDireito()) == null)){
					JOptionPane.showMessageDialog(telaDoPrograma.getFrame(), estruturaArquivos.lerArquivoDeConfig("/MSG-CLASSIFICACAO-ESPECIE.txt")
							+opcaoA.getConteudo().getNomeDaEspecie()+"</i></b></font></html>", "Classificador de Espécie", 3);
			}
			else{
				opcaoB = (No) elementosDaEstrutura.retornarObjeto(opcaoA.getNoDireito());
				opcaoA = (No) elementosDaEstrutura.retornarObjeto(opcaoA.getNoEsquerdo());
				atualizarOpcoes();
			}
		}
		catch(NullPointerException e){
			//JOptionPane.showMessageDialog(telaDoPrograma.getFrame(), estruturaArquivos.lerArquivoDeConfig("/MSG-ERRO-01.txt"), "ERRO - 001", 0);
		}
	}

	@Override
	public void executarOpcao2() {
		try{
			if((elementosDaEstrutura.retornarObjeto(opcaoB.getNoEsquerdo()) == null)
				&& (elementosDaEstrutura.retornarObjeto(opcaoB.getNoDireito()) == null)){
				JOptionPane.showMessageDialog(telaDoPrograma.getFrame(), estruturaArquivos.lerArquivoDeConfig("/MSG-CLASSIFICACAO-ESPECIE.txt")
						+opcaoB.getConteudo().getNomeDaEspecie()+"</i></b></font></html>", "Classificador de Espécie", 3);
			}
			else{
				opcaoA = (No) elementosDaEstrutura.retornarObjeto(opcaoB.getNoEsquerdo());
				opcaoB = (No) elementosDaEstrutura.retornarObjeto(opcaoB.getNoDireito());
				atualizarOpcoes();
			}
		}
		catch(NullPointerException e){
	//			JOptionPane.showMessageDialog(telaDoPrograma.getFrame(), estruturaArquivos.lerArquivoDeConfig("/MSG-CLASSIFICACAO-ESPECIE.txt")
	//					+opcaoB.getConteudo().getNomeDaEspecie()+"</i></font></html>", "Classificador de Espécie", 3);
			
		}
		
	}

	@Override
	public void finalizarPrograma() {
		Runtime.getRuntime().exit(0);
		
	}

	@Override
	public void carregarArquivo() {
		zerarVariaveisDeAmbiente();
		String caminhoDoArquivo;
		JFileChooser file = new JFileChooser();
		int result = file.showOpenDialog(telaDoPrograma.getFrame());
		if(result == JFileChooser.APPROVE_OPTION){
			caminhoDoArquivo = file.getSelectedFile().getAbsolutePath();
		}
		else{
			return;
		}
		try{
			estruturaArquivos.carregarArquivos(caminhoDoArquivo, elementosDaEstrutura);
			telaDeClassificacao = telaDoPrograma.habilitarTelaDeClassificao();
			iniciarEstrutura();
		}
		catch(RuntimeException | FileNotFoundException e){
			JOptionPane.showMessageDialog(telaDoPrograma.getFrame(), estruturaArquivos.lerArquivoDeConfig("/MSG-ERRO-01.txt"), "ERRO - 001", 0);
			telaDoPrograma.habilitarMenuInicial();
			return;
		}
		
	}

	private void iniciarEstrutura() {
		No raiz = (No) elementosDaEstrutura.retornarObjeto("RAIZ");
		opcaoA = (No) elementosDaEstrutura.retornarObjeto(raiz.getNoEsquerdo());
		opcaoB = (No) elementosDaEstrutura.retornarObjeto(raiz.getNoDireito());
		telaDeClassificacao.setDescricaoOpcao1(opcaoA.getConteudo().getDescricao());
		telaDeClassificacao.setImagemOpcao1(opcaoA.getConteudo().getImage());
		telaDeClassificacao.setDescricaoOpcao2(opcaoB.getConteudo().getDescricao());
		telaDeClassificacao.setImagemOpcao2(opcaoB.getConteudo().getImage());
	}
	
	private void atualizarOpcoes() throws NullPointerException {
		telaDeClassificacao.setDescricaoOpcao1(opcaoA.getConteudo().getDescricao());
		telaDeClassificacao.setImagemOpcao1(opcaoA.getConteudo().getImage());
		telaDeClassificacao.setDescricaoOpcao2(opcaoB.getConteudo().getDescricao());
		telaDeClassificacao.setImagemOpcao2(opcaoB.getConteudo().getImage());
	}

	@Override
	public void reiniciarClassificacao() {
		String[] opcoes = new String[2];
		ImageIcon image = new FabricaDeImagens().obterImagem(Icones.LOGOTIPO);
		image.setImage(image.getImage().getScaledInstance(100, 120, 100));
		int resultado;
		opcoes[0] = "REINICIAR";
		opcoes[1] = "OBTER NOVO";
		resultado = JOptionPane.showOptionDialog(telaDoPrograma.getFrame(),
				estruturaArquivos.lerArquivoDeConfig("/MSG-REINICIARCLASSIFICACAO.txt"), "Classificador de Espécies", 0, JOptionPane.INFORMATION_MESSAGE,
				image, opcoes, null);
		System.out.println(resultado);
		if(resultado == 0){
			iniciarEstrutura();
			atualizarOpcoes();
		}
		else if(resultado == 1){
			carregarArquivo();
		}
//		int result = JOptionPane.showConfirmDialog(telaDoPrograma.getFrame(), "teste", "Title",JOptionPane.YES_NO_OPTION);
//		if(result == JOptionPane.YES_OPTION){
//			
//		}
//		carregarArquivo();
		
	}
	
	private void zerarVariaveisDeAmbiente(){
		elementosDaEstrutura = null;
		elementosDaEstrutura = new Hash(1000);
		opcaoA = null;
		opcaoB = null;
	}


}
