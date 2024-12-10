package enchants.cool.coolenchants.UI;

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
        ItemStack EnchantSurrounding = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);

        Inventory.setItem(1, ItemSurrounding);
        Inventory.setItem(2, ItemSurrounding);
        Inventory.setItem(3, ItemSurrounding);
        Inventory.setItem(10, ItemSurrounding);
        Inventory.setItem(12, ItemSurrounding);
        Inventory.setItem(19, ItemSurrounding);
        Inventory.setItem(20, ItemSurrounding);
        Inventory.setItem(21, ItemSurrounding);
        Inventory.setItem(22, new ItemStack(Material.ANVIL));
        Inventory.setItem(5, EnchantSurrounding);
        Inventory.setItem(6, EnchantSurrounding);
        Inventory.setItem(7, EnchantSurrounding);
        Inventory.setItem(14, EnchantSurrounding);
        Inventory.setItem(16, EnchantSurrounding);
        Inventory.setItem(23, EnchantSurrounding);
        Inventory.setItem(24, EnchantSurrounding);
        Inventory.setItem(25, EnchantSurrounding);

        ItemStack LootBoxIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta LootBoxIconMeta = LootBoxIcon.getItemMeta();
        LootBoxIcon.setItemMeta(LootBoxIconMeta);
        Inventory.setItem(26, LootBoxIcon);

        Player.openInventory(Inventory);
    }
}
