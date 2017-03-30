package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

public interface Idao {
	
	public boolean salvarEmArq(Object obj, String str) throws Exception;
	public Object carregarArq(String str)throws Exception;
	public boolean verificarArquivo(String str)throws Exception;
	

}
