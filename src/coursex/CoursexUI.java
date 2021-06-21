package coursex;

import components.CardComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.course.CourseModel;
import models.user.UserModel;
import presenters.AllCoursesPresenter;
import presenters.CreateCoursePresenter;
import presenters.SignInPresenter;
import presenters.SignUpPresenter;
import views.*;


import java.io.FileNotFoundException;

public class CoursexUI extends Application {

    public static Stage window;
    public static UserModel myProfile;

//    public static SignUpView signUpView = new SignUpView();

    public static SignInView signInView = new SignInView();

//    public static CreateCourseView createCourseView;
//    public static AllCoursesView allCoursesView;

//    static {
//        try {
//            createCourseView = new CreateCourseView();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        SignInPresenter SignInPresenter = new SignInPresenter(signInView);
//        SignUpPresenter SignUpPresenter = new SignUpPresenter(signUpView);
//        CreateCoursePresenter CreateCoursePresenter = new CreateCoursePresenter(createCourseView);
//        AllCoursesPresenter allCoursesPresenter = new AllCoursesPresenter(allCoursesView);


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