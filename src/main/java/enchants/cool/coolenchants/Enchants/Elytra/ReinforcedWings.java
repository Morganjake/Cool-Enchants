package enchants.cool.coolenchants.Enchants.Elytra;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ReinforcedWings implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageEvent Event) {

        if (!(Event.getEntity() instanceof Player)) { return; }
        Player Player = (Player) Event.getEntity();

        ItemStack Elytra = Player.getInventory().getChestplate();
        if (Elytra == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Elytra);
        if (!Lore.contains("Reinforced Wings")) { return; }
        int EnchantLevel = EnchantHelper.GetEnchantLevels(Elytra).get("Reinforced Wings");

        Event.setDamage(Event.getDamage() * (1 - 0.11 * EnchantLevel));
    }
}
