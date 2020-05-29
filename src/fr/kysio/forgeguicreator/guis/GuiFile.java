package fr.kysio.forgeguicreator.guis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;

import java.util.ArrayList;

public class GuiFile {

    public String name;
    public ArrayList<GuiControler> guiControlers;

    public GuiFile(String name, ArrayList<GuiControler> controlers){
        this.name = name;
        this.guiControlers = controlers;
    }

    public Gson createGsonInstance(){
        return new GsonBuilder()
                .registerTypeAdapter(GuiFile.class, new GuiFileTypeAdapter())
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

}
