package enchants.cool.coolenchants.Enchants.Sword;

import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Butcher implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent Event) {

        if (!(Event.getEntity() instanceof Player)) { return; }
        Player Player = (Player) AttackerOnDeath.Attacker.get(Event.getEntity());

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
