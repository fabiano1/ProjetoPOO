package controller;

public class Endereco {
	private String estado;
	private String Cidade;
	private String Bairro;
	private String cep;
	private String rua;
	private int numero;
	
	
	
	public Endereco(String estado, String cidade, String bairro, String cep, String rua, int numero) {
		super();
		this.estado = estado;
		Cidade = cidade;
		Bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (Bairro == null) {
			if (other.Bairro != null)
				return false;
		} else if (!Bairro.equals(other.Bairro))
			return false;
		if (Cidade == null) {
			if (other.Cidade != null)
				return false;
		} else if (!Cidade.equals(other.Cidade))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (numero != other.numero)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bairro == null) ? 0 : Bairro.hashCode());
		result = prime * result + ((Cidade == null) ? 0 : Cidade.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + numero;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Funcionario [estado=" + estado + ", Cidade=" + Cidade + ", Bairro=" + Bairro + ", cep=" + cep + ", rua="
				+ rua + ", numero=" + numero + "]";
	}
	

}
