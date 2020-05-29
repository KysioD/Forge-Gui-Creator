package fr.kysio.forgeguicreator.guis.controlers;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GuiControlerTypeAdapter extends TypeAdapter<GuiControler> {
    @Override
    public void write(JsonWriter writer, GuiControler guiControler) throws IOException {
        //writer.beginObject();
        writer.name("x").value(guiControler.x);
        writer.name("y").value(guiControler.y);
        writer.name("type").value(guiControler.type.name());
        //writer.endObject();
    }

    @Override
    public GuiControler read(JsonReader reader) throws IOException {
        reader.beginObject();
        int x = 0;
        int y = 0;
        GuiControlers type = null;

        while(reader.hasNext()){
            switch (reader.nextName()){
                case "x":
                    x = reader.nextInt();
                    break;
                case "y":
                    y = reader.nextInt();
                    break;
                case "type":
                    type = GuiControlers.valueOf(reader.nextString().toUpperCase());
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();

        return new GuiControler(type, x, y);
    }
}
