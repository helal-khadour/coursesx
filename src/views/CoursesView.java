package views;

import components.CardComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CoursesView extends ScrollPane {
    public StackPane navBar = new StackPane();
    public VBox imgSection = new VBox();
    public TilePane coursesGrid = new TilePane();
    public VBox body = new VBox();
    public Text userName = new Text("User");
    public Text logo = new Text("CoursesX");
    public Button createCourse = new Button("Create Course");
    public HBox leftList = new HBox();
    public HBox searchSection = new HBox();
    public TextField searchFld = new TextField();
    public Button searchBtn = new Button("Search");

    public Image image = new Image(new FileInputStream("assets/img/coursesBG.png"));
    //Setting the image view
    ImageView imageView = new ImageView(image);
    public Image avatar = new Image(new FileInputStream("assets/img/person.png"));
    //Setting the image view
    ImageView avatarView = new ImageView(avatar);

    public CoursesView() throws FileNotFoundException {
        attachLayout();
    }

    public void attachLayout() throws FileNotFoundException {
        this.setStyle("-fx-background-color: #2D3134");

        this.setContent(this.body);
        this.body.getChildren().add(this.navBar);
        this.body.getChildren().add(this.imgSection);
        this.body.getChildren().add(this.searchSection);
        this.body.getChildren().add(this.coursesGrid);
        this.body.setAlignment(Pos.CENTER);
        this.body.setStyle("-fx-background-color: #2D3134");
        viewNavBar();
        viewImage();
        searchSection();

    }

    private void viewImage() throws FileNotFoundException {
        this.imgSection.getChildren().add(this.imageView);
        this.imageView.setFitHeight(408);
        this.imageView.setFitWidth(1520);
    }
    private void searchSection(){
        this.searchSection.setAlignment(Pos.CENTER);
        this.searchSection.setPadding(new Insets(30,0,30,0));
        this.searchSection.getChildren().add(this.searchFld);
        this.searchSection.setMargin(this.searchFld,new Insets(0, 10, 00, 0));
        this.searchFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.searchFld.setPromptText("Search By Title");
        this.searchFld.setStyle(
                "-fx-text-inner-color: white; " +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 40; -fx-prompt-text-fill: #87878D; -fx-min-width: 600;" );

        this.searchSection.getChildren().add(this.searchBtn);
        this.searchBtn.setStyle("-fx-background-color: white; -fx-min-height: 40; -fx-min-width: 120;");
        this.searchBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.searchBtn.setCursor(Cursor.HAND);
    }

    private void viewNavBar() throws FileNotFoundException {
        leftList();
        this.navBar.setAlignment(Pos.CENTER_LEFT);
        this.navBar.setPadding(new Insets(8, 60, 8, 60));
        this.navBar.getChildren().add(this.logo);
        this.navBar.getChildren().add(this.leftList);
        this.navBar.setAlignment(this.logo, Pos.CENTER_LEFT);
        this.logo.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.logo.setFill(Color.WHITE);
    }
    private void leftList(){
        this.leftList.setAlignment(Pos.CENTER_RIGHT);
        this.leftList.getChildren().add(this.createCourse);
        this.leftList.setSpacing(8);
        this.createCourse.setStyle("-fx-background-color: #2D3134; -fx-min-height: 40; -fx-min-width: 50; -fx-border-color: white;" +
                " -fx-text-fill: white; -fx-border-radius: 3;");
        this.createCourse.setFont(Font.font("roboto", FontWeight.NORMAL, 14));
        this.createCourse.setCursor(Cursor.HAND);
        this.createCourse.setVisible(true);
        this.leftList.getChildren().add(this.avatarView);
        this.avatarView.setFitHeight(30);
        this.avatarView.setFitWidth(30);
        this.leftList.getChildren().add(this.userName);
        this.userName.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.userName.setFill(Color.WHITE);
    }

}
