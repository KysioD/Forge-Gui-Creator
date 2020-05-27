package fr.kysio.forgeguicreator.controls;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class GuiControl extends Button {

    public String name;
    public Pane pane;
    public Pane optionsPane;

    public GuiControl(String name, Pane pane, Pane optionspane){
        this.name = name;
        this.pane = pane;
        this.optionsPane = optionspane;

        for(GuiControlOption option : getOptions()){
            option.control.setVisible(false);
        }

        this.setText(name);
        this.setLayoutX(20);
        this.setLayoutY(25);

        pane.getChildren().add(this);

        getOptions();
    }

    public abstract ArrayList<GuiControlOption> getOptions();

}
