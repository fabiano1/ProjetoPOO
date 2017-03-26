package net;

import java.net.Socket;

public interface INetServer {
	
	public void initServer()throws Exception;
	public boolean receberObeject(Socket client)throws Exception;
	public boolean enviarObject(Socket clint)throws Exception;

}
