package enchants.cool.coolenchants.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender CommandSender, Command Command, String Label, String[] Args) {
        if (!(CommandSender instanceof Player)) {
            return false;
        }

        if (!Command.getName().equalsIgnoreCase("coolenchants")) {
            return false;
        }

        Player Player = (org.bukkit.entity.Player) CommandSender;
        MainMenu(Player);

        return true;
    }

    public static void MainMenu(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lCool Enchants");

        ItemStack LootBoxIcon = new ItemStack(Material.BLACK_SHULKER_BOX);
        ItemMeta LootBoxIconMeta = LootBoxIcon.getItemMeta();
        LootBoxIcon.setItemMeta(LootBoxIconMeta);
        Inventory.setItem(10, LootBoxIcon);

        ItemStack EnchantIcon = new ItemStack(Material.ENCHANTING_TABLE);
        ItemMeta EnchantIconMeta = EnchantIcon.getItemMeta();
        EnchantIcon.setItemMeta(EnchantIconMeta);
        Inventory.setItem(12, EnchantIcon);

        ItemStack InfoIcon = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta InfoIconMeta = InfoIcon.getItemMeta();
        InfoIcon.setItemMeta(InfoIconMeta);
        Inventory.setItem(16, InfoIcon);

        Player.openInventory(Inventory);
    }
}
