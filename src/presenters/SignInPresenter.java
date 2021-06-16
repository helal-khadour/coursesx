package presenters;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.SignInView;
import views.SignUpView;

public class SignInPresenter {
    public SignInView SignInView ;
    public SignUpView SignUpView;
    public Stage window;
    public Scene SignUpScene;
    public SignInPresenter( SignInView SignInView, Stage window)
    {
        this.window = window;
        this.SignInView=SignInView;
        showSignUpView();
    }
    private void showSignUpView()
    {
        this.SignInView.signUpBtn.setOnAction(action->{
            this.SignUpView = new SignUpView();
            this.SignUpScene = new Scene(SignUpView, 450, 601);
            System.out.println(this.window.getScene());
            this.window.setScene(this.SignUpScene);
            this.window.show();
        });
    }
}

