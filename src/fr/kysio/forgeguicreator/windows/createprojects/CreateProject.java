package fr.kysio.forgeguicreator.windows.createprojects;

import fr.kysio.forgeguicreator.Main;
import fr.kysio.forgeguicreator.utils.FilesManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateProject {

    @FXML
    public TextField name;

    @FXML
    public TextField author;

    @FXML
    public MenuButton version;

    public void initialize(){
        Main.stage.setResizable(false);
    }

    public void createProject(){
        if(!name.getText().isEmpty() && !author.getText().isEmpty()){
            FilesManager.createProject(name.getText(), author.getText(), "1.12.2");

            try {
                Main.changeWindow(FXMLLoader.load(getClass().getResource("../projects/projects.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            };
        }
    }

}
