package net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ControllerNetClient implements INetClient, Serializable {

	@Override
	public boolean enviarObject(Object obj) {
		try{
			Socket sock = new Socket("127.0.0.1",6013);
		//	ArrayList<String>  array = new ArrayList<String>();
//			InputStream in = sock.getInputStream();
			
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
			outStream.writeObject(obj);
			
			sock.close();
			
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public ArrayList receberObject(Object obj) {
		ArrayList array = new ArrayList();
		
		try{			
			Socket sock = new Socket("127.0.0.1",6013);
			ObjectInputStream inStream = new ObjectInputStream(sock.getInputStream());
			array = (ArrayList)inStream.readObject();
			
			sock.close();
			return array;
		}catch(Exception e){
			System.err.println("erro ao recebr objeto");
		}
		
		return array;
	}

	
}
