package enchants.cool.coolenchants.UI;

import enchants.cool.coolenchants.EnchantList;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Info {

    public static void InfoUI(Player Player) {

        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lInfo");

        ItemStack Common = new ItemStack(Material.COAL_BLOCK);
        ItemMeta CommonMeta = Common.getItemMeta();
        CommonMeta.displayName(Component.text("§7§lSee Common Enchants"));
        Common.setItemMeta(CommonMeta);
        Inventory.setItem(9, Common);

        ItemStack Uncommon = new ItemStack(Material.IRON_BLOCK);
        ItemMeta UncommonMeta = Uncommon.getItemMeta();
        UncommonMeta.displayName(Component.text("§a§lSee Uncommon Enchants"));
        Uncommon.setItemMeta(UncommonMeta);
        Inventory.setItem(11, Uncommon);

        ItemStack Rare = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta RareMeta = Rare.getItemMeta();
        RareMeta.displayName(Component.text("§9§lSee Rare Enchants"));
        Rare.setItemMeta(RareMeta);
        Inventory.setItem(13, Rare);

        ItemStack Epic = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta EpicMeta = Epic.getItemMeta();
        EpicMeta.displayName(Component.text("§b§lSee Epic Enchants"));
        Epic.setItemMeta(EpicMeta);
        Inventory.setItem(15, Epic);

        ItemStack Legendary = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta LegendaryMeta = Legendary.getItemMeta();
        LegendaryMeta.displayName(Component.text("§6§lSee Legendary Enchants"));
        Legendary.setItemMeta(LegendaryMeta);
        Inventory.setItem(17, Legendary);

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        ReturnIconMeta.displayName(Component.text("§c§lReturn"));
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);

        Player.openInventory(Inventory);

    }

    public static void ShowRarity(Player Player, Integer RarityNum) {

        String RarityColour = new String[] {"§3§l", "§a§l", "§9§l", "§5§l", "§6§l"}[RarityNum];
        String Rarity = new String[] {"Common", "Uncommon", "Rare", "Epic", "Legendary"}[RarityNum];

        Inventory Inventory = Bukkit.createInventory(Player, 27,  RarityColour + Rarity + " Enchants");
        ArrayList<ItemStack> Books = EnchantList.Get().get(Rarity);

        for (int i = 0; i < Books.size(); i++) {
            Inventory.setItem(i, Books.get(i));
        }

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        ReturnIconMeta.displayName(Component.text("§c§lReturn"));
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);

        Player.openInventory(Inventory);

    }
}
