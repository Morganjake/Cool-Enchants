package enchants.cool.coolenchants.Enchants.Tool;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Set;

public class Tunneller implements Listener {

    // Used to run the Player.breakBlock() method without re-running the code
    public static ArrayList<Block> BlocksJustBroken = new ArrayList<>();

    // Used to make sure tool durability only goes down one point when breaking lots of blocks
    public static ArrayList<Player> NoDurabilityTime = new ArrayList<>();

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent Event) {

        if (BlocksJustBroken.contains(Event.getBlock())) {
            BlocksJustBroken.remove(Event.getBlock());
            return;
        }

        Player Player = Event.getPlayer();
        ItemStack Tool = Player.getItemInHand();

        // If the player uses a shovel the code checks if they broke an unpreferred block
        boolean BreakUnpreferredBlocks = !Tool.getType().name().contains("SHOVEL") || !Event.getBlock().isPreferredTool(Tool);

        // Qol that if the player is sneaking it doesn't mine in a 3x3 area
        if (Player.isSneaking()) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Tool.lore());
        if (!Lore.contains("Tunneller")) { return; }

        Location BlockLocation = Event.getBlock().getLocation();

        Set<Material> IndestructibleBlocks = Set.of(
                Material.BEDROCK,
                Material.BARRIER,
                Material.END_PORTAL_FRAME,
                Material.NETHER_PORTAL,
                Material.END_PORTAL
        );



        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Location NewBlockLocation = BlockLocation.clone().add(x, y, z);
                    Block NewBlock = BlockLocation.getWorld().getBlockAt(NewBlockLocation);

                    if (NewBlockLocation.equals(BlockLocation) || IndestructibleBlocks.contains(NewBlock.getType())) { continue; }

                    if (BreakUnpreferredBlocks || NewBlock.isPreferredTool(Tool)) {
                        BlocksJustBroken.add(NewBlock);
                        Player.breakBlock(NewBlock);
                    }

                    if (!NoDurabilityTime.contains(Player)) {
                        NoDurabilityTime.add(Player);
                    }
                }
            }
        }

        NoDurabilityTime.remove(Player);
    }

    @EventHandler
    public void OnItemDamage(PlayerItemDamageEvent Event) {

        if (NoDurabilityTime.contains(Event.getPlayer())) {
            Event.setCancelled(true);
        }
    }
}
