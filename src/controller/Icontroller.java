package controller;

import java.util.ArrayList;

public interface Icontroller{
	
	public boolean addPessoa(Pessoa p);
	public ArrayList<Pessoa> listarPessoa();
	public ArrayList<Cliente> listarCliente();
	public ArrayList<Funcionario> listarFuncionario();
	public Pessoa pesquisarPessoaPeloCPF(String cpf);
	public boolean removerPessoa(String cpf);
	
	public void addVeiculo(Veiculo v);
	public ArrayList<Veiculo> listarVeiculo();
	public Veiculo listarVeiculo(String placa);
	public ArrayList<Veiculo> listarVeiculosDisponivel(String placa);
	public boolean removerVeiculo(String placa);
	
	public void realizarLocacao(Locacao l);
	public ArrayList<Locacao> listarLocacoes();
	public ArrayList<Locacao> listarLocacao(Pessoa p);
	public ArrayList<Locacao> listarLocacao(Veiculo v);
	public Locacao listarLocacao(int id);
	public boolean removerLocacao(int id);
	public Locacao pesquisaLocacao(int id);
	
	

}
