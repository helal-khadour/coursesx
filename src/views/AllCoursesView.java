package views;


import components.CardComponent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import models.course.CourseModel;
import javafx.scene.control.ScrollPane;


import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class AllCoursesView extends TilePane {
    public int columns = 0;
    public int row = 1;
    public CardComponent card;

    ScrollPane sp = new ScrollPane();


    public AllCoursesView() throws FileNotFoundException {
        attachLayout();
    }

    private void attachLayout() throws FileNotFoundException {
    this.setOrientation(Orientation.HORIZONTAL);;
        this.setStyle("-fx-background-color: #2D3134");
        this.setAlignment(Pos.TOP_CENTER);

//        this.prefTileHeightProperty().set(182);
//        for (int i = 0; i < 12; i++) {
//            this.card = new CardComponent();
//
//            if (this.columns == 4) {
//                this.columns = 0;
//                ++row;
//            }
//            this.add(card, this.columns++, this.row);
//            this.setMargin(card, new Insets(10));
//        }
                for (int i = 0; i < 10; i++) {
            this.card = new CardComponent();

            this.getChildren().add(card);
            this.setMargin(card, new Insets(10));
        }


//        scrollPane.setPannable(true);




    }
}

