package view;

import java.io.Serializable;

import controller.*;


public class Principal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icontroller ic= new Controller();

	public static void main(String[] args) {

		Cliente      c=new Cliente();
		Cliente     c1=new Cliente();
		Funcionario  f=new Funcionario();

		/*comentario*/
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
*/
	}

}
