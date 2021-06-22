package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.course.CourseModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardComponent extends VBox {
    private CourseModel courseModel;

    private final Text title;
    private final Text topic;
    private final Image image;

    //Setting the image view

    public CardComponent(CourseModel courseModel) throws FileNotFoundException {
        this.courseModel = courseModel;
        this.title = new Text(courseModel.getTitle());
        this.topic = new Text(courseModel.getTopic());
        if (!courseModel.getBanner().isEmpty())
            this.image = new Image(new FileInputStream(courseModel.getBanner()));
        else
            this.image = new Image(new FileInputStream("assets/img/createImg.png"));
        attachLayout();
    }

    private void attachLayout() {
        ImageView imageView = new ImageView(image);

        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(5);
        this.setStyle("-fx-background-color:  #2D3134");
        this.getChildren().add(imageView);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);

        this.getChildren().add(this.title);
        this.title.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 16));
        this.title.setFill(Color.WHITE);
        this.title.setWrappingWidth(290);
        this.setMargin(this.title, new Insets(0,5,0,5));

        this.getChildren().add(this.topic);
        this.topic.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        this.topic.setFill(Color.WHITE);
        this.setMargin(this.topic, new Insets(0, 5, 10, 5));
    }
}
