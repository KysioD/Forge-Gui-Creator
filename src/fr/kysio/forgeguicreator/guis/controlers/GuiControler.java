package fr.kysio.forgeguicreator.guis.controlers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.GuiFileTypeAdapter;
import fr.kysio.forgeguicreator.guis.options.GuiOption;
import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.ArrayList;

import static fr.kysio.forgeguicreator.guis.controlers.ControlerGizmo2D.currentGizmo;

public class GuiControler extends Pane implements EventHandler<MouseEvent> {

    public GuiFile guiFile;

    public int x;
    public int y;
    public int width;
    public int height;
    public GuiControlers type;

    public Pane editPane;
    public Pane controlersPane;
    public Pane optionsPane;
    public Pane objectsPane;

    public GuiControler(GuiFile guiFile, GuiControlers type, int x, int y, int width, int height, Pane editPane, Pane controlersPane, Pane optionsPane, Pane objectPane){
        this.guiFile = guiFile;
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.editPane = editPane;
        this.controlersPane = controlersPane;
        this.optionsPane = optionsPane;
        this.objectsPane = objectPane;
    }

    public void draw() {

    }

    public void enable(){
        this.setOnMouseClicked(this);
        draw();
    }

    public void disable(){

    }

    public ArrayList<GuiOption> guiOptions(){
        return new ArrayList<>();
    }

    public void resetGraphic(){
        for(int i = 0; editPane.getChildren().size() > i; i++){
            editPane.getChildren().remove(i);
        }

        for(GuiControler controler : guiFile.guiControlers){
            controler.editPane = editPane;
            controler.optionsPane = optionsPane;
            controler.controlersPane = objectsPane;
            controler.enable();
        }
    }

    public void updateController(){
        File editedFile = new File(System.getProperty("user.home") + "/gui-creator/projects/" + Projects.project.getName()+"/"+guiFile.name+".gui");

        if(editedFile == null || !editedFile.exists() || guiFile == null || editPane == null) return;

        resetGraphic();

        Gson gson = guiFile.createGsonInstance();
        String json = gson.toJson(guiFile);
        System.out.println("JSON GUIFILE : "+json);

        FilesManager.updateFile(editedFile, json);

        resetGraphic();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("CLICK ON CONTROLER");
        System.out.println("Controller gui options : "+guiOptions());

        if(currentGizmo != null) currentGizmo.remove();

        for(GuiControler guiControler : guiFile.guiControlers){
            for(GuiOption guiOption : guiControler.guiOptions()){
                guiOption.disable();
            }
        }

        for(GuiOption guiOption : guiOptions()){
            guiOption.enable();
        }

        ControlerGizmo2D gizmo2D = new ControlerGizmo2D(this);
        gizmo2D.render();

        currentGizmo = gizmo2D;
    }
}
