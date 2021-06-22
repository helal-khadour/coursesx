package presenters;



import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

import coursex.CoursexUI;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import models.course.CourseDAO;
import models.course.CourseModel;
import models.video.VideoDAO;
import models.video.VideoModel;
import views.CoursesView;
import views.CreateCourseView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCoursePresenter {
    protected CreateCourseView createCourseView;
    protected CourseDAO courseDAO;
    protected VideoDAO videoDAO;
    private List<File> contentFiles;

    public CreateCoursePresenter(CreateCourseView createCourseView) {
        this.createCourseView = createCourseView;
        this.courseDAO = new CourseDAO();
        this.videoDAO = new VideoDAO();
        addHandlers();
        addContents();
        addBanner();
        back();
    }

    private void addHandlers() {
        this.createCourseView.createBtn.setOnAction(action -> {

            String title = this.createCourseView.titleFld.getText();
            String description = this.createCourseView.descriptionFld.getText();
            String requirements = this.createCourseView.requirementsFld.getText();
            String topic = this.createCourseView.topicFld.getText();

            this.courseDAO.add(new CourseModel(title, description, "", requirements, topic, CoursexUI.myProfile.getId()));
            int courseId = this.courseDAO.getData().get(0).getId();

            if (!contentFiles.isEmpty()) {
                try {
                    for (File file : contentFiles) {
                        String ext = FilenameUtils.getExtension(file.getName());
                        String originalName = FilenameUtils.getBaseName(file.getName());
                        String newName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
                        File dest = new File(System.getProperty("user.home") + "/Desktop/CourseX", newName);
                        FileUtils.copyFile(file, dest);

                        videoDAO.add(new VideoModel(originalName, dest.getPath(), courseId));
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You must add at least one video to the course!");
                alert.show();
                return;
            }


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("The Course has been added successfully!");
            alert.show();

            this.contentFiles = new ArrayList<>();
            this.createCourseView.titleFld.clear();
            this.createCourseView.topicFld.clear();
            this.createCourseView.requirementsFld.clear();
            this.createCourseView.descriptionFld.clear();
        });
    }


    private void addContents() {
        this.createCourseView.contentsBtn.setOnAction(e -> {
            createCourseView.contentChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv", "*.mts"));
            contentFiles = createCourseView.contentChooser.showOpenMultipleDialog(CoursexUI.window);
        });
    }

    private void addBanner() {
        this.createCourseView.bannerBtn.setOnAction(e -> {
            File bannerFile = createCourseView.contentChooser.showOpenDialog(CoursexUI.window);
        });
    }
    private void back(){
        this.createCourseView.backBtn.setOnAction(e -> {
            CoursesView coursesView = null;
            try {
                coursesView = new CoursesView();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            CoursexUI.window.getScene().setRoot(coursesView);
            CoursexUI.window.setMaximized(true);
        });
    }

}
