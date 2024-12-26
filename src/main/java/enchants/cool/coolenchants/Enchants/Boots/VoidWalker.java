package enchants.cool.coolenchants.Enchants.Boots;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class VoidWalker implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageEvent Event) {

        if (!(Event.getEntity() instanceof Player)) { return; }
        Player Player = (Player) Event.getEntity();

        ItemStack Boots = Player.getInventory().getBoots();
        if (Boots == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Boots.lore());
        if (!Lore.contains("Void Walker")) { return; }

        if (Event.getCause() == EntityDamageEvent.DamageCause.VOID && Player.getHealth() - Event.getDamage() <= 0) {
            Event.setCancelled(true);

            if (Player.getBedSpawnLocation() != null) {
                Player.teleport(Player.getBedSpawnLocation().add(0, 1, 0));
            }
            else {
                Player.teleport(Player.getWorld().getSpawnLocation().add(0, 1, 0));
            }

            Player.playSound(Player, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            Player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100, true, false));
        }
    }
}
