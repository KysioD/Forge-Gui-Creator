package fr.kysio.forgeguicreator.guis.options;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

public class GuiOption {

    String name;
    int x;
    int y;
    GuiControler controler;

    public GuiOption(String name, int x, int y, GuiControler controler){
        this.name = name;
        this.x = x;
        this.controler = controler;
    }

    public void enable(){

    }

    public void disable(){

    }

}
