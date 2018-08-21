package control;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.AvaliaEspecialidade;
import model.Especialidade;
import model.Usuario;
import model.dao.AvaliaEspecialidadeDAO;
import model.dao.EspecialidadeDAO;





@ManagedBean(name = "avaliaespecialidadeMB")
public class AvaliaEspecialidadeMB implements Serializable {

	private AvaliaEspecialidade avalia = new AvaliaEspecialidade();
	private Especialidade especialidade = new Especialidade();
	private EspecialidadeDAO especialidadedao = new EspecialidadeDAO();
	private Usuario usuario;
	private AvaliaEspecialidadeDAO dao = new AvaliaEspecialidadeDAO();
	private int numero;
	private int nota;
	private boolean disponibilidade;
	private String comentario;
	private Date data;
	
	
	
	private List<AvaliaEspecialidade> lista;
	
	
	
public String incluirAvaliaEspecialidade(Especialidade especialidadex, EspecialidadeMB espe) throws IOException {
		
		avalia.setNota(nota);
		avalia.setEspecialidade(especialidadex);
		avalia.setComentario(comentario);

		
		dao.salvar(avalia);
		
		 lista = dao.lerTodos();
		
	

		for (Iterator<AvaliaEspecialidade> it = lista.iterator(); it.hasNext();) {
			AvaliaEspecialidade avaliaespecialidade = it.next();
			if (!(avaliaespecialidade.getEspecialidade().getMatricula()==avalia.getEspecialidade().getMatricula())) {
				it.remove();
			}
		}
		
		
		float media=0;
		
		for (Iterator<AvaliaEspecialidade> it = lista.iterator(); it.hasNext();) {
			AvaliaEspecialidade avaliaespecialidade = it.next();
			media+= avaliaespecialidade.getNota();
			
		}
		
		
		media = media / lista.size();
		System.out.println(media);
	
		especialidade = especialidadedao.lerPorId(avalia.getEspecialidade().getMatricula());
		especialidade.setAvaliação(media);
		especialidadedao.salvar(especialidade);
		
		//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    //ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		
		////// atualizando a  busca
		espe.setLista(espe.getDao().lerTodos());
		
		String rato = espe.getEspecialidade().getNome();

		for (Iterator<Especialidade> it = espe.getLista().iterator(); it.hasNext();) {
			Especialidade especialidade = it.next();
			if (!(especialidade.getNome().toLowerCase().indexOf(espe.getNome().toLowerCase()) != -1)) {
				it.remove();
			}
		}

		if (lista.isEmpty()) {

			System.out.println("SUPER MEGA TESTE");
			int i;

			for (i = 1; i < 5 && lista.isEmpty(); i++) {

				lista = dao.lerTodos();
				
				for (Iterator<Especialidade> it = espe.getLista().iterator(); it.hasNext();) {
					Especialidade especialidade = it.next();
					
					System.out.println(espe.getNome().substring (0, espe.getNome().length() - i));
					
					if (!(especialidade.getNome().toLowerCase().indexOf(espe.getNome().substring (0, espe.getNome().length() - i).toLowerCase()) != -1)) {
						it.remove();
					}
				}
			}
		}
	/////////////// fim da atualização
		
		return "index.jsf";
	}
	
	
	public AvaliaEspecialidade getAvalia() {
		return avalia;
	}
	public void setAvalia(AvaliaEspecialidade avalia) {
		this.avalia = avalia;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public AvaliaEspecialidadeDAO getDao() {
		return dao;
	}
	public void setDao(AvaliaEspecialidadeDAO dao) {
		this.dao = dao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
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
	
	
}
	

		
	

	
	



