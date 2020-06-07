package fr.kysio.forgeguicreator.guis;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.kysio.forgeguicreator.guis.controlers.GuiControler;
import fr.kysio.forgeguicreator.guis.controlers.GuiControlers;
import fr.kysio.forgeguicreator.guis.controlers.controlers.guIrect.GuiRectTypeAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class GuiFileTypeAdapter extends TypeAdapter<GuiFile> {
    @Override
    public void write(JsonWriter writer, GuiFile guiFile) throws IOException {
        writer.beginObject();
        writer.name("name").value(guiFile.name);
        writer.name("guiControllers").beginArray();
            for(GuiControler guiControler : guiFile.guiControlers){
                try {
                    writer.beginObject();
                    writer.name("type").value(guiControler.type.name());
                        guiControler.type.getGuiRectTypeAdapterClass().newInstance().write(writer, guiControler);
                    writer.endObject();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        writer.endArray();
        writer.endObject();
    }

    @Override
    public GuiFile read(JsonReader reader) throws IOException {
        reader.beginObject();
        String name = null;
        ArrayList<GuiControler> controlers = new ArrayList<>();

        while(reader.hasNext()){
            switch (reader.nextName()){
                case "name":
                    name = reader.nextString();
                    break;
                case "guiControllers":
                    reader.beginArray();
                        while(reader.hasNext()){
                            reader.beginObject();
                            //while (reader.hasNext()){
                                switch (reader.nextName()){
                                    case "type":
                                            System.out.println("TYPE FOUND ");
                                            GuiControlers controlerType = GuiControlers.valueOf(reader.nextString().toUpperCase());
                                            try {
                                                controlers.add(controlerType.getGuiRectTypeAdapterClass().newInstance().customRread(reader, controlerType));
                                            } catch (InstantiationException e) {
                                                e.printStackTrace();
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                        break;
                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            //}
                            reader.endObject();
                        }
                        reader.endArray();
                        break;
            }
        }

        reader.endObject();
        System.out.println("Name : "+name);
        System.out.println("Controlers : "+controlers);

        GuiFile guiFile = new GuiFile(name, controlers);
        for(GuiControler controler : guiFile.guiControlers){
            controler.guiFile = guiFile;
        }

        return guiFile;
    }
}
