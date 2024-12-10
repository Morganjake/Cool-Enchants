package enchants.cool.coolenchants.Helper;

import java.util.*;

public class EnchantHelper {

    // Gets the enchant text from a TextComponent
    private static String GetEnchantText(String Line) {
        String Enchant = String.join("", List.of(Line.split("")).subList(Line.indexOf('"') + 1, Line.length()));
        Enchant = String.join("", List.of(Enchant.split("")).subList(0, Enchant.indexOf('"')));
        return Enchant;
    }


    private static Map<String, Integer> GetEnchantAndLevel(String Enchant) {

        String[] Levels = {"I", "II", "III", "IV", "V"};
        int LevelNum = 0;
        int EnchantLevel = 1;
        boolean HasLevel = false;

        for (String Level : Levels) {
            LevelNum += 1;
            if (Enchant.endsWith(Level)) {
                EnchantLevel = LevelNum;
                HasLevel = true;
            }
        }

        // Gets the name of the enchant without the trailing level
        String EnchantName;
        if (HasLevel) {
            EnchantName = String.join("", List.of(Enchant.split("")).subList(
                    0, Enchant.length() - Levels[EnchantLevel - 1].length())
            ).trim();
        }
        else {
            EnchantName = Enchant;
        }

        return Map.of(EnchantName, EnchantLevel);
    }


    public static ArrayList<String> GetEnchants(List<net.kyori.adventure.text.Component> Lore) {
        if (Lore != null) {

            ArrayList<String> EnchantNames = new ArrayList<>();

            for (net.kyori.adventure.text.Component component : Lore) {
                String Enchant = GetEnchantText(component.children().get(0).toString());
                EnchantNames.add(new ArrayList<>(GetEnchantAndLevel(Enchant).keySet()).get(0));
            }

            return EnchantNames;
        }
        else {
            return new ArrayList<>();
        }
    }

    public static Map<String, Integer> GetEnchantLevels(List<net.kyori.adventure.text.Component> Lore) {
        if (Lore != null) {

            Map<String, Integer> Enchants = new HashMap<>(Map.of());

            for (net.kyori.adventure.text.Component component : Lore) {
                String Enchant;
                if (component.children().isEmpty()) {
                    Enchant = GetEnchantText(component.toString());
                }
                else {
                    Enchant = GetEnchantText(component.children().get(0).toString());
                }

                Map<String, Integer> EnchantAndLevel = GetEnchantAndLevel(Enchant);
                Enchants.putAll(EnchantAndLevel);
            }

            return Enchants;
        }
        else {
            return Map.of();
        }
    }
}