package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;
import javafx.scene.paint.Color;

public class GuiRect extends GuiControler {

    public Color backgroundColor;

    public int width;
    public int height;

    public GuiRect(int x, int y, int width, int height, Color backgoundColor) {
        super(GuiControlers.GUI_RECT, x, y);
        this.backgroundColor = backgoundColor;
        this.width = width;
        this.height = height;
    }
}
