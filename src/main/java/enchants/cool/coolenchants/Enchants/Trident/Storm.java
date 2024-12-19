package enchants.cool.coolenchants.Enchants.Trident;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.EnchantList;
import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Storm implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getDamager() instanceof Trident)) { return; }
        Trident Trident = (Trident) Event.getDamager();

        if (Trident.getName().equals("Storm Trident")) {
            Trident.getWorld().strikeLightning(Trident.getLocation());
        }

        Player Player = (Player) Trident.getShooter();
        if (Player == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Trident.getItemStack().getItemMeta().lore());
        if (!Lore.contains("Storm")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Trident.getItemStack().getItemMeta().lore()).get("Storm");

        final Integer[] Iterations = {0};

        BukkitRunnable SummonTridents = new BukkitRunnable() {

            @Override
            public void run() {

                if (Event.getEntity().isDead()) { cancel(); }
                Location Position = Event.getEntity().getLocation().add(new Vector((Math.random() - 0.5), 15, (Math.random() - 0.5)));
                Trident Trident = Event.getEntity().getWorld().spawn(Position, Trident.class);
                Trident.setCustomName("Storm Trident");
                Trident.setVelocity(new Vector((Math.random() - 0.5), -2, (Math.random() - 0.5)));

                Iterations[0]++;

                if (Iterations[0] > 50 * EnchantLevel) {
                    cancel();
                }
            }
        };

        SummonTridents.runTaskTimer(CoolEnchants.GetPlugin(), 0, 2L);
    }
}
