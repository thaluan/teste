package model;


//import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class UnidadeSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATRICULA2")
	@SequenceGenerator(name = "ID_MATRICULA2", sequenceName = "SEQ_UNIDADE", allocationSize = 1)
	private int matricula;
	private String nome;
	private float avalia��o;
	private String Endere�o;
	private float latitude;
	private float longitude;
	
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
	public float getAvalia��o() {
		return avalia��o;
	}
	public void setAvalia��o(float avalia��o) {
		this.avalia��o = avalia��o;
	}
	public String getEndere�o() {
		return Endere�o;
	}
	public void setEndere�o(String endere�o) {
		Endere�o = endere�o;
	}
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public UnidadeSaude(int matricula, String nome, float avalia��o, String endere�o) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.avalia��o = avalia��o;
		Endere�o = endere�o;
	}
	public UnidadeSaude() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	
}
