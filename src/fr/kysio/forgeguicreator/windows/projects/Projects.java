package fr.kysio.forgeguicreator.windows.projects;

import fr.kysio.forgeguicreator.Main;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.utils.FilesManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class Projects {

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

        Project project = projects.get(selectedProject);

        name.setText(project.getName());
        author.setText(project.getAuthor());
        version.setText(project.getVersion());
    }

    public void nextProject(){
        if(selectedProject < projects.size()-1){
            selectedProject++;
        }


        Project project = projects.get(selectedProject);

        name.setText(project.getName());
        author.setText(project.getAuthor());
        version.setText(project.getVersion());
    }

    public void precedentProject(){
        if(selectedProject > 0){
            selectedProject--;
        }


        Project project = projects.get(selectedProject);

        name.setText(project.getName());
        author.setText(project.getAuthor());
        version.setText(project.getVersion());
    }

    public void createProject(){
        try {
            Main.changeWindow(FXMLLoader.load(getClass().getResource("../createprojects/CreateProject.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
