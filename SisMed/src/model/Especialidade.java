package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATRICULA")
	@SequenceGenerator(name = "ID_MATRICULA", sequenceName = "SEQ_ESPECIALIDADE", allocationSize = 1)
	private int matricula;
	private String nome;
	private float avalia��o;
	private boolean disponibilidade;
	@ManyToOne
	private UnidadeSaude unidade;
	
	
	public int avaliacaoint() {
		
		return (int) this.getAvalia��o();
		
	}
	
	
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
	public float getAvalia��o() {
		return avalia��o ;
	}
	public void setAvalia��o(float avalia��o) {
		this.avalia��o = avalia��o;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public UnidadeSaude getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeSaude unidade) {
		this.unidade = unidade;
	}
	public Especialidade(int matricula, String nome, float avalia��o, boolean disponibilidade, UnidadeSaude unidade) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.avalia��o = avalia��o;
		this.disponibilidade = disponibilidade;
		this.unidade = unidade;
	}
	public Especialidade() {
		// TODO Auto-generated constructor stub
	}

	
	
	

}
