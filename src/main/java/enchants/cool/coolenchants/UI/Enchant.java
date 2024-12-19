package enchants.cool.coolenchants.UI;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchant {

    public static void EnchantUI(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lEnchant");

        ItemStack ItemSurrounding = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta ItemSurroundingMeta = ItemSurrounding.getItemMeta();
        ItemSurroundingMeta.displayName(Component.text("§7§lItem"));
        ItemSurrounding.setItemMeta(ItemSurroundingMeta);

        ItemStack EnchantSurrounding = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta EnchantSurroundingMeta = EnchantSurrounding.getItemMeta();
        EnchantSurroundingMeta.displayName(Component.text("§b§lEnchant Book"));
        EnchantSurrounding.setItemMeta(EnchantSurroundingMeta);

        Integer[] ItemSurroundingSlots = {1, 2, 3, 10, 12, 19, 20, 21};
        Integer[] EnchantSurroundingSlots = {5, 6, 7, 14, 16, 23, 24, 25};

        for (int i = 0; i < ItemSurroundingSlots.length; i++) {
            Inventory.setItem(ItemSurroundingSlots[i], ItemSurrounding);
        }

        ItemStack Craft = new ItemStack(Material.ANVIL);
        ItemMeta CraftMeta = Craft.getItemMeta();
        CraftMeta.displayName(Component.text("§6§lENCHANT"));
        Craft.setItemMeta(CraftMeta);
        Inventory.setItem(22, Craft);

        for (int i = 0; i < EnchantSurroundingSlots.length; i++) {
            Inventory.setItem(EnchantSurroundingSlots[i], EnchantSurrounding);
        }

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        ReturnIconMeta.displayName(Component.text("§c§lReturn"));
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);

        Player.openInventory(Inventory);
    }
}
