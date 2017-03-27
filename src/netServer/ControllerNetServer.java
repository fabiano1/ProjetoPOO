package netServer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
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

import dao.*;

public class ControllerNetServer implements INetServer, Serializable{

	private Idao id=new ControllerDao();
	
	@Override
	public void initServer()throws Exception{
		try{
			ServerSocket sock = new ServerSocket(6013);
			String op = new String();
			
			while (true) {
				Socket client = sock.accept();
				// temos uma conexão
			
				/**	
				 * 	Menu de Dados das opcao recebida:
				 *	0 - Cancelar;
				 *	1 - salvar arquivo do cliente;
				 *	2 - enviar arquivo solicitado pelo cliente;
				 *
				 **/
				InputStream in = client.getInputStream();
				BufferedReader bin = new BufferedReader(new InputStreamReader(in));
					
				op = bin.readLine();
				System.out.println(op);
					
				if((!op.equals("0"))&&(!op.equals("1"))&&(!op.equals("2"))){
					client.close();
				}else{
				
					//				client.wait();
					switch(op){
						case "1":
							receberObeject(client);
							break;
						case "2":
							enviarObject(client);
							break;
						default:
							client.close();
							break;
					}
				}
			
				client.close();
			}
		}catch(Exception e){
			System.err.println("erro no servidor");
		}
	}

	@Override
	public boolean receberObeject(Socket client) throws Exception {
		
		String op = new String();
		
		try{
		
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			InputStream in = client.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			
			op = bin.readLine();
			System.out.println(op);
				
			if((op.equals("0"))&&(!op.equals("1"))&&(!op.equals("2"))&&(!op.equals("3"))){
				client.close();
				return false;
			}else{
			
				ObjectInputStream inStream = new ObjectInputStream(client.getInputStream());
				Object obj = (Object) inStream.readObject();
				if(obj!=null){
					switch(op){
						case "1":
								id.salvarEmArq(obj,"pessoas.obj");
							break;
						case "2":
								id.salvarEmArq(obj,"veiculos.obj");
							break;
						case "3":
								id.salvarEmArq(obj,"locacoes.obj");
							break;
						default:
							client.close();
							return false;
					}
					client.close();
					return true;
				}else{
					client.close();
					return false;
				}
			}
		}catch(Exception e){
			System.err.println("Erro receber objeto do servidor");
		}
		
		return false;
	}

	@Override
	public boolean enviarObject(Socket client) throws Exception{

		String op = new String();
		
		try{
		
			/**	
			 * 	Menu de Dados da segunda opcao recebida para enviar aquivo:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
		
			
			InputStream in = client.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
	
			
			op = bin.readLine();
			System.out.println(op);
					
			if((op.equals("0"))||(!op.equals("1"))&&(!op.equals("2"))&&(!op.equals("3"))){
				client.close();
				return false;
			}else{
				ObjectOutputStream outStream = new ObjectOutputStream(client.getOutputStream());
				Object obj = new Object();
				switch(op){
					case "1":
						obj = id.carregarArq("pessoas.obj");
						outStream.writeObject(obj);
						break;
					case "2":
						obj = id.carregarArq("veiculos.obj");
						outStream.writeObject(obj);
						break;
					case "3":
						obj = id.carregarArq("locacoes.obj");
						outStream.writeObject(obj);
						break;
					default:
						outStream.flush();
						client.close();
						return false;
				}
				outStream.flush();
				client.close();
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao enviar objeto para servidor");
		}
		return false;
	
	}
	
}
