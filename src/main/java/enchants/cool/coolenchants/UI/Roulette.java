package enchants.cool.coolenchants.UI;

import enchants.cool.coolenchants.CoolEnchants;
import enchants.cool.coolenchants.EnchantList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Roulette {

    public static ArrayList<Player> RouletteDone = new ArrayList<Player>();
    public static Map<Player, BukkitRunnable> RunRouletteMap = new HashMap<Player, BukkitRunnable>();
    public static Map<Player, ItemStack> RoulettePrizeMap = new HashMap<Player, ItemStack>();

    private static String GetRarity(int[] Odds) {
        String[] Rarities = {"Common", "Uncommon", "Rare", "Epic", "Legendary"};
        int Number = (int) Math.floor(Math.random() * 100) + 1;

        for (int i = 0; i < 5; i++) {
            if (Number <= Odds[i]) {
                return Rarities[i];
            }
        }

        return "Common";
    }

    public static void Spin(Player Player, int[] Odds) {

        Map<String, ArrayList<ItemStack>> Books = EnchantList.Get();
        ArrayList<ItemStack> Display = new ArrayList<>();
        ArrayList<String> DisplayRarities = new ArrayList<>();

        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lRoulette");
        Player.openInventory(Inventory);

        final int[] Iterations = {70};

        BukkitRunnable RunRoulette = new BukkitRunnable() {

            @Override
            public void run() {

                Iterations[0]--;

                if (Iterations[0] >= 0) {
                    String Rarity = GetRarity(Odds);
                    ArrayList<ItemStack> EnchantPool = Books.get(Rarity);
                    ItemStack Enchant = EnchantPool.get((int) Math.floor(Math.random() * EnchantPool.size()));

                    Display.add(0, Enchant);
                    DisplayRarities.add(0, Rarity);

                    if (Display.size() > 9) {
                        Display.remove(9);
                        DisplayRarities.remove(9);
                    }

                    Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lRoulette");

                    for (int i = 0; i < Display.size(); i++) {
                        Inventory.setItem(i + 9, Display.get(i));
                        Player.playSound(Player, Sound.BLOCK_NOTE_BLOCK_BASS, 1, (float) 1.5 - ((float) Iterations[0] / 70));

                        ItemStack GlassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

                        if (Objects.equals(DisplayRarities.get(i), "Uncommon")) {
                            GlassPane = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                        } else if (Objects.equals(DisplayRarities.get(i), "Rare")) {
                            GlassPane = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
                        } else if (Objects.equals(DisplayRarities.get(i), "Epic")) {
                            GlassPane = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
                        } else if (Objects.equals(DisplayRarities.get(i), "Legendary")) {
                            GlassPane = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                        }

                        Inventory.setItem(i, GlassPane);
                        Inventory.setItem(i + 18, GlassPane);
                    }

                    Player.openInventory(Inventory);

                    if (Iterations[0] == 0) {
                        Inventory = Bukkit.createInventory(Player, 27,  "§3§lRoulette");
                        Inventory.setItem(13, Display.get(4));
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, 1);
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, (float) 0.7);
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, (float) 1.3);
                        Player.openInventory(Inventory);
                        RouletteDone.add(Player);
                        RoulettePrizeMap.put(Player, Display.get(4));
                    }
                }
                else if ((Iterations[0] + 1) % 4 == 0){
                    ItemStack EvenGlassPane = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                    ItemStack OddGlassPane = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);

                    if ((Iterations[0] + 1) % 8 == 0) {
                        EvenGlassPane = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                        OddGlassPane = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                    }

                    Inventory.setItem(13, Display.get(4));
                    Inventory.setItem(3, OddGlassPane);
                    Inventory.setItem(4, EvenGlassPane);
                    Inventory.setItem(5, OddGlassPane);
                    Inventory.setItem(12, EvenGlassPane);
                    Inventory.setItem(14, EvenGlassPane);
                    Inventory.setItem(21, OddGlassPane);
                    Inventory.setItem(22, EvenGlassPane);
                    Inventory.setItem(23, OddGlassPane);
                    Player.openInventory(Inventory);
                }
            }
        };

        RunRoulette.runTaskTimer(CoolEnchants.GetPlugin(), 0, 2L);
        RunRouletteMap.put(Player, RunRoulette);
    }
}
