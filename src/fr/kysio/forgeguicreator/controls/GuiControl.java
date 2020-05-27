package fr.kysio.forgeguicreator.controls;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class GuiControl extends Control {

    public String name;
    public Pane pane;

    public GuiControl(String name, Pane pane){
        this.name = name;
        this.pane = pane;
    }

    public abstract ArrayList<GuiControlOption> getOptions();

}
