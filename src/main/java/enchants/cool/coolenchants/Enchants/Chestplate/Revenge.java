package enchants.cool.coolenchants.Enchants.Chestplate;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Revenge implements Listener {

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent Event) {

        Player Player = Event.getEntity();
        ItemStack Chestplate = Player.getInventory().getChestplate();
        if (Chestplate == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Chestplate);
        if (!Lore.contains("Revenge")) { return; }


        for (int i = 0; i < 100; i++) {
            double Angle = 2 * Math.PI * i / 100;
            double X = Math.cos(Angle);
            double Z = Math.sin(Angle);
            double Speed = Math.random() + 0.3;

            TNTPrimed TNT = Player.getWorld().spawn(Player.getLocation(), TNTPrimed.class);
            TNT.setCustomName("Revenge Tnt");
            TNT.setCustomNameVisible(false);
            TNT.setFuseTicks((int) (60 * Speed * Math.max(Speed, 1)));
            TNT.setIsIncendiary(false);
            TNT.setVelocity(new Vector(X, Math.random() * 0.7 + 0.3, Z).multiply(Speed));
        }
    }

    @EventHandler
    public void OnTntExplode(EntityExplodeEvent Event) {
        if (!Event.getEntity().getName().equals("Revenge Tnt")) { return; }
        if (Event.getEntity() instanceof TNTPrimed) { Event.blockList().clear(); }
    }

    @EventHandler
    public void OnDamage(EntityDamageByEntityEvent Event) {
        if (!(Event.getDamager() instanceof TNTPrimed)) { return; }
        if (!Event.getDamager().getName().equals("Revenge Tnt")) { return; }
        if (Event.getEntity() instanceof Item) { Event.setCancelled(true); }
    }
}
