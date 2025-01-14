package enchants.cool.coolenchants.Enchants.Boots;

import enchants.cool.coolenchants.CoolEnchants21;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LavaWalker implements Listener {

    // Used to keep track of the lava that has been obsidianed and their progress to turning back to lava
    private static final HashMap<Block, Integer> ObsidianedLava = new HashMap<>();

    @EventHandler
    public static void OnMove(PlayerMoveEvent Event) {

        Player Player = Event.getPlayer();

        ItemStack Boots = Player.getInventory().getBoots();
        if (Boots == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Boots);
        if (!Lore.contains("Lava Walker")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Boots).get("Lava Walker");

        for (int x = -EnchantLevel; x <= EnchantLevel; x++) {
            for (int z = -EnchantLevel; z <= EnchantLevel; z++) {
                Location BlockLocation = Player.getLocation().add(x, -1, z);
                Block Block = Objects.requireNonNull(BlockLocation.getWorld()).getBlockAt(BlockLocation);

                if (Block.getType() == Material.LAVA && BlockLocation.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                    Block.setType(Material.OBSIDIAN);
                    ObsidianedLava.put(Block, (int) (100 + Math.floor(Math.random() * 40)));

                }
                else if (ObsidianedLava.containsKey(Block)) {
                    Block.setType(Material.OBSIDIAN);
                    ObsidianedLava.replace(Block, (int) (100 + Math.floor(Math.random() * 40)));
                }
            }
        }
    }

    public static void StartLavaUpdater() {

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Block ObsidianedBlock : ((HashMap<Block, Integer>) ObsidianedLava.clone()).keySet()) {
                    ObsidianedLava.replace(ObsidianedBlock, ObsidianedLava.get(ObsidianedBlock) - 1);

                    if (ObsidianedLava.get(ObsidianedBlock) <= 0) {
                        ObsidianedBlock.setType(Material.LAVA);
                        ObsidianedLava.remove(ObsidianedBlock);
                    }
                    else if (ObsidianedLava.get(ObsidianedBlock) == 60) {
                        ObsidianedBlock.setType(Material.CRYING_OBSIDIAN);
                    }
                }
            }

        }.runTaskTimer(CoolEnchants21.GetPlugin(), 0, 1L);
    }

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent Event) {

        // Stops players farming obsidian
        if (ObsidianedLava.containsKey(Event.getBlock())) {
            Event.getBlock().setType(Material.LAVA);
            ObsidianedLava.remove(Event.getBlock());
            Event.setCancelled(true);
        }
    }
}
