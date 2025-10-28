package enchants.cool.coolenchants;

import enchants.cool.coolenchants.Enchants.Boots.Sonic;
import enchants.cool.coolenchants.Enchants.Chestplate.Tank;
import enchants.cool.coolenchants.Enchants.Helmet.NightOwl;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class ArmourUpdater {

    private static void UpdateHelmet(Player Player, ItemStack PreviousItem, ItemStack Item) {

        ArrayList<String> PreviousEnchants = EnchantHelper.GetEnchants(PreviousItem);
        Map<String, Integer> PreviousLevels = EnchantHelper.GetEnchantLevels(PreviousItem);

        ArrayList<String> Enchants = EnchantHelper.GetEnchants(Item);
        Map<String, Integer> Levels = EnchantHelper.GetEnchantLevels(Item);

        if (Enchants.contains("Night Owl")) {
            NightOwl.Update(Player, true);
        }
        if (PreviousEnchants.contains("Night Owl")) {
            NightOwl.Update(Player, false);
        }
    }

    private static void UpdateChestplate(Player Player, ItemStack PreviousItem, ItemStack Item) {

        ArrayList<String> PreviousEnchants = EnchantHelper.GetEnchants(PreviousItem);
        Map<String, Integer> PreviousLevels = EnchantHelper.GetEnchantLevels(PreviousItem);

        ArrayList<String> Enchants = EnchantHelper.GetEnchants(Item);
        Map<String, Integer> Levels = EnchantHelper.GetEnchantLevels(Item);

        if (Enchants.contains("Tank")) {
            Tank.Update(Player, Levels.get("Tank"));
        }
        if (PreviousEnchants.contains("Tank")) {
            Tank.Update(Player, PreviousLevels.get("Tank") * -1);
        }
    }

    private static void UpdateLeggings(Player Player, ItemStack PreviousItem, ItemStack Item) {

    }

    private static void UpdateBoots(Player Player, ItemStack PreviousItem, ItemStack Item) {

        ArrayList<String> PreviousEnchants = EnchantHelper.GetEnchants(PreviousItem);
        Map<String, Integer> PreviousLevels = EnchantHelper.GetEnchantLevels(PreviousItem);

        ArrayList<String> Enchants = EnchantHelper.GetEnchants(Item);
        Map<String, Integer> Levels = EnchantHelper.GetEnchantLevels(Item);

        if (Enchants.contains("Sonic")) {
            Sonic.Update(Player, Levels.get("Sonic"));
        }
        if (PreviousEnchants.contains("Sonic")) {
            Sonic.Update(Player, PreviousLevels.get("Sonic") * -1);
        }
    }

    public static void Start() {
        BukkitRunnable ResetCooldown = new BukkitRunnable() {

            public final Map<Player, ArrayList<ItemStack>> PreviousArmourMap = new HashMap<>();

            @Override
            public void run() {
                for (Player Player : CoolEnchants21.GetPlugin().getServer().getOnlinePlayers()) {
                    ArrayList<ItemStack> Armour = new ArrayList<>();

                    if (Player.getInventory().getHelmet() != null) {
                        Armour.add(Player.getInventory().getHelmet().clone());
                    }
                    else {
                        Armour.add(null);
                    }

                    if (Player.getInventory().getChestplate() != null) {
                        Armour.add(Player.getInventory().getChestplate().clone());
                    }
                    else {
                        Armour.add(null);
                    }

                    if (Player.getInventory().getLeggings() != null) {
                        Armour.add(Player.getInventory().getLeggings().clone());
                    }
                    else {
                        Armour.add(null);
                    }

                    if (Player.getInventory().getBoots() != null) {
                        Armour.add(Player.getInventory().getBoots().clone());
                    }
                    else {
                        Armour.add(null);
                    }

                    if (PreviousArmourMap.containsKey(Player)) {

                        for (int i = 0; i < 4; i++) {
                            if (!Objects.equals(PreviousArmourMap.get(Player).get(i), Armour.get(i))) {
                                switch (i) {
                                    case 0: {
                                        UpdateHelmet(Player, PreviousArmourMap.get(Player).get(i), Armour.get(i));
                                    }
                                    case 1: {
                                        UpdateChestplate(Player, PreviousArmourMap.get(Player).get(i), Armour.get(i));
                                    }
                                    case 2: {
                                        UpdateLeggings(Player, PreviousArmourMap.get(Player).get(i), Armour.get(i));
                                    }
                                    case 3: {
                                        UpdateBoots(Player, PreviousArmourMap.get(Player).get(i), Armour.get(i));
                                    }
                                }
                            }
                        }
                    }

                    PreviousArmourMap.put(Player, Armour);
                }
            }
        };

        ResetCooldown.runTaskTimer(CoolEnchants21.GetPlugin(), 1L, 10L);
    }
}
