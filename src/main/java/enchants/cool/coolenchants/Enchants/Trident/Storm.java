package enchants.cool.coolenchants.Enchants.Trident;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.EnchantList;
import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import net.kyori.adventure.text.BlockNBTComponent;
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

        final Location[] Position = {Event.getEntity().getLocation()};

        BukkitRunnable SummonTridents = new BukkitRunnable() {

            int Iterations = 0;

            @Override
            public void run() {

                for (int i = 0; i < 3; i++) {

                    if (!Event.getEntity().isDead()) {
                        Position[0] = Event.getEntity().getLocation();
                    }

                    Location TridentPosition = Position[0].clone().add((Math.random() - 0.5) * 40, 100, (Math.random() - 0.5) * 40);

                    Trident Trident = Event.getEntity().getWorld().spawn(TridentPosition, Trident.class);
                    Trident.setCustomName("Storm Trident");
                    Trident.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);

                    Vector Direction = Position[0].toVector().subtract(TridentPosition.toVector()).normalize();
                    Trident.setVelocity(Direction.multiply(new Vector(4 + Math.random() * 2 , 5, 4 + Math.random() * 2)));
                }

                Iterations++;

                if (Iterations > 50 * EnchantLevel) {
                    cancel();
                }
            }
        };

        SummonTridents.runTaskTimer(CoolEnchants.GetPlugin(), 0, 1L);
    }
}
