package fr.kysio.forgeguicreator.controls;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.ArrayList;

public class GuiControlOption{

    private String name;
    private Pane pane;

    public Control control;

    public GuiControlOption(String name, Pane pane, Control control, int id){
        this.name = name;
        this.pane = pane;
        this.control = control;

        control.setLayoutX(30);
        control.setLayoutY(30*id);

        pane.getChildren().add(control);

        control.setVisible(false);
    }

}
