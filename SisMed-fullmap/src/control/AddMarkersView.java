
	package control;



	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	import javax.annotation.PostConstruct;
	import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.context.FacesContext;

	import org.primefaces.model.map.DefaultMapModel;
	import org.primefaces.model.map.LatLng;
	import org.primefaces.model.map.MapModel;
	import org.primefaces.model.map.Marker;

	import model.Especialidade;
	import model.UnidadeSaude;
	import model.dao.UnidadeSaudeDAO;
	 
	@ManagedBean
	public class AddMarkersView implements Serializable {
	     
		
		
		
	    /**
		 * 
		 */
		
		UnidadeSaudeDAO dao = new UnidadeSaudeDAO();
		
		private List<UnidadeSaude> lista = new ArrayList<UnidadeSaude>();;
		
		private static final long serialVersionUID = 1L;

		private MapModel emptyModel;
	      
	    private String title;
	      
	    private double lat;
	      
	    private double lng;
	  
	    @PostConstruct
	    public void init() {
	        emptyModel = new DefaultMapModel();
	        lista = dao.lerTodos();
	        
	        
	        for(UnidadeSaude it :  lista) {
	        Marker marker = new Marker(new LatLng(it.getLatitude(),it.getLongitude()),it.getNome());
	        
	      
	        emptyModel.addOverlay(marker);
	        
	        }
	    }
	      
	    public MapModel getEmptyModel() {
	        return emptyModel;
	    }
	      
	    public String getTitle() {
	        return title;
	    }
	  
	    public void setTitle(String title) {
	        this.title = title;
	    }
	  
	    public double getLat() {
	        return lat;
	    }
	  
	    public void setLat(double lat) {
	        this.lat = lat;
	    }
	  
	    public double getLng() {
	        return lng;
	    }
	  
	    public void setLng(double lng) {
	        this.lng = lng;
	    }
	      
	    public void addMarker() {
	        Marker marker = new Marker(new LatLng(-22000, -4300), title);
	        emptyModel.addOverlay(marker);
	          
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
	    }
	}
	


