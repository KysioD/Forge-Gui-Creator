package fr.kysio.forgeguicreator.windows.updateproject;

import fr.kysio.forgeguicreator.Main;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Updateproject {

    @FXML
    public TextField author;
    @FXML
    public TextField name;

    public void initialize(){
        name.setText(Projects.project.getName());
        author.setText(Projects.project.getAuthor());

        Main.stage.setResizable(false);
    }

    public void goBack(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../projects/projects.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProject(){
        FilesManager.updateProject(Projects.project.getName(), name.getText(), author.getText(), "1.12.2");
        Main.stage.setResizable(true);
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../projects/projects.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
