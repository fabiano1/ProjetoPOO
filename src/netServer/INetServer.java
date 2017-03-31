package netServer;

import java.net.Socket;

/**
 * interface que cont�m os m�todos para inicializa��o do servidor de 
 * arquivos, devendo-se ser implementado os m�todos pela classe que 
 * implementar essa interface;
 * 
 * @author SHOW13
 *
 */

public interface INetServer {
	
	public void initServer()throws Exception;
	public boolean receberObeject(Socket client)throws Exception;
	public boolean enviarObject(Socket clint)throws Exception;

}
