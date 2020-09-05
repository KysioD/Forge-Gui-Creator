package fr.kysio.forgeguicreator.guis.controlers;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GuiControlerTypeAdapter extends TypeAdapter<GuiControler> {
    @Override
    public void write(JsonWriter writer, GuiControler guiControler) throws IOException {
        System.out.println("WRITE CONTROLLER X : " +guiControler.x);
        System.out.println("WRITE CONTROLLER Y: "+guiControler.y);
        writer.name("x").value(guiControler.x);
        writer.name("y").value(guiControler.y);
        writer.name("width").value(guiControler.width);
        writer.name("height").value(guiControler.height);
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
        int width = 0;
        int height = 0;
        GuiControlers type = guiControlers;

        //while(reader.hasNext()){
        for(int i = 0; i != 4; i++) {
            String nextName = reader.nextName();
            System.out.println("NEXT NAME : "+nextName);
            switch (nextName) {
                case "x":
                    x = reader.nextInt();
                    System.out.println("READ CONTROLLER X : " + x);
                    break;
                case "y":
                    y = reader.nextInt();
                    System.out.println("READ CONTROLLER Y : " + y);
                    break;
                case "width":
                    width = reader.nextInt();
                    System.out.println("READ CONTROLLER WIDTH : "+width);
                    break;
                case "height":
                    height = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        //}
        //reader.endObject();

        System.out.println("create controller width "+width);

        return new GuiControler(null, type, x, y, width, height, null, null, null, null);
    }
}
