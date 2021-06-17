package presenters;

import coursex.CoursexUI;
import views.SignInView;


public class SignInPresenter {
    public SignInView SignInView ;
    public CoursexUI CoursexUI;

    public SignInPresenter( SignInView SignInView)
    {
        this.SignInView=SignInView;
        showSignUpView();
    }
    private void showSignUpView()
    {
        this.SignInView.signUpBtn.setOnAction(action->{
            this.CoursexUI.window.getScene().setRoot(CoursexUI.SignUpView);
        });
    }
}

