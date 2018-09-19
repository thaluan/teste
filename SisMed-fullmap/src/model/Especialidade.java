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
	private float avaliação;
	private boolean disponibilidade;
	@ManyToOne
	private UnidadeSaude unidade;
	
	
	public int avaliacaoint() {
		
		return (int) this.getAvaliação();
		
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
	public float getAvaliação() {
		return avaliação ;
	}
	public void setAvaliação(float avaliação) {
		this.avaliação = avaliação;
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
	public Especialidade(int matricula, String nome, float avaliação, boolean disponibilidade, UnidadeSaude unidade) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.avaliação = avaliação;
		this.disponibilidade = disponibilidade;
		this.unidade = unidade;
	}
	public Especialidade() {
		// TODO Auto-generated constructor stub
	}

	
	
	

}
