package enchants.cool.coolenchants.Enchants.Bow;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Velocity implements Listener {

    @EventHandler
    public void OnArrowShoot(ProjectileLaunchEvent Event) {

        if (!(Event.getEntity() instanceof Arrow)) { return; }
        Arrow Arrow = (Arrow) Event.getEntity();

        if (!(Arrow.getShooter() instanceof Player)) { return; }
        Player Player = (Player) Arrow.getShooter();

        ItemStack Weapon = Player.getInventory().getItemInMainHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon);
        if (!Lore.contains("Velocity")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon).get("Velocity");
        Arrow.setVelocity(Arrow.getVelocity().multiply(1 + EnchantLevel / 3));
    }
}
