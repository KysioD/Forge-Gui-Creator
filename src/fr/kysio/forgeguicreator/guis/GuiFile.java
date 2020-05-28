package fr.kysio.forgeguicreator.guis;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;

import java.util.ArrayList;

public class GuiFile {

    public String name;
    public GuiControler[] guiControlers;

    public GuiFile(String name, GuiControler[] controlers){
        this.name = name;
        this.guiControlers = controlers;
    }

}
