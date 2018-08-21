package model;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class UnidadeSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATRICULA2")
	@SequenceGenerator(name = "ID_MATRICULA2", sequenceName = "SEQ_UNIDADE", allocationSize = 1)
	private int matricula;
	private String nome;
	private float avaliação;
	private String Endereço;
	//@OneToMany(mappedBy="unidadesaude")
	//private ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();
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
		return avaliação;
	}
	public void setAvaliação(float avaliação) {
		this.avaliação = avaliação;
	}
	public String getEndereço() {
		return Endereço;
	}
	public void setEndereço(String endereço) {
		Endereço = endereço;
	}
	public UnidadeSaude(int matricula, String nome, float avaliação, String endereço) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.avaliação = avaliação;
		Endereço = endereço;
	}
	public UnidadeSaude() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	
}
