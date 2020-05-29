package fr.kysio.forgeguicreator.windows.edit.creategui;

import fr.kysio.forgeguicreator.utils.FilesManager;
import fr.kysio.forgeguicreator.windows.edit.Edit;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateGui {

    @FXML
    public TextField name;

    public void initialize(){

    }

    public void createGui(){
        FilesManager.createGuiFile(Edit.selectedFolder, name.getText());
        Edit.popup.close();
        Edit.popup = null;
        Edit.generateTree();
    }

}
