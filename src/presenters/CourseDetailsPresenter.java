package presenters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import components.VideoTileComponent;
import coursex.CoursexUI;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.course.CourseDAO;
import models.course.CourseModel;
import models.user.UserDAO;
import models.user.UserModel;
import models.video.VideoDAO;
import models.video.VideoModel;
import views.CourseDetailsView;
import views.CoursesView;

public class CourseDetailsPresenter {

    protected CourseDetailsView courseDetailsView;
    protected CourseModel courseModel;
    protected CourseDAO courseDAO;
    protected VideoDAO videoDAO;
    protected UserDAO userDAO;
    private List<File> contentFiles;

    CourseDetailsPresenter(CourseDetailsView courseDetailsView, CourseModel courseModel) {
        this.courseDetailsView = courseDetailsView;
        this.courseModel = courseModel;
        this.courseDAO = new CourseDAO();
        this.videoDAO = new VideoDAO();
        this.userDAO = new UserDAO();
        try {
            addHandlers();
            back();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void addHandlers() throws MalformedURLException {
        this.courseDetailsView.titleContent.setText(courseModel.getTitle());
        this.courseDetailsView.topicContent.setText(courseModel.getTopic());
        this.courseDetailsView.descriptionContent.setText(courseModel.getDescription());
        this.courseDetailsView.requirementsContent.setText(courseModel.getRequirements());

        int instructorId = courseModel.getInstructorUserId();
        userDAO.retrieveUserById(instructorId);
        UserModel instructor = userDAO.getData().get(0);
        this.courseDetailsView.instructorName.setText(instructor.getName());


        videoDAO.retrieveAllCourseVideos(courseModel.getId());
        List<VideoModel> videos = videoDAO.getData();

        for (VideoModel video : videos) {
            VideoTileComponent videoTileComponent = new VideoTileComponent(video);


            File mediaFile = new File(video.getUrl());
            Media media = new Media(mediaFile.toURI().toURL().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            MediaView mediaView = new MediaView(mediaPlayer);

            videoTileComponent.setOnMouseClicked(action -> {
                mediaPlayer.play();
                Scene scene = new Scene(new Pane(mediaView));

                Stage stage = new Stage();

                stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
                    mediaPlayer.stop();
                });

                stage.setTitle(video.getName());
                stage.setScene(scene);
                stage.show();

            });

            this.courseDetailsView.videos.getChildren().add(videoTileComponent);

            this.courseDetailsView.removeCourseBtn.setOnAction(action -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure you want to delete the course?");

                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        courseDAO.delete(courseModel.getId());
                        try {
                            CoursesView coursesView = new CoursesView();
                            CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
                            CoursexUI.window.getScene().setRoot(coursesView);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            });
        }

    }

    private void back() {
        this.courseDetailsView.backBtn.setOnAction(e -> {
            try {
                CoursesView coursesView = new CoursesView();
                CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
                CoursexUI.window.getScene().setRoot(coursesView);
                CoursexUI.window.setMaximized(true);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
    }
}
