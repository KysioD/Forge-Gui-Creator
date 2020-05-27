package fr.kysio.forgeguicreator;

import fr.kysio.forgeguicreator.utils.FilesManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;

    public static Application application;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FilesManager.initFiles();
        stage = primaryStage;
        application = this;

        Parent root = null;
        if(FilesManager.getprojects().size() < 0) {
            root = FXMLLoader.load(getClass().getResource("windows/createprojects/CreateProject.fxml"));
        }else{
            root = FXMLLoader.load(getClass().getResource("windows/projects/projects.fxml"));
        }
        primaryStage.setTitle("Forge Gui Creator");
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
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
