package presenters;

import java.util.ArrayList;

import coursex.CoursexUI;
import models.user.UserDAO;
import models.user.UserModel;
import views.SignInView;


public class SignInPresenter {
    protected SignInView signInView;
    protected CoursexUI coursexUI;
    protected UserDAO userDAO;


    public SignInPresenter(SignInView SignInView) {
        this.signInView = SignInView;
        this.userDAO = new UserDAO();
        addHandlers();
        showSignUpView();

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
}

