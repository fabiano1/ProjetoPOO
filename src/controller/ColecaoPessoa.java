package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import dao.ControllerDao;
import dao.Idao;
import net.*;

/**
 * Classe ColecaoPessoa, cont�m os m�todos para criar e 
 * manipular uma cole��o de classes do tipo Pessoa.
 * 
 * @author SHOW13
 *
 */

public class ColecaoPessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private INetClient iNet = new ControllerNetClient();
	private Idao id=new ControllerDao();
	private static String localizacao = new String("pessoas.obj");
	
	private ArrayList<Pessoa> pessoas; /*= id.carregarArq("bd.dat");*/
	
	public ColecaoPessoa(ArrayList<Pessoa> pessoas){
		this.pessoas = pessoas;
	}

	public ColecaoPessoa(){
		this.pessoas = new ArrayList<Pessoa>();
	}

	
/*	public void recuperarArquivo() throws IOException, ClassNotFoundException{
		try{
			FileInputStream file = new FileInputStream(localizacao); 
			ObjectInputStream stream = new ObjectInputStream(file);
			ArrayList<Pessoa> readObject = (ArrayList<Pessoa>) stream.readObject();
			this.pessoas = readObject;
			stream.close();
		}catch(IOException io){
			System.err.println("erro ao obter arquivo");
		}
	}*/

	public boolean carregarArqDePessoas()throws Exception{
		
		try{
			Object obj = (Object) iNet.receberObject(localizacao);
			if(obj!=null){
				this.pessoas = (ArrayList<Pessoa>) obj;
				System.out.println(this.pessoas.toString());
				return true;
			}else{
				return false;
			}

		/*	Object obj = (Object) id.carregarArq(localizacao);
			if(obj==null){
		//		System.out.println("objeto nulo");
				return false;
			}else{
				this.pessoas = (ArrayList<Pessoa>) obj;
			//	System.out.println(this.pessoas.toString());
					return true;
			}*/

		//	}
		}catch(Exception e){
		//	e.printStackTrace();
		//	System.err.println("erro ao carregar arquivo - Colecao Pessoa");
		}
		return false;
	}
	
	public boolean addPessoa(Pessoa p)throws Exception{
		if(!pessoas.contains(p)){
			pessoas.add(p);
			try {
				iNet.enviarObject(this.pessoas, localizacao);
			//	id.salvarEmArq(this.pessoas,localizacao);
				return true;

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			/**
			 * 		Colocar um m�todo para salvar no aquivo passando a cale��o como paramentro
			 */
		}
		return false;
	}

	public ArrayList<Pessoa> listarPessoa()throws Exception{
		try{
		//	if(!pessoas.isEmpty()){
		//		this.pessoas = (ArrayList<Pessoa>) id.carregarArq(localizacao);
				return this.pessoas;
		//	}
		}catch(Exception e){
			System.err.println("erro ao listar pessoas");
		}
		return null;
	}

	public ArrayList<Cliente> listarClientes()throws Exception{
	
		try{
			ArrayList<Cliente> clientes=new ArrayList<Cliente>();

			for (Pessoa pessoa : this.pessoas) {
				if(pessoa instanceof Cliente){
					clientes.add((Cliente) pessoa);
				}
			}
			return clientes;
		}catch(Exception e){
			System.err.println("erro ao listar clientes");
		}
		return null;
	}
	
	public ArrayList<Funcionario> listarFuncionarios()throws Exception{
		
		try{
			ArrayList<Funcionario> func =new ArrayList<Funcionario>();

			for (Pessoa pessoa : this.pessoas) {

				if(pessoa instanceof Funcionario){
					func.add((Funcionario) pessoa);
				}
			}
			return func;
		}catch(Exception e){
			System.err.println("erro ao listar funcionarios");
		}
		return null;

	}
	/*
	public Pessoa pesquisarPessoaPeloCPF(String cpf)throws Exception {
		try{

			for (Pessoa p : this.pessoas){

				if( p.getCpf().equals(cpf)){
					return p;
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao pesquisar pessoa");
		}
		return null;

	} 
*/
/*	public Pessoa pesquisarClientePeloCNH(String cnh)throws Exception {
		try{

			for (Pessoa p : this.pessoas){

				if(p instanceof Cliente){
					Cliente client = (Cliente) p;
					if( client.getCnh().equals(cnh)){
						return p;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao pesquisar Cliente pela cnh");
		}
		return null;

	} */
	
	public boolean removerPessoa(String cpf) throws Exception{

		for (Pessoa pessoa : pessoas) {
			if(pessoa.getCpf().equals(cpf)){

					pessoas.remove(pessoa);

					try {
						iNet.enviarObject(this.pessoas, localizacao);
				//		id.salvarEmArq(this.pessoas,localizacao);
						return true;
					} catch (Exception e) {
						// TODO: handle exception
					}
			
			}
		}
		return false;

	}
	

}
