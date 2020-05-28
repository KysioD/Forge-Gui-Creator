package fr.kysio.forgeguicreator.utils;

import com.google.gson.Gson;
import fr.kysio.forgeguicreator.Project;
import fr.kysio.forgeguicreator.windows.projects.Projects;
import sun.java2d.cmm.Profile;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;

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

    private static void removeFolder(File folder){
        for(File f : folder.listFiles()){
            if(f.isDirectory()){
                removeFolder(f);
            }else{
                f.delete();
            }
        }
    }

    public static void removeProject(String name){
        File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);

        if(!projectFolder.exists()) {
            System.out.println("remove project not exist");
            return;
        }

        for(File file : projectFolder.listFiles()){
            if(file.isDirectory()){
                removeFolder(file);
            }else{
                file.delete();
            }
        }

        projectFolder.delete();

        System.out.println("project deleted");
    }

    public static void updateFile(File f, String content){
        if(!f.exists() || Projects.project.getName() == null) return;

        String path = f.getPath();

        f.delete();

        try {
            File file = new File(path);

            file.createNewFile();

            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            dos.writeUTF(content);

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProject(String name, String newName, String newAuthor, String newVersion){
        Gson gson = new Gson();

        File projectFolder = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name);
        File projectFile = new File(System.getProperty("user.home") + "/gui-creator/projects/" + name + "/project.json");

        if(!projectFolder.exists() || !projectFile.exists()) return;

        projectFile.delete();
        projectFolder.renameTo(new File(System.getProperty("user.home") + "/gui-creator/projects/" + newName));

        try {
            File file = new File(System.getProperty("user.home") + "/gui-creator/projects/" + newName + "/project.json");

            file.createNewFile();

            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            String json = gson.toJson(new Project(newName, newAuthor, newVersion));

            dos.writeUTF(json);

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Project> getprojects(){
        ArrayList<Project> projects = new ArrayList<>();

        File f = new File(System.getProperty("user.home") + "/gui-creator/projects");

        Gson gson = new Gson();

        for(File file : f.listFiles()){
            if(file.isDirectory()){
                String name = file.getName();
                Project project = getProject(name);

                if(project != null){
                    projects.add(project);
                }
            }
        }

        return projects;
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
