package presenters;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import models.user.UserDAO;
import models.user.UserModel;
import views.SignUpView;

public class SignUpPresenter {
    protected SignUpView signUpView;
    protected UserDAO userDAO;

    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
        this.userDAO = new UserDAO();
        showSignInView();
        addHandlers();
    }

    private void addHandlers() {
        this.signUpView.signUpBtn.setOnAction(action -> {
            String userName = this.signUpView.userNameFld.getText();
            String userEmail = this.signUpView.emailFld.getText();
            String userPassword = this.signUpView.passwordFld.getText();
            String userConfirmPassword = this.signUpView.confirmPasswordFld.getText();

            boolean ableToRetrieveUsers = userDAO.retrieveAllUsers();

            if (ableToRetrieveUsers || userDAO.getData().isEmpty()) {
                ArrayList<UserModel> users = userDAO.getData();
                for (UserModel user : users) {
                    if (userEmail.equals(user.getEmail())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Email already exists!");
                        alert.show();
                    }
                }

                if (userPassword.equals(userConfirmPassword)) {
                    this.userDAO.add(new UserModel(userName, userEmail, userPassword, false));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Password and confirm password don't match!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Unexpected Error!");
                alert.show();
            }


            this.signUpView.userNameFld.clear();
            this.signUpView.emailFld.clear();
            this.signUpView.passwordFld.clear();
            this.signUpView.confirmPasswordFld.clear();

        });

    }

    private void showSignInView() {
        this.signUpView.signInBtn.setOnAction(action -> {
            coursex.CoursexUI.window.getScene().setRoot(coursex.CoursexUI.signInView);
        });
    }

}
