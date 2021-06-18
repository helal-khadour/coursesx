package presenters;

import java.util.ArrayList;

import coursex.CoursexUI;
import models.user.UserDAO;
import models.user.UserModel;
import views.SignUpView;

public class SignUpPresenter {
    protected CoursexUI coursexUI;
    protected SignUpView signUpView;
    protected UserDAO userDAO;

    public SignUpPresenter(SignUpView SignUpView) {
        this.signUpView = SignUpView;
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

            if (userDAO.retrieveAllUsers()) {
                ArrayList<UserModel> users = userDAO.getData();
                for (UserModel user : users) {
                    if (userEmail.equals(user.getEmail())) {
                        // TODO handle the error
                    }
                }

                if (userPassword.equals(userConfirmPassword)) {
                    this.userDAO.add(new UserModel(userName, userEmail, userPassword, false));
                } else {
                    // TODO handle the error
                }
            } else {
                // TODO handle the error
            }


            this.signUpView.userNameFld.clear();
            this.signUpView.emailFld.clear();
            this.signUpView.passwordFld.clear();
            this.signUpView.confirmPasswordFld.clear();

        });

    }

    private void showSignInView() {
        this.signUpView.signInBtn.setOnAction(action -> {
            coursex.CoursexUI.window.getScene().setRoot(coursex.CoursexUI.SignInView);
        });
    }

}
