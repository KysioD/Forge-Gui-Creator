package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import com.sun.istack.internal.Nullable;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import fr.kysio.forgeguicreator.guis.options.options.GuiPositionOption;
import fr.kysio.forgeguicreator.guis.options.options.GuiScaleOption;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GuiRect extends GuiControler {

    public Color backgroundColor;

    public AnchorPane pane;

    public GuiRect(GuiFile guiFile, int x, int y, int width, int height, Color backgoundColor, @Nullable Pane editPane, @Nullable Pane controlerPane, @Nullable Pane optionsPane, @Nullable Pane objectPane) {
        super(guiFile, GuiControlers.GUI_RECT, x, y, width, height, editPane, controlerPane, optionsPane, objectPane);
        this.backgroundColor = backgoundColor;
    }

    @Override
    public void draw() {
        System.out.println("draw guirect");
        pane = new AnchorPane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        pane.setMaxWidth(width);
        pane.setMaxHeight(height);
        pane.setMinHeight(height);
        pane.setMinWidth(width);
        pane.setVisible(true);

        System.out.println("width : "+width);
        System.out.println("height : "+height);

        String hex = String.format( "#%02X%02X%02X",
                (int)( backgroundColor.getRed() * 255 ),
                (int)( backgroundColor.getGreen() * 255 ),
                (int)( backgroundColor.getBlue() * 255 ) );

        pane.setStyle("-fx-background-color: "+hex+";");

        editPane.getChildren().add(pane);
        pane.setOnMouseClicked(this);
    }

    @Override
    public void disable() {
        if(pane != null){
            pane.setVisible(false);
            editPane.getChildren().remove(pane);
        }
    }

    @Override
    public ArrayList<GuiOption> guiOptions() {
        ArrayList<GuiOption> guiOptions = new ArrayList<>();
        guiOptions.add(new GuiPositionOption(10, 35, this));
        guiOptions.add(new GuiScaleOption(10, 100, this));
        return guiOptions;
    }
}
