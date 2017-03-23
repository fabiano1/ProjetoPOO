package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

public class ControllerDao implements Idao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean salvarEmArq(ArrayList<Pessoa> list, String str) {
		
			 
	           try {
	             FileOutputStream saveFile = new FileOutputStream(str);
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             
	              // salva o objeto
	             stream.writeObject(list);
	 
	             stream.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    
		return false;
	}

	@Override
	public ArrayList<Pessoa> carregarArq(String str) {

		Object obj = null;
		ArrayList<Pessoa> list;
           
            try{
            	File file = new File(str);
            	if(file.exists()){
            		FileInputStream restFile = new FileInputStream(str);
                  
            		ObjectInputStream stream = new ObjectInputStream(restFile);

            		// recupera o objeto
                  
            	//	obj = (Object) stream.readObject();
            		list = (ArrayList<Pessoa>) stream.readObject();

            		stream.close();
            		return list;
            	}
            	return null;
            } catch (Exception e) {
                   e.printStackTrace();
                   return null;
            }
     
	}
	
	public boolean verificarArquivo(String str){
		File file = new File(str);
		
		if(file.exists()){
			return true;
		}
		return false;
	}
	/*
	File arquivo = new File("CAMINHO DO ARQUIVO.EXTENSÃO");
	if(arquivo.exists()){
	    //O ARQUIVO EXISTE
	}else{
	    //O ARQUIVO NÃO EXISTE
	}
*/
}
