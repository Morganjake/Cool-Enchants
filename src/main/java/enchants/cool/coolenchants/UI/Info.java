package enchants.cool.coolenchants.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Info {

    public static void InfoUI(Player Player) {

        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lInfo");

        ItemStack Common = new ItemStack(Material.COAL_BLOCK);
        ItemMeta CommonMeta = Common.getItemMeta();
        Common.setItemMeta(CommonMeta);
        Inventory.setItem(9, Common);

        ItemStack Uncommon = new ItemStack(Material.IRON_BLOCK);
        ItemMeta UncommonMeta = Uncommon.getItemMeta();
        Uncommon.setItemMeta(UncommonMeta);
        Inventory.setItem(11, Uncommon);

        ItemStack Rare = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta RareMeta = Rare.getItemMeta();
        Rare.setItemMeta(RareMeta);
        Inventory.setItem(13, Rare);

        ItemStack Epic = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta EpicMeta = Epic.getItemMeta();
        Epic.setItemMeta(EpicMeta);
        Inventory.setItem(15, Epic);

        ItemStack Legendary = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta LegendaryMeta = Legendary.getItemMeta();
        Legendary.setItemMeta(LegendaryMeta);
        Inventory.setItem(17, Legendary);

        Player.openInventory(Inventory);

    }
}
