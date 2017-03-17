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
	
	/********************Pessoa*************************/
	@Override
	public boolean addPessoa(Pessoa p) {

		cp.addPessoa(p);
		return true;
	}
	
	@Override
	public ArrayList<Pessoa> listarPessoa() {

		return cp.listarPessoa();
	}
	
	@Override
	public ArrayList<Cliente> listarCliente() {

		return cp.listarClientes();

	}
	
	@Override
	public ArrayList<Funcionario> listarFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pessoa pesquisarPessoaPeloCPF(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean removerPessoa(String cpf) {
			
		return cp.removerPessoa(cpf);
	}
	
	/********************Veiculo***************************/
	@Override
	public void addVeiculo(Veiculo v) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Veiculo> listarVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Veiculo> listarVeiculosDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Automovel> listarAutomoveis() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Motocicleta> listarMotocicletas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Veiculo pesquisarVeiculo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean removerVeiculo(String placa) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/************************Locacao*********************/
	@Override
	public void realizarLocacao(Locacao l) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Locacao> listarLocacoes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(Pessoa p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(Veiculo v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Locacao pesquisarLocacao(int id){
		return cl.pesquisaLocacao(id);
	}
	
	@Override
	public boolean removerLocacao(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
