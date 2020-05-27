package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.controls.RectangleControl;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;

public class Edit {

    @FXML
    public Menu nameMenu;

    @FXML
    public Pane optionsPane;

    @FXML
    public Pane objectsPane;

    public void initialize(){
        nameMenu.setText(Projects.project.getName());

        GuiControl rectangle = new RectangleControl(objectsPane);

    }

}
