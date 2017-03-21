package controller;

import java.util.ArrayList;

public interface Icontroller{

	public boolean addPessoa(Pessoa p) throws Exception;
	public ArrayList<Pessoa> listarPessoa() throws Exception;
	public ArrayList<Cliente> listarCliente()throws Exception;
	public ArrayList<Funcionario> listarFuncionario()throws Exception;
	public Pessoa pesquisarPessoaPeloCPF(String cpf)throws Exception;
	public boolean removerPessoa(String cpf)throws Exception;

	public boolean addVeiculo(Veiculo v)throws Exception;
	public ArrayList<Veiculo> listarVeiculos()throws Exception;
	public ArrayList<Veiculo> listarVeiculosDisponiveis()throws Exception;
	public ArrayList<Automovel> listarAutomoveis()throws Exception;
	public ArrayList<Motocicleta> listarMotocicletas()throws Exception;
	public Veiculo pesquisarVeiculo(String placa)throws Exception;
	public boolean removerVeiculo(String placa)throws Exception;

	public boolean realizarLocacao(Locacao l)throws Exception;
	public ArrayList<Locacao> listarLocacoes()throws Exception;
	public Locacao pesquisarLocPorPessoa(String cpf)throws Exception;
	public Locacao pesquisarLocPorVeiculo(String placa)throws Exception;
	public Locacao pesquisarLocacao(int id)throws Exception;
	public boolean removerLocacao(int id)throws Exception;



}
