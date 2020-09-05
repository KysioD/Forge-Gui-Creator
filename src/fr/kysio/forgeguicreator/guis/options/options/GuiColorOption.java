package fr.kysio.forgeguicreator.guis.options.options;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect.GuiRect;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class GuiColorOption extends GuiOption {

    public GuiColorOption(int x, int y, GuiControler controler) {
        super("color", x, y, controler);
    }

    @Override
    public void enable() {
        System.out.println("enabling gui position option");

        ColorPicker colorPicker = new ColorPicker();

        colorPicker.setLayoutX(x);
        colorPicker.setLayoutY(y);
        colorPicker.setVisible(true);
        colorPicker.setLayoutX(x);
        colorPicker.setLayoutY(y + 25);
        colorPicker.setVisible(true);

        colorPicker.setOnMouseMoved(event -> {
                    Color color = colorPicker.getValue();

                    if (controler instanceof GuiRect) {
                        GuiRect guiRect = (GuiRect) controler;
                        guiRect.backgroundColor = color;

                        controler.updateController();
                    }
                }
        );

        controler.optionsPane.getChildren().add(colorPicker);
        controler.optionsPane.setVisible(true);

        super.enable();
    }



    /*public void pressEnter(KeyCode code){
        if(code != KeyCode.ENTER) return;
        try {
            if (!textFieldX.getText().isEmpty()) {
                controler.x = Integer.parseInt(textFieldX.getText());
                System.out.println("edit controler x to : " + controler.x);
            }
            if (!textFieldY.getText().isEmpty()) {
                controler.y = Integer.parseInt(textFieldY.getText());
                System.out.println("edit controler y to : " + controler.y);
            }

            textFieldX.setText(controler.x + "");
            textFieldY.setText(controler.y + "");

            controler.updateController();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    @Override
    public void disable() {

        super.disable();
    }
}
