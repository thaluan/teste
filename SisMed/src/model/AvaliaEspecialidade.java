package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AvaliaEspecialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_NUMERO")
	@SequenceGenerator(name = "ID_NUMERO", sequenceName = "SEQ_NUMERO", allocationSize = 1)
	private int numero;
	private float nota;
	private boolean disponibilidade;
	private String comentario;
	private Date data;
	@ManyToOne
	private Especialidade especialidade;
	@ManyToOne
	private Usuario usuario;
	
	public AvaliaEspecialidade(int numero, float nota, boolean disponibilidade, String comentario, Date data,
			Especialidade especialidade, Usuario usuario) {
		super();
		this.numero = numero;
		this.nota = nota;
		this.disponibilidade = disponibilidade;
		this.comentario = comentario;
		this.data = data;
		this.especialidade = especialidade;
		this.usuario = usuario;
	}
	public AvaliaEspecialidade() {
		// TODO Auto-generated constructor stub
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
		System.out.println("SUPER MEGA TESTE 2");
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
