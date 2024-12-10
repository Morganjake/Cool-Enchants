package enchants.cool.coolenchants.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LootBox {

    public static void LootBoxUI(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lSelect Lootbox");

        ItemStack IronBox = new ItemStack(Material.IRON_BLOCK);
        ItemMeta IronBoxMeta = IronBox.getItemMeta();
        IronBox.setItemMeta(IronBoxMeta);
        Inventory.setItem(10, IronBox);

        ItemStack GoldBox = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta GoldBoxMeta = GoldBox.getItemMeta();
        GoldBox.setItemMeta(GoldBoxMeta);
        Inventory.setItem(12, GoldBox);

        ItemStack DiamondBox = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta DiamondBoxMeta = DiamondBox.getItemMeta();
        DiamondBox.setItemMeta(DiamondBoxMeta);
        Inventory.setItem(14, DiamondBox);

        ItemStack NetheriteBox = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta NetheriteBoxMeta = NetheriteBox.getItemMeta();
        NetheriteBox.setItemMeta(NetheriteBoxMeta);
        Inventory.setItem(16, NetheriteBox);

        ItemStack LootBoxIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta LootBoxIconMeta = LootBoxIcon.getItemMeta();
        LootBoxIcon.setItemMeta(LootBoxIconMeta);
        Inventory.setItem(26, LootBoxIcon);


        Player.openInventory(Inventory);
    }
}
