package logica;

import apresentacao.TelaPrograma;
import estrutura.Hash;
import interfaces.AcoesDeTela;
import interfaces.SaidaPrograma;

public class ExecucaoPrograma implements AcoesDeTela{
	
	private SaidaPrograma telaDoPrograma;
	private LeitorArquivos estruturaArquivos;
	private Hash elementosDaEstrutura;
	
	public ExecucaoPrograma(){
		telaDoPrograma = new TelaPrograma();
		estruturaArquivos = new LeitorArquivos();
	}
	
	public void iniciarPrograma(){
		telaDoPrograma.iniciarPrograma();
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	public void sair() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executarOpcao1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executarOpcao2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void botaoIniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void botaoSair() {
		// TODO Auto-generated method stub
		
	}

}
