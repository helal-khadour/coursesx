package coursex;

import components.CardComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenters.CreateCoursePresenter;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.*;


import java.io.FileNotFoundException;

public class CoursexUI extends Application {

    public static Stage window;
    public static SignUpView SignUpView = new SignUpView();
    public static SignInView SignInView = new SignInView();
    public static CreateCourseView CreateCourseView;
    public static AllCoursesView view;
    public static CardComponent card;


    static {
        try {
            card = new CardComponent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            view = new AllCoursesView();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        Scene mainScene = new Scene(view, 1000, 1000);

        window.setScene(mainScene);
//        window.setResizable(false);
        window.setMaximized(true);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}