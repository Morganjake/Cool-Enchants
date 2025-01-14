package enchants.cool.coolenchants.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Enchant {

    public static void EnchantUI(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lEnchant");

        ItemStack ItemSurrounding = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta ItemSurroundingMeta = ItemSurrounding.getItemMeta();
        Objects.requireNonNull(ItemSurroundingMeta).setDisplayName("§7§lItem");
        ItemSurrounding.setItemMeta(ItemSurroundingMeta);

        ItemStack EnchantSurrounding = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta EnchantSurroundingMeta = EnchantSurrounding.getItemMeta();
        Objects.requireNonNull(EnchantSurroundingMeta).setDisplayName("§b§lEnchant Book");
        EnchantSurrounding.setItemMeta(EnchantSurroundingMeta);

        Integer[] ItemSurroundingSlots = {1, 2, 3, 10, 12, 19, 20, 21};
        Integer[] EnchantSurroundingSlots = {5, 6, 7, 14, 16, 23, 24, 25};

        for (int Slot : ItemSurroundingSlots) {
            Inventory.setItem(Slot, ItemSurrounding);
        }

        ItemStack Craft = new ItemStack(Material.ANVIL);
        ItemMeta CraftMeta = Craft.getItemMeta();
        Objects.requireNonNull(CraftMeta).setDisplayName("§6§lENCHANT");
        Craft.setItemMeta(CraftMeta);
        Inventory.setItem(22, Craft);

        for (int Slot : EnchantSurroundingSlots) {
            Inventory.setItem(Slot, EnchantSurrounding);
        }

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        Objects.requireNonNull(ReturnIconMeta).setDisplayName("§c§lReturn");
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);

        Player.openInventory(Inventory);
    }
}
