package fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.GuiFile;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlerTypeAdapter;
import javafx.scene.paint.Color;

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
        //reader.beginObject();
        int backgroundColorR = 0;
        int backgroundColorG = 0 ;
        int backgroundColorB = 0;
        GuiControler controler = new GuiControlerTypeAdapter().read(reader);

        while (reader.hasNext()){
            switch (reader.nextName()){
                case "backgroundColor_r":
                    backgroundColorR = reader.nextInt();
                case "backgroundColor_g":
                    backgroundColorG = reader.nextInt();
                case "backgroundColor_b":
                    backgroundColorB = reader.nextInt();
                default:
                    reader.skipValue();
                    break;
            }
        }
        //reader.endObject();


        return new GuiRect(controler.x, controler.y, new Color(backgroundColorR, backgroundColorG, backgroundColorB, 1));
    }
}
