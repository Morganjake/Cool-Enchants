package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class Lifesteal implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getDamager() instanceof Player)) { return; }
        Player Player = (Player) Event.getDamager();

        ItemStack Weapon = Player.getItemInUse();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon);
        if (!Lore.contains("Lifesteal")) { return; }
        int EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon).get("Lifesteal");

        double HealAmount = Event.getDamage() / EnchantLevel * 0.2;
        Player.setHealth(Math.min(Player.getHealth() + HealAmount, Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue()));
    }
}
