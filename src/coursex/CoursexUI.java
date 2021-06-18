package coursex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenters.CreateCoursePresenter;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.CreateCourseView;
import views.SignInView;
import views.SignUpView;

import java.io.FileNotFoundException;

public class CoursexUI extends Application {

    public static Stage window;
    public static SignUpView SignUpView = new SignUpView();
    public static SignInView SignInView = new SignInView();
    public static CreateCourseView CreateCourseView;

    static {
        try {
            CreateCourseView = new CreateCourseView();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start(Stage primaryStage) {
        window = primaryStage;

        SignInPresenter SignInPresenter = new SignInPresenter(SignInView);
        SignUpPresenter SignUpPresenter = new SignUpPresenter(SignUpView);
        CreateCoursePresenter CreateCoursePresenter = new CreateCoursePresenter(CreateCourseView);

        window.setTitle("courseX Platform");
        Scene mainScene = new Scene(CreateCourseView, 450, 600);

        window.setScene(mainScene);
        window.setFullScreen(true);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}