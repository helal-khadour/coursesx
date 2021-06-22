package presenters;

import components.CardComponent;
import coursex.CoursexUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import models.course.CourseDAO;
import models.course.CourseModel;
import views.CourseDetailsView;
import views.CoursesView;
import views.CreateCourseView;

import java.io.FileNotFoundException;
import java.util.List;

public class CoursesPresenter {
    CourseDAO courseDAO = new CourseDAO();
    CardComponent card;
    CoursesView coursesView;
    List<CourseModel> courses;


    public CoursesPresenter(CoursesView coursesView) throws FileNotFoundException {
        this.coursesView = coursesView;
        if (this.courseDAO.retrieveAllCourses()) {
            this.courses = this.courseDAO.getData();
        }
        addHandlers();
    }

    private void addHandlers() throws FileNotFoundException {
        this.coursesView.coursesGrid.setAlignment(Pos.CENTER);
        this.coursesView.body.setAlignment(Pos.CENTER);
        this.coursesView.coursesGrid.setMaxWidth(1400);
        for (CourseModel course : courses) {
            this.card = new CardComponent(course);
            this.card.setOnMouseClicked(action -> {
                try {
                    CourseDetailsView courseDetailsView = new CourseDetailsView();
                    CourseDetailsPresenter courseDetailsPresenter = new CourseDetailsPresenter(courseDetailsView, course);
                    CoursexUI.window.getScene().setRoot(courseDetailsView);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            });
            this.coursesView.coursesGrid.getChildren().add(card);
            this.coursesView.coursesGrid.setMargin(card, new Insets(10));
        }
        this.coursesView.createCourse.setOnAction(action -> {
            try {
                CreateCourseView createCourseView = new CreateCourseView();
                CreateCoursePresenter createCoursePresenter = new CreateCoursePresenter(createCourseView);
                CoursexUI.window.getScene().setRoot(createCourseView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        this.coursesView.userName.setText(CoursexUI.myProfile.getName());
        this.coursesView.createCourse.setVisible(CoursexUI.myProfile.isInstructor());
    }
}
