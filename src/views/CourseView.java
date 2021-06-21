package views;
import components.CardComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

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

public class CourseView extends ScrollPane{
    StackPane navBar = new StackPane();
    VBox imgSection = new VBox();
    TilePane coursesGrid = new TilePane();
    VBox body = new VBox();
    CardComponent card;
    Text userName = new Text("Milad Awad");
    Text logo = new Text("CoursesX");
    Button createCourse = new Button("Create Course");

    public Image image = new Image(new FileInputStream("assets/img/coursesBG.png"));
    //Setting the image view
    ImageView imageView = new ImageView(image);
    public Image avatar = new Image(new FileInputStream("assets/img/person.png"));
    //Setting the image view
    ImageView avatarView = new ImageView(avatar);

    public CourseView() throws FileNotFoundException {
        attachLayout();
    }
    public void attachLayout() throws FileNotFoundException {
        this.setStyle("-fx-background-color: #2D3134");

        this.setContent(this.body);
        this.body.getChildren().add(this.navBar);
        this.body.getChildren().add(this.imgSection);
        this.body.getChildren().add(this.coursesGrid);
        this.body.setAlignment(Pos.CENTER);
        this.body.setStyle("-fx-background-color: #2D3134");
        viewImage();
        viewNavBar();

    }

    private void viewImage() throws FileNotFoundException{
        this.imgSection.getChildren().add(this.imageView);
        this.imageView.setFitHeight(408);
        this.imageView.setFitWidth(1520);
    }
    private void viewNavBar() throws FileNotFoundException{
        this.navBar.setAlignment(Pos.CENTER_LEFT);
        this.navBar.setPadding(new Insets(8,60,8,60));
        this.navBar.getChildren().add(this.logo);
        this.navBar.getChildren().add(this.createCourse);

        this.navBar.setAlignment(this.userName, Pos.CENTER_RIGHT);
        this.createCourse.setStyle("-fx-background-color: white; -fx-min-height: 40; -fx-min-width: 50;");
        this.createCourse.setFont(Font.font("roboto", FontWeight.NORMAL, 14));
        this.createCourse.setCursor(Cursor.HAND);
        this.createCourse.setVisible(true);


//        this.navBar.setMargin(this.logo,new Insets(0, 1060, 0, 0));
        this.navBar.getChildren().add(this.avatarView);
        this.navBar.getChildren().add(this.userName);
        this.avatarView.setFitHeight(30);
        this.avatarView.setFitWidth(30);
        this.logo.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.logo.setFill(Color.WHITE);
        this.userName.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.userName.setFill(Color.WHITE);


    }

}
