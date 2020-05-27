package fr.kysio.forgeguicreator;

import fr.kysio.forgeguicreator.utils.FilesManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("windows/projects/projects.fxml"));
        primaryStage.setTitle("Forge Gui Creator");
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();

        stage = primaryStage;

        FilesManager.initFiles();

        FilesManager.createProject("test", "Kysio", "1.14.4");

        Project project = FilesManager.getProject("test");

        if(project != null){
            System.out.println("project : "+project.getName()+" / "+project.getAuthor()+" / "+project.getVersion()+" / "+project);
        }
    }

    public static void changeWindow(Parent root){
        try {
           stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}