package presenters;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.SignInView;
import views.SignUpView;

public class SignUpPresenter {
    public views.SignInView SignInView ;
    public views.SignUpView SignUpView;
    public Stage window;
    public Scene SignInScene;
    public SignUpPresenter( SignUpView SignUpView, Stage window)
    {
        this.window = window;
        this.SignUpView = SignUpView;
        showSignInView();
    }
    private void showSignInView()
    {
        this.SignUpView.signInBtn.setOnAction(action->{
            this.SignInView = new SignInView();
            this.SignInScene = new Scene(SignInView , 450, 601);;
            this.window.setScene(this.SignInScene);
            this.window.show();
            System.out.println("ss");
        });
    }
}
