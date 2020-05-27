package fr.kysio.forgeguicreator.windows.projects;

import fr.kysio.forgeguicreator.Main;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.utils.FilesManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Projects {

    public static Project project = null;

    @FXML
    public Label name;

    @FXML
    public Label author;

    @FXML
    public Label version;

    public ArrayList<Project> projects = FilesManager.getprojects();
    public int selectedProject;

    public void initialize(){
        this.selectedProject = 0;
        Main.stage.setResizable(true);

        update();
    }

    public void update(){
        project = projects.get(selectedProject);

        name.setText(project.getName());
        author.setText(project.getAuthor());
        version.setText(project.getVersion());
    }

    public void nextProject(){
        if(selectedProject < projects.size()-1){
            selectedProject++;
        }

        update();
    }

    public void updateProject(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../updateproject/updateproject.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startProject(){

    }

    public void removeProject(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../removeconfirm/removeconfirm.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void precedentProject(){
        if(selectedProject > 0){
            selectedProject--;
        }

        update();
    }

    public void createProject(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../createprojects/CreateProject.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
