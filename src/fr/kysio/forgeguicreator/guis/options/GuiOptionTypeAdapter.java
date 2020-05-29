package fr.kysio.forgeguicreator.guis.options;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;

import java.io.IOException;

public class GuiOptionTypeAdapter extends TypeAdapter<GuiOption> {
    @Override
    public void write(JsonWriter jsonWriter, GuiOption guiOption) throws IOException {

    }

    @Override
    public GuiOption read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
