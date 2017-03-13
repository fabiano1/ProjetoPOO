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
	public boolean removerPessoa(String cpf) {
		
		
		return cp.removerPessoa(cpf);
	}

	@Override
	public ArrayList<Funcionario> listarFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVeiculo(Veiculo v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Veiculo> listarVeiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo listarVeiculo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removerVeiculo(String placa) {
		// TODO Auto-generated method stub
		return false;
	}

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
	public ArrayList<Locacao> listarLocacao(Pessoa p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Locacao> listarLocacao(Veiculo v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locacao listarLocacao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removerLocacao(int id) {
		return false;
	}

	@Override
	public ArrayList<Veiculo> listarVeiculosDisponivel(String placa) {
		return null;
	}

}
