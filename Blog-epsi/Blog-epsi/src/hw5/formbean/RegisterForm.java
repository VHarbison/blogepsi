package hw5.formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RegisterForm {
	private String email;
    private String password1;
    private String password2;
    private String firstName;
    private String lastName;
    private String button;
    private static final String EMAIL_PATTERN =
    		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public RegisterForm(HttpServletRequest request) {
        this.email = request.getParameter("email");
        this.password1 = request.getParameter("password1");
        this.password2 = request.getParameter("password2");
        this.firstName = request.getParameter("firstName");
        this.lastName = request.getParameter("lastName");
        this.button = request.getParameter("button");
    }



    public String getEmail() {
		return email;
	}



	public String getPassword1() {
		return password1;
	}



	public String getPassword2() {
		return password2;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getButton() {
		return button;
	}



	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.length() == 0) {
            errors.add("Email requis");
        }
        
        if (firstName == null || firstName.length() == 0) {
            errors.add("Prénom requis");
        }
        
        if (lastName == null || lastName.length() == 0) {
            errors.add("nom requis");
        }
        
        if (password1 == null || password1.length() == 0) {
            errors.add("Mot de passe requis");
        }
        
        if (password2 == null || password2.length() == 0) {
            errors.add("Mot de passe requis");
        }
        
        if (button == null) {
            errors.add("Action requise");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!button.equals("s'enregistrer")) {
            errors.add("erreur");
        }
        
        if (!password1.equals(password2)) {
    		errors.add("mot de passe non concordant");
        }

        if (!email.matches(EMAIL_PATTERN)) {
            errors.add("email invalide");
        }
        
        if (firstName.matches(".*[<>\"].*")) {
            errors.add("ne pas mettre de caractères spéciaux");
        }
        
        if (lastName.matches(".*[<>\"].*")) {
            errors.add("ne pas mettre de caractères spéciaux");
        }
        
        
        return errors;
    }
}
