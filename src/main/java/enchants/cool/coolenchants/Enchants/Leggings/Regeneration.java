package enchants.cool.coolenchants.Enchants.Leggings;

import enchants.cool.coolenchants.CoolEnchants21;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Objects;

public class Regeneration {

    public static void Regen() {

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player Player : Bukkit.getOnlinePlayers()) {

                    ItemStack Leggings = Player.getInventory().getLeggings();
                    if (Leggings == null) { return; }

                    ArrayList<String> Lore = EnchantHelper.GetEnchants(Leggings);
                    if (!Lore.contains("Regeneration")) { return; }
                    Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Leggings).get("Regeneration");

                    double HealAmount = 0.25 * EnchantLevel;
                    Player.setHealth(Math.min(Player.getHealth() + HealAmount, Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue()));

                }
            }
        }.runTaskTimer(CoolEnchants21.GetPlugin(), 0L, 40L);
    }
}
