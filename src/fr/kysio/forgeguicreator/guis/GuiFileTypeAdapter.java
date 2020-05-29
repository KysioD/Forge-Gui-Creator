package fr.kysio.forgeguicreator.guis;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

import java.io.IOException;

public class GuiFileTypeAdapter extends TypeAdapter<GuiFile> {
    @Override
    public void write(JsonWriter writer, GuiFile guiFile) throws IOException {
        writer.beginObject();
        writer.name("name").value(guiFile.name);
            writer.name("guiControllers").beginArray();
                for(GuiControler guiControler : guiFile.guiControlers){
                    try {
                        guiControler.type.getGuiRectTypeAdapterClass().newInstance().write(writer, guiControler);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            writer.endArray();
        writer.endObject();
    }

    @Override
    public GuiFile read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
