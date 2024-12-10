package com.example.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.CommandExecutor;

public class OpenUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a custom inventory
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Click to see slot");

            // Add some items to the inventory
            ItemStack item1 = new ItemStack(org.bukkit.Material.DIAMOND);
            ItemMeta meta1 = item1.getItemMeta();
            if (meta1 != null) {
                meta1.setDisplayName(ChatColor.AQUA + "Diamond");
                item1.setItemMeta(meta1);
            }
            inv.setItem(0, item1);

            ItemStack item2 = new ItemStack(org.bukkit.Material.GOLD_INGOT);
            ItemMeta meta2 = item2.getItemMeta();
            if (meta2 != null) {
                meta2.setDisplayName(ChatColor.GOLD + "Gold Ingot");
                item2.setItemMeta(meta2);
            }
            inv.setItem(1, item2);

            // Open the inventory for the player
            player.openInventory(inv);
        }

        return true;
    }
}
