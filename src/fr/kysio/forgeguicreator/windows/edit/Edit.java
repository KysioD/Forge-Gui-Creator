package fr.kysio.forgeguicreator.windows.edit;

import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.swing.event.HyperlinkEvent;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Edit{

    @FXML
    public Menu nameMenu;

    @FXML
    public Pane editPane;

    @FXML
    public Pane optionsPane;

    @FXML
    public Pane objectsPane;

    @FXML
    public Pane txtPane;

    @FXML
    public Pane emptyPane;

    @FXML
    public TreeView<String> files;

    public void initialize(){
        nameMenu.setText(Projects.project.getName());

        String name = Projects.project.getName();
        File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);

        TreeItem<String> item = new TreeItem<>();
        item.setValue(name);
        item.setExpanded(true);

        if(projectFolder.listFiles() != null) {
            for (File file : Objects.requireNonNull(projectFolder.listFiles())) {
                if (file.isDirectory()) {
                    folderTree(file, item);
                } else {
                    TreeItem<String> it = new TreeItem<>(file.getName());
                    item.getChildren().add(it);
                }
            }
        }

        files.setRoot(item);

    }

    public void selectFile(){
        TreeItem<String> item = files.getEditingItem();
        if(item != null){
            System.out.println(item);
            String name = Projects.project.getName();
            File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);

            while (item.getParent() != files.getRoot()){

            }
        }
    }

    public void folderTree(File file, TreeItem<String> item){
        if(file.listFiles() != null) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println(f.getName()+" is a directory");
                    TreeItem<String> it = new TreeItem<>(f.getName());
                    it.setExpanded(true);
                    item.getChildren().add(it);

                    folderTree(f, it);
                } else {
                    System.out.println(f.getName()+" is a file");
                    TreeItem<String> it = new TreeItem<>(f.getName());
                    item.getChildren().add(it);
                }
            }
        }else{
            TreeItem<String> it = new TreeItem<>(file.getName());
            item.getChildren().add(it);
        }
    }
}
