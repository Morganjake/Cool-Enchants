package enchants.cool.coolenchants.Helper;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static org.bukkit.Bukkit.getLogger;

public class EnchantHelper {

    public static Map<String, Integer> GetEnchantAndLevel(String Enchant) {

        String[] Levels = {" I", " II", " III", " IV", " V"};
        int LevelNum = 0;
        int EnchantLevel = 1;
        boolean HasLevel = false;

        for (String Level : Levels) {
            LevelNum += 1;
            if (Enchant.endsWith(Level)) {
                EnchantLevel = LevelNum;
                HasLevel = true;
                break;
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


    public static ArrayList<String> GetEnchants(ItemStack Item) {
        if (Item != null && Item.getItemMeta() != null && Item.getItemMeta().getLore() != null) {

            ArrayList<String> EnchantNames = new ArrayList<>();

            for (String Enchant: Item.getItemMeta().getLore()) {
                EnchantNames.add(new ArrayList<>(GetEnchantAndLevel(Enchant).keySet()).get(0));
            }

            return EnchantNames;
        }
        else {
            return new ArrayList<>();
        }
    }

    public static Map<String, Integer> GetEnchantLevels(ItemStack Item) {
        if (Item != null && Item.getItemMeta() != null && Item.getItemMeta().getLore() != null) {

            Map<String, Integer> Enchants = new HashMap<>(Map.of());

            for (String Enchant: Item.getItemMeta().getLore()) {

                Map<String, Integer> EnchantAndLevel = GetEnchantAndLevel(Enchant);
                Enchants.putAll(EnchantAndLevel);
            }

            return Enchants;
        }
        else {
            return Map.of();
        }
    }

    public static boolean ItemsAreCompatible(ItemStack Item1, ItemStack Item2) {

        List<String> Item1Lore = Objects.requireNonNull(Item1.getItemMeta()).getLore();
        List<String> Item2Lore = Objects.requireNonNull(Item2.getItemMeta()).getLore();

        // First item is an enchant book
        if (Item1Lore != null && Objects.equals(Item1Lore.get(0), "§3§l--Cool Enchants--")) {

            // Enchant books are not of the same enchant or level
            if (!Objects.equals(Item1Lore.get(2), Objects.requireNonNull(Item2Lore).get(2))) { return false; }

            String[] Lore = Item1Lore.get(2).split(" ");
            int Item1Level = Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5).get(Lore[Lore.length - 1]);

            Lore = Item2Lore.get(2).split(" ");
            int Item2Level = Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5).get(Lore[Lore.length - 1]);

            int MaxLevel = Integer.parseInt(Item1Lore.get(3).split(" ")[2]);

            // Levels aren't equal or enchant is already max level
            return Item1Level == Item2Level && Item1Level < MaxLevel;
        }
        // First Item isn't an enchant book
        else {

            Material ItemType = Item1.getType();
            String BookType = ChatColor.stripColor(Objects.requireNonNull(Item2Lore).get(1));

            if (
                    (ItemType == Material.LEATHER_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.CHAINMAIL_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.IRON_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.GOLDEN_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.DIAMOND_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.NETHERITE_HELMET && (BookType.equals("Helmet") || BookType.equals("Armour"))) ||
                    (ItemType == Material.LEATHER_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.CHAINMAIL_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.IRON_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.GOLDEN_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.DIAMOND_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.NETHERITE_CHESTPLATE && (BookType.equals("Chestplate") || BookType.equals("Armour"))) ||
                    (ItemType == Material.LEATHER_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.CHAINMAIL_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.IRON_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.GOLDEN_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.DIAMOND_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.NETHERITE_LEGGINGS && (BookType.equals("Leggings") || BookType.equals("Armour"))) ||
                    (ItemType == Material.LEATHER_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.CHAINMAIL_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.IRON_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.GOLDEN_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.DIAMOND_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.NETHERITE_BOOTS && (BookType.equals("Boots") || BookType.equals("Armour"))) ||
                    (ItemType == Material.ELYTRA && BookType.equals("Elytra")) ||
                    (ItemType == Material.WOODEN_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.STONE_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.IRON_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.GOLDEN_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.DIAMOND_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.NETHERITE_PICKAXE && (BookType.equals("Pickaxe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.WOODEN_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.STONE_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.IRON_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.GOLDEN_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.DIAMOND_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.NETHERITE_AXE && (BookType.equals("Axe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.WOODEN_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.STONE_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.IRON_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.GOLDEN_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.DIAMOND_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.NETHERITE_SHOVEL && (BookType.equals("Shovel") || BookType.equals("Tool"))) ||
                    (ItemType == Material.WOODEN_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.STONE_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.IRON_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.GOLDEN_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.DIAMOND_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.NETHERITE_HOE && (BookType.equals("Hoe") || BookType.equals("Tool"))) ||
                    (ItemType == Material.WOODEN_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.STONE_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.IRON_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.GOLDEN_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.DIAMOND_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.NETHERITE_SWORD && BookType.equals("Sword")) ||
                    (ItemType == Material.TRIDENT && BookType.equals("Trident")) ||
                    (ItemType == Material.BOW && BookType.equals("Bow")) ||
                    (ItemType == Material.CROSSBOW && BookType.equals("Crossbow")))
            {

                String Enchant = ChatColor.stripColor(Objects.requireNonNull(Item2.getItemMeta().getLore()).get(2));
                String EnchantName = (String) GetEnchantAndLevel(Enchant).keySet().toArray()[0];

                Map<String, Integer> ItemEnchants = GetEnchantLevels(Item1);

                int MaxLevel = Integer.parseInt(Item2Lore.get(3).split(" ")[2]);

                if (ItemEnchants.get(EnchantName) == null) { return true; }

                return ItemEnchants.get(EnchantName) < MaxLevel;
            }
            else {
                return false;
            }
        }
    }
}