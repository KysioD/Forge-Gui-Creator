package fr.kysio.forgeguicreator.utils;

import com.google.gson.Gson;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.exceptions.ProjectAlreadyExistException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class FilesManager {

    public static final File folder = new File(System.getProperty("user.home") + "/gui-creator");
    public static final File projects = new File(System.getProperty("user.home") + "/gui-creator/projects");

    public static void initFiles() {
        if (!folder.exists()) {
            folder.mkdirs();
        }

        if (!projects.exists()) {
            projects.mkdirs();
        }
    }

    public static Project getProject(String name){
        Gson gson = new Gson();

        File file = new File(System.getProperty("user.home") +"/gui-creator/projects/" + name + "/project.json");

        try {
            if(!file.exists()){
                System.out.println("file not exist");
                return null;
            }

            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            String txt = dis.readUTF();
            System.out.println(txt);

            Project project = gson.fromJson(txt, Project.class);

            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void createProject(String name, String author, String version) {
        Gson gson = new Gson();
        Project project = new Project(name, author, version);

        String json = gson.toJson(project);

        System.out.println(json);

        try {
            File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);
            File projectFile = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name + "/project.json");
            if (projectFile != null && !projectFolder.exists() || !projectFile.exists()) {
                projectFolder.mkdirs();
                projectFile.createNewFile();
            }

            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(projectFile)));

            dos.writeUTF(json);

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
