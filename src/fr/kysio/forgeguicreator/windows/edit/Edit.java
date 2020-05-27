package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.GuiControlOption;
import fr.kysio.forgeguicreator.controls.controls.RectangleControl;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Edit implements EventHandler<MouseEvent> {

    @FXML
    public Menu nameMenu;

    @FXML
    public Pane optionsPane;

    @FXML
    public Pane objectsPane;

    public GuiControl selectedControl;

    public void initialize(){
        nameMenu.setText(Projects.project.getName());

        GuiControl rectangle = new RectangleControl(objectsPane, optionsPane);
        rectangle.setOnMouseClicked(this);

    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("onclick");
        if(event.getSource() instanceof GuiControl){
            System.out.println("GuiControl");
            if(selectedControl != null){
                for(GuiControlOption guiControlOption : selectedControl.getOptions()){
                    guiControlOption.control.setVisible(false);
                }
            }
            selectedControl = (GuiControl)event.getSource();

            for(GuiControlOption guiControlOption : selectedControl.getOptions()){
                guiControlOption.control.setVisible(true);
            }
        }
    }
}
