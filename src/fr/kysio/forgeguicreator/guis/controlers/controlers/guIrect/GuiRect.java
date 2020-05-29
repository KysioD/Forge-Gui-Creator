package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;
import javafx.scene.paint.Color;

public class GuiRect extends GuiControler {

    public Color backgroundColor;

    public GuiRect(int x, int y, Color backgoundColor) {
        super(GuiControlers.GUI_RECT, x, y);
        this.backgroundColor = backgoundColor;
    }
}
