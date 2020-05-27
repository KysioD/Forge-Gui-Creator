package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

public class Edit {

    @FXML
    public Menu nameMenu;

    public void initialize(){
        nameMenu.setText(Projects.project.getName());
    }

}
