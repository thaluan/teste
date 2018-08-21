package control;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.Especialidade;
import model.UnidadeSaude;
import model.dao.EspecialidadeDAO;
import model.dao.UnidadeSaudeDAO;


@SessionScoped
@ManagedBean(name = "especialidadeMB")
public class EspecialidadeMB implements Serializable {

	private int matricula;
	private String nome;
	private float avaliação;
	private boolean disponibilidade;
	private UnidadeSaude unidade = new UnidadeSaude();
	private UnidadeSaudeDAO dao1 = new UnidadeSaudeDAO();

	private Especialidade especialidade = new Especialidade();
	private EspecialidadeDAO dao = new EspecialidadeDAO();
	private List<Especialidade> lista = new ArrayList<Especialidade>();;

	public String buscarEspecialidade() throws IOException {
		System.out.println("teste");
		lista = dao.lerTodos();
		lista.isEmpty();
		String rato = especialidade.getNome();

		for (Iterator<Especialidade> it = lista.iterator(); it.hasNext();) {
			Especialidade especialidade = it.next();
			if (!(especialidade.getNome().toLowerCase().indexOf(this.nome.toLowerCase()) != -1)) {
				it.remove();
			}
		}

		if (lista.isEmpty()) {

			System.out.println("SUPER MEGA TESTE");
			int i;

			for (i = 1; i < 5 && lista.isEmpty(); i++) {

				lista = dao.lerTodos();
				
				for (Iterator<Especialidade> it = lista.iterator(); it.hasNext();) {
					Especialidade especialidade = it.next();
					
					System.out.println(this.nome.substring (0, nome.length() - i));
					
					if (!(especialidade.getNome().toLowerCase().indexOf(this.nome.substring (0, nome.length() - i).toLowerCase()) != -1)) {
						it.remove();
					}
				}
			}
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	
	    return "index.jsf";
	    
	}
	
	

	public String pagBuscar() {

		System.out.println("trocar de pagina");
		return "index.jsf";
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
		return avaliação;
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public EspecialidadeDAO getDao() {
		return dao;
	}

	public void setDao(EspecialidadeDAO dao) {
		this.dao = dao;
	}

	public List<Especialidade> getLista() {
		
		
		return lista;
	}

	public void setLista(List<Especialidade> lista) {
		this.lista = lista;
	}

	

}
