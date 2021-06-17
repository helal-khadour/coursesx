package coursex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.SignInView;
import views.SignUpView;

public class CoursexUI extends Application {

    public static Stage window;
    public static SignUpView SignUpView = new SignUpView();
    public static SignInView SignInView = new SignInView();
    public void start(Stage primaryStage) {
        window = primaryStage;

        SignInPresenter SignInPresenter = new SignInPresenter(SignInView);
        SignUpPresenter SignUpPresenter = new SignUpPresenter(SignUpView);

        window.setTitle("courseX Platform");
        Scene mainScene = new Scene(SignInView , 450, 600);

        window.setScene(mainScene);
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