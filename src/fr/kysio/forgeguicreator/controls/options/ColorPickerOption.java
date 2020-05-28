package fr.kysio.forgeguicreator.controls.options;

import fr.kysio.forgeguicreator.controls.GuiControlOption;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ColorPickerOption extends GuiControlOption {

    public ColorPickerOption(String name, Pane pane, int id) {
        super(name, pane, new ColorPicker(Color.WHITE), id);

    }
}
