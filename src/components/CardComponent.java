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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardComponent extends VBox {
    public Text title = new Text("The title The title The titleThe titleThe titleThe titleThe titleThe titleThe titleThe titleThe titleThe titleThe titleThe title");
    public Text topic = new Text("React");
    public Image image = new Image(new FileInputStream("assets/img/createImg.png"));
    //Setting the image view
    ImageView imageView = new ImageView(image);

    public CardComponent() throws FileNotFoundException {
        attachLayout();
    }
    private void attachLayout() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(5);
        this.setStyle("-fx-background-color: white");
        this.getChildren().add(this.imageView);
        this.imageView.setFitHeight(200);
        this.imageView.setFitWidth(300);

        this.getChildren().add(this.title);
        this.title.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 16));
        this.title.setFill(Color.BLACK);
        this.title.setWrappingWidth(290);

        this.getChildren().add(this.topic);
        this.topic.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        this.topic.setFill(Color.BLACK);
        this.setMargin(this.topic, new Insets(0, 0, 50, 0));
    }
}
