package presenters;

import java.util.ArrayList;

import coursex.CoursexUI;
import models.user.UserDAO;
import models.user.UserModel;
import views.SignInView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignInPresenter {
    protected SignInView signInView;
    protected CoursexUI coursexUI;
    protected UserDAO userDAO;


    public SignInPresenter(SignInView SignInView) {
        this.signInView = SignInView;
        this.userDAO = new UserDAO();
        addHandlers();
        showSignUpView();
        emailValidation();
        passwordValidation();
    }

    private void addHandlers() {
        this.signInView.loginBtn.setOnAction(action -> {
            String userEmail = this.signInView.emailFld.getText();
            String userPassword = this.signInView.passwordFld.getText();

            if (userDAO.retrieveAllUsers()) {

                ArrayList<UserModel> users = userDAO.getData();
                for (UserModel user : users) {
                    if (userEmail.equals(user.getEmail())) {
                        if (userPassword.equals(user.getPassword())) {
                            // TODO handle successful login
                            System.out.println("Welcome back, " + user.getName());
                        } else {
                            // TODO handle wrong password error
                            System.out.println("Wrong Password!");
                        }
                    }
                }
                // TODO handle email not found error
                System.out.println("User not found!");
            }

        });

    }

    private void showSignUpView() {
        this.signInView.signUpBtn.setOnAction(action -> {
            coursex.CoursexUI.window.getScene().setRoot(coursex.CoursexUI.SignUpView);
        });
    }

    private void emailValidation() {
        this.signInView.emailFld.setOnKeyPressed(e -> {
            this.signInView.emailValidate.setVisible(!isValidEmail(this.signInView.emailFld.getText()) && (!this.signInView.emailFld.getText().equals("")));
        });
    }

    private void passwordValidation() {
        this.signInView.passwordFld.setOnKeyPressed(e -> {
            this.signInView.passwordValidate.setVisible(!isValidPassword(this.signInView.passwordFld.getText()));
        });
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 7;
    }
}

