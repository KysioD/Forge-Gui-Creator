package fr.kysio.forgeguicreator.windows.edit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.GuiFileTypeAdapter;
import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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

    @FXML
    public TextArea textEdit;

    @FXML
    public HBox vueChange;

    public File editedFile = null;
    public File selectedFolder = null;

    public void initialize(){
        nameMenu.setText(Projects.project.getName());

        generateTree();

    }

    public void generateTree(){
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

    public void createGui(){
        System.out.println("CREATE GUI INTO "+selectedFolder);
        if(selectedFolder != null){
            FilesManager.createGuiFile(selectedFolder, "untitled");
        }

        generateTree();
        update();
    }

    public void fileEditorUpdated(){
        FilesManager.updateFile(editedFile, textEdit.getText());
    }

    public void vueGraphic(){
        try {
            emptyPane.setVisible(false);
            editPane.setVisible(true);
            vueChange.setVisible(true);
            txtPane.setVisible(false);

            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(editedFile)));

            String txt = dis.readUTF();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(GuiFile.class, new GuiFileTypeAdapter())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .disableHtmlEscaping()
                    .create();;
            GuiFile guiFile = gson.fromJson(txt, GuiFile.class);

            System.out.println(guiFile);
            System.out.println(guiFile.guiControlers);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void vueJson(){
        try {
            emptyPane.setVisible(false);
            editPane.setVisible(false);
            vueChange.setVisible(true);
            txtPane.setVisible(true);

            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(editedFile)));

            String txt = dis.readUTF();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(txt);
            String prettyJsonString = gson.toJson(je);

            textEdit.clear();
            textEdit.appendText(prettyJsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(editedFile == null) return;

        String[] args = editedFile.getName().split("\\.");
        if(args[args.length-1].equals("json")){
            try {
                System.out.println("EDITING .JSON FILE");
                emptyPane.setVisible(false);
                editPane.setVisible(false);
                vueChange.setVisible(false);
                txtPane.setVisible(true);

                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(editedFile)));

                String txt = dis.readUTF();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();
                JsonElement je = jp.parse(txt);
                String prettyJsonString = gson.toJson(je);

                textEdit.clear();
                textEdit.appendText(prettyJsonString);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(args[args.length-1].equals("gui")){
            try {
                vueGraphic();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void selectFile(){
        TreeItem<String> item = files.getEditingItem();
        if(item != null){
            System.out.println(item);
            String name = Projects.project.getName();
            File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);


            String access = "";
            if(item != files.getRoot()){
                access = "/"+item.getValue();
                while (item.getParent() != files.getRoot()) {
                    item = item.getParent();
                    //String str = access;
                    access = "/" + item.getValue() + access;
                }
            }
            System.out.println("Path :"+projectFolder.getPath()+access);
            File file = new File(projectFolder.getPath()+access);
            if(!file.isDirectory()){
                editedFile = file;
            }else{
                selectedFolder = file;
            }

            update();
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
