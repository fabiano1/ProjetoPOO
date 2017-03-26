package net;

import java.util.*;

public interface INetClient {
	
	public boolean enviarObject(Object obj)throws Exception;
	public ArrayList<Object> receberObject(String arquivo) throws Exception;

}
