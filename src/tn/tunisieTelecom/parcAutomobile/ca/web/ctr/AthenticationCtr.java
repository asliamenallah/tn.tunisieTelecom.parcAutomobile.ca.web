package tn.tunisieTelecom.parcAutomobile.ca.web.ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.tunisieTelecom.parcAutomobile.ca.entity.User;
import tn.tunisieTelecom.parcAutomobile.ca.service.local.UserEJBLocal;

@ManagedBean
@SessionScoped
public class AthenticationCtr {
	private String login;
	private String pass;
	User user= new User() ;
	
	@EJB
	UserEJBLocal ejbLocal ;
	
	public String doLogin() {
		user.setLogin(login);
		user.setPasswd(pass);
		user = ejbLocal.authentication(login,pass);
		if(user == null)
			return "index?faces-redirect=true";
		else
		return "profile?faces-redirect=true" ;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
