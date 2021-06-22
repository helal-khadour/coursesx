package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CourseDetailsView extends ScrollPane {
    public HBox heroBox = new HBox();
    public VBox infoBox = new VBox();
    public Text titleContent = new Text("titleContent");
    public Text descriptionLb = new Text("Description");
    public Text descriptionContent = new Text("descriptionContent");
    public Text requirementsLb = new Text("requirements");
    public Text requirementsContent = new Text("requirementsContent");
    public Text TopicContent = new Text("React");
    public Text createdBy = new Text("CreatedBy");
    public Text instructorName = new Text("instructorName ");

    Image image = new Image(new FileInputStream("assets/img/createImg.png"));

    //Setting the image view
    ImageView imageView = new ImageView(image);

    public CourseDetailsView() throws FileNotFoundException {
        attachLayout();
    }
    public void attachLayout(){
        this.setContent(this.heroBox);
        heroBox();
    }
    private void heroBox(){
        this.heroBox.setAlignment(Pos.CENTER);
        this.heroBox.setStyle("-fx-background-color: #2D3134");
        this.heroBox.setMinSize(1500,500);
        this.heroBox.getChildren().add(this.infoBox);
        this.heroBox.getChildren().add(this.imageView);
        this.imageView.setFitHeight(450);
        this.imageView.setFitWidth(434);

        infoSection();
    }
    private void infoSection() {
        this.infoBox.getChildren().add(this.titleContent);
        this.titleContent.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 60));
        this.titleContent.setFill(Color.WHITE);
//        this.titleContent.setMargin(this.createLb,new Insets(20, 250, 0, 0));
        this.infoBox.getChildren().add(this.TopicContent);
        this.TopicContent.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.TopicContent.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.createdBy);
        this.createdBy.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.createdBy.setFill(Color.WHITE);
        this.infoBox.getChildren().add(this.instructorName);
        this.instructorName.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        this.instructorName.setFill(Color.WHITE);
    }
}
