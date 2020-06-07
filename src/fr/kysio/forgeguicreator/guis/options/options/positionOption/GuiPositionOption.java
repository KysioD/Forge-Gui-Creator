package fr.kysio.forgeguicreator.guis.options.options.positionOption;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.scene.control.Label;


public class GuiPositionOption extends GuiOption {
    public GuiPositionOption(int x, int y, GuiControler controler) {
        super("position", x, y, controler);
    }

    @Override
    public void enable() {
        Label labelX = new Label("Pos X:");
        Label labelY = new Label("Pos Y:");

        labelX.setLayoutX(x);
        labelX.setLayoutY(y);
        labelX.setVisible(true);
        controler.optionsPane.getChildren().add(labelX);

        super.enable();
    }

    @Override
    public void disable() {

        super.disable();
    }
}
