package fr.kysio.forgeguicreator.controls.options;

import fr.kysio.forgeguicreator.controls.GuiControlOption;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ColorPickerOption extends GuiControlOption {

    public ColorPickerOption(String name, Pane pane) {
        super(name, pane, new ColorPicker(Color.WHITE));

        control.setLayoutX(30);
        control.setLayoutY(50);

        pane.getChildren().add(control);

        System.out.println("COLOR PICKER DRAWED");
    }
}
