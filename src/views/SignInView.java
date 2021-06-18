package views;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class SignInView extends VBox {
    public Text coursexLb = new Text("CourseX");
    public Text sloganLb = new Text("Discover a new way of learning");
    public TextField emailFld = new TextField();
    public PasswordField passwordFld = new PasswordField();
    public Button loginBtn = new Button("SignIn");

    public HBox signUpBox = new HBox();
    public Text createLb = new Text("Don't have an account?");
    public Button signUpBtn = new Button("SignUp");

    //Constructor
    public SignInView() {
        attachLayout();
    }

    private void attachLayout() {
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #2D3134");


        this.getChildren().add(this.coursexLb);
        this.coursexLb.setFont(Font.font("roboto", FontWeight.BOLD, FontPosture.REGULAR, 60));
        this.coursexLb.setFill(Color.WHITE);

        this.getChildren().add(this.sloganLb);
        this.sloganLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.sloganLb.setFill(Color.WHITE);


        this.getChildren().add(this.emailFld);
        this.emailFld.setPromptText("Enter Your Email");
        this.setMargin(this.emailFld, new Insets(120, 60, 10, 60));
        this.emailFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.emailFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");


        this.getChildren().add(this.passwordFld);
        this.setMargin(this.passwordFld, new Insets(10, 60, 20, 60));
        this.passwordFld.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.passwordFld.setPromptText("Enter Your Password");
        this.passwordFld.setStyle(
                "-fx-text-inner-color: white;" +
                        "-fx-control-inner-background: #1F1F21; " +
                        "-fx-background-color: -fx-control-inner-background;" +
                        " -fx-min-height: 30; -fx-prompt-text-fill: #87878D;");

        this.getChildren().add(this.loginBtn);
        loginBtn.setStyle("-fx-background-color: white; -fx-min-height: 40; -fx-min-width: 150;");
        loginBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.loginBtn.setCursor(Cursor.HAND);

        signUpSection();
        this.getChildren().add(this.signUpBox);
    }

    private void signUpSection() {
        signUpBox.setAlignment(Pos.CENTER);
        this.setMargin(this.signUpBox, new Insets(10, 60, 20, 60));
        this.signUpBox.setAlignment(Pos.CENTER);
        this.signUpBox.getChildren().add(this.createLb);
        this.createLb.setFont(Font.font("roboto", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        this.createLb.setFill(Color.WHITE);
        this.signUpBox.getChildren().add(this.signUpBtn);
        this.signUpBtn.setStyle("-fx-background-color: #2D3134; -fx-min-height: 16; -fx-text-fill: #0787F9;");
        this.signUpBtn.setFont(Font.font("roboto", FontWeight.NORMAL, 16));
        this.signUpBtn.setCursor(Cursor.HAND);

    }

    ;
}
