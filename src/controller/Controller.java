package controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Controller implements Icontroller, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColecaoPessoa cp=new ColecaoPessoa();
	private	ColecaoLocacao cl=new ColecaoLocacao();
	private	ColecaoVeiculo cv=new ColecaoVeiculo();
	
	/******************Pessoa
	 * @throws Exception ***************
	 
	 **/
	@Override
	public boolean addPessoa(Pessoa p) throws Exception {

		cp.addPessoa(p);
		return true;
	}
	
	@Override
	public ArrayList<Pessoa> listarPessoa() throws Exception{

		return cp.listarPessoa();
	}
	
	@Override
	public ArrayList<Cliente> listarCliente() throws Exception{

		return cp.listarClientes();

	}
	
	@Override
	public ArrayList<Funcionario> listarFuncionario() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pessoa pesquisarPessoaPeloCPF(String cpf) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean removerPessoa(String cpf) throws Exception{
			
		return cp.removerPessoa(cpf);
	}
	
	/********************Veiculo***************************/
	@Override
	public void addVeiculo(Veiculo v) throws Exception{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Veiculo> listarVeiculos() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Veiculo> listarVeiculosDisponiveis() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Automovel> listarAutomoveis() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Motocicleta> listarMotocicletas() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Veiculo pesquisarVeiculo(String placa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean removerVeiculo(String placa) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}
	
	/************************Locacao*********************/
	@Override
	public void realizarLocacao(Locacao l) throws Exception{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Locacao> listarLocacoes() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(Pessoa p) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(Veiculo v) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(int id)throws Exception{
		return cl.pesquisarLocacao(id);
	}
	
	@Override
	public boolean removerLocacao(int id) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}


}
