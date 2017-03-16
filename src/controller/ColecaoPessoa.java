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
	
	private Idao id=new ControllerDao();
	private ArrayList<Pessoa> pessoas=id.carregarPessoas();
	public ColecaoPessoa(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public ColecaoPessoa() {

		this.pessoas = new ArrayList<Pessoa>();
	}

	public boolean addPessoa(Pessoa p){
		if(!pessoas.contains(p)){
			pessoas.add(p);
			try {
				id.salvarEmArq(pessoas);
				return true;

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			/**
			 * 		Colocar um método para salvar no aquivo passando a caleção como paramentro
			 */
		}
		return false;
	}

	public ArrayList<Pessoa> listarPessoa(){
		if(!pessoas.isEmpty()){
			return pessoas;
		}
		return null;
	}

	public ArrayList<Cliente> listarClientes(){
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();

		for (Pessoa pessoa : id.carregarPessoas()) {

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

					try {
						
						id.salvarEmArq(pessoas);

					} catch (Exception e) {
						// TODO: handle exception
					}
			
			}
		}


		return true;

	}
	





}
