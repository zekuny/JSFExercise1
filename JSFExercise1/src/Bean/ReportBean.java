package Bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.TodoUserDB;
import model.Todouser;

@ManagedBean
@RequestScoped
public class ReportBean {
	private Todouser user;
    private String action;
    
    public ReportBean() {
    }
    
    @PostConstruct
    public void init() {
        user = new Todouser();
        action = "";
    }
    
    public void setAction(String action) {
		this.action = action;
	}
    
    public String getReport() {
    	user = TodoUserDB.selectUser(action);
        return "report";
    }

    public Todouser getUser() {
        return user;
    }

    public void setUser(Todouser user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }
}
