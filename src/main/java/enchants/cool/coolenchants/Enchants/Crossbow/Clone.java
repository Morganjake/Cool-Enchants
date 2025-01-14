package enchants.cool.coolenchants.Enchants.Crossbow;

import enchants.cool.coolenchants.CoolEnchants21;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Clone implements Listener {

    private static final HashMap<Player, ArrayList<ArmorStand>> PlayerClones = new HashMap<>();

    @EventHandler
    public static void OnItemHeldChange(PlayerItemHeldEvent Event) {

        Player Player = Event.getPlayer();
        ItemStack Crossbow = Player.getInventory().getItem(Event.getNewSlot());

        if (Crossbow == null) {
            HideClones(Player);
            return;
        }

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Crossbow);
        if (!Lore.contains("Clone")) {
            HideClones(Player);
        }
        else {
            ShowClones(Player);
        }

    }

    private static void ShowClones(Player Player) {

        World World = Player.getWorld();

        ArrayList<ArmorStand> Clones = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            // Spawn them very high up, so they don't get in the player's way
            ArmorStand ArmourStand = World.spawn(Player.getLocation().add(0, 1000000, 0), ArmorStand.class);

//            ArmourStand.setVisible(false);
            ArmourStand.setGravity(false);
            ArmourStand.setMarker(true);

            Objects.requireNonNull(ArmourStand.getEquipment()).setHelmet(new ItemStack(Material.CROSSBOW));
            Clones.add(ArmourStand);

        }

        PlayerClones.put(Player, Clones);

        new BukkitRunnable() {

            @Override
            public void run() {

                if (!Player.isOnline()) {
                    HideClones(Player);
                }

                if (Clones.get(0).isDead()) {
                    cancel();
                }

                Location TargetLocation = GetBlockPlayerIsLookingAt(Player);

                for (int i = 0; i < 2; i++) {

                    ArmorStand Clone = Clones.get(i);

                    Location ArmourStandLocation = Player.getLocation().clone().add(0, 2,0);
                    ArmourStandLocation.setPitch(Player.getLocation().getPitch());

                    Location SideALoc = Player.getLocation().clone().subtract(ArmourStandLocation.clone());
                    double SideA = new Vector(Math.abs(SideALoc.getX()), Math.abs(SideALoc.getY()), Math.abs(SideALoc.getZ())).length();

                    Location SideBLoc = ArmourStandLocation.clone().subtract(TargetLocation.clone());
                    double SideB = new Vector(Math.abs(SideBLoc.getX()), Math.abs(SideBLoc.getY()), Math.abs(SideBLoc.getZ())).length();

                    Location SideCLoc = Player.getLocation().subtract(TargetLocation.clone());
                    double SideC = new Vector(Math.abs(SideCLoc.getX()), Math.abs(SideCLoc.getY()), Math.abs(SideCLoc.getZ())).length();

                    double Pitch = Math.acos((SideA * SideA + SideB * SideB - SideC * SideC) / (2 * SideA * SideB));

                    // Offsets the crossbows
                    Vector Direction = Player.getLocation().getDirection().clone();
                    Vector Offset = Direction.normalize().crossProduct(new Vector(0, -4 + 9 * i, 0));
                    ArmourStandLocation.add(Offset);

                    Clone.teleport(ArmourStandLocation);
                    Clone.setHeadPose(new EulerAngle(Math.toRadians(90) + Math.PI / 2 - Pitch, Math.toRadians(-45), 0));
                    Clone.setBodyPose(Clone.getHeadPose());

                    GetBlockCrossbowIsLookingAt(Clone);
                }
            }
        }.runTaskTimer(CoolEnchants21.GetPlugin(), 0, 1L);
    }

    private static void HideClones(Player Player) {

        if (!PlayerClones.containsKey(Player)) { return; }

        for (Entity Clone : PlayerClones.get(Player)) {
            Clone.remove();
        }

        PlayerClones.remove(Player);
    }

    private static Location GetBlockPlayerIsLookingAt(Player Player) {

        Location CurrentLocation = Player.getEyeLocation().clone();
        Vector Direction = Player.getLocation().getDirection().clone();

        // Uses smaller increments if the player is facing a block for more accurate locations
        double Precision;
        if (Player.getTargetBlockExact(5) == null) {
            Precision = 1;
        }
        else {
            Precision = 0.2;
        }

        int MaxIterations = 0;

        while (MaxIterations < 300) {

            if (Player.getWorld().getBlockAt(CurrentLocation).getType() != Material.AIR) {

                if (!Player.getWorld().getBlockAt(CurrentLocation).isPassable()) {
                    return CurrentLocation;
                }
            }

            CurrentLocation.add(Direction.clone().multiply(0.2 * Precision));
            MaxIterations++;
        }

        return CurrentLocation;
    }

    private static void GetBlockCrossbowIsLookingAt(Entity Crossbow) {

        Location CurrentLocation = Crossbow.getLocation().clone().add(0, 2, 0);
        Vector Direction = Crossbow.getLocation().getDirection().clone();

        int MaxIterations = 0;

        while (MaxIterations < 300) {

//            Crossbow.getWorld().spawnParticle(Particle.HEART, CurrentLocation, 2);

            if (Crossbow.getWorld().getBlockAt(CurrentLocation).getType() != Material.AIR) {

                if (!Crossbow.getWorld().getBlockAt(CurrentLocation).isPassable()) {
                    return;
                }
            }

            CurrentLocation.add(Direction.clone().multiply(0.5));
            MaxIterations++;
        }
    }
}
