package enchants.cool.coolenchants;

import enchants.cool.coolenchants.Enchants.Chestplate.Tank;
import enchants.cool.coolenchants.Helper.EnchantHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class ArmourUpdater {

    private static void UpdateHelmet(Player Player, List<Component> PreviousLore, List<Component> Lore) {

    }

    private static void UpdateChestplate(Player Player, List<Component> PreviousLore, List<Component> Lore) {

        ArrayList<String> PreviousEnchants = EnchantHelper.GetEnchants(PreviousLore);
        Map<String, Integer> PreviousLevels = EnchantHelper.GetEnchantLevels(PreviousLore);

        ArrayList<String> Enchants = EnchantHelper.GetEnchants(Lore);
        Map<String, Integer> Levels = EnchantHelper.GetEnchantLevels(Lore);

        if (Enchants.contains("Tank")) {
            Tank.UpdateTank(Player, Levels.get("Tank"));
        }
        if (PreviousEnchants.contains("Tank")) {
            Tank.UpdateTank(Player, PreviousLevels.get("Tank") * -1);
        }
    }

    private static void UpdateLeggings(Player Player, List<Component> PreviousLore, List<Component> Lore) {

    }

    private static void UpdateBoots(Player Player, List<Component> PreviousLore, List<Component> Lore) {

    }

    public static void Start() {
        BukkitRunnable ResetCooldown = new BukkitRunnable() {

            public final Map<Player, ArrayList<String>> PreviousArmourMap = new HashMap<>();
            public final Map<Player, ArrayList<List<Component>>> PreviousRawArmourLoreMap = new HashMap<>();

            @Override
            public void run() {
                for (Player Player : CoolEnchants.GetPlugin().getServer().getOnlinePlayers()) {
                    ArrayList<String> Armour = new ArrayList<>();
                    ArrayList<List<Component>> RawArmourLore = new ArrayList<>();

                    if (Player.getInventory().getHelmet() != null && Player.getInventory().getHelmet().lore() != null) {
                        Armour.add(Objects.requireNonNull(Player.getInventory().getHelmet().lore()).toString());
                        RawArmourLore.add(Player.getInventory().getHelmet().lore());
                    } else {
                        Armour.add(null);
                        RawArmourLore.add(null);
                    }

                    if (Player.getInventory().getChestplate() != null && Player.getInventory().getChestplate().lore() != null) {
                        Armour.add(Objects.requireNonNull(Player.getInventory().getChestplate().lore()).toString());
                        RawArmourLore.add(Player.getInventory().getChestplate().lore());
                    } else {
                        Armour.add(null);
                        RawArmourLore.add(null);
                    }

                    if (Player.getInventory().getLeggings() != null && Player.getInventory().getLeggings().lore() != null) {
                        Armour.add(Objects.requireNonNull(Player.getInventory().getLeggings().lore()).toString());
                        RawArmourLore.add(Player.getInventory().getLeggings().lore());
                    } else {
                        Armour.add(null);
                        RawArmourLore.add(null);
                    }

                    if (Player.getInventory().getBoots() != null && Player.getInventory().getBoots().lore() != null) {
                        Armour.add(Objects.requireNonNull(Player.getInventory().getBoots().lore()).toString());
                        RawArmourLore.add(Player.getInventory().getBoots().lore());
                    } else {
                        Armour.add(null);
                        RawArmourLore.add(null);
                    }

                    if (PreviousArmourMap.containsKey(Player) && PreviousRawArmourLoreMap.containsKey(Player)) {

                        for (int i = 0; i < 4; i++) {
                            if (!Objects.equals(PreviousArmourMap.get(Player).get(i), Armour.get(i))) {
                                switch (i) {
                                    case 0: {
                                        UpdateHelmet(Player, PreviousRawArmourLoreMap.get(Player).get(i), RawArmourLore.get(i));
                                    }
                                    case 1: {
                                        UpdateChestplate(Player, PreviousRawArmourLoreMap.get(Player).get(i), RawArmourLore.get(i));
                                    }
                                    case 2: {
                                        UpdateLeggings(Player, PreviousRawArmourLoreMap.get(Player).get(i), RawArmourLore.get(i));
                                    }
                                    case 3: {
                                        UpdateBoots(Player, PreviousRawArmourLoreMap.get(Player).get(i), RawArmourLore.get(i));
                                    }
                                }
                            }
                        }
                    }

                    PreviousArmourMap.put(Player, Armour);
                    PreviousRawArmourLoreMap.put(Player, RawArmourLore);
                }
            }
        };

        ResetCooldown.runTaskTimer(CoolEnchants.GetPlugin(), 1L, 1L);
    }
}
