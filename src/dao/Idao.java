package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

public interface Idao {
	
	public boolean salvarEmArq(ArrayList<Pessoa> list, String str);
	public ArrayList<Pessoa> carregarArq(String str);
	public boolean verificarArquivo(String str);
	

}
