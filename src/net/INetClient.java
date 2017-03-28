package net;

import java.util.*;

public interface INetClient {
	
	public boolean enviarObject(Object obj, String fileName)throws Exception;
	public Object receberObject(String arquivo) throws Exception;

}
