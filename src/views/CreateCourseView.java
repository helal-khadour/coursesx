package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreateCourseView extends HBox {
    public Text createLb = new Text("Create New Course");
    public Text titleLb = new Text("How about a working title?");
    public TextField titleFld = new TextField();
    public Text descriptionLb = new Text("What is the description of the course?");
    public TextField descriptionFld = new TextField();
    public Text requirementsLb = new Text("Are there any course requirements?");
    public TextField requirementsFld = new TextField();
    public Text topicLb = new Text("What tags best fits the knowledge you'll share?");
    public TextField topicFld = new TextField();
    public Button contentsBtn = new Button("Add Contents");
    public FileChooser contentChooser = new FileChooser();
    public FileChooser bannerChooser = new FileChooser();
    public Button bannerBtn = new Button("Add Banner");

    public Button createBtn = new Button("Create Course");

    public VBox formBox = new VBox();
    public VBox imageBox = new VBox();
    //Creating an image
    Image image = new Image(new FileInputStream("assets/img/createImg.png"));

    //Setting the image view
    ImageView imageView = new ImageView(image);

    //Constructor
    public CreateCourseView() throws FileNotFoundException {
        attachLayout();
    }

    private void attachLayout() {
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #2D3134");
        this.getChildren().add(this.formBox);
        this.getChildren().add(this.imageBox);
        this.setMargin(this.formBox,new Insets(40, 100, 20, 100));
        formSection();
        imageSection();
    }
    private void formSection(){
        this.formBox.setPrefWidth(700);
        this.formBox.setAlignment(Pos.CENTER_LEFT);

        this.formBox.getChildren().add(this.createLb);
        this.createLb.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 60));
        this.createLb.setFill(Color.WHITE);

        this.formBox.getChildren().add(this.titleLb);
        this.titleLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.titleLb.setFill(Color.WHITE);
        this.formBox.setMargin(this.titleLb,new Insets(50, 250, 0, 0));


        this.formBox.getChildren().add(this.titleFld);
        this.titleFld.setPromptText("Title of Course");
        this.formBox.setMargin(this.titleFld,new Insets(10, 250, 20, 0));
        this.titleFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.titleFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");

        this.formBox.getChildren().add(this.descriptionLb);
        this.descriptionLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.descriptionLb.setFill(Color.WHITE);

        this.formBox.getChildren().add(this.descriptionFld);
        this.descriptionFld.setPromptText("Description");
        this.formBox.setMargin(this.descriptionFld,new Insets(10, 250, 20, 0));
        this.descriptionFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.descriptionFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");

        this.formBox.getChildren().add(this.requirementsLb);
        this.requirementsLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.requirementsLb.setFill(Color.WHITE);



        this.formBox.getChildren().add(this.requirementsFld);
        this.requirementsFld.setPromptText("Requirements");
        this.formBox.setMargin(this.requirementsFld,new Insets(10, 250, 20, 0));
        this.requirementsFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.requirementsFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");


        this.formBox.getChildren().add(this.topicLb);
        this.topicLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.topicLb.setFill(Color.WHITE);

        this.formBox.getChildren().add(this.topicFld);
        this.topicFld.setPromptText("topic");
        this.formBox.setMargin(this.topicFld,new Insets(10, 250, 20, 0));
        this.topicFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.topicFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");


        this.formBox.getChildren().add(this.contentsBtn);
        this.contentsBtn.setStyle("-fx-background-color: #2D3134; -fx-min-height: 16; -fx-text-fill: #0787F9;");
        this.contentsBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.contentsBtn.setCursor(Cursor.HAND);


        this.formBox.getChildren().add(this.bannerBtn);
        this.bannerBtn.setStyle("-fx-background-color: #2D3134; -fx-min-height: 16; -fx-text-fill: #0787F9;");
        this.bannerBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.bannerBtn.setCursor(Cursor.HAND);

        this.formBox.getChildren().add(this.createBtn);
        this.createBtn.setStyle("-fx-background-color: white; -fx-min-height: 40; -fx-min-width: 150;");
        this.createBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.createBtn.setCursor(Cursor.HAND);


    }
    private void imageSection(){
        this.formBox.setPrefWidth(700);
        this.imageBox.setAlignment(Pos.CENTER_RIGHT);
        this.imageBox.getChildren().add(this.imageView);
        this.imageView.setFitHeight(550);

        this.imageView.setFitWidth(534);

    }
}