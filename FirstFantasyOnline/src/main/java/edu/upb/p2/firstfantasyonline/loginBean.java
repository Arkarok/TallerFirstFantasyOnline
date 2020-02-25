/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.p2.firstfantasyonline;

import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author informatica
 */
@Named(value = "loginBean")
@Dependent
public class loginBean implements Serializable{

    private String username;
    private String password;
    
    public loginBean() {
    }
    
    public void login(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (this.username.equals("admin") && this.password.equals("admin")) {
            context.getExternalContext().getSessionMap().put("user", username);
            
            try {
                context.getExternalContext().redirect("home.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            context.addMessage(null, new FacesMessage("La autenticación."));
        }
    }
    
    public void logout() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        
        try {
            context.getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
}
