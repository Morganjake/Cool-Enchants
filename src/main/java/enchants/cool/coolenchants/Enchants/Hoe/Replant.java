package enchants.cool.coolenchants.Enchants.Hoe;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Replant implements Listener {

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent Event) {
        Player Player = Event.getPlayer();
        Block Block = Event.getBlock();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Player.getItemInHand().lore());
        if (!Lore.contains("Replant")) { return; }

        Material CropType = Block.getType();

        Material NewCropType = switch (CropType) {
            case WHEAT -> Material.WHEAT;
            case CARROTS -> Material.CARROTS;
            case POTATOES -> Material.POTATOES;
            case BEETROOTS -> Material.BEETROOTS;
            case NETHER_WART -> Material.NETHER_WART;
            default -> null;
        };

        if (NewCropType == null) { return; }

        Material NewSeedType = switch (CropType) {
            case WHEAT -> Material.WHEAT_SEEDS;
            case CARROTS -> Material.CARROTS;
            case POTATOES -> Material.POTATOES;
            case BEETROOTS -> Material.BEETROOT_SEEDS;
            case NETHER_WART -> Material.NETHER_WART;
            default -> null;
        };

        if (!Player.getInventory().contains(NewSeedType)) { return; }
        HashMap<Integer, ? extends ItemStack> SeedSlots = Player.getInventory().all(NewSeedType);

        for (ItemStack Item : SeedSlots.values()) {
            if (Item.getAmount() > 1) { Item.setAmount(Item.getAmount() - 1); break; }
            else { Player.getInventory().remove(Item); }
        }


        Bukkit.getScheduler().runTaskLater(CoolEnchants.GetPlugin(), () -> {
            Block.setType(NewCropType);
        }, 1L);

    }
}
