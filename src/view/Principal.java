package view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import controller.*;


public class Principal implements Serializable{

	private static Icontroller ic= new Controller();
	/*private static ColecaoPessoa pessoa = new ColecaoPessoa();
	private static ColecaoVeiculo veiculo = new ColecaoVeiculo();*/
	private static ColecaoLocacao locacao = new ColecaoLocacao();
	
	public static void main(String[] args) throws Exception {
		
		int op = 0, i=0;
		Scanner sc = new Scanner(System.in);
		String str = new String();
		Endereco endereço = new Endereco();
		
		/*do{
			System.out.println("Menu ");
			System.out.println("0- Sair");
			System.out.println("1- Adicionar Pessoa");
			System.out.println("2- Listar Pessoal");
			System.out.println("3- Listar Clientes");
			
		}while(op!=0);*/
		
		do{
			System.out.println("Menu ");
			System.out.println("0- Sair");
			
			System.out.println("\nPacientes:");
			System.out.println("1- Adicionar Pessoa");
			System.out.println("2- Listar Pessoal");
			System.out.println("3- Listar Clientes");
			System.out.println("4- Listar Funcionarios");
			System.out.println("5- Pesquisar Pessoa");
			System.out.println("6- Remover Pessoa");
			
			System.out.println("\nVeiculo:");
			System.out.println("7- Adicionar Veiculo");
			System.out.println("8- Listar Veiculos");
			System.out.println("9- Listar Automoveis");
			System.out.println("10- Listar Motocicletas");
			System.out.println("11- Procurar Veiculo");
			System.out.println("12- Remover Veiculo");
			
			System.out.println("\nLocacao:");
			System.out.println("13- Adiconar Locacao");
			System.out.println("14- Listar Locacoes");
			System.out.println("15- Procurar Locacao");
			System.out.println("16- Remover Locacao");
		
			System.out.print("\nOpção: ");
//			op = LerNumero();
			
			switch(op){
			
				/*Pessoa*/
				case 1:
					if(adicionarPessoa()){
						System.out.println("pessoa adicionada com sucesso"); 
					}
			
				case 2:
					System.out.println(ic.listarPessoa().toString());
					break;
					
				case 3:
					System.out.println(ic.listarCliente().toString());
					break;
					
				case 4:
					System.out.println(ic.listarFuncionario().toString());
					break;
					
				case 5:
					System.out.print("digite o documento: ");
					str = lerDocumento();
					ic.pesquisarPessoaPeloCPF(str);
					break;
					
				case 6:
					System.out.print("digite o documento: ");
					str = lerDocumento();
					ic.removerPessoa(str);
					break;
					
				/*Veiculo*/
				case 7:
		//			if(adicionarVeiculo())
					{
						System.out.println("Veiculo adicionado com sucesso");
					}
				case 8:
					System.out.println(ic.listarVeiculo().toString());
				case 9:
		//			System.out.println(ic.listarAutmoveis());
				case 10:
		//			System.out.println(ic.listarMOtocicletas());
				case 11:
		//			System.out.println(ic.pesquisaVeiculoPelaPlaca());
				case 12:
					System.out.print("digite o unmero da Placa: ");
					str = sc.nextLine();
					ic.removerVeiculo(str);
				
				/*Locacao*/
				case 13:
		//			if(adicionarLocacao())
					{
						System.out.println("Locacao adicionado com sucesso");
					}
				case 14:
		//			ic.listarLocacao();
				case 15:
					System.out.print("digite o id da locacao: ");
					i = lerInteiro();
					ic.pesquisaLocacao(i);
				case 16:
					System.out.print("digite o id da locacao: ");
		//			i = LerInteiro();
					ic.removerLocacao(i);
			}
		}while(op!=0);
	}
		
	public static boolean adicionarPessoa() throws Exception{
		int op = 0;
		Scanner sc = new Scanner(System.in);
		String str = new String();
		String data = new String();
		Cliente client = new Cliente();
		Funcionario func = new Funcionario();
		Endereco endereco = new Endereco();
		
		System.out.print("digite o cpf do paciente: ");
		str = lerDocumento();
	//	if(pessoa.pesquisaPeloCPF(str)!= null)
	//	{
	//		System.out.println("pessoa já está cadastrado");
	//		return false;
	//	}
		client.setCpf(str);
		
		System.out.print("digite o nome do paciente: ");
		str = lerNome();
		client.setNome(str);
		
		System.out.print("digite a data de Nascimento: ");
		str = lerData();
	//	client.setDataNascimento(str);
		
		System.out.print("digite o endereço do paciente: ");

		System.out.print("Cep: ");
		str = sc.nextLine();
		endereco.setCep(str);
		System.out.print("rua: ");
		str = sc.nextLine();
		endereco.setRua(str);
		System.out.print("bairro: ");
		str = sc.nextLine();
		endereco.setBairro(str);
		System.out.print("Cidade: ");
		str = sc.nextLine();
		endereco.setCidade(str);
		System.out.print("digite o Estado: ");
		str = sc.nextLine();
		endereco.setEstado(str);
		
		client.setEndereco(endereco);
		
		if(!ic.addPessoa(client)){
			System.out.println("erro ao cadastrar paciente");
			return false;
		}
		return true;
	}
	
	public static int lerInteiro(){
		Scanner sc = new Scanner(System.in);
		
		if( !sc.hasNextInt())
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um numero: ");
			return lerInteiro();
		}
		return sc.nextInt();
	}
	
	public static String lerDocumento(){
		Scanner sc = new Scanner(System.in);
		
		if( !sc.hasNextInt())
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um numero: ");
			return lerDocumento();
		}
		return sc.nextLine();
	}
	
	public static String lerNome(){
		Scanner sc = new Scanner(System.in);
		if( sc.hasNextDouble()  ||  sc.hasNextInt() )
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um nome: ");
			return lerNome();
		}
		return sc.nextLine();
	}
	
	public static String lerData()throws ParseException{
		Scanner sc = new Scanner(System.in);
		String leitor, res;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		leitor = sc.nextLine();
		if(sdf.parse(leitor)==null)
		{
			System.out.println("voce deve digitar a data no formato solicitado(dd/MM/yyyy): ");
			return lerData();
		}
		return leitor;
	}
	
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	private static Icontroller ic= new Controller();

	public static void main(String[] args) {

		Cliente      c=new Cliente();
		Cliente     c1=new Cliente();
		Funcionario  f=new Funcionario();

		/*comentario
		c.setCnh("123");
		c.setNome("Fabiano");
		c.setCpf("000");

		f.setCargo("gerente");
		f.setMatricula("321");
		f.setCpf("001");


		c1.setCnh("111");
		c1.setNome("Roberto");
		c1.setCpf("011");


		ic.addPessoa(f);
		ic.addPessoa(c);
		ic.addPessoa(c1);

		System.out.println(ic.listarPessoa().toString());
		
		for (Cliente cli : ic.listarCliente()) {
			
			if(cli.getCnh().equals("111")){
				System.out.println(cli.toString());
			}
			
		}
		System.out.println("Removendo..");
		ic.removerPessoa("123");
		ic.removerPessoa("000");
		System.out.println(ic.listarPessoa().toString());

		
		/*
		
		ic.listarCliente("123");
		ic.listarCliente("111");
		ic.listarCliente("123");

	}*/

}
