package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Smite implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getDamager() instanceof Player)) { return; }
        Player Player = (Player) Event.getDamager();

        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Smite")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Smite");

        Player.getWorld().strikeLightningEffect(Event.getEntity().getLocation());
        Player.playSound(Event.getEntity(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
        Event.setDamage(Event.getDamage() + (double) EnchantLevel / 1.5);
    }
}