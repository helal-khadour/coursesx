package views;

import components.CardComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import models.user.UserDAO;

import java.io.FileNotFoundException;

public class ViewPresenter {
    CardComponent card;
    CourseView view;
    public ViewPresenter(CourseView view) throws FileNotFoundException {
        this.view = view;
        viewHandlers();
    }
    private void viewHandlers() throws FileNotFoundException {
        this.view.coursesGrid.setAlignment(Pos.CENTER);
        this.view.body.setAlignment(Pos.CENTER);
        this.view.coursesGrid.setMaxWidth(1400);
        for (int i = 0; i < 20; i++) {
            this.card = new CardComponent();
            this.view.coursesGrid.getChildren().add(card);
            this.view.coursesGrid.setMargin(card, new Insets(10));
        }

    }

}
