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
	public boolean salvarEmArq(ArrayList<Pessoa> p) {
		// TODO Auto-generated method stub
		
			 
	           try {
	             FileOutputStream saveFile = new FileOutputStream("bd.txt");
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             
	              // salva o objeto
	             stream.writeObject(p);
	 
	             stream.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    
		return false;
	}

	@Override
	public ArrayList<Pessoa> carregarPessoas() {
					 
		ArrayList<Pessoa> list = null;
           
            try {
                   FileInputStream restFile = new FileInputStream("bd.txt");
                   ObjectInputStream stream = new ObjectInputStream(restFile);

                   // recupera o objeto
                   list = (ArrayList<Pessoa>) stream.readObject();

                   stream.close();
            } catch (Exception e) {
                   e.printStackTrace();
            }

            return list;
     
	}

}
