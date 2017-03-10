package controller;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cargo;
	private String matricula;
	

	public Funcionario(String nome, Endereco endereco, String cpf, String login, String senha, LocalDate dataNascimento,
			String cargo, String matricula) {
		super(nome, endereco, cpf, login, senha, dataNascimento);
		this.cargo = cargo;
		this.matricula = matricula;
	}


	public Funcionario() {
		// TODO Auto-generated constructor stub
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", matricula=" + matricula + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getCpf()=" + getCpf() + ", getLogin()=" + getLogin()
				+ ", getSenha()=" + getSenha() + ", getDataNascimento()=" + getDataNascimento() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
	
	
	
	
	

}
