package enchants.cool.coolenchants.Enchants.Elytra;

import enchants.cool.coolenchants.CoolEnchants;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MachineGuns implements Listener {

    @EventHandler
    public void OnPlayerLeftClick(PlayerInteractEvent Event) {

        if (Event.getAction() == Action.LEFT_CLICK_AIR || Event.getAction() == Action.LEFT_CLICK_BLOCK) {

            Player Player = Event.getPlayer();

            if (!Player.isGliding()) { return; }

            new BukkitRunnable() {

                int Count = 0;

                @Override
                public void run() {

                    // Maths stuff
                    Vector Direction = Player.getLocation().getDirection();

                    Vector Right = Direction.clone().crossProduct(new Vector(0, 1, 0)).normalize();
                    Vector Left = Direction.clone().crossProduct(new Vector(0, -1, 0)).normalize();

                    Location RightLocation = Player.getLocation().add(Right.multiply(0.5));
                    Location LeftLocation = Player.getLocation().add(Left.multiply(0.5));

                   Player.getWorld().spawn(RightLocation, Arrow.class, RightArrow -> {
                       RightArrow.setShooter(Player);
                       RightArrow.setVelocity(Player.getVelocity().normalize().multiply(3));
                       RightArrow.setMetadata("MachineGunArrow", new FixedMetadataValue(CoolEnchants.GetPlugin(), true));
                    });

                    Player.getWorld().spawn(LeftLocation, Arrow.class, LeftArrow -> {
                        LeftArrow.setShooter(Player);
                        LeftArrow.setVelocity(Player.getVelocity().normalize().multiply(3));
                        LeftArrow.setMetadata("MachineGunArrow", new FixedMetadataValue(CoolEnchants.GetPlugin(), true));
                    });

                    Count++;
                    if (Count > 2) {
                        this.cancel();
                    }
                };
            }.runTaskTimer(CoolEnchants.GetPlugin(), 0, 2L);
        }
    }

    @EventHandler
    public void OnArrowHit(ProjectileHitEvent Event) {
        if (Event.getEntity() instanceof Arrow) {
            Arrow Arrow = (Arrow) Event.getEntity();

            if (Arrow.hasMetadata("MachineGunArrow")) {

                new BukkitRunnable() {
                    public void run() {
                        if (!(Event.getHitEntity() instanceof LivingEntity)) { return; }
                        LivingEntity HitEntity = (LivingEntity) Event.getHitEntity();
                        HitEntity.setNoDamageTicks(1);
                    }
                }.runTaskLater(CoolEnchants.GetPlugin(), 1);

                Arrow.remove();
            }
        }
    }
}
