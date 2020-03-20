/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.login;

import com.mycompany.project_to2.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utils.SessionUtils;

/**
 *
 * @author Ele
 */
@Named(value = "login2")
@SessionScoped
public class Login2 implements Serializable {

    /**
     * Creates a new instance of Login2
     */
    public Login2() {
    }
    private String pwd;
	private String msg;
	private String user;
        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() throws ClassNotFoundException {
		boolean valid = LoginDAO.validate(user, pwd);
                Users userName = LoginDAO.getUserName(user, pwd);
                boolean isAdmin= LoginDAO.isAdmin(user, pwd);
                this.name= userName.getName();
		if ((valid)&& !(isAdmin)) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("user", user);
                        session.setAttribute("name", name);
			return "shop";
		} else if((valid)&& isAdmin){
                    HttpSession session = SessionUtils.getSession();
			session.setAttribute("user", user);
                        //session.setAttribute("name", name);
			return "clients";
                }else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passoword",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
    
}
