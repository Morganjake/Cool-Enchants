package enchants.cool.coolenchants.Enchants.Helmet;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class HugeCerebrum implements Listener {

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent Event) {

        Player Player = Event.getPlayer();

        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Smite")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Smite");
        Event.setAmount(Event.getAmount() * (1 + EnchantLevel / 2));
    }
}
