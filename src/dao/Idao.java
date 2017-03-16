package dao;

import java.util.ArrayList;

import controller.Pessoa;

public interface Idao {
	
	public boolean salvarEmArq(ArrayList<Pessoa> p);
	public ArrayList<Pessoa> carregarPessoas();
	

}
