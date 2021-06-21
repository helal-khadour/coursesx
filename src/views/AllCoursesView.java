package views;


import components.CardComponent;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import models.course.CourseModel;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AllCoursesView extends GridPane {
    public int columns = 0;
    public int row = 1;
    public List<CourseModel> Courses;
    public CardComponent card;
public




    public AllCoursesView() throws FileNotFoundException {
        attachLayout();
    }

    private void attachLayout() throws FileNotFoundException {
        for (int i = 0; i < 12; i++) {
            this.card = new CardComponent();


            if (this.columns == 3) {
                this.columns = 0;
                ++row;
            }
            this.add(card, this.columns++, this.row);
            this.setMargin(card, new Insets(10));
        }
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
