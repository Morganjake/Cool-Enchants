package enchants.cool.coolenchants.UI;

import enchants.cool.coolenchants.CoolEnchants21;
import enchants.cool.coolenchants.EnchantList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class Sacrifice implements Listener {

    static HashMap<Player, ArrayList<ItemStack>> SacrificedBooks = new HashMap<>();

    public static void SacrificeUI(Player Player) {
        Inventory Inventory = Bukkit.createInventory(Player, 27,  "§3§lSacrifice Books");

        ItemStack CauldronIcon = new ItemStack(Material.CAULDRON);
        ItemMeta CauldronIconMeta = CauldronIcon.getItemMeta();
        CauldronIconMeta.setDisplayName("§5§lSacrificial Cauldron");
        CauldronIconMeta.setLore(List.of("§dYou have sacrificed 0 books"));
        CauldronIcon.setItemMeta(CauldronIconMeta);
        Inventory.setItem(4, CauldronIcon);

        for (int i = 9; i < 18; i++) {
            ItemStack PowerLevelIcon = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta PowerLevelIconMeta = PowerLevelIcon.getItemMeta();
            Objects.requireNonNull(PowerLevelIconMeta).setDisplayName("§8§lSacrifice Meter");
            PowerLevelIcon.setItemMeta(PowerLevelIconMeta);
            Inventory.setItem(i, PowerLevelIcon);
        }

        ItemStack ReturnIcon = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta ReturnIconMeta = ReturnIcon.getItemMeta();
        Objects.requireNonNull(ReturnIconMeta).setDisplayName("§c§lReturn");
        ReturnIcon.setItemMeta(ReturnIconMeta);
        Inventory.setItem(26, ReturnIcon);

        Player.openInventory(Inventory);
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent Event) {
        Player Player = (Player) Event.getWhoClicked();
        int ClickedSlot = Event.getSlot();
        ItemStack ClickedItem = Event.getCurrentItem();
        Inventory GUI = Event.getInventory();

        if (ClickedItem == null) { return; }

        if (!Event.getView().getTitle().equals("§3§lSacrifice Books")) { return; }
        Event.setCancelled(true);

        if (Event.getClickedInventory() == Player.getInventory()) {
            List<String> ClickedItemLore = ClickedItem.getItemMeta().getLore();

            if (ClickedItemLore != null && Objects.equals(ClickedItemLore.get(0), "§3§l--Cool Enchants--")) {

                int PrevPower = 0;

                for (ItemStack Book : SacrificedBooks.getOrDefault(Player, new ArrayList<>())) {
                    ItemMeta BookMeta = Book.getItemMeta();
                    String Rarity = String.valueOf(BookMeta.getLore().get(1).charAt(1));
                    int RarityPower = Map.of("7", 3, "a", 5, "9", 8, "5", 15, "6", 30).get(Rarity);
                    PrevPower += RarityPower;
                }

                if (PrevPower >= 45) {
                    Player.playSound(Player, Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return;
                }

                if (SacrificedBooks.containsKey(Player)) {
                    ArrayList<ItemStack> PlayerBooks = SacrificedBooks.get(Player);
                    PlayerBooks.add(ClickedItem);
                    SacrificedBooks.replace(Player, PlayerBooks);
                }
                else {
                    SacrificedBooks.put(Player, new ArrayList<>(List.of(ClickedItem)));
                }
                Player.playSound(Player, Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, 5, 1);

                Player.getInventory().setItem(ClickedSlot, null);


                int Power = 0;

                ArrayList<ItemStack> Books = SacrificedBooks.getOrDefault(Player, new ArrayList<>());

                for (ItemStack Book : Books) {
                    ItemMeta BookMeta = Book.getItemMeta();
                    String Rarity = String.valueOf(BookMeta.getLore().get(1).charAt(1));
                    int RarityPower = Map.of("7", 3, "a", 5, "9", 8, "5", 15, "6", 30).get(Rarity);
                    Power += RarityPower;
                }

                ArrayList<String> Lore = new ArrayList<>(List.of("§dYou have sacrificed " + Books.size() + " book" + (Books.size() > 1 ? "s" : "")));

                if (Power >= 9) {
                    String Book = new String[] {" Common", "n Uncommon", " Rare", "n Epic", " Legendary"}[Math.min((int) Math.floor(Math.max(Power - 9, 0) / 9.0), 4)];
                    Lore.add("§aSacrificing now will give you a" + Book + " Enchant!");
                }

                ItemStack CauldronIcon = new ItemStack(Material.CAULDRON);
                ItemMeta CauldronIconMeta = CauldronIcon.getItemMeta();
                CauldronIconMeta.setDisplayName("§5§lSacrificial Cauldron");
                CauldronIconMeta.setLore(Lore);
                CauldronIcon.setItemMeta(CauldronIconMeta);
                GUI.setItem(4, CauldronIcon);

                Material[] GlassPanes = {Material.GRAY_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE,
                Material.BLUE_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE};

                for (int i = 0; i < 9; i++) {
                    int Tier = Math.min((int) Math.floor((Power - i - 1) / 9.0), 4);
                    if (Tier < 0) { continue; }
                    ItemStack PowerLevelIcon = new ItemStack(GlassPanes[Tier]);
                    ItemMeta PowerLevelIconMeta = PowerLevelIcon.getItemMeta();
                    String RarityPower = new String[] {"7", "a", "9", "5", "6"}[Tier];
                    Objects.requireNonNull(PowerLevelIconMeta).setDisplayName("§" + RarityPower + "§lSacrifice Meter");
                    if (Power >= 45) {
                        PowerLevelIconMeta.addEnchant(Enchantment.BREACH, 1, true);
                        PowerLevelIconMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    }
                    PowerLevelIcon.setItemMeta(PowerLevelIconMeta);
                    GUI.setItem(i + 9, PowerLevelIcon);
                }

                ItemStack SacrificeIcon = new ItemStack(Material.HOPPER);
                ItemMeta SacrificeIconMeta = SacrificeIcon.getItemMeta();
                Objects.requireNonNull(SacrificeIconMeta).setDisplayName("§6§lSacrifice");
                SacrificeIcon.setItemMeta(SacrificeIconMeta);
                GUI.setItem(22, SacrificeIcon);

                Player.updateInventory();
            }
        }
        else {
            if (ClickedSlot == 26) {
                MainUI.MainMenu(Player);
            }
            else if (ClickedSlot == 22) {

                int Power = 0;

                for (ItemStack Book : SacrificedBooks.getOrDefault(Player, new ArrayList<>())) {
                    ItemMeta BookMeta = Book.getItemMeta();
                    String Rarity = String.valueOf(BookMeta.getLore().get(1).charAt(1));
                    int RarityPower = Map.of("7", 3, "a", 5, "9", 8, "5", 15, "6", 30).get(Rarity);
                    Power += RarityPower;
                }

                ArrayList<ItemStack> Books;
                if (Power < 9) {
                    Player.playSound(Player, Sound.BLOCK_CHAIN_BREAK, 1, 1);
                    return;
                }
                else if (Power < 18) {
                    Books = EnchantList.Get().get("Common");
                }
                else if (Power < 27) {
                    Books = EnchantList.Get().get("Uncommon");
                }
                else if (Power < 36) {
                    Books = EnchantList.Get().get("Rare");
                }
                else if (Power < 45) {
                    Books = EnchantList.Get().get("Epic");
                }
                else {
                    Books = EnchantList.Get().get("Legendary");
                }

                Player.playSound(Player, Sound.BLOCK_BREWING_STAND_BREW, 1, 1);
                SacrificedBooks.remove(Player);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, 1);
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, (float) 0.7);
                        Player.playSound(Player, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, (float) 1.3);

                        ItemStack Enchant = Books.get((int) Math.floor(Math.random() * Books.size()));
                        Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Enchant);
                        if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Enchant); }

                        SacrificeUI(Player);
                    }
                }.runTaskLater(CoolEnchants21.GetPlugin(), 20L);
            }
        }
    }

    @EventHandler
    public void OnInventoryClose(InventoryCloseEvent Event) {

        if (!Event.getView().getTitle().equals("§3§lSacrifice Books")) { return; }

        Player Player = (Player) Event.getPlayer();

        for (ItemStack Book : SacrificedBooks.getOrDefault(Player, new ArrayList<>())) {
            Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Book);
            if (!Overflow.isEmpty()) {
                Player.getWorld().dropItem(Player.getLocation(), Book);
            }
        }
        SacrificedBooks.remove(Player);
    }
}
