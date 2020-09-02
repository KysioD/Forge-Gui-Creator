package fr.kysio.forgeguicreator.guis.options.options.positionOption;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


public class GuiPositionOption extends GuiOption {
    public GuiPositionOption(int x, int y, GuiControler controler) {
        super("position", x, y, controler);
    }

    @Override
    public void enable() {
        System.out.println("enabling gui position option");
        Label labelX = new Label("Pos X:");
        Label labelY = new Label("Pos Y:");
        TextField textFieldX = new TextField(""+controler.x);
        TextField textFieldY = new TextField(""+controler.y);

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

        controler.optionsPane.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            if(event.getCode() == KeyCode.ENTER){
                try {
                    if(!textFieldX.getText().isEmpty()) {
                        controler.x = Integer.parseInt(textFieldX.getText());
                    }
                    if(!textFieldY.getText().isEmpty()){
                        controler.y = Integer.parseInt(textFieldY.getText());
                    }

                    textFieldX.setText(controler.x+"");
                    textFieldY.setText(controler.y+"");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        controler.optionsPane.getChildren().addAll(textFieldX, labelX, labelY, textFieldY);
        controler.optionsPane.setVisible(true);

        super.enable();
    }

    @Override
    public void disable() {

        super.disable();
    }
}
