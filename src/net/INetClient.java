package net;

import java.util.*;

/**
 * Interface que cont�m os m�todos para conex�o com o servidor de 
 * arquivos, devendo-se ser implementado os m�todos pela classe que 
 * implementar essa interface;
 * 
 * @author SHOW13
 *
 */

public interface INetClient {
	
	public boolean enviarObject(Object obj, String fileName)throws Exception;
	public Object receberObject(String arquivo) throws Exception;

}
