package fr.kysio.forgeguicreator.windows.createcommands;

import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.edit.Edit;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateCommands {

    @FXML
    public TextField name;

    public void initialize(){

    }

    public void createGui(){
        FilesManager.createCommandFile(Edit.selectedFolder, name.getText());
        Edit.popup.close();
        Edit.popup = null;
        Edit.generateTree();
    }

}
