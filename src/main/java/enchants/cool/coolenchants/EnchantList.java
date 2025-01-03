package enchants.cool.coolenchants;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnchantList {

    private static String Butcher;

    public static Map<String, ArrayList<ItemStack>> Get() {

        ArrayList<ItemStack> Common = new ArrayList<>();
        ArrayList<ItemStack> Uncommon = new ArrayList<>();
        ArrayList<ItemStack> Rare = new ArrayList<>();
        ArrayList<ItemStack> Epic = new ArrayList<>();
        ArrayList<ItemStack> Legendary = new ArrayList<>();

        ItemStack SmiteI = new ItemStack(Material.ENCHANTED_BOOK);
        SmiteI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Smite I", "§7Max level 5" }));

        ItemStack SmiteII = new ItemStack(Material.ENCHANTED_BOOK);
        SmiteII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Smite II", "§7Max level 5" }));

        ItemStack SmiteIII = new ItemStack(Material.ENCHANTED_BOOK);
        SmiteIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aSmite III", "§aMax level 5" }));

        ItemStack SmiteIV = new ItemStack(Material.ENCHANTED_BOOK);
        SmiteIV.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aSmite IV", "§aMax level 5" }));

        ItemStack SmiteV = new ItemStack(Material.ENCHANTED_BOOK);
        SmiteV.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Sword", "§9Smite V", "§9Max level 5" }));

        ItemStack ButcherI = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Butcher I", "§7Max level 3" }));

        ItemStack ButcherII = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aButcher II", "§aMax level 3" }));

        ItemStack ButcherIII = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Sword", "§9Butcher III", "§9Max level 3" }));

        ItemStack LifeStealI = new ItemStack(Material.ENCHANTED_BOOK);
        LifeStealI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Lifesteal I", "§7Max level 5" }));

        ItemStack LifeStealII = new ItemStack(Material.ENCHANTED_BOOK);
        LifeStealII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aLifesteal II", "§aMax level 5" }));

        ItemStack LifeStealIII = new ItemStack(Material.ENCHANTED_BOOK);
        LifeStealIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Sword", "§9Lifesteal III", "§9Max level 5" }));

        ItemStack LifeStealIV = new ItemStack(Material.ENCHANTED_BOOK);
        LifeStealIV.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Sword", "§5Lifesteal IV", "§5Max level 5" }));

        ItemStack LifeStealV = new ItemStack(Material.ENCHANTED_BOOK);
        LifeStealV.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Sword", "§6Lifesteal V", "§6Max level 5" }));

        ItemStack VelocityI = new ItemStack(Material.ENCHANTED_BOOK);
        VelocityI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Bow", "§7Velocity I", "§7Max level 3" }));

        ItemStack VelocityII = new ItemStack(Material.ENCHANTED_BOOK);
        VelocityII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aBow", "§aVelocity II", "§aMax level 3" }));

        ItemStack VelocityIII = new ItemStack(Material.ENCHANTED_BOOK);
        VelocityIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Bow", "§9Velocity III", "§9Max level 3" }));

        ItemStack PoisonI = new ItemStack(Material.ENCHANTED_BOOK);
        PoisonI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aBow", "§aPoison I", "§aMax level 3" }));

        ItemStack PoisonII = new ItemStack(Material.ENCHANTED_BOOK);
        PoisonII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Bow", "§9Poison II", "§9Max level 3" }));

        ItemStack PoisonIII = new ItemStack(Material.ENCHANTED_BOOK);
        PoisonIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Bow", "§5Poison III", "§5Max level 3" }));

        ItemStack HugeCerebrumI = new ItemStack(Material.ENCHANTED_BOOK);
        HugeCerebrumI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aHelmet", "§aHuge Cerebrum I", "§aMax level 2" }));

        ItemStack HugeCerebrumII = new ItemStack(Material.ENCHANTED_BOOK);
        HugeCerebrumII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Helmet", "§9Huge Cerebrum II", "§9Max level 2" }));

        ItemStack BleedI = new ItemStack(Material.ENCHANTED_BOOK);
        BleedI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Bleed I", "§7Max level 3" }));

        ItemStack BleedII = new ItemStack(Material.ENCHANTED_BOOK);
        BleedII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aBleed II", "§aMax level 3" }));

        ItemStack BleedIII = new ItemStack(Material.ENCHANTED_BOOK);
        BleedIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Sword", "§9Bleed III", "§9Max level 3" }));

        ItemStack RegenerationI = new ItemStack(Material.ENCHANTED_BOOK);
        RegenerationI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Leggings", "§9Regeneration I", "§9Max level 2" }));

        ItemStack RegenerationII = new ItemStack(Material.ENCHANTED_BOOK);
        RegenerationII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Leggings", "§5Regeneration II", "§5Max level 2" }));

        ItemStack Revenge = new ItemStack(Material.ENCHANTED_BOOK);
        Revenge.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Chestplate", "§5Revenge", "§5Max level 1" }));

        ItemStack VoidWalker = new ItemStack(Material.ENCHANTED_BOOK);
        VoidWalker.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Boots", "§5Void Walker", "§5Max level 1" }));

        ItemStack SonicI = new ItemStack(Material.ENCHANTED_BOOK);
        SonicI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aBoots", "§aSonic I", "§aMax level 3" }));

        ItemStack SonicII = new ItemStack(Material.ENCHANTED_BOOK);
        SonicII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Boots", "§9Sonic II", "§9Max level 3" }));

        ItemStack SonicIII = new ItemStack(Material.ENCHANTED_BOOK);
        SonicIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Boots", "§5Sonic III", "§5Max level 3" }));

        ItemStack Replant = new ItemStack(Material.ENCHANTED_BOOK);
        Replant.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Hoe", "§9Replant", "§9Max level 1" }));

        ItemStack TankI = new ItemStack(Material.ENCHANTED_BOOK);
        TankI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Chestplate", "§9Tank I", "§9Max level 3" }));

        ItemStack TankII = new ItemStack(Material.ENCHANTED_BOOK);
        TankII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Chestplate", "§5Tank II", "§5Max level 3" }));

        ItemStack TankIII = new ItemStack(Material.ENCHANTED_BOOK);
        TankIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Chestplate", "§6Tank III", "§6Max level 3" }));

        ItemStack ReinforcedWingsI = new ItemStack(Material.ENCHANTED_BOOK);
        ReinforcedWingsI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Elytra", "§9Reinforced Wings I", "§9Max level 3" }));

        ItemStack ReinforcedWingsII = new ItemStack(Material.ENCHANTED_BOOK);
        ReinforcedWingsII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Elytra", "§5Reinforced Wings II", "§5Max level 3" }));

        ItemStack ReinforcedWingsIII = new ItemStack(Material.ENCHANTED_BOOK);
        ReinforcedWingsIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Elytra", "§6Reinforced Wings III", "§6Max level 3" }));

        ItemStack TamerI = new ItemStack(Material.ENCHANTED_BOOK);
        TamerI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Leggings", "§5Tamer I", "§5Max level 3" }));

        ItemStack TamerII = new ItemStack(Material.ENCHANTED_BOOK);
        TamerII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Leggings", "§5Tamer II", "§5Max level 3" }));

        ItemStack TamerIII = new ItemStack(Material.ENCHANTED_BOOK);
        TamerIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Leggings", "§6Tamer III", "§6Max level 3" }));

        ItemStack StormI = new ItemStack(Material.ENCHANTED_BOOK);
        StormI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Trident", "§5Storm I", "§5Max level 2" }));

        ItemStack StormII = new ItemStack(Material.ENCHANTED_BOOK);
        StormII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Trident", "§6Storm II", "§6Max level 2" }));

        ItemStack Tunneller = new ItemStack(Material.ENCHANTED_BOOK);
        Tunneller.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Tool", "§6Tunneller", "§6Max level 1" }));

        ItemStack Treecapitator = new ItemStack(Material.ENCHANTED_BOOK);
        Treecapitator.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Axe", "§6Treecapitator", "§6Max level 1" }));

        ItemStack MachineGuns = new ItemStack(Material.ENCHANTED_BOOK);
        MachineGuns.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Elytra", "§6Machine Guns", "§6Max level 1" }));

        Common.add(ButcherI);
        Common.add(SmiteI);
        Common.add(SmiteII);
        Common.add(LifeStealI);
        Common.add(VelocityI);
        Common.add(BleedI);

        Uncommon.add(ButcherII);
        Uncommon.add(SmiteIII);
        Uncommon.add(SmiteIV);
        Uncommon.add(SonicI);
        Uncommon.add(LifeStealII);
        Uncommon.add(HugeCerebrumI);
        Uncommon.add(VelocityII);
        Uncommon.add(PoisonI);
        Uncommon.add(BleedII);

        Rare.add(ButcherIII);
        Rare.add(TankI);
        Rare.add(Replant);
        Rare.add(SmiteV);
        Rare.add(SonicII);
        Rare.add(LifeStealIII);
        Rare.add(HugeCerebrumII);
        Rare.add(VelocityIII);
        Rare.add(PoisonII);
        Rare.add(BleedIII);
        Rare.add(RegenerationI);
        Rare.add(ReinforcedWingsI);

        Epic.add(TankII);
        Epic.add(Revenge);
        Epic.add(LifeStealIV);
        Epic.add(StormI);
        Epic.add(SonicIII);
        Epic.add(PoisonIII);
        Epic.add(VoidWalker);
        Epic.add(RegenerationII);
        Epic.add(TamerI);
        Epic.add(TamerII);
        Epic.add(ReinforcedWingsII);

        Legendary.add(TankIII);
        Legendary.add(StormII);
        Legendary.add(Tunneller);
        Legendary.add(LifeStealV);
        Legendary.add(MachineGuns);
        Legendary.add(TamerIII);
        Legendary.add(ReinforcedWingsIII);
        Legendary.add(Treecapitator);

        return Map.of(
                "Common", Common,
                "Uncommon", Uncommon,
                "Rare", Rare,
                "Epic", Epic,
                "Legendary", Legendary
        );
    }

    public static Map<String, String> GetDescriptions() {
        return Map.ofEntries(
                Map.entry("Butcher I", "Get 1 more food when killing a mob"),
                Map.entry("Smite I", "Smite your enemy dealing 0.66 more damage"),
                Map.entry("Smite II", "Smite your enemy dealing 1.33 more damage"),
                Map.entry("Lifesteal I", "Gain back 2% of damage dealt"),
                Map.entry("Velocity I", "Arrows have 33% more velocity"),
                Map.entry("Bleed I", "Damage the enemy for 1 heart a second later"),

                Map.entry("Butcher II", "Get 3 more food when killing a mob"),
                Map.entry("Smite III", "Smite your enemy dealing 2 more damage"),
                Map.entry("Smite IV", "Smite your enemy dealing 2.66 more damage"),
                Map.entry("Sonic I", "Move 10% faster"),
                Map.entry("Lifesteal II", "Gain back 4% of damage dealt"),
                Map.entry("Huge Cerebrum I", "Gain 50% more xp from all sources"),
                Map.entry("Velocity II", "Arrows have 66% more velocity"),
                Map.entry("Poison I", "Arrows give poison 2 for 1 second"),
                Map.entry("Bleed II", "Damage the enemy for 1 heart every second later twice"),

                Map.entry("Butcher III", "Get 2 more food when killing a mob"),
                Map.entry("Tank I", "Increases max health by 1 heart"),
                Map.entry("Replant", "Replants crops when you break them if you have their seed"),
                Map.entry("Smite V", "Smite your enemy dealing 3.33 more damage"),
                Map.entry("Sonic II", "Move 20% faster"),
                Map.entry("Lifesteal III", "Gain back 6% of damage dealt"),
                Map.entry("Huge Cerebrum II", "Gain double xp from all sources"),
                Map.entry("Velocity III", "Arrows have twice as much velocity"),
                Map.entry("Poison II", "Arrows give poison 2 for 2 seconds"),
                Map.entry("Bleed III", "Damage the enemy for 1 heart every second later 3 times"),
                Map.entry("Regeneration I", "Heal 0.25 hearts every 2 seconds"),
                Map.entry("Reinforced Wings I", "You take 11% less damage"),

                Map.entry("Tank II", "Increases max health by 2 hearts"),
                Map.entry("Revenge", "Release massive amounts of tnt when you die"),
                Map.entry("Lifesteal IV", "Gain back 8% of damage dealt"),
                Map.entry("Storm I", "Make a storm of twice as many tridents rain down and smite whatever mob you throw your trident at"),
                Map.entry("Sonic III", "Move 30% faster"),
                Map.entry("Poison III", "Arrows give poison 2 for 3 seconds"),
                Map.entry("Void Walker", "When you die to the void you teleport back to your spawn without losing any items"),
                Map.entry("Regeneration II", "Heal half a heart every 2 seconds"),
                Map.entry("Tamer I", "2% chance to get a spawn egg when killing a mob"),
                Map.entry("Tamer II", "4% chance to get a spawn egg when killing a mob"),
                Map.entry("Reinforced Wings II", "You take 22% less damage"),

                Map.entry("Tank III", "Increases max health by 3 hearts"),
                Map.entry("Storm II", "Make a storm of tridents rain down and smite whatever mob you throw your trident at"),
                Map.entry("Tunneller", "Breaks blocks in a 3x3 area, crouch to mine one block"),
                Map.entry("Lifesteal V", "Gain back 10% of damage dealt"),
                Map.entry("Machine Guns", "Arm your elytra with two super powered machine guns that you can shoot by left clicking while flying"),
                Map.entry("Tamer III", "6% chance to get a spawn egg when killing a mob"),
                Map.entry("Reinforced Wings III", "You take 33% less damage"),
                Map.entry("Treecapitator", "Cut down the whole tree when you break a log")
        );
    }
}
