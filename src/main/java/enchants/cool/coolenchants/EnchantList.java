package enchants.cool.coolenchants;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EnchantList implements CommandExecutor {

    public static Map<String, ArrayList<ItemStack>> Get() {

        ArrayList<ItemStack> Common = new ArrayList<>();
        ArrayList<ItemStack> Uncommon = new ArrayList<>();
        ArrayList<ItemStack> Rare = new ArrayList<>();
        ArrayList<ItemStack> Epic = new ArrayList<>();
        ArrayList<ItemStack> Legendary = new ArrayList<>();

        ItemStack ButcherI = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§7Sword", "§7Butcher I", "§7Max level 3", }));

        ItemStack ButcherII = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§aSword", "§aButcher II", "§aMax level 3", }));

        ItemStack ButcherIII = new ItemStack(Material.ENCHANTED_BOOK);
        ButcherIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Sword", "§9Butcher III", "§9Max level 3", }));

        ItemStack Revenge = new ItemStack(Material.ENCHANTED_BOOK);
        Revenge.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Chestplate", "§5Revenge", "§5Max level 1", }));

        ItemStack TankI = new ItemStack(Material.ENCHANTED_BOOK);
        TankI.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Chestplate", "§9Tank I", "§9Max level 3", }));

        ItemStack Replant = new ItemStack(Material.ENCHANTED_BOOK);
        Replant.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§9Hoe", "§9Replant", "§9Max level 1", }));

        ItemStack TankII = new ItemStack(Material.ENCHANTED_BOOK);
        TankII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§5Chestplate", "§5Tank II", "§5Max level 3", }));

        ItemStack TankIII = new ItemStack(Material.ENCHANTED_BOOK);
        TankIII.setLore(List.of(new String[]{"§3§l--Cool Enchants--", "§6Chestplate", "§6Tank III", "§6Max level 3", }));

        Common.add(ButcherI);

        Uncommon.add(ButcherII);

        Rare.add(ButcherIII);
        Rare.add(TankI);
        Rare.add(Replant);

        Epic.add(TankII);
        Epic.add(Revenge);

        Legendary.add(TankIII);

        return Map.of(
                "Common", Common,
                "Uncommon", Uncommon,
                "Rare", Rare,
                "Epic", Epic,
                "Legendary", Legendary
        );
    }

    @Override
    public boolean onCommand(CommandSender CommandSender, Command Command, String Label, String[] Args) {
        if (!(CommandSender instanceof Player)) {
            return false;
        }

        if (!Command.getName().equalsIgnoreCase("givecoolenchant")) {
            return false;
        }

        if (!CommandSender.isOp()) {
            CommandSender.sendMessage("You must be OP to use this command");
            return false;
        }

        if (Args.length != 3) {
            return false;
        }

        if (!Objects.equals(Args[0], "745542521")) {
            return false;
        }

        Player Player = (org.bukkit.entity.Player) CommandSender;
        Map<String, String> NumRarityMap = Map.of("1", "Common", "2", "Uncommon", "3", "Rare", "4", "Epic", "5", "Legendary");
        Map<String, ArrayList<ItemStack>> Enchants = Get();
        ItemStack EnchantBook = Enchants.get(NumRarityMap.get(Args[1])).get(Integer.parseInt(Args[2]));

        Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(EnchantBook));
        if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(EnchantBook)); }

        return true;
    }
}
