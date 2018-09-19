package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATRICULA1")
	@SequenceGenerator(name = "ID_MATRICULA1", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	private int matricula;
	private String nome;
	private String senha;
	private String email;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario(int matricula, String nome, String senha, String email) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	

	
	
	

}
