package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Butcher implements Listener {

    @EventHandler
    public void OnEntityDeath(EntityDeathEvent Event) {

        Player Player = (Player) AttackerOnDeath.Attacker.get(Event.getEntity());
        if (Player != null) { return; }

        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Butcher")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Butcher");

        for (ItemStack Drop : Event.getDrops()) {

            switch (Drop.getType()) {
                case BEEF:
                case COOKED_BEEF:
                case CHICKEN:
                case COOKED_CHICKEN:
                case PORKCHOP:
                case COOKED_PORKCHOP:
                case MUTTON:
                case COOKED_MUTTON:
                case RABBIT:
                case COOKED_RABBIT:
                    Drop.add(EnchantLevel);
            }
        }

    }
}
