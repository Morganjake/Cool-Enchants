package enchants.cool.coolenchants.Enchants.Pickaxe;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Tunneller implements Listener {

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent Event) {

        Player Player = Event.getPlayer();
        ItemStack Pickaxe = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Pickaxe.lore());
        if (!Lore.contains("Tunneller")) { return; }

        Location BlockLocation = Event.getBlock().getLocation();

        Set<Material> IndestructibleBlocks = Set.of(
                Material.BEDROCK,
                Material.BARRIER,
                Material.END_PORTAL_FRAME,
                Material.NETHER_PORTAL,
                Material.END_PORTAL
        );

        boolean PickaxeHasSilkTouch = Pickaxe.containsEnchantment(Enchantment.SILK_TOUCH);

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Location NewBlockLocation = BlockLocation.clone().add(x, y, z);
                    Block NewBlock = BlockLocation.getWorld().getBlockAt(NewBlockLocation);

                    if (NewBlockLocation.equals(BlockLocation) || IndestructibleBlocks.contains(NewBlock.getType())) { continue; }

                    if (PickaxeHasSilkTouch) {
                        NewBlock.getWorld().dropItemNaturally(NewBlockLocation, new ItemStack(NewBlock.getType()));
                        NewBlock.setType(Material.AIR);
                    }
                    else {
                        NewBlock.breakNaturally();
                    }
                }
            }
        }
    }
}
