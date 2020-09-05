package fr.kysio.forgeguicreator.guis.controlers.gizmo;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import javafx.scene.layout.AnchorPane;

public class ControlerGizmo2D {

    public GuiControler guiControler;

    public static ControlerGizmo2D currentGizmo;
    public static GizmoMods gizmoMod;

    public ControlerGizmo2D(GuiControler guiControler) {
        this.guiControler = guiControler;
    }

    AnchorPane paneY;
    AnchorPane paneX;
    AnchorPane posYPane;
    AnchorPane posXPane;

    public void render() {
        System.out.println("rendering gizmo");

        System.out.println("RENDER GIZMO WITH MOD : "+gizmoMod);

        paneY = new AnchorPane();
        paneY.setLayoutX(guiControler.width / 2 - 2);
        paneY.setLayoutY(guiControler.height / 2 - 40);
        paneY.setPrefSize(2, 40);
        paneY.setStyle("-fx-background-color: white; -fx-border-color: black");
        paneY.setVisible(true);

        paneX = new AnchorPane();
        paneX.setLayoutX(guiControler.width / 2);
        paneX.setLayoutY(guiControler.height / 2 - 2);
        paneX.setPrefSize(40, 2);
        paneX.setStyle("-fx-background-color: white; -fx-border-color: black");
        posYPane = new AnchorPane();
        posYPane.setLayoutX(guiControler.width / 2 - 7);
        posYPane.setLayoutY(guiControler.height / 2 - 40);
        posYPane.setPrefSize(10, 10);
        posYPane.setStyle("-fx-background-color: white; -fx-border-color: black");
        posYPane.setOnMousePressed(event -> {
            System.out.println("PRESS POS Y GIZMO");
            changePosY();
        });
        posYPane.setOnMouseReleased(event -> {
            currentGizmo = new ControlerGizmo2D(guiControler);
            guiControler.editPane.setOnMouseDragged(event1 -> {});
            remove();
        });

        posXPane = new AnchorPane();
        posXPane.setLayoutX(guiControler.width / 2 + 40);
        posXPane.setLayoutY(guiControler.height / 2 - 7);
        posXPane.setPrefSize(10, 10);
        posXPane.setStyle("-fx-background-color: white; -fx-border-color: black");
        posXPane.setOnMousePressed(event -> {
            System.out.println("PRESS POS X GIZMO");
            changePosX();
        });
        posXPane.setOnMouseReleased(event -> {
            currentGizmo = new ControlerGizmo2D(guiControler);
            guiControler.editPane.setOnMouseDragged(event1 -> {});
            remove();
        });


        if(gizmoMod == GizmoMods.TRANSLATE){
            posYPane.setRotate(45);
            posXPane.setRotate(45);
        }

        guiControler.getChildren().addAll(paneY, posYPane, paneX, posXPane);
    }

    public void remove() {
        System.out.println("removing gizmo");
        try {
            guiControler.getChildren().remove(posYPane);
            guiControler.getChildren().remove(paneY);
            guiControler.getChildren().remove(paneX);
            guiControler.getChildren().remove(posXPane);
            this.finalize(); // frees up the memory resources used by the object
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void changePosY() {
        switch (gizmoMod) {
            default:
                break;
            case TRANSLATE:
                guiControler.editPane.setOnMouseDragged(event -> {
                    guiControler.y = (int) ((guiControler.height / 2 - 40) + event.getY());

                    guiControler.updateController();
                });
                break;
            case SCALE:
                guiControler.editPane.setOnMouseDragged(event -> {
                    guiControler.height = (int) ((guiControler.height / 2 - 40) + event.getY());

                    guiControler.updateController();
                });
                break;
        }
    }

    private void changePosX() {
        switch (gizmoMod) {
            default:
                break;
            case TRANSLATE:
                System.out.println("MOD TRANSLATE");
                guiControler.editPane.setOnMouseDragged(event -> {
                    guiControler.x = (int) ((guiControler.width / 2) + event.getX()) - (guiControler.width + 40);

                    guiControler.updateController();
                });
                break;
            case SCALE:
                System.out.println("MOD SCALE");
                guiControler.editPane.setOnMouseDragged(event -> {
                    guiControler.width = (int) ((guiControler.width / 2) + event.getX()) - (guiControler.width + 40);

                    guiControler.updateController();
                });
                break;
        }
    }

    private void changeSizeX() {

    }

    private void changeSizeY() {

    }
}
