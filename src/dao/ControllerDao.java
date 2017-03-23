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
	public boolean salvarEmArq(Object obj, String localizacao) {
		
			 
	           try {
	             FileOutputStream saveFile = new FileOutputStream(localizacao);
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             
	              // salva o objeto
	             stream.writeObject(obj);
	         //  System.out.println(list+"\ncontrollerDao- salvar\n");
	         //  System.out.println(stream+"\nobject de salvar arquivo\n");
	             
	             stream.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    
		return false;
	}

	@Override
	public Object carregarArq(String localizacao) {

		Object obj = new Object();
		//ArrayList<Pessoa> list = new ArrayList<Pessoa>();
           
            try{
            	File file = new File(localizacao);
            	if(file.exists()){
            		FileInputStream restFile = new FileInputStream(localizacao);
                  
            		ObjectInputStream stream = new ObjectInputStream(restFile);

            		// recupera o objeto
                  
            		obj = (Object) stream.readObject();
            	//	list = (Object) stream.readObject();
            	//	System.out.println(list+"\ncontrollerdao - carregar arquivo\n");

            		stream.close();
            		return obj;
            	}
            	else{
            		FileOutputStream saveFile = new FileOutputStream(localizacao,true);
   	             	ObjectOutputStream stream = new ObjectOutputStream(saveFile);
   	             	return obj;
            	}
            	
            } catch (Exception e) {
                   e.printStackTrace();
            }
            
            return obj;
     
	}
	
	public boolean verificarArquivo(String localizacao){
		File file = new File(localizacao);
		
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
