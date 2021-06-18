package presenters;

import coursex.CoursexUI;
import javafx.stage.Stage;
import views.CreateCourseView;

import java.io.File;

public class CreateCoursePresenter {
    public CreateCourseView view;
    public CoursexUI ui;
    public CreateCoursePresenter(CreateCourseView view){
        this.view = view;
        addContents();
        addBanner();
    }

    private void addContents(){
        this.view.contentsBtn.setOnAction(e -> {
            File videosFile = view.contentChooser.showOpenDialog(this.ui.window);
        });
    }
    private void addBanner(){
        this.view.bannerBtn.setOnAction(e -> {
            File bannerFile = view.contentChooser.showOpenDialog(this.ui.window);
        });
    }


}
