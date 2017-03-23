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
	             FileOutputStream saveFile = new FileOutputStream("bd.dat");
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             
	              // salva o objeto
	             stream.writeObject(list);
	         //  System.out.println(list+"\ncontrollerDao- salvar\n");
	         //  System.out.println(stream+"\nobject de salvar arquivo\n");
	             
	             stream.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    
		return false;
	}

	@Override
	public ArrayList<Pessoa> carregarArq(String str) {

	//	Object obj = null;
		ArrayList<Pessoa> list = new ArrayList<Pessoa>();
           
            try{
            	File file = new File("bd.dat");
            	if(file.exists()){
            		FileInputStream restFile = new FileInputStream("bd.dat");
                  
            		ObjectInputStream stream = new ObjectInputStream(restFile);

            		// recupera o objeto
                  
            	//	obj = (Object) stream.readObject();
            		list = (ArrayList<Pessoa>) stream.readObject();
            	//	System.out.println(list+"\ncontrollerdao - carregar arquivo\n");

            		stream.close();
            		return list;
            	}
            	else{
            		FileOutputStream saveFile = new FileOutputStream("bd.dat",true);
   	             	ObjectOutputStream stream = new ObjectOutputStream(saveFile);
   	             	return list;
            	}
            	
            } catch (Exception e) {
                   e.printStackTrace();
            }
            
            return list;
     
	}
	
	public boolean verificarArquivo(String str){
		File file = new File("bd.dat");
		
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
