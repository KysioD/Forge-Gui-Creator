package fr.kysio.forgeguicreator.guis.controlers;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GuiControlerTypeAdapter extends TypeAdapter<GuiControler> {
    @Override
    public void write(JsonWriter writer, GuiControler guiControler) throws IOException {
        writer.name("x").value(guiControler.x);
        writer.name("y").value(guiControler.y);
        //writer.name("type").value(guiControler.type.name());
    }

    public GuiControlers guiControlers;

    public GuiControler customRread(JsonReader reader, GuiControlers controlers) throws IOException {
        this.guiControlers = controlers;
        return read(reader);
    }

    @Override
    public GuiControler read(JsonReader reader) throws IOException {
        //reader.beginObject();
        int x = 0;
        int y = 0;
        GuiControlers type = guiControlers;

        //while(reader.hasNext()){
            switch (reader.nextName()){
                case "x":
                    x = reader.nextInt();
                    break;
                case "y":
                    y = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
            switch (reader.nextName()){
                case "x":
                    x = reader.nextInt();
                    break;
                case "y":
                    y = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        //}
        //reader.endObject();

        return new GuiControler(null, type, x, y, null, null, null);
    }
}
