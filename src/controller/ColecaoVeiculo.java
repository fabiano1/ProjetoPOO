package controller;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import dao.ControllerDao;
import dao.Idao;

public class ColecaoVeiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Veiculo> veiculos;
	private Idao id=new ControllerDao();
	private static String localizacao = new String("veiculos.obj");
	
	/*
	stream = id.recuparArq(this.veiculo,"veiculos.txt");
	(ArrayList<Veiculo>)stream;
	*/
	
	public ColecaoVeiculo(ArrayList<Veiculo> veiculo) {
		this.veiculos = veiculo;
	//	id.salvarEmArq(this.veiculos, localizacao);
	}

	public ColecaoVeiculo() {	 	
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	
	public boolean carregarArqDeVeiculos()throws Exception{
		
		try{
			if(id.verificarArquivo(localizacao)){
				this.veiculos = (ArrayList<Veiculo>) id.carregarArq(localizacao);
			//	System.out.println(this.pessoas.toString());
				if(this.veiculos!=null){
					return true;
				}
			}
		}catch(Exception e){
			System.err.println("erro ao carregar arquivo");
		}
		return false;
	}


	public boolean addVeiculo(Veiculo v)throws Exception{
		try{
			if(!veiculos.contains(v)){
				veiculos.add(v);
				id.salvarEmArq(this.veiculos, localizacao);
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao adionar veiculo");
		}
		return false;
		
			/**
			 * id.salvarEmArq(this.veiculo,"veiculos.txt");
			 * 		Colocar um método para salvar no aquivo passando a caleção como paramentro
			 */
	}

	public ArrayList<Veiculo> listarVeiculos()throws Exception{
		try{
			//if(!this.veiculos.isEmpty()){
				return this.veiculos;
			//}
		}catch(Exception e){
			System.err.println("erro ao listar veiculos");
		}
			return null;
	}
	
	public ArrayList<Veiculo> listarVeiculosDisponiveis()throws Exception {
		try{
			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

			for (Veiculo v : this.veiculos){

				if( v.isDisponibilidade()){
					veiculos.add(v);
				}
			}
			return veiculos;
		}catch(Exception e){
			System.err.println("erro ao listar veiculos disponiveis");
		}
		return null;

	} 

	public ArrayList<Automovel> listarAutomoveis()throws Exception {
		try{
			ArrayList<Automovel> automovel = new ArrayList<Automovel>();

			for (Veiculo veiculo : this.veiculos){

				if( veiculo instanceof Automovel){
					automovel.add((Automovel) veiculo);
				}
			}
			return automovel;
		}catch(Exception e){
			System.err.println("erro ao listar automoveis");
		}
		return null;

	} 
	
	public ArrayList<Motocicleta> listarMotocicleta()throws Exception {
		try{
			ArrayList<Motocicleta> motocicleta = new ArrayList<Motocicleta>();

			for (Veiculo veiculo : this.veiculos){

				if( veiculo instanceof Motocicleta){
					motocicleta.add((Motocicleta) veiculo);
				}
			}
			return motocicleta;
		}catch(Exception e){
			System.err.println("erro ao listar motocicletas");
		}
		return null;

	} 
	public boolean removerVeiculo(String placa) throws Exception{
		try{
		//	Idao id;
			//ObjectInputStream stream;
			
			for (Veiculo v : this.veiculos) {
				if(v.getPlaca().getNumerosEletras().equalsIgnoreCase(placa)){
					this.veiculos.remove(v);
					id.salvarEmArq(this.veiculos,localizacao);
					return true;
				}
			}

		}catch(Exception e){
			System.err.println("erro ao remover veiculo");
		}
		
		/*
		id.salvarEmrArq(this.veiculo,"veiculos.txt");
		*/
		return false;
	}
	

}
