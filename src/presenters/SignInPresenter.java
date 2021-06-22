package presenters;

import java.io.FileNotFoundException;

import coursex.CoursexUI;
import javafx.scene.control.Alert;
import models.user.UserDAO;
import views.CoursesView;
import views.SignInView;
import utils.HelperFunctions;
import views.SignUpView;


public class SignInPresenter {
    protected SignInView signInView;
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

            if (userDAO.retrieveUser(userEmail, userPassword)) {
                System.out.println("Welcome back, " + userEmail);
                CoursexUI.myProfile = userDAO.getData().get(0);
                try {
                    CoursesView coursesView = new CoursesView();
                    CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
                    CoursexUI.window.getScene().setRoot(coursesView);
                    CoursexUI.window.setMaximized(true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email or Password not correct!");
                alert.show();
            }
        });

    }

    private void showSignUpView() {
        SignUpView signUpView = new SignUpView();
        SignUpPresenter signUpPresenter = new SignUpPresenter(signUpView);

        this.signInView.signUpBtn.setOnAction(action -> {
            coursex.CoursexUI.window.getScene().setRoot(signUpView);
        });
    }

    private void emailValidation() {
        this.signInView.emailFld.setOnKeyPressed(e -> {
            this.signInView.emailValidate.setVisible(!HelperFunctions.isValidEmail(this.signInView.emailFld.getText())
                    && (!this.signInView.emailFld.getText().equals("")));
        });
    }

    private void passwordValidation() {
        this.signInView.passwordFld.setOnKeyPressed(e -> {
            this.signInView.passwordValidate.setVisible(!isValidPassword(this.signInView.passwordFld.getText()));
        });
    }


    public boolean isValidPassword(String password) {
        return password.length() >= 7;
    }
}

