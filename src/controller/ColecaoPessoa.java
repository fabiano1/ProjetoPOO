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
	
	public ColecaoPessoa(ArrayList<Pessoa> pessoas){
		this.pessoas = pessoas;
	}

	public ColecaoPessoa(){
		
	//	this.pessoa = (ArrayList<Pessoa>)id.carregarArq("pessoa.txt");
		this.pessoas = new ArrayList<Pessoa>();
	}

	public boolean addPessoa(Pessoa p)throws Exception{
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

	public ArrayList<Pessoa> listarPessoa()throws Exception{
		try{
			if(!pessoas.isEmpty()){
				return pessoas;
			}
		}catch(Exception e){
			System.err.println("erro ao listar pessoas");
		}
		return null;
	}

	public ArrayList<Cliente> listarClientes()throws Exception{
	
		try{
			ArrayList<Cliente> clientes=new ArrayList<Cliente>();

			for (Pessoa pessoa : id.carregarPessoas()) {
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

			for (Pessoa pessoa : id.carregarPessoas()) {

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
	

	public boolean removerPessoa(String cpf) throws Exception{

		for (Pessoa pessoa : pessoas) {
			if(pessoa.getCpf().equals(cpf)){
				
					pessoas.remove(pessoa);

					try {
						
						id.salvarEmArq(pessoas);
						return true;
					} catch (Exception e) {
						// TODO: handle exception
					}
			
			}
		}
		return false;

	}
	

}
