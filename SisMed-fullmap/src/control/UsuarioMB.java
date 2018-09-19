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
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import model.Especialidade;
import model.Usuario;
import model.dao.UsuarioDAO;


@SessionScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Especialidade especialidade;
	private int matricula;
	private String nome;
	private String senha;
	private String email;
	private UsuarioDAO dao = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();
	private boolean logado = false;
	
	
	
	
	

	public String recarregar() throws IOException {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	    
	    return "index.jsf";
	    

	}
	
	public void acaoAutenticar() {

		lista = dao.lerTodos();
		
		for (Iterator<Usuario> it = lista.iterator(); it.hasNext();) {
			Usuario user = it.next();
			if (!(user.getNome().toLowerCase().equals(this.getNome().toLowerCase()))) {
				it.remove();
			}
		}
		
		if(!(lista.isEmpty())) {
			
			for (Iterator<Usuario> it = lista.iterator(); it.hasNext();) {
				Usuario user = it.next();
				if (user.getSenha().equals(this.getSenha()) ) {
					System.out.println("achado");
					setLogado(true);
					this.setUsuario(user);
					
				}
			}
			
			
			
			
		}
		
		if(logado==false) {
			
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("$('.modalPseudoClasslLoginNegado').modal()");
			
			
		}
		
	}
	

	
	
	public String acaoPagCadastro() {
		
		return "cadastro.jsf";
		
	}
	
public String acaoPagAvalia(Especialidade especialidadex) {
		
		System.out.println("return avalia");
		this.especialidade= especialidadex;
		return "avalia.jsf";
		
	}
	
	public String voltarPrincipal() {
		return "index.jsf";
	}

	
	public String realizarCadastro() {
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		
		if(dao.salvar(usuario) != null) {
			
			acaoAutenticar();
		}
		return "index.jsf";
		
	}
	
	
	
	public String acaoLogout() {
		this.usuario = new Usuario(0,null,null,null);
		this.matricula=0;
		this.nome = null;
		this.senha = null;

		
		FacesContext fc = FacesContext.getCurrentInstance();
		if(fc!=null) {
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();}

		// encerrar a sessão atual
		

		return null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioDAO getDao() {
		return dao;
	}
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}
	public List<Usuario> getLista() {
		return lista;
	}
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Especialidade getEspecialidade() {
		return especialidade;
	}




	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	

}
