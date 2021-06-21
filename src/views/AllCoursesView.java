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


import java.io.FileNotFoundException;
import java.util.ArrayList;
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
//        this.getChildren().add(this.b);
//        this.b.setPrefSize(800,200);
//        this.setHgrow(this.b, Priority.ALWAYS);
//
//        for (
//                int i = 0;
//                i < 20; i++) {
//            textFieldList.add(new TextField());
//            titleList.add(new Text());
//        }
//
//
//        for (
//                TextField textField :
//                textFieldList) {
//            textField.setText("Yay for text again!");
//            textField.setPrefSize(100,100);
//
//        }
//        for (
//                Text text :
//                titleList) {
//            text.setText("Yay for text again!");
//
//
//        }
//        this.getChildren().addAll(this.textFieldList);
//        this.getChildren().addAll(this.titleList);
//        this.setHgrow((Node) this.titleList, Priority.ALWAYS);
//        this.setFillHeight(false);
    }
}

//    private List<CourseModel> courseList() {
//        List<CourseModel> ls = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            CourseModel course = new CourseModel();
//            course.setBanner("assets/img/createImg.png");
//            course.setTitle("sdsd");
//            course.setDescription("sdssssd");
//            ls.add(course);
//        }
//        return ls;
//    }
//}
