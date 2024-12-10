package enchants.cool.coolenchants.Helper;

import java.util.Arrays;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class EnchantHelper {

    public static void GetEnchants(List<net.kyori.adventure.text.Component> Lore) {

        if (Lore != null) {
            for (int i = 0; i < Lore.size() - 1; i++) {
//                String Line = Lore.get(i).children().get(0).;
//                String Enchant = Arrays.stream(Line).findFirst('');
                getLogger().info(String.valueOf(Lore.get(i).children().get(0)));
            }

        }
    }
}