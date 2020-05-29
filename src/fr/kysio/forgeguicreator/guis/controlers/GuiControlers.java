package fr.kysio.forgeguicreator.guis.controlers;

import fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect.GuiRect;
import fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect.GuiRectTypeAdapter;

public enum GuiControlers {
    GUI_RECT(GuiRect.class, GuiRectTypeAdapter.class);

    private Class<GuiRect> guiRectClass;
    private Class<GuiRectTypeAdapter> guiRectTypeAdapterClass;

    GuiControlers(Class<GuiRect> guiRectClass, Class<GuiRectTypeAdapter> guiRectTypeAdapterClass) {
        this.guiRectClass = guiRectClass;
        this.guiRectTypeAdapterClass = guiRectTypeAdapterClass;
    }

    public Class<GuiRect> getGuiRectClass() {
        return guiRectClass;
    }

    public Class<GuiRectTypeAdapter> getGuiRectTypeAdapterClass() {
        return guiRectTypeAdapterClass;
    }
}
