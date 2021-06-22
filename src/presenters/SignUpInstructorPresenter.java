package presenters;

import coursex.CoursexUI;
import javafx.scene.control.Alert;
import models.user.UserDAO;
import models.user.UserModel;
import views.CoursesView;
import views.SignUpInstructorView;
import views.SignUpView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SignUpInstructorPresenter {
    protected SignUpInstructorView signUpInstructorView;
    protected UserDAO userDAO;

    public SignUpInstructorPresenter(SignUpInstructorView signUpInstructorView) {
        this.signUpInstructorView = signUpInstructorView;
        this.userDAO = new UserDAO();
        showSignInView();
        addHandlers();
    }

    private void addHandlers() {
        this.signUpInstructorView.signUpBtn.setOnAction(action -> {
            String userName = this.signUpInstructorView.userNameFld.getText();
            String userEmail = this.signUpInstructorView.emailFld.getText();
            String userPassword = this.signUpInstructorView.passwordFld.getText();
            String userConfirmPassword = this.signUpInstructorView.confirmPasswordFld.getText();

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
                    this.userDAO.add(new UserModel(userName, userEmail, userPassword, true));
                    CoursexUI.myProfile = this.userDAO.getData().get(0);
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
                    alert.setContentText("Password and confirm password don't match!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Unexpected Error!");
                alert.show();
            }


            this.signUpInstructorView.userNameFld.clear();
            this.signUpInstructorView.emailFld.clear();
            this.signUpInstructorView.passwordFld.clear();
            this.signUpInstructorView.confirmPasswordFld.clear();

        });
    }

    private void showSignInView() {
        this.signUpInstructorView.signInBtn.setOnAction(action -> {
            coursex.CoursexUI.window.getScene().setRoot(coursex.CoursexUI.signInView);
        });
    }
}