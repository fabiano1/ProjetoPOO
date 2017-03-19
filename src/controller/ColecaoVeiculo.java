package controller;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import dao.ControllerDao;
import dao.Idao;

public class ColecaoVeiculo {
	private ArrayList<Veiculo> veiculos;
	
	/*
	stream = id.recuparArq(this.veiculo,"veiculos.txt");
	(ArrayList<Veiculo>)stream;
	*/
	
	public ColecaoVeiculo(ArrayList<Veiculo> veiculo) {
		this.veiculos = veiculo;
	}

	public ColecaoVeiculo() {

		this.veiculos = new ArrayList<Veiculo>();
	}


	public boolean addVeiculo(Veiculo v)throws Exception{
		try{
			if(!veiculos.contains(v)){
				veiculos.add(v);
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
			if(!this.veiculos.isEmpty()){
				return this.veiculos;
			}
		}catch(Exception e){
			System.err.println("eero ao listar veiculos");
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
			System.err.println("Erro ao listar clientes");
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
			System.err.println("Erro ao listar clientes");
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
			System.err.println("Erro ao listar clientes");
		}
		return null;

	} 

	public Veiculo pesquisarVeiculo(String placa)throws Exception {
		try{

			for (Veiculo v : this.veiculos){

				if( v.getPlaca().getNumerosEletras().equals(placa)){
					return v;
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao listar clientes");
		}
		return null;

	} 
	
	public boolean removerVeiculo(String placa) throws Exception{
		try{
			for (Veiculo v : this.veiculos) {
				if(v.getPlaca().getNumerosEletras().equals(placa)){
					this.veiculos.remove(v);
				}
			}
			Idao id;
			ObjectInputStream stream;
			return true;
		}catch(Exception e){
			System.err.println("erro ao remover");
		}
		
		/*
		id.salvarEmrArq(this.veiculo,"veiculos.txt");
		*/
		return false;
	}
	

}
