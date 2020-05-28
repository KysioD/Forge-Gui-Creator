package fr.kysio.forgeguicreator.controls.controls;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.GuiControlOption;
import fr.kysio.forgeguicreator.controls.options.ColorPickerOption;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class RectangleControl extends GuiControl {
    public RectangleControl(Pane pane, Pane optionsPane) {
        super("rectangle", pane, optionsPane);

        System.out.println("RECTANGLE DRAWED");
    }

    @Override
    public ArrayList<GuiControlOption> getOptions() {
        ArrayList<GuiControlOption> options = new ArrayList<>();

        options.add(new ColorPickerOption("background color : ", optionsPane, 1));
        options.add(new ColorPickerOption("border color: ", optionsPane, 2));

        return options;
    }
}
