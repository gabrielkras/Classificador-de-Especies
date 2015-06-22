package estrutura;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe Hash, Estrutura de dados que permite armazenar informa��es
 * de qualquer tipo (Object). Permite recuperar as informa��es atrav�s
 * de uma chave unica gerada automaticamente para cada elemento
 * @author Francisco Gon�alves da Mota Longhini 
 * @author Gabriel Sousa Kraszczuk*/
public class Hash {
	
	private Object tabelaHash[][];
	private int tamanhoTabelaHash;
	/**
	 * Construtor, Recebe um tamanho definido para a estrutura da
	 * tabela Hash
	 * @param int tamanhoTotal*/
	public Hash(int tamanhoTotal){
		this.tabelaHash = new Object[tamanhoTotal][];
		this.tamanhoTabelaHash = tamanhoTotal;
	}
	/**
	 * Armazena Objetos na tabela e retorna a sua respectiva chave.
	 * @param Object objeto
	 * @return Float*/
	public void armazenarObjeto(Object objeto, String chave){
		int chaveArmazenada = gerarChave(chave);
		if(contemObjeto(objeto, chaveArmazenada) == true){
			List<Object> listaTemp = new ArrayList<Object>();
			int quantidadeElementos = 0;
			for(quantidadeElementos=0; ;quantidadeElementos++){
				try{
					listaTemp.add(tabelaHash[chaveArmazenada][quantidadeElementos]);
				}
				catch(ArrayIndexOutOfBoundsException e){
					break;
				}
			}
			listaTemp.add(objeto);
			tabelaHash[chaveArmazenada] = new Object[quantidadeElementos+1];
			for(int k=0; k<=quantidadeElementos; k++){
				tabelaHash[chaveArmazenada][k] = listaTemp.get(k);
			}
			listaTemp = null;
			float chaveFinal = (float) ((chaveArmazenada) + ((quantidadeElementos)*0.1));
		}
		else{
			tabelaHash[chaveArmazenada] = new Object[1];
			tabelaHash[chaveArmazenada][0] = objeto;
		}
	}
	/**
	 * Remove um objeto da tabela.
	 * @param float chave*/
	public void removerObjeto(float chave){
		try{
			int chaveInteira = (int)chave;
			int chaveSecundaria =  (int) ((chave - chaveInteira)*10);
			tabelaHash[chaveInteira][chaveSecundaria]= null;
		}
		catch(Exception e){
		}
	}
	/**
	 * Efetua a Gera��o da Chave
	 * @param String objeto
	 * @return float*/
	private int gerarChave(String objeto){
		int tamanhoObjeto = objeto.length();
		int codigo = 0;
		for(int k=0; k<tamanhoObjeto; k++){
			codigo += objeto.charAt(k)+objeto.charAt(tamanhoObjeto-1)+((k*2.35));
		}
		return codigo%tamanhoTabelaHash;
	}
	/**
	 * Verifica se o objeto, com a respectiva chave j� foi inserida
	 * na tabela.
	 * @param String objeto
	 * @param int chave
	 * @return boolean*/
	private boolean contemObjeto(Object objeto, int chave){
		try{
			if(objeto.equals((String)tabelaHash[chave][0])== true){
				return true;
			}
			else{
				return false;
			}
		}
		catch(NullPointerException e){
			return false;
		}
	}
	/**
	 * Retorna o objeto com base na chave inserida
	 * @param float chave
	 * @return Object*/
	public Object retornarObjeto(String chaveString){
		int chave = gerarChave(chaveString);
		try{
			int chaveInteira = (int)chave;
			int chaveSecundaria =  (int) ((chave - chaveInteira)*10);
			return tabelaHash[chaveInteira][chaveSecundaria];
		}
		catch(Exception e){
			return null;
		}
	}
}
