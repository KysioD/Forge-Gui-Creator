package fr.kysio.forgeguicreator.commands;

import fr.kysio.forgeguicreator.guis.GuiFile;

public class Command {

    private String name;
    private String commandDescription;
    private CommandArg[] commandArgs;
    private GuiFile guiFile;
    private String commandPermission;

    public Command(String name, String commandDescription, CommandArg[] commandArgs, String commandPermission, GuiFile guiFile){
        this.name = name;
        this.commandArgs = commandArgs;
        this.guiFile = guiFile;
        this.commandPermission = commandPermission;
        this.commandDescription = commandDescription;
    }

    public void onCommandExecute(){}

    public String getName() {
        return name;
    }

    public CommandArg[] getCommandArgs() {
        return commandArgs;
    }

    public GuiFile getGuiFile() {
        return guiFile;
    }

    public String getCommandPermission() {
        return commandPermission;
    }
}
