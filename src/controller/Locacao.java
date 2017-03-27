package controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Locacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static int id=0;
	private LocalDate dataRetirada;
	private LocalDate dataDevolucao;
	private Pessoa pessoa;
	private Veiculo veiculo;
	
		
	
	/**
	 * 
	 */
	public Locacao() {
		
		super();
		
		id++;
	}
	
	public Locacao(LocalDate dataRetirada, LocalDate dataDevolucao, Pessoa pessoa, Veiculo veiculo) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.pessoa = pessoa;
		this.veiculo = veiculo;
		id++;
	}
	/**
	 * Calcula Valor da Locação
	 */
	public  double calcValorLoc(){
				
		Period p=Period.between(dataRetirada,dataDevolucao);
		
		return veiculo.getPrecoPorHra()*p.getDays();
	}
	public int getId() {
		return id;
	}
	
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataRetirada == null) {
			if (other.dataRetirada != null)
				return false;
		} else if (!dataRetirada.equals(other.dataRetirada))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nLocacao [dataRetirada=" + dataRetirada + ", dataDevolucao=" + dataDevolucao + ", pessoa[nome=" + pessoa.getNome()+ 
				", CPF=" + pessoa.getCpf() + ", Veiculo=" + veiculo.toString() + " Id da Locação: "+this.id+
				" Valor Da Localizacao "+calcValorLoc()+ "]\n";
	}
	
	
	

}
