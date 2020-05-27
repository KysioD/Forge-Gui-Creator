package fr.kysio.forgeguicreator.windows.removeconfirm;

import fr.kysio.forgeguicreator.Main;
import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class RemoveConfirm {

    public void initialize(){
        Main.stage.setResizable(false);
    }

    public void goBack(){
        Main.stage.setResizable(true);
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../projects/projects.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(){
        FilesManager.removeProject(Projects.project.getName());
        goBack();
    }

}
