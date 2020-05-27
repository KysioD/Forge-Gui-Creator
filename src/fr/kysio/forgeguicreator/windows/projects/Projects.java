package fr.kysio.forgeguicreator.windows.projects;

import fr.kysio.forgeguicreator.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

public class Projects {

    @FXML
    public Label name;

    @FXML
    public Label author;

    @FXML
    public Label version;

    public void initialize(){
        Main.stage.setResizable(true);
    }

    public void createProject(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../createProject/CreateProject.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
