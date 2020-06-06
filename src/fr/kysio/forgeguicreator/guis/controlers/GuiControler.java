package fr.kysio.forgeguicreator.guis.controlers;


import fr.kysio.forgeguicreator.guis.options.GuiOption;
import fr.kysio.forgeguicreator.guis.options.GuiOptions;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GuiControler {

    public int x;
    public int y;
    public GuiControlers type;

    public Pane editPane;

    public GuiControler(GuiControlers type, int x, int y, Pane editPane){
        this.type = type;
        this.x = x;
        this.y = y;
        this.editPane = editPane;
    }

    public void draw() {

    }

    public void enable(){

    }

    public void disable(){

    }

    public ArrayList<GuiOptions> guiOptions(){
        return new ArrayList<>();
    }

}
