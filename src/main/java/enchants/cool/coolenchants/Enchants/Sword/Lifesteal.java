package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Lifesteal implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getDamager() instanceof Player)) { return; }
        Player Player = (Player) Event.getDamager();

        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Lifesteal")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Lifesteal");
        Double HealAmount = Event.getDamage() / EnchantLevel * 0.2;
        Player.setHealth(Player.getHealth() + HealAmount);
    }
}
