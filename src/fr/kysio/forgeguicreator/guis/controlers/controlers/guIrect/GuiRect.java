package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import com.sun.istack.internal.Nullable;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GuiRect extends GuiControler {

    public Color backgroundColor;

    public int width;
    public int height;

    public AnchorPane pane;

    public GuiRect(int x, int y, int width, int height, Color backgoundColor, @Nullable Pane editPane) {
        super(GuiControlers.GUI_RECT, x, y, editPane);
        this.backgroundColor = backgoundColor;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        pane = new AnchorPane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setVisible(true);

        String hex = String.format( "#%02X%02X%02X",
                (int)( backgroundColor.getRed() * 255 ),
                (int)( backgroundColor.getGreen() * 255 ),
                (int)( backgroundColor.getBlue() * 255 ) );

        pane.setStyle("-fx-background-color: "+hex+";");

        System.out.println("Background color hex : "+hex);
        System.out.println("Background color : "+backgroundColor);

        editPane.getChildren().add(pane);
    }

    @Override
    public void enable() {
        draw();
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
        return super.guiOptions();
    }
}
