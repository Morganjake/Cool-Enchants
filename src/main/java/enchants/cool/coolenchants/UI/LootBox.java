package enchants.cool.coolenchants.UI;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class LootBox {

    public static void LootBoxUI(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lSelect Lootbox");

        ItemStack IronBox = new ItemStack(Material.IRON_BLOCK);
        ItemMeta IronBoxMeta = IronBox.getItemMeta();
        IronBoxMeta.displayName(Component.text("§8§lBad Lootbox"));
        IronBoxMeta.lore(Collections.singletonList(Component.text("§3Costs 25 Levels")));
        IronBox.setItemMeta(IronBoxMeta);
        Inventory.setItem(10, IronBox);

        ItemStack GoldBox = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta GoldBoxMeta = GoldBox.getItemMeta();
        GoldBoxMeta.displayName(Component.text("§2§lNormal Lootbox"));
        GoldBoxMeta.lore(Collections.singletonList(Component.text("§3Costs 30 Levels")));
        GoldBox.setItemMeta(GoldBoxMeta);
        Inventory.setItem(12, GoldBox);

        ItemStack DiamondBox = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta DiamondBoxMeta = DiamondBox.getItemMeta();
        DiamondBoxMeta.displayName(Component.text("§6§lGood Lootbox"));
        DiamondBoxMeta.lore(Collections.singletonList(Component.text("§3Costs 35 Levels")));
        DiamondBox.setItemMeta(DiamondBoxMeta);
        Inventory.setItem(14, DiamondBox);

        ItemStack NetheriteBox = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta NetheriteBoxMeta = NetheriteBox.getItemMeta();
        NetheriteBoxMeta.displayName(Component.text("§4§lGreat Lootbox"));
        NetheriteBoxMeta.lore(Collections.singletonList(Component.text("§3Costs 40 Levels")));
        NetheriteBox.setItemMeta(NetheriteBoxMeta);
        Inventory.setItem(16, NetheriteBox);

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        ReturnIconMeta.displayName(Component.text("§c§lReturn"));
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);


        Player.openInventory(Inventory);
    }
}
