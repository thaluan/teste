package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class FlexGridView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> columns;
 
    @PostConstruct
    public void init() {
        columns = new ArrayList<Integer>();
        for (int i = 1; i <7; i++) {
            columns.add(i);
        }
    }
 
    public List<Integer> getColumns() {
        return columns;
    }
 
    public void setColumns(List<Integer> columns) {
        this.columns = columns;
    }
 
    public void increment() {
        if (columns.size() < 20) {
            columns.add(columns.size() + 1);
        }
    }
 
    public void decrease() {
        if (columns.size() > 1) {
            columns.remove(columns.size() - 1);
        }
    }
}                 