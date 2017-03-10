package controller;

import java.io.Serializable;
import java.util.ArrayList;

import dao.ControllerDao;
import dao.Idao;

public class ColecaoPessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pessoa> pessoas=new  ArrayList<Pessoa>();
	private Idao id=new ControllerDao();

	public ColecaoPessoa(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public ColecaoPessoa() {

		this.pessoas = new ArrayList<Pessoa>();
	}

	public void addPessoa(Pessoa p){
		if(!pessoas.contains(p)){
			pessoas.add(p);
			try {
				id.salvarEmArq(pessoas);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			/**
			 * 		Colocar um método para salvar no aquivo passando a caleção como paramentro
			 */
		}
	}

	public ArrayList<Pessoa> listarPessoa(){
		if(!pessoas.isEmpty()){
			return pessoas;
		}
		return null;
	}

	public ArrayList<Cliente> listarClientes(){
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();

		for (Pessoa pessoa : pessoas) {

			if(pessoa instanceof Cliente){
				clientes.add((Cliente) pessoa);

			}
		}
		return clientes;

	} 

	public boolean removerPessoa(String cpf) {

		for (Pessoa pessoa : pessoas) {
			if(pessoa.getCpf().equals(cpf)){
				
					pessoas.remove(pessoa);
					
					
			
			
			}
		}


		return true;

	}





}
