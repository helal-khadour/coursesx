package coursex;

import components.CardComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.user.UserModel;
import presenters.CoursesPresenter;
import presenters.CreateCoursePresenter;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.*;


import java.io.FileNotFoundException;

public class CoursexUI extends Application {

    public static Stage window;
    public static SignInView signInView = new SignInView();
    public static UserModel myProfile;

    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        SignInPresenter SignInPresenter = new SignInPresenter(signInView);

        window.setTitle("CourseX Platform");
        Scene mainScene = new Scene(signInView, 800, 500);

        window.setScene(mainScene);
//        window.setResizable(false);
        window.setMaximized(true);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}