package controller;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import dao.ControllerDao;
import dao.Idao;

public class ColecaoLocacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Locacao> locacoes;
	private Idao id=new ControllerDao();
	private static String localizacao = new String("locacoes.obj");

	public ColecaoLocacao() {

		this.locacoes = new ArrayList<Locacao>();
		/*if(id.verificarArquivo(localizacao)){
			carregarArqDeLocacoes();
		}*/
	}
	
	public boolean carregarArqDeLocacoes()throws Exception{
		
		try{
			if(id.verificarArquivo(localizacao)){
				this.locacoes = (ArrayList<Locacao>) id.carregarArq(localizacao);
			//	System.out.println(this.pessoas.toString());
				if(this.locacoes!=null){
					return true;
				}	
			}
		}catch(Exception e){
			System.err.println("erro ao carregar arquivo");
		}
		return false;
	}

	public boolean addLocacao(Locacao locacao)throws Exception{
		
		try{
			if (!locacao.equals(locacao)){
				locacoes.add(locacao);
	//			id.salvarEmArq(this.locacoes, localizacao);
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao adicionar locacao");
		}
		return false;
		
	}

	public boolean removerLocacao(int id)throws Exception{

		try{
			for (Locacao locacao : locacoes) {
				if (locacao.getId()==id){
					locacoes.remove(id);
	//				this.id.salvarEmArq(this.locacoes, localizacao);
					return true;
				}
			}
			
		}catch(Exception e){
			System.err.println("erro ao remover locacao");
		}
		return false;

	}
	
	
	
	public ArrayList<Locacao> listarLocacoes(){
		return this.locacoes;
			
	}
/*	
 * Verificar necessidade
 * 
 * 
	public Locacao editarLocacao(int id){
		
		for (Locacao locacao : locacoes) {
			if (locacao.getId()==id){
				return locacao;
			}

		}
		return null;
		
		
	}
	*/
	
}
