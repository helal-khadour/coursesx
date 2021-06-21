package views;


import components.CardComponent;
import coursex.CoursexUI;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import models.course.CourseDAO;
import models.course.CourseModel;
import presenters.AllCoursesPresenter;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import models.course.CourseModel;
import javafx.scene.control.ScrollPane;


import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class AllCoursesView extends ScrollPane {
    public int columns = 0;
    public int row = 2;
    public List<CourseModel> courses;
    public Button createCourseBtn;
    public Label userLb;
    public CourseDAO courseDAO;

    public AllCoursesView() {
        this.courseDAO = new CourseDAO();
        if (this.courseDAO.retrieveAllCourses()) {
            this.courses = this.courseDAO.getData();
        }
        attachLayout();
    }

    ScrollPane sp = new ScrollPane();

    private void attachLayout() {

        GridPane gridPane = new GridPane();

        createCourseBtn = new Button("Create Course");

        userLb = new Label("Hello, user");
        gridPane.add(userLb, 0, 1);

        gridPane.add(createCourseBtn, 2, 1);

        if (this.courses != null) {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

            for (CourseModel course : courses) {
                try {
                    CardComponent card = new CardComponent(course);


                    if (this.columns == 3) {
                        this.columns = 0;
                        ++row;
                    }

                    gridPane.add(card, this.columns++, this.row);
                    GridPane.setMargin(card, new Insets(10));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        this.setContent(gridPane);


//        scrollPane.setPrefSize(600, 200);
//        scrollPane.setContent(topicParent);
//         scrollPane.setFitToHeight(true);
//        scrollPane.setPannable(true);




    }
}

