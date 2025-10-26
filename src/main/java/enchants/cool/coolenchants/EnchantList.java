package enchants.cool.coolenchants;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EnchantList {

    public static Map<String, ArrayList<ItemStack>> Get() {

        ArrayList<ItemStack> Common = new ArrayList<>();
        ArrayList<ItemStack> Uncommon = new ArrayList<>();
        ArrayList<ItemStack> Rare = new ArrayList<>();
        ArrayList<ItemStack> Epic = new ArrayList<>();
        ArrayList<ItemStack> Legendary = new ArrayList<>();

        ItemStack SmiteI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SmiteIMeta = SmiteI.getItemMeta();
        Objects.requireNonNull(SmiteIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Sword", "§7Smite I", "§7Max level 5"));
        SmiteI.setItemMeta(SmiteIMeta);

        ItemStack SmiteII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SmiteIIMeta = SmiteII.getItemMeta();
        Objects.requireNonNull(SmiteIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Sword", "§7Smite II", "§7Max level 5"));
        SmiteII.setItemMeta(SmiteIIMeta);

        ItemStack SmiteIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SmiteIIIMeta = SmiteIII.getItemMeta();
        Objects.requireNonNull(SmiteIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aSword", "§aSmite III", "§aMax level 5"));
        SmiteIII.setItemMeta(SmiteIIIMeta);

        ItemStack SmiteIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SmiteIVMeta = SmiteIV.getItemMeta();
        Objects.requireNonNull (SmiteIVMeta).setLore(List.of("§3§l--Cool Enchants--", "§aSword", "§aSmite IV", "§aMax level 5"));
        SmiteIV.setItemMeta(SmiteIVMeta);

        ItemStack SmiteV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SmiteVMeta = SmiteV.getItemMeta();
        Objects.requireNonNull(SmiteVMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Sword", "§9Smite V", "§9Max level 5"));
        SmiteV.setItemMeta(SmiteVMeta);

        ItemStack ButcherI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ButcherIMeta = ButcherI.getItemMeta();
        Objects.requireNonNull(ButcherIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Sword", "§7Butcher I", "§7Max level 3"));
        ButcherI.setItemMeta(ButcherIMeta);

        ItemStack ButcherII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ButcherIIMeta = ButcherII.getItemMeta();
        Objects.requireNonNull(ButcherIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aSword", "§aButcher II", "§aMax level 3"));
        ButcherII.setItemMeta(ButcherIIMeta);

        ItemStack ButcherIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ButcherIIIMeta = ButcherIII.getItemMeta();
        Objects.requireNonNull(ButcherIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Sword", "§9Butcher III", "§9Max level 3"));
        ButcherIII.setItemMeta(ButcherIIIMeta);

        ItemStack LifeStealI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LifeStealIMeta = LifeStealI.getItemMeta();
        Objects.requireNonNull(LifeStealIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Sword", "§7Lifesteal I", "§7Max level 5"));
        LifeStealI.setItemMeta(LifeStealIMeta);

        ItemStack LifeStealII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LifeStealIIMeta = LifeStealII.getItemMeta();
        Objects.requireNonNull(LifeStealIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aSword", "§aLifesteal II", "§aMax level 5"));
        LifeStealII.setItemMeta(LifeStealIIMeta);

        ItemStack LifeStealIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LifeStealIIIMeta = LifeStealIII.getItemMeta();
        Objects.requireNonNull (LifeStealIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Sword", "§9Lifesteal III", "§9Max level 5"));
        LifeStealIII.setItemMeta(LifeStealIIIMeta);

        ItemStack LifeStealIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LifeStealIVMeta = LifeStealIV.getItemMeta();
        Objects.requireNonNull(LifeStealIVMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Sword", "§5Lifesteal IV", "§5Max level 5"));
        LifeStealIV.setItemMeta(LifeStealIVMeta);

        ItemStack LifeStealV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LifeStealVMeta = LifeStealV.getItemMeta();
        Objects.requireNonNull(LifeStealVMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Sword", "§6Lifesteal V", "§6Max level 5"));
        LifeStealV.setItemMeta(LifeStealVMeta);

        ItemStack VelocityI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta VelocityIMeta = VelocityI.getItemMeta();
        Objects.requireNonNull(VelocityIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Bow", "§7Velocity I", "§7Max level 3"));
        VelocityI.setItemMeta(VelocityIMeta);

        ItemStack VelocityII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta VelocityIIMeta = VelocityII.getItemMeta();
        Objects.requireNonNull(VelocityIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aBow", "§aVelocity II", "§aMax level 3"));
        VelocityII.setItemMeta(VelocityIIMeta);

        ItemStack VelocityIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta VelocityIIIMeta = VelocityIII.getItemMeta();
        Objects.requireNonNull(VelocityIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Bow", "§9Velocity III", "§9Max level 3"));
        VelocityIII.setItemMeta(VelocityIIIMeta);

        ItemStack PoisonI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta PoisonIMeta = PoisonI.getItemMeta();
        Objects.requireNonNull(PoisonIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aBow", "§aPoison I", "§aMax level 3"));
        PoisonI.setItemMeta(PoisonIMeta);

        ItemStack PoisonII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta PoisonIIMeta = PoisonII.getItemMeta();
        Objects.requireNonNull(PoisonIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Bow", "§9Poison II", "§9Max level 3"));
        PoisonII.setItemMeta(PoisonIIMeta);

        ItemStack PoisonIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta PoisonIIIMeta = PoisonIII.getItemMeta();
        Objects.requireNonNull(PoisonIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Bow", "§5Poison III", "§5Max level 3"));
        PoisonIII.setItemMeta(PoisonIIIMeta);

        ItemStack HugeCerebrumI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta HugeCerebrumIMeta = HugeCerebrumI.getItemMeta();
        Objects.requireNonNull(HugeCerebrumIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aHelmet", "§aHuge Cerebrum I", "§aMax level 2"));
        HugeCerebrumI.setItemMeta(HugeCerebrumIMeta);

        ItemStack HugeCerebrumII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta HugeCerebrumIIMeta = HugeCerebrumII.getItemMeta();
        Objects.requireNonNull(HugeCerebrumIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Helmet", "§9Huge Cerebrum II", "§9Max level 2"));
        HugeCerebrumII.setItemMeta(HugeCerebrumIIMeta);

        ItemStack BleedI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta BleedIMeta = BleedI.getItemMeta();
        Objects.requireNonNull(BleedIMeta).setLore(List.of("§3§l--Cool Enchants--", "§7Sword", "§7Bleed I", "§7Max level 3"));
        BleedI.setItemMeta(BleedIMeta);

        ItemStack BleedII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta BleedIIMeta = BleedII.getItemMeta();
        Objects.requireNonNull(BleedIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aSword", "§aBleed II", "§aMax level 3"));
        BleedII.setItemMeta(BleedIIMeta);

        ItemStack BleedIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta BleedIIIMeta = BleedIII.getItemMeta();
        Objects.requireNonNull(BleedIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Sword", "§9Bleed III", "§9Max level 3"));
        BleedIII.setItemMeta(BleedIIIMeta);

        ItemStack RegenerationI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta RegenerationIMeta = RegenerationI.getItemMeta();
        Objects.requireNonNull(RegenerationIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Leggings", "§9Regeneration I", "§9Max level 2"));
        RegenerationI.setItemMeta(RegenerationIMeta);

        ItemStack RegenerationII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta RegenerationIIMeta = RegenerationII.getItemMeta();
        Objects.requireNonNull(RegenerationIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Leggings", "§5Regeneration II", "§5Max level 2"));
        RegenerationII.setItemMeta(RegenerationIIMeta);

        ItemStack NightOwl = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta NightOwlMeta = NightOwl.getItemMeta();
        Objects.requireNonNull(NightOwlMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Helmet", "§9Night Owl", "§9Max level 1"));
        NightOwl.setItemMeta(NightOwlMeta);

        ItemStack Revenge = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta RevengeMeta = Revenge.getItemMeta();
        Objects.requireNonNull(RevengeMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Chestplate", "§5Revenge", "§5Max level 1"));
        Revenge.setItemMeta(RevengeMeta);

        ItemStack VoidWalker = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta VoidWalkerMeta = VoidWalker.getItemMeta();
        Objects.requireNonNull(VoidWalkerMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Boots", "§5Void Walker", "§5Max level 1"));
        VoidWalker.setItemMeta(VoidWalkerMeta);

        ItemStack SonicI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SonicIMeta = SonicI.getItemMeta();
        Objects.requireNonNull(SonicIMeta).setLore(List.of("§3§l--Cool Enchants--", "§aBoots", "§aSonic I", "§aMax level 3"));
        SonicI.setItemMeta(SonicIMeta);

        ItemStack SonicII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SonicIIMeta = SonicII.getItemMeta();
        Objects.requireNonNull(SonicIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Boots", "§9Sonic II", "§9Max level 3"));
        SonicII.setItemMeta(SonicIIMeta);

        ItemStack SonicIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta SonicIIIMeta = SonicIII.getItemMeta();
        Objects.requireNonNull(SonicIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Boots", "§5Sonic III", "§5Max level 3"));
        SonicIII.setItemMeta(SonicIIIMeta);

        ItemStack Replant = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ReplantMeta = Replant.getItemMeta();
        Objects.requireNonNull(ReplantMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Hoe", "§9Replant", "§9Max level 1"));
        Replant.setItemMeta(ReplantMeta);

        ItemStack TankI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TankIMeta = TankI.getItemMeta();
        Objects.requireNonNull(TankIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Chestplate", "§9Tank I", "§9Max level 3"));
        TankI.setItemMeta(TankIMeta);

        ItemStack TankII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TankIIMeta = TankII.getItemMeta();
        Objects.requireNonNull(TankIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Chestplate", "§5Tank II", "§5Max level 3"));
        TankII.setItemMeta(TankIIMeta);

        ItemStack TankIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TankIIIMeta = TankIII.getItemMeta();
        Objects.requireNonNull(TankIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Chestplate", "§6Tank III", "§6Max level 3"));
        TankIII.setItemMeta(TankIIIMeta);

        ItemStack ReinforcedWingsI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ReinforcedWingsIMeta = ReinforcedWingsI.getItemMeta();
        Objects.requireNonNull(ReinforcedWingsIMeta).setLore(List.of("§3§l--Cool Enchants--", "§9Elytra", "§9Reinforced Wings I", "§9Max level 3"));
        ReinforcedWingsI.setItemMeta(ReinforcedWingsIMeta);

        ItemStack ReinforcedWingsII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ReinforcedWingsIIMeta = ReinforcedWingsII.getItemMeta();
        Objects.requireNonNull(ReinforcedWingsIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Elytra", "§5Reinforced Wings II", "§5Max level 3"));
        ReinforcedWingsII.setItemMeta(ReinforcedWingsIIMeta);

        ItemStack ReinforcedWingsIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta ReinforcedWingsIIIMeta = ReinforcedWingsIII.getItemMeta();
        Objects.requireNonNull(ReinforcedWingsIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Elytra", "§6Reinforced Wings III", "§6Max level 3"));
        ReinforcedWingsIII.setItemMeta(ReinforcedWingsIIIMeta);

        ItemStack TamerI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TamerIMeta = TamerI.getItemMeta();
        Objects.requireNonNull(TamerIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Leggings", "§5Tamer I", "§5Max level 3"));
        TamerI.setItemMeta(TamerIMeta);

        ItemStack TamerII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TamerIIMeta = TamerII.getItemMeta();
        Objects.requireNonNull(TamerIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Leggings", "§5Tamer II", "§5Max level 3"));
        TamerII.setItemMeta(TamerIIMeta);

        ItemStack TamerIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TamerIIIMeta = TamerIII.getItemMeta();
        Objects.requireNonNull(TamerIIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Leggings", "§6Tamer III", "§6Max level 3"));
        TamerIII.setItemMeta(TamerIIIMeta);

        ItemStack StormI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta StormIMeta = StormI.getItemMeta();
        Objects.requireNonNull(StormIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Trident", "§5Storm I", "§5Max level 2"));
        StormI.setItemMeta(StormIMeta);

        ItemStack StormII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta StormIIMeta = StormII.getItemMeta();
        Objects.requireNonNull(StormIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Trident", "§6Storm II", "§6Max level 2"));
        StormII.setItemMeta(StormIIMeta);

        ItemStack Tunneller = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TunnellerMeta = Tunneller.getItemMeta();
        Objects.requireNonNull(TunnellerMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Tool", "§6Tunneller", "§6Max level 1"));
        Tunneller.setItemMeta(TunnellerMeta);

        ItemStack LavaWalkerI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LavaWalkerIMeta = LavaWalkerI.getItemMeta();
        Objects.requireNonNull(LavaWalkerIMeta).setLore(List.of("§3§l--Cool Enchants--", "§5Boots", "§5Lava Walker I", "§5Max level 2"));
        LavaWalkerI.setItemMeta(LavaWalkerIMeta);

        ItemStack LavaWalkerII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta LavaWalkerIIMeta = LavaWalkerII.getItemMeta();
        Objects.requireNonNull(LavaWalkerIIMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Boots", "§6Lava Walker II", "§6Max level 2"));
        LavaWalkerII.setItemMeta(LavaWalkerIIMeta);

        ItemStack Treecapitator = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta TreecapitatorMeta = Treecapitator.getItemMeta();
        Objects.requireNonNull(TreecapitatorMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Axe", "§6Treecapitator", "§6Max level 1"));
        Treecapitator.setItemMeta(TreecapitatorMeta);

        ItemStack MachineGuns = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta MachineGunsMeta = MachineGuns.getItemMeta();
        Objects.requireNonNull(MachineGunsMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Elytra", "§6Machine Guns", "§6Max level 1"));
        MachineGuns.setItemMeta(MachineGunsMeta);

        ItemStack Clone = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta CloneMeta = Clone.getItemMeta();
        Objects.requireNonNull(CloneMeta).setLore(List.of("§3§l--Cool Enchants--", "§6Crossbow", "§6Clone", "§6Max level 1"));
        Clone.setItemMeta(CloneMeta);

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
        Rare.add(NightOwl);

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
        Epic.add(LavaWalkerI);

        Legendary.add(TankIII);
        Legendary.add(StormII);
        Legendary.add(Tunneller);
        Legendary.add(LifeStealV);
        Legendary.add(MachineGuns);
        Legendary.add(TamerIII);
        Legendary.add(ReinforcedWingsIII);
        Legendary.add(Treecapitator);
        Legendary.add(LavaWalkerII);
        Legendary.add(Clone);

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
                Map.entry("Night Owl", "Gives the user permanent night vision"),

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
                Map.entry("Lava Walker I", "Allows you to walk on lava in a 2 block radius"),

                Map.entry("Tank III", "Increases max health by 3 hearts"),
                Map.entry("Storm II", "Make a storm of tridents rain down and smite whatever mob you throw your trident at"),
                Map.entry("Tunneller", "Breaks blocks in a 3x3 area, crouch to mine one block"),
                Map.entry("Lifesteal V", "Gain back 10% of damage dealt"),
                Map.entry("Machine Guns", "Arm your elytra with two super powered machine guns that you can shoot by left clicking while flying"),
                Map.entry("Tamer III", "6% chance to get a spawn egg when killing a mob"),
                Map.entry("Reinforced Wings III", "You take 33% less damage"),
                Map.entry("Treecapitator", "Cut down the whole tree when you break a log, crouch to chop one log"),
                Map.entry("Lava Walker II", "Allows you to walk on lava in a 3 block radius"),
                Map.entry("Clone", "Summon 2 clones of your crossbow")
        );
    }
}
