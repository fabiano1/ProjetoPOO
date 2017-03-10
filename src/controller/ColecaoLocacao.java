package controller;

import java.util.ArrayList;

public class ColecaoLocacao {

	private ArrayList<Locacao> locacoes;

	public ColecaoLocacao() {

		this.locacoes=new ArrayList<Locacao>();
	}

	public void addLocacao(Locacao locacao){
		if (!locacao.equals(locacao))
		locacoes.add(locacao);
	}

	public void remoceLocacao(int id){

		for (Locacao locacao : locacoes) {
			if (locacao.getId()==id);
			locacoes.remove(id);


		}


	}
	public Locacao pesquisaLocacao(int id){

		for (Locacao locacao : locacoes) {
			if (locacao.getId()==id){
				return locacao;
			}

		}
		return null;

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
