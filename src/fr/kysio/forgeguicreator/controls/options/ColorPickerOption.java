package fr.kysio.forgeguicreator.controls.options;

import fr.kysio.forgeguicreator.controls.GuiControl;
import fr.kysio.forgeguicreator.controls.GuiControlOption;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.management.DynamicMBean;

public class ColorPickerOption extends GuiControlOption {

    public ColorPickerOption(String name, Pane pane, int id, GuiControl guiControl) {
        super(name, pane, new ColorPicker(Color.WHITE), id, guiControl);

        control.setOnMouseClicked(new ColorPickerOptionClickManager());
        control.setOnMouseExited(new ColorPickerOptionClickManager());
        control.setOnMouseEntered(new ColorPickerOptionClickManager());
        control.setOnMouseMoved(new ColorPickerOptionClickManager());
        control.setOnContextMenuRequested(new ColorPickerOptionContextMenuManager());

        //updateColor();
    }

    public void updateColor(){
        if((ColorPicker)control != null) {
            String style[] = guiControl.getStyle().split(";");
            String color = null;

            for (String string : style) {
                String[] args = string.split(": ");
                if (args[0].equals("-fx-background-color")) {
                    color = args[1];
                }
            }

            ((ColorPicker)control).setValue(new Color(Integer.valueOf(color.substring(1, 3), 16)/255,
                    Integer.valueOf(color.substring(3, 5), 16)/255,
                    Integer.valueOf(color.substring(5, 7), 16)/255, 1));


            if(((ColorPicker)control).getContextMenu() != null) {
                ((ColorPicker) control).getContextMenu().setOnAction(new ColorPickerOptionActionManager());
                System.out.println("color picker enabled");
            }
        }
    }

    class ColorPickerOptionClickManager implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            updateColor();
            Color c = ((ColorPicker)control).getValue();
            String hex = String.format( "#%02X%02X%02X",
                    (int)( c.getRed() * 255 ),
                    (int)( c.getGreen() * 255 ),
                    (int)( c.getBlue() * 255 ) );
            System.out.println("setting to color:  "+hex);
            guiControl.setStyle("-fx-background-color: "+hex);
        }
    }

    class ColorPickerOptionContextMenuManager implements EventHandler<ContextMenuEvent> {

        @Override
        public void handle(ContextMenuEvent event) {
            Color c = ((ColorPicker)control).getValue();
            String hex = String.format( "#%02X%02X%02X",
                    (int)( c.getRed() * 255 ),
                    (int)( c.getGreen() * 255 ),
                    (int)( c.getBlue() * 255 ) );
            System.out.println("setting to color:  "+hex);
            guiControl.setStyle("-fx-background-color: "+hex);

            control.getContextMenu().setOnAction(new ColorPickerOptionActionManager());
            System.out.println("CONTEXT REGISTER");
        }
    }

    class ColorPickerOptionActionManager implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("HANDLE ACTION EVENT");

            Color c = ((ColorPicker)control).getValue();
            String hex = String.format( "#%02X%02X%02X",
                    (int)( c.getRed() * 255 ),
                    (int)( c.getGreen() * 255 ),
                    (int)( c.getBlue() * 255 ) );
            System.out.println("setting to color:  "+hex);
            guiControl.setStyle("-fx-background-color: "+hex);

            updateColor();
        }
    }
}
