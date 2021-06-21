package presenters;

import java.io.FileNotFoundException;
import java.util.List;

import models.course.CourseDAO;
import models.course.CourseModel;
import models.video.VideoDAO;
import views.AllCoursesView;
import views.CreateCourseView;

public class AllCoursesPresenter {
    protected CourseDAO courseDAO;
    protected VideoDAO videoDAO;
    protected AllCoursesView allCoursesView;

    public AllCoursesPresenter(AllCoursesView allCoursesView) {
        this.courseDAO = new CourseDAO();
        this.videoDAO = new VideoDAO();
        this.allCoursesView = allCoursesView;
        addHandlers();
    }



    private void addHandlers() {
        this.allCoursesView.createCourseBtn.setOnAction(action -> {
            try {
                CreateCourseView createCourseView = new CreateCourseView();
                CreateCoursePresenter createCoursePresenter = new CreateCoursePresenter(createCourseView);
                coursex.CoursexUI.window.getScene().setRoot(createCourseView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}


