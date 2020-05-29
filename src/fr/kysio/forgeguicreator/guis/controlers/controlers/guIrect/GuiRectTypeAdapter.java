package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlerTypeAdapter;

import java.io.IOException;

public class GuiRectTypeAdapter extends TypeAdapter<GuiControler> {
    @Override
    public void write(JsonWriter writer, GuiControler guiControler) throws IOException {
        GuiRect rect = (GuiRect)guiControler;

        writer.beginObject();
        new GuiControlerTypeAdapter().write(writer, guiControler);
        writer.name("backgroundColor_r").value(rect.backgroundColor.getRed());
        writer.name("backgroundColor_g").value(rect.backgroundColor.getGreen());
        writer.name("backgroundColor_b").value(rect.backgroundColor.getBlue());
        writer.endObject();
    }

    @Override
    public GuiControler read(JsonReader reader) throws IOException {
        return null;
    }
}
