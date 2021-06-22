package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CourseDetailsView extends ScrollPane {
    public VBox interfaceView = new VBox();
    public StackPane heroBox = new StackPane();
    public VBox bodyBox = new VBox();
    public VBox infoBox = new VBox();
    public Text titleContent = new Text("titleContent");
    public Text descriptionLb = new Text("Description");
    public Text descriptionContent = new Text("descriptionContent");
    public Text requirementsLb = new Text("requirements");
    public Text requirementsContent = new Text("requirementsContent");
    public Text TopicContent = new Text("React");
    public Text createdBy = new Text("Created By");
    public Text instructorName = new Text("instructorName ");
    public Text allVideosLb = new Text("All Videos");
    public HBox video = new HBox();
    public Text videoName = new Text("video Name");
    public Button editCourseBtn = new Button("Edit Course");
    public Button removeCourseBtn = new Button("Remove Course");
    public HBox buttonGroup = new HBox();
    Image iconVideo = new Image(new FileInputStream("assets/img/video.png"));
    //Setting the image view
    ImageView iconVideoView = new ImageView(iconVideo);
    Image image = new Image(new FileInputStream("assets/img/createImg.png"));
    //Setting the image view
    ImageView imageView = new ImageView(image);

    public CourseDetailsView() throws FileNotFoundException {
        attachLayout();
    }
    public void attachLayout(){
        this.setContent(this.interfaceView);
        this.interfaceView.getChildren().add(this.heroBox);
        this.interfaceView.getChildren().add(this.bodyBox);
        heroBox();
        bodySection();
    }
    private void heroBox(){
        this.heroBox.setPadding(new Insets(0,60,0,60));
        this.heroBox.setStyle("-fx-background-color: #2D3134;");
        this.heroBox.setMinSize(1400,400);
        this.heroBox.getChildren().add(this.infoBox);
        this.heroBox.getChildren().add(this.imageView);
        this.heroBox.setAlignment(this.infoBox,Pos.CENTER_LEFT);
        this.heroBox.setAlignment(this.imageView,Pos.CENTER_RIGHT);
        this.imageView.setFitHeight(350);
        this.imageView.setFitWidth(334);
        infoSection();

    }
    private void infoSection() {
        this.infoBox.getChildren().add(this.titleContent);
        this.infoBox.setSpacing(10);
        this.infoBox.setAlignment(Pos.CENTER_LEFT);
        this.titleContent.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 60));
        this.titleContent.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.TopicContent);
        this.TopicContent.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.TopicContent.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.createdBy);
        this.createdBy.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.createdBy.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.instructorName);
        this.instructorName.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.instructorName.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.buttonGroup);
        this.buttonGroup.getChildren().add(this.editCourseBtn);
        this.editCourseBtn.setStyle("-fx-background-color: #0787F9; -fx-min-height: 30; -fx-text-fill: white; -fx-min-width: 150;");
        this.editCourseBtn.setCursor(Cursor.HAND);
        this.editCourseBtn.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.buttonGroup.setMargin(this.editCourseBtn, new Insets(0,10,0,0));
        this.buttonGroup.getChildren().add(this.removeCourseBtn);
        this.removeCourseBtn.setStyle("-fx-background-color:  #F82D56; -fx-min-height: 30; -fx-text-fill: white; -fx-min-width: 150;");
        this.removeCourseBtn.setCursor(Cursor.HAND);
        this.removeCourseBtn.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
    }
    private void bodySection(){
        this.bodyBox.setStyle("-fx-background-color: white");
        this.bodyBox.setPadding(new Insets(0,60,0,60));
        this.bodyBox.setSpacing(10);
        this.bodyBox.setAlignment(Pos.TOP_LEFT);
        this.bodyBox.getChildren().add(this.descriptionLb);
        this.descriptionLb.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 34));
        this.descriptionLb.setFill(Color.BLACK);
        this.bodyBox.getChildren().add(this.descriptionContent);
        this.descriptionContent.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.descriptionContent.setFill(Color.BLACK);
        this.bodyBox.getChildren().add(this.requirementsLb);
        this.requirementsLb.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 34));
        this.requirementsLb.setFill(Color.BLACK);
        this.bodyBox.getChildren().add(this.requirementsContent);
        this.requirementsContent.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.requirementsContent.setFill(Color.BLACK);
        this.bodyBox.getChildren().add(this.allVideosLb);
        this.allVideosLb.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 34));
        this.allVideosLb.setFill(Color.BLACK);
        this.bodyBox.getChildren().add(this.video);
        videoSection();
    }
    private void videoSection(){
        this.video.setStyle("-fx-background-color: white");
        this.video.setPadding(new Insets(10));
        this.video.setAlignment(Pos.CENTER_LEFT);
//        this.video.setStyle("-fx-background-color: #2D3134; -fx-min-height: 50; -fx-min-width: 200; -fx-border-color: white;" +
//                " -fx-text-fill: white; -fx-border-radius: 3;");
        this.video.getChildren().add(this.iconVideoView);
        this.video.getChildren().add(this.videoName);
        this.videoName.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.videoName.setFill(Color.BLACK);
        this.iconVideoView.setFitHeight(30);
        this.iconVideoView.setFitWidth(30);
    }
}
