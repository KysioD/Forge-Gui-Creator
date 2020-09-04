package fr.kysio.forgeguicreator.guis.options.options;

import fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect.GuiRect;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class GuiScaleOption extends GuiOption {
    GuiRect controler;

    public Label labelX;
    public Label labelY;
    public TextField textFieldX;
    public TextField textFieldY;

    public GuiScaleOption(int x, int y, GuiRect controler) {
        super("scale", x, y, controler);
        this.controler = controler;
    }

    @Override
    public void enable() {


        GuiRect controler = (GuiRect)this.controler;


        labelX = new Label("Width:");
        labelY = new Label("Height:");

        textFieldX = new TextField(""+controler.width);
        textFieldY = new TextField(""+controler.height);

        textFieldX.setOnKeyPressed(event -> {
            pressEnter(event.getCode());
        });
        textFieldY.setOnKeyPressed(event -> {
            pressEnter(event.getCode());
        });

        System.out.println("enabling gui scale option");
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
                    controler.width = Integer.parseInt(textFieldX.getText());
                }
                if (!textFieldY.getText().isEmpty()) {
                    controler.height = Integer.parseInt(textFieldY.getText());
                }

                textFieldX.setText(controler.width + "");
                textFieldY.setText(controler.height + "");

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
