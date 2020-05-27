package fr.kysio.forgeguicreator.controls.controls;

import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.GuiControlOption;
import fr.kysio.forgeguicreator.controls.options.ColorPickerOption;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class RectangleControl extends GuiControl {
    public RectangleControl(Pane pane) {
        super("rectangle", pane);

        Button button = new Button("test");
        button.setLayoutX(20);
        button.setLayoutY(20);

        pane.getChildren().add(button);

        System.out.println("RECTANGLE DRAWED");
    }

    @Override
    public ArrayList<GuiControlOption> getOptions() {
        ArrayList<GuiControlOption> options = new ArrayList<>();

        options.add(new ColorPickerOption("background color : ", pane));

        return options;
    }
}
