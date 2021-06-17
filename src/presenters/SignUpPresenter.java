package presenters;

import coursex.CoursexUI;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.SignInView;
import views.SignUpView;

public class SignUpPresenter {
    public CoursexUI CoursexUI;
    public views.SignUpView SignUpView;

    public SignUpPresenter( SignUpView SignUpView)
    {
        this.SignUpView = SignUpView;
        showSignInView();
    }
    private void showSignInView()
    {
        this.SignUpView.signInBtn.setOnAction(action->{
            this.CoursexUI.window.getScene().setRoot(CoursexUI.SignInView);
        });
    }

}
