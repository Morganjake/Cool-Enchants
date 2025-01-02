package enchants.cool.coolenchants.Enchants.Elytra;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class MachineGuns implements Listener {

    @EventHandler
    public void OnPlayerLeftClick(PlayerInteractEvent Event) {

        Player Player = Event.getPlayer();
        ItemStack Chestplate = Player.getInventory().getChestplate();
        if (Chestplate == null) { return; }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Chestplate.lore());
        if (!Lore.contains("Machine Guns")) { return; }

        if (Event.getAction() == Action.LEFT_CLICK_AIR || Event.getAction() == Action.LEFT_CLICK_BLOCK) {

            if (Player.getItemInHand().getType().equals(Material.FIREWORK_ROCKET)) { return; }
            if (!Player.isGliding()) { return; }

            BukkitRunnable ShootArrows = new BukkitRunnable() {

                int Count = 0;

                @Override
                public void run() {

                    // Maths stuff
                    Vector Direction = Player.getLocation().getDirection();

                    Vector Right = Direction.clone().crossProduct(new Vector(0, 1, 0)).normalize();
                    Vector Left = Direction.clone().crossProduct(new Vector(0, -1, 0)).normalize();

                    Location RightLocation = Player.getLocation().add(Right.multiply(0.5));
                    Location LeftLocation = Player.getLocation().add(Left.multiply(0.5));

                    Arrow RightArrow = Player.getWorld().spawn(RightLocation, Arrow.class);

                   RightArrow.setShooter(Player);
                   RightArrow.setVelocity(Player.getVelocity().add(Player.getVelocity().normalize().multiply(3)));
                   RightArrow.setVelocity(RightArrow.getVelocity().add(new Vector((Math.random() - 0.5) / 5, 0, (Math.random() - 0.5) / 5)));
                   RightArrow.setMetadata("MachineGunArrow", new FixedMetadataValue(CoolEnchants.GetPlugin(), true));

                    Arrow LeftArrow = Player.getWorld().spawn(LeftLocation, Arrow.class);
                    LeftArrow.setShooter(Player);
                    LeftArrow.setVelocity(Player.getVelocity().add(Player.getVelocity().normalize().multiply(3)));
                    LeftArrow.setVelocity(LeftArrow.getVelocity().add(new Vector((Math.random() - 0.5) / 5, 0, (Math.random() - 0.5) / 5)));
                    LeftArrow.setMetadata("MachineGunArrow", new FixedMetadataValue(CoolEnchants.GetPlugin(), true));

                    Count++;
                    if (Count >= 3) {
                        this.cancel();
                    }
                };
            };

            ShootArrows.runTaskTimer(CoolEnchants.GetPlugin(), 0, 2L);
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

                }.runTaskLater(CoolEnchants.GetPlugin(), 3);

                Arrow.remove();
            }
        }
    }
}
