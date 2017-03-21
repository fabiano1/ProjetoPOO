package controller;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ColecaoLocacao {

	private ArrayList<Locacao> locacoes;

	public ColecaoLocacao() {

		this.locacoes=new ArrayList<Locacao>();
	}

	public boolean addLocacao(Locacao locacao)throws Exception{
		
		try{
			if (!locacao.equals(locacao)){
				locacoes.add(locacao);
				return true;
		}
		}catch(Exception e){
			System.err.println("erro ao adicionar locacao");
		}
		return false;
		
	}

	public boolean removerLocacao(int id)throws Exception{

		try{
			for (Locacao locacao : locacoes) {
				if (locacao.getId()==id){
					locacoes.remove(id);
					return true;
				}
			}
			
		}catch(Exception e){
			System.err.println("erro ao remover locacao");
		}
		return false;

	}
	
	
	
	public ArrayList<Locacao> listarLocacoes(){
		return this.locacoes;
			
	}
/*	
 * Verificar necessidade
 * 
 * 
	public Locacao editarLocacao(int id){
		
		for (Locacao locacao : locacoes) {
			if (locacao.getId()==id){
				return locacao;
			}

		}
		return null;
		
		
	}
	*/
	
}
