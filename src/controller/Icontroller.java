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
	public ArrayList<Veiculo> listarVeiculos();
	public ArrayList<Veiculo> listarVeiculosDisponiveis();
	public ArrayList<Automovel> listarAutomoveis();
	public ArrayList<Motocicleta> listarMotocicletas();
	public Veiculo pesquisarVeiculo(String placa);
	public boolean removerVeiculo(String placa);
	
	public void realizarLocacao(Locacao l);
	public ArrayList<Locacao> listarLocacoes();
	public Locacao pesquisarLocacao(Pessoa p);
	public Locacao pesquisarLocacao(Veiculo v);
	public Locacao pesquisarLocacao(int id);
	public boolean removerLocacao(int id);
	
	

}
