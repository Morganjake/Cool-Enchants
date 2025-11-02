package enchants.cool.coolenchants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHandler extends JavaPlugin {

    private static final Gson Gson = new Gson();
    private static JsonObject Json;
    private static File JsonFile;

    public static void Init(JavaPlugin Plugin) {
        File Folder = Plugin.getDataFolder();
        if (!Folder.exists()) { Folder.mkdirs(); }

        JsonFile = new File(Folder, "Settings.json");

        if (!JsonFile.exists()) {
            Json = new JsonObject();
            SaveJson();
        }

        try (FileReader reader = new FileReader(JsonFile)) {
            Json = Gson.fromJson(reader, JsonObject.class);
            if (Json == null) {
                Json = new JsonObject();
            };
        } catch (IOException Error) {
            Error.printStackTrace();
            Json = new JsonObject();
        }
    }

    private static void SaveJson() {
        try (FileWriter writer = new FileWriter(JsonFile)) {
            Gson.toJson(Json, writer);
        } catch (IOException Error) {
            Error.printStackTrace();
        }
    }

    public static void Toggle(Player Player, String Key) {

        if (!Json.has(Player.getName())) {
            JsonObject PlayerEntry = new JsonObject();
            PlayerEntry.addProperty("toggletunneller", true);
            PlayerEntry.addProperty("toggletreecapitator", true);
            Json.add(Player.getName(), PlayerEntry);
            SaveJson();
        }

        JsonObject PlayerJson = Json.getAsJsonObject(Player.getName());

        if (PlayerJson.has(Key)) {
            boolean Value = PlayerJson.get(Key).getAsBoolean();
            PlayerJson.addProperty(Key, !Value);
            SaveJson();
        }
    }

    public static boolean GetJsonValue(Player Player, String Key) {
        if (!Json.has(Player.getName())) {
            JsonObject PlayerEntry = new JsonObject();
            PlayerEntry.addProperty("toggletunneller", true);
            PlayerEntry.addProperty("toggletreecapitator", true);
            Json.add(Player.getName(), PlayerEntry);
            SaveJson();
        }

        JsonObject PlayerJson = Json.getAsJsonObject(Player.getName());

        return PlayerJson.has(Key) && PlayerJson.get(Key).getAsBoolean();
    }
}
