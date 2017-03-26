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

public class ControllerNetClient implements INetClient, Serializable {

	@Override
	public boolean enviarObject(Object obj) throws Exception{
		
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
			if(obj instanceof ArrayList/*<Pessoa>*/){
				op = "1";
			}
			if(obj instanceof ArrayList/*<Veiculo>*/){
				op = "2";
			}
			if(obj instanceof ArrayList/*<Locacao>*/){
				op = "3";
			}
			pout.println(op);
			
		//	SignerOutputStream sc1 = null;
		//	sc1.write(1);
			
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
			outStream.writeObject(obj);
			
			sock.close();
			
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public ArrayList<Object> receberObject(String arquivo)throws Exception{
		ArrayList<Object> array = new ArrayList();
	
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
			
			ObjectInputStream inStream = new ObjectInputStream(sock.getInputStream());
			array = (ArrayList<Object>) inStream.readObject();
			
			sock.close();
			return array;
		}catch(Exception e){
			System.err.println("erro ao recebr objeto");
		}
		
		return array;
	}

	
}
