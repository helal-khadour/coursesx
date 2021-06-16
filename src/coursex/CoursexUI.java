package coursex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.SignInView;
import views.SignUpView;

public class CoursexUI extends Application {
    public Stage window;
    public void start(Stage primaryStage) {
        window = primaryStage;
        SignInView SignInView = new SignInView();
        SignUpView SignUpView = new SignUpView();

        SignInPresenter SignInPresenter = new SignInPresenter(SignInView, window );
        SignUpPresenter SignUpPresenter = new SignUpPresenter(SignUpView, window );

        window.setTitle("courseX Platform");
        Scene logInScene = new Scene(SignUpView, 450, 600);
        window.setScene(logInScene);
        window.setMaxHeight(window.getScene().getHeight()+20);
        window.setMaxWidth(window.getScene().getWidth()+20);
        window.setMinWidth(window.getScene().getWidth()+20);
        window.setMinHeight(window.getScene().getHeight()+20);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}