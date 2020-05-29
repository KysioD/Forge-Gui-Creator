package fr.kysio.forgeguicreator.guis.controlers;


import javafx.scene.paint.Color;

public class GuiControler {

    public int x;
    public int y;
    public GuiControlers type;

    public GuiControler(GuiControlers type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }

}
