/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;

import model.User;

/**
 *
 * @author itcrc
 */
public class UserAction extends ActionSupport {
    
    private User user;
    private String fname;
    private String lname;

    // Getters and Setters for fname and lname
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
    public UserAction() {
    }
    
    
    @Override
public String execute() throws Exception {
    if (user == null) {
        user = new User();
        user.setFname(fname);
        user.setLname(lname);
    }
    
    UserDAO userdao = new UserDAO();
    
    
    if(user.getFname() != null || user.getLname() != null){
        userdao.SaveUser(user);
    return SUCCESS;
    }
        
    return ERROR;
    }







}
