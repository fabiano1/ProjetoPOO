package controller;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cnh;
	private String categoriaCnh;
	
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, Endereco endereco, String cpf, String login, String senha, LocalDate dataNascimento,
			String cnh, String categoriaCnh) {
		super(nome, endereco, cpf, login, senha, dataNascimento);
		this.cnh = cnh;
		this.categoriaCnh = categoriaCnh;
	}


	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((categoriaCnh == null) ? 0 : categoriaCnh.hashCode());
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (categoriaCnh == null) {
			if (other.categoriaCnh != null)
				return false;
		} else if (!categoriaCnh.equals(other.categoriaCnh))
			return false;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cnh=" + cnh + ",\n categoriaCnh=" + categoriaCnh + ",\n getNome()=" + super.getNome()
				+ ",\n getEndereco()=" + super.getEndereco() + ",\n getCpf()=" + super.getCpf() + ",\n getLogin()=" + getLogin()
				+ ",\n getSenha()=" + super.getSenha() + ",\n getDataNascimento()=" + super.getDataNascimento() + ",\n toString()="
				+ super.toString() + ",\n getClass()=" + getClass() + "]\n";
		
	}
	
	

}
