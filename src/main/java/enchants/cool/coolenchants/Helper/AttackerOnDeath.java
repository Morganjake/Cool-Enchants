package enchants.cool.coolenchants.Helper;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.Map;

public class AttackerOnDeath implements Listener {

    public static Map<Entity, Entity> Attacker = new HashMap<>();

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent Event) {

        if (!(Event.getEntity() instanceof LivingEntity)) {
            return;
        }

        if (((LivingEntity) Event.getEntity()).getHealth() - Event.getDamage() <= 0.0) {
            Attacker.put(Event.getEntity(), Event.getDamager());
        }
    }
}
