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
public class GetData extends ActionSupport {
    private List<User> users;

    // Fetch all users
    @Override
    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        users = userDAO.getAllUsers();  // Call the DAO method to get users
        return SUCCESS;  // Return success to load the JSP page
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    

}
