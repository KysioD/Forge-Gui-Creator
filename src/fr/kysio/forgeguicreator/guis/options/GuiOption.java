package fr.kysio.forgeguicreator.guis.options;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

public class GuiOption {

    public String name;
    public int x;
    public int y;
    public GuiControler controler;

    public GuiOption(String name, int x, int y, GuiControler controler){
        this.name = name;
        this.x = x;
        this.y = y;
        this.controler = controler;
    }

    public void enable(){

    }

    public void disable(){

    }

    public int getNextX(){
        return 0;
    }

    public int getNextY(){
        return 0;
    }

}
