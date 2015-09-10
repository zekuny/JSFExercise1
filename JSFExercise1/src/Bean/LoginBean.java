package Bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import dao.TodoUserDB;
import model.Todouser;

@ManagedBean
@RequestScoped
public class LoginBean {
	private Todouser user;
    private String message;
    
    public LoginBean() {
    }
    
    @PostConstruct
    public void init() {
        user = new Todouser();
    }
    
    public String checkuser() {
        if (TodoUserDB.userExists(user.getUsername())) {
        	user = TodoUserDB.selectUser(user.getUsername());
            message = "Successfully Logged in!";
            return "welcome";
        } else {
            //UserDB.insert(user);
            return "login";
        }
    }

    public Todouser getUser() {
        return user;
    }

    public void setUser(Todouser user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
}
