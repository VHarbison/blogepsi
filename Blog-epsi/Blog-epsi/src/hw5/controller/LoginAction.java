package hw5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.genericdao.RollbackException;


import hw5.databean.User;
import hw5.formbean.LoginForm;
import hw5.model.Model;
import hw5.model.UserDAO;

public class LoginAction extends Action {
    private UserDAO userDAO;

    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "Login.do";
    }
    
    
    public String performGet(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "Home.do";
        }
        

        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
            request.setAttribute("users", userDAO.getUsers());
            return "Login.jsp";
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
        
    }

    
    public String performPost(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "Home.do";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
            LoginForm form = new LoginForm(request);
            request.setAttribute("form", form);
            request.setAttribute("users", userDAO.getUsers());
            

            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
            		return "Login.jsp";
            }
            
            if (form.getButton().equals("s'enregistrer")) {
                return "Register.do";
            }

            User user = userDAO.read(form.getEmail());
            if (user == null) {
                errors.add("Utilisateur introuvable");
                return "Login.jsp";
            }

            if (!form.getPassword().equals(user.getPassword())) {
                errors.add("mot de passe incorect");
                return "Login.jsp";
            }

            session.setAttribute("user", user);
            

            return "Home.do";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
