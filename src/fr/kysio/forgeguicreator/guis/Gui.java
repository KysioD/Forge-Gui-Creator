package fr.kysio.forgeguicreator.guis;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

import java.util.ArrayList;

public class Gui {
    public String name;
    public ArrayList<Class <? extends GuiControler>> guiControlers;

    public Gui(String name, ArrayList<Class <? extends GuiControler>> controlers){
        this.name = name;
        this.guiControlers = controlers;
    }
}
