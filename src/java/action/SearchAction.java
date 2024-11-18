/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import java.util.List;
import model.User;

/**
 *
 * @author itcrc
 */
public class SearchAction extends ActionSupport {
    private String searchId;
    
    private List<User> users;

    
    public SearchAction() {
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
    
    @Override
    public String execute() throws Exception {
        UserDAO userdao = new UserDAO();
        users  = userdao.sarchUser(searchId);
        return SUCCESS;
        
    }
    
}
