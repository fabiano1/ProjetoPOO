package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

public interface Idao {
	
	public boolean salvarEmArq(Object obj, String str);
	public Object carregarArq(String str);
	public boolean verificarArquivo(String str);
	

}
