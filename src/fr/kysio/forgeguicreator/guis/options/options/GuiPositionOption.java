package fr.kysio.forgeguicreator.guis.options.options;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import fr.kysio.forgeguicreator.windows.edit.Edit;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.security.Key;


public class GuiPositionOption extends GuiOption {

    public Label labelX;
    public Label labelY;
    public TextField textFieldX;
    public TextField textFieldY;

    public GuiPositionOption(int x, int y, GuiControler controler) {
        super("position", x, y, controler);labelX = new Label("Pos X:");
    }

    @Override
    public void enable() {
        System.out.println("enabling gui position option");

        labelX = new Label("Pos X:");
        labelY = new Label("Pos Y:");
        textFieldX = new TextField(""+controler.x);
        textFieldY = new TextField(""+controler.y);

        textFieldX.setOnKeyPressed(event -> {
            pressEnter(event.getCode());
        });
        textFieldY.setOnKeyPressed(event -> {
            pressEnter(event.getCode());
        });

        labelX.setLayoutX(x);
        labelX.setLayoutY(y);
        labelX.setVisible(true);
        labelX.setStyle("-fx-text-fill: white");
        labelY.setLayoutX(x);
        labelY.setLayoutY(y+25);
        labelY.setVisible(true);
        labelY.setStyle("-fx-text-fill: white");

        textFieldX.setLayoutX(x+40);
        textFieldX.setLayoutY(y-2);
        textFieldX.setPrefWidth(50);

        textFieldY.setLayoutX(x+40);
        textFieldY.setLayoutY(y+23);
        textFieldY.setPrefWidth(50);

        controler.optionsPane.getChildren().addAll(textFieldX, labelX, labelY, textFieldY);
        controler.optionsPane.setVisible(true);

        super.enable();
    }

    public void pressEnter(KeyCode code){
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
    }

    @Override
    public void disable() {

        super.disable();
    }
}
