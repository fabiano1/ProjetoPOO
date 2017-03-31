package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

/**
 * Interface que cont�m os m�todos para salvamento dos arquivos, 
 * devendo-se ser implementado os m�todos na classe que implementar 
 * essa interface.
 * 
 * @author SHOW13
 *
 */

public interface Idao {
	
	public boolean salvarEmArq(Object obj, String str) throws Exception;
	public Object carregarArq(String str)throws Exception;
	public boolean verificarArquivo(String str)throws Exception;
	

}
