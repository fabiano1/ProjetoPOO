package net;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import com.sun.jndi.ldap.sasl.SaslInputStream;
import com.sun.org.apache.xml.internal.security.utils.SignerOutputStream;

import  controller.*;

public class ControllerNetClient implements INetClient, Serializable {
	
	@Override
	public boolean enviarObject(Object obj, String fileName) throws Exception{
		
		try{
//			ArrayList<String>  array = new ArrayList<String>();
			
			Socket sock = new Socket("127.0.0.1",6013);
			
			/**	
			 * 	Menu de Dados das opcao recebida:
			 *	0 - Cancelar;
			 *	1 - enviar arquivo para servidor;
			 *	2 - receber arquivo do servidor;
			 *
			 **/
			/*Primeira etapa: envio de opção escolhida para o servidor*/
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			String op = new String("1");
			pout.println(op);
			pout.flush();
			
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			/*Segunda etapa: envio de opção escolhida para o servidor*/
			op = "0";
			
		/*Segunda etapa: resposta a segunda opcao do tipo de arquivo a enviar*/
			if(fileName.equals("pessoas.obj")){
				op = "1";
			}
			if(fileName.equals("veiculos.obj")){
				op = "2";
			}
			if(fileName.equals("locacoes.obj")){
				op = "3";
			}else{
				sock.close();
				return true;
			}
			pout.println(op);
			pout.flush();
		//	SignerOutputStream sc1 = null;
		//	sc1.write(1);
			
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
			outStream.writeObject(obj);
			outStream.flush();
			
			sock.close();
			
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Object receberObject(String arquivo)throws Exception{
		Object obj = new Object();
		
		try{
			Socket sock = new Socket("127.0.0.1",6013);
		
			/**	
			 * 	Menu de Dados das opcao recebida:
			 *	0 - Cancelar;
			 *	1 - enviar arquivo para servidor;
			 *	2 - receber arquivo do servidor;
			 *
			 **/
			/*Primeira etapa: envio de opção escolhida para o servidor*/
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			String op = new String("2");
			pout.println(op);
			pout.flush();
			
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			/*Segunda etapa: envio de opção escolhida para o servidor*/
			op = "0";
			
			if(arquivo.equals("pessoas.obj")){
				op = "1";
			}
			if(arquivo.equals("veiculos.obj")){
				op = "2";
			}
			if(arquivo.equals("locacoes.obj")){
				op = "3";
			}
			pout.println(op);
			pout.flush();
			
			ObjectInputStream inStream = new ObjectInputStream(sock.getInputStream());
			obj = (Object) inStream.readObject();
			
			sock.close();
			return obj;
		}catch(Exception e){
			System.err.println("erro ao recebr objeto");
		}
		
		return obj;
	}

	
}
