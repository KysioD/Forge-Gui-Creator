package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.controls.GuiControl;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseManager implements EventHandler<MouseEvent> {

    GuiControl guiControl;

    public MouseManager(GuiControl guiControl){
        this.guiControl = guiControl;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("HANDLE "+event.getEventType());
        if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            guiControl.setLayoutX(event.getX());
            guiControl.setLayoutY(event.getY());
        }
    }
}
