package fr.kysio.forgeguicreator.guis.controlers;


import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GuiControler extends Pane implements EventHandler<MouseEvent> {

    public GuiFile guiFile;

    public int x;
    public int y;
    public GuiControlers type;

    public Pane editPane;
    public Pane controlersPane;
    public Pane optionsPane;

    public GuiControler(GuiFile guiFile, GuiControlers type, int x, int y, Pane editPane, Pane controlersPane, Pane optionsPane){
        this.guiFile = guiFile;
        this.type = type;
        this.x = x;
        this.y = y;
        this.editPane = editPane;
        this.controlersPane = controlersPane;
        this.optionsPane = optionsPane;
    }

    public void draw() {

    }

    public void enable(){
        this.setOnMouseClicked(this);
    }

    public void disable(){

    }

    public ArrayList<GuiOption> guiOptions(){
        return new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("CLICK ON CONTROLER");
        System.out.println("Controller gui options : "+guiOptions());

        for(GuiControler guiControler : guiFile.guiControlers){
            for(GuiOption guiOption : guiControler.guiOptions()){
                guiOption.disable();
            }
        }

        for(GuiOption guiOption : guiOptions()){
            guiOption.enable();
        }
    }
}
