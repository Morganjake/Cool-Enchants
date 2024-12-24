package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Bleed implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getEntity() instanceof LivingEntity)) { return; }
        LivingEntity Victim = (LivingEntity) Event.getEntity();

        if (!(Event.getDamager() instanceof Player)) { return; }
        Player Player = (Player) Event.getDamager();


        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Bleed")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Bleed");


        new BukkitRunnable() {

            int Iterations = EnchantLevel;

            @Override
            public void run() {

                Victim.damage(2);

                Iterations--;
                if (Iterations == 0) {
                    cancel();
                }
            }
        }.runTaskTimer(CoolEnchants.GetPlugin(), 20L, 20L);
    }
}
