package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import coursex.CoursexUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.video.VideoModel;

public class VideoTileComponent extends HBox {

    public VideoTileComponent(VideoModel videoModel) {
        Text videoName = new Text(videoModel.getName());

        try {
            Image iconVideo = new Image(new FileInputStream("assets/img/video.png"));

            ImageView iconVideoView = new ImageView(iconVideo);

            this.setStyle("-fx-background-color: white");
            this.setPadding(new Insets(10));
            this.setAlignment(Pos.CENTER_LEFT);

            this.getChildren().add(iconVideoView);
            this.getChildren().add(videoName);

            videoName.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 20));
            videoName.setFill(Color.BLACK);
            iconVideoView.setFitHeight(30);
            iconVideoView.setFitWidth(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}