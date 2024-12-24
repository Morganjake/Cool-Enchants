package enchants.cool.coolenchants.Enchants.Bow;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Poison implements Listener {

    @EventHandler
    public void OnArrowHit(ProjectileHitEvent Event) {

        if (!(Event.getEntity() instanceof Arrow)) { return; }
        Arrow Arrow = (Arrow) Event.getEntity();

        if (!(Arrow.getShooter() instanceof Player)) { return; }
        Player Player = (Player) Arrow.getShooter();

        if (!(Event.getHitEntity() instanceof LivingEntity)) { return; }
        LivingEntity Target = (LivingEntity) Event.getHitEntity();

        ItemStack Weapon = Player.getItemInHand();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Weapon.lore());
        if (!Lore.contains("Poison")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Weapon.lore()).get("Poison");

        Target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, EnchantLevel * 20, 2, true));

    }
}
