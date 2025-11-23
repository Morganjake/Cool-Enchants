package enchants.cool.coolenchants.Enchants.Axe;

import enchants.cool.coolenchants.CoolEnchants21;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockVector;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import static enchants.cool.coolenchants.JsonHandler.GetJsonValue;

public class Treecapitator implements Listener {

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent Event) {

        Player Player = Event.getPlayer();
        ItemStack Pickaxe = Player.getInventory().getItemInMainHand();

        Material PreviousBlock = Event.getBlock().getType();

        // Qol that if the player is sneaking it doesn't mine in a 3x3 area
        if (Player.isSneaking()) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Pickaxe);
        if (!Lore.contains("Treecapitator")) {return; }
        if (!GetJsonValue(Player, "toggletreecapitator")) { return; }

        Set<Material> LogBlocks = Set.of(
                Material.OAK_LOG,
                Material.SPRUCE_LOG,
                Material.BIRCH_LOG,
                Material.JUNGLE_LOG,
                Material.ACACIA_LOG,
                Material.DARK_OAK_LOG,
                Material.MANGROVE_LOG,
                Material.CHERRY_LOG,
                Material.CRIMSON_STEM,
                Material.WARPED_STEM,
                Material.STRIPPED_OAK_LOG,
                Material.STRIPPED_SPRUCE_LOG,
                Material.STRIPPED_BIRCH_LOG,
                Material.STRIPPED_JUNGLE_LOG,
                Material.STRIPPED_ACACIA_LOG,
                Material.STRIPPED_DARK_OAK_LOG,
                Material.STRIPPED_MANGROVE_LOG,
                Material.STRIPPED_CHERRY_LOG,
                Material.STRIPPED_CRIMSON_STEM,
                Material.STRIPPED_WARPED_STEM,
                Material.MANGROVE_ROOTS,
                Material.MUDDY_MANGROVE_ROOTS
        );

        if (!LogBlocks.contains(PreviousBlock)) { return; }

        Location BlockLocation = Event.getBlock().getLocation();

        Set<BlockVector> BlockOffsets = Set.of(
                new BlockVector(1, 0, 0),
                new BlockVector(-1, 0, 0),
                new BlockVector(0, 1, 0),
                new BlockVector(0, -1, 0),
                new BlockVector(0, 0, 1),
                new BlockVector(0, 0, -1)
        );

        new BukkitRunnable() {

            @Override
            public void run() {

                for (BlockVector Offset : BlockOffsets) {
                    Location NewBlockLocation = BlockLocation.clone().add(Offset);
                    Block NewBlock = Objects.requireNonNull(BlockLocation.getWorld()).getBlockAt(NewBlockLocation);

                    if (PreviousBlock == NewBlock.getType()) {
                        Player.breakBlock(NewBlock);
                    }
                }
            }
        }.runTaskLater(CoolEnchants21.GetPlugin(), 1L);
    }
}
