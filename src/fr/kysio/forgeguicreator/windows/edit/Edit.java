package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.GuiControlOption;
import fr.kysio.forgeguicreator.controls.controls.RectangleControl;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.swing.event.HyperlinkEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

public class Edit implements EventHandler<MouseEvent>{

    @FXML
    public Menu nameMenu;

    @FXML
    public Pane mainPane;

    @FXML
    public Pane optionsPane;

    @FXML
    public Pane objectsPane;

    public GuiControl selectedControl;

    public HashMap<Button, Class<?extends GuiControl>> buttons = new HashMap<>();

    public void initialize(){
        nameMenu.setText(Projects.project.getName());

        Button rectangle = new Button("Rectangle");
        rectangle.setOnMouseClicked(this);
        rectangle.setOnDragDetected(this);

        rectangle.setLayoutX(20);
        rectangle.setLayoutY(25);
        objectsPane.getChildren().add(rectangle);

        buttons.put(rectangle, RectangleControl.class);

    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getEventType());
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
        }else if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED) && buttons.containsKey(event.getSource())){
            try {

                Constructor<? extends GuiControl> constructor = buttons.get(event.getSource()).getConstructor(Pane.class, Pane.class);

                if(selectedControl != null) selectedControl.setSelected(false);

                selectedControl = constructor.newInstance(mainPane, optionsPane);
                selectedControl.setLayoutX(0);
                selectedControl.setLayoutY(0);
                selectedControl.setPrefSize(100, 50);
                selectedControl.setStyle("-fx-background-color: #FF666666;");
                selectedControl.setOnMouseDragged(new MouseManager(selectedControl));
                selectedControl.setOnMouseClicked(this::handle);

                mainPane.getChildren().add(selectedControl);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

            /*if(event.getEventType().equals(MouseEvent.DRAG_DETECTED)){
            System.out.println("DRAG");
            try {

                Constructor<? extends GuiControl> constructor = buttons.get(event.getSource()).getConstructor(Pane.class, Pane.class);

                selectedControl = constructor.newInstance(objectsPane, optionsPane);
                selectedControl.setLayoutX(event.getX());
                selectedControl.setLayoutY(event.getY());
                selectedControl.setStyle("-fx-background-color: gray;");

                mainPane.getChildren().add(selectedControl);
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
    }
}
