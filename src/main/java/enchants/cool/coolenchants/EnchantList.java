package enchants.cool.coolenchants;

import java.util.ArrayList;
import java.util.Map;

public class Enchants {

    public static ArrayList<String> Get(String Rarity) {

        return Map.of(
                "Common", new ArrayList<String>(),
                "Uncommon", new ArrayList<String>(),
                "Rare", new ArrayList<String>(),
                "Epic", new ArrayList<String>(),
                "Legendary", new ArrayList<String>()
        ).get(Rarity);
    }
}
