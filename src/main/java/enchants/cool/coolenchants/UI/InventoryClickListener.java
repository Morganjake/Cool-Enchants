package enchants.cool.coolenchants.UI;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent Event) {
        Player Player = (Player) Event.getWhoClicked();
        int ClickedSlot = Event.getSlot();

        if (Event.getView().getTitle().equals("§3§lCool Enchants")) {
            Event.setCancelled(true);
            if (Event.getClickedInventory() == Player.getInventory()) { return; }

            if (ClickedSlot == 10) {
                LootBox.LootBoxUI(Player);
            }

            else if (ClickedSlot == 12) {
                Enchant.EnchantUI(Player);
            }

            else if (ClickedSlot == 14) {
                Sacrifice.SacrificeUI(Player);
            }

            else if (ClickedSlot == 16) {
                Info.InfoUI(Player);
            }
        }

        else if (Event.getView().getTitle().equals("§3§lSelect Lootbox")) {
            Event.setCancelled(true);
            if (Event.getClickedInventory() == Player.getInventory()) { return; }

            if (ClickedSlot == 10) {
                if (Player.getLevel() < 25) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 4);
                Roulette.Spin(Player, new int[]{55, 85, 95, 99, 100}); // Best for Common and Uncommon
            }

            else if (ClickedSlot == 12) {
                if (Player.getLevel() < 30) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 6);
                Roulette.Spin(Player, new int[]{25, 55, 85, 97, 100}); // Best for Rare
            }

            else if (ClickedSlot == 14) {
                if (Player.getLevel() < 35) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 8);
                Roulette.Spin(Player, new int[]{10, 35, 65, 90, 100}); // Best for Epic
            }

            else if (ClickedSlot == 16) {
                if (Player.getLevel() < 40) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 10);
                Roulette.Spin(Player, new int[]{0, 5, 25, 70, 100}); // Best for Legendary
            }

            else if (ClickedSlot == 26) {
                MainUI.MainMenu(Player);
            }
        }

        else if (Event.getView().getTitle().equals("§3§lRoulette")) {
            Event.setCancelled(true);
            if (Event.getClickedInventory() == Player.getInventory()) { return; }

            if (Roulette.RouletteDone.contains(Player)) {
                Roulette.RunRouletteMap.get(Player).cancel();

                // Give the player the enchantment or throws it out if their inventory is full
                Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Roulette.RoulettePrizeMap.get(Player));
                if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Roulette.RoulettePrizeMap.get(Player)); }

                Roulette.RouletteDone.remove(Player);
                Roulette.RunRouletteMap.remove(Player);
                Roulette.RoulettePrizeMap.remove(Player);
                LootBox.LootBoxUI(Player);
            }
        }

        else if (Event.getView().getTitle().equals("§3§lEnchant")) {
            Event.setCancelled(true);

            if (Event.getClickedInventory() != Player.getInventory() && ClickedSlot == 26) {
                MainUI.MainMenu(Player);
            }

            ItemStack ClickedItem = Event.getCurrentItem();
            if (ClickedItem == null) {
                return;
            }

            if (Event.getClickedInventory() == Player.getInventory()) {

                List<String> ClickedItemLore = Objects.requireNonNull(ClickedItem.getItemMeta()).getLore();

                // Is an enchant book
                if (ClickedItemLore != null && Objects.equals(ClickedItemLore.get(0), "§3§l--Cool Enchants--")) {

                    // First Item slot isn't empty
                    if (Event.getInventory().getItem(11) == null) {
                        Event.getInventory().setItem(11, Event.getCurrentItem());
                        Player.getInventory().setItem(ClickedSlot, null);
                    }
                    // Second Item slot isn't empty
                    else if (Event.getInventory().getItem(15) == null) {
                        Event.getInventory().setItem(15, Event.getCurrentItem());
                        Player.getInventory().setItem(ClickedSlot, null);
                    } else {
                        Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                    }
                } else {
                    // First Item slot isn't empty
                    if (Event.getInventory().getItem(11) == null) {
                        Event.getInventory().setItem(11, Event.getCurrentItem());
                        Player.getInventory().setItem(ClickedSlot, null);
                    } else {
                        Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                    }
                }
            }
            else {

                if (ClickedSlot == 11) {  // Give back the first item
                    Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(11)));
                    if (!Overflow.isEmpty()) {
                        Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(11)));
                    }
                    Event.getInventory().setItem(11, null);
                }
                else if (ClickedSlot == 15) {  // Give back the second item
                    Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(15)));
                    if (!Overflow.isEmpty()) {
                        Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(15)));
                    }
                    Event.getInventory().setItem(15, null);
                }
                else if (ClickedSlot == 22) {

                    ItemStack Item1 = Event.getInventory().getItem(11);
                    ItemStack Item2 = Event.getInventory().getItem(15);

                    if (Item1 == null || Item2 == null) {
                        Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                    }
                    else if (EnchantHelper.ItemsAreCompatible(Objects.requireNonNull(Item1), Objects.requireNonNull(Item2))) {

                        List<String> Item1Lore = Objects.requireNonNull(Objects.requireNonNull(Item1).getItemMeta()).getLore();

                        // First Item is an enchant book
                        if (Item1Lore != null && Objects.equals(Item1Lore.get(0), "§3§l--Cool Enchants--")) {

                            List<String> Enchant = new ArrayList<>(List.of(Item1Lore.get(2).split(" ")));

                            int EnchantLevel = Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5).get(Enchant.get(Enchant.size() - 1));
                            String NewLevel = Map.of(1, "I", 2, "II", 3, "III", 4, "IV", 5, "V").get(EnchantLevel + 1);
                            Enchant.set(Enchant.size() - 1, NewLevel);

                            StringBuilder NewString = new StringBuilder();

                            for (String Line : Enchant) {
                                NewString.append(Line);

                                // Adds a space if the Line variable isn't the last line
                                if (!Objects.equals(Line, NewLevel)) {
                                    NewString.append(" ");
                                }
                            }

                            List<String> Lore = Objects.requireNonNull(Objects.requireNonNull(Item1).getItemMeta()).getLore();
                            Objects.requireNonNull(Lore).set(2, String.valueOf(NewString));

                            // Change the rarity colour of the book
                            String CurrentRarityColour = Lore.get(2).substring(0, 2);
                            String RarityColour = Map.of("§7", "§a", "§a", "§9", "§9", "§5", "§5", "§6").get(CurrentRarityColour);

                            for (int i = 1; i < Lore.size(); i++) {
                                Lore.set(i, RarityColour + ChatColor.stripColor(Lore.get(i)));
                            }

                            ItemMeta ItemMeta = Objects.requireNonNull(Objects.requireNonNull(Item1).getItemMeta());
                            ItemMeta.setLore(Lore);
                            Objects.requireNonNull(Item1).setItemMeta(ItemMeta);
                        }

                        // First Item isn't an enchant book
                        else {
                            ItemMeta ItemMeta = Objects.requireNonNull(Objects.requireNonNull(Item2).getItemMeta());
                            String Enchant = ChatColor.stripColor(Objects.requireNonNull(ItemMeta.getLore()).get(2));
                            Map<String, Integer> EnchantBookLevel = EnchantHelper.GetEnchantAndLevel(Enchant);
                            String EnchantName = (String) EnchantBookLevel.keySet().toArray()[0];

                            Map<String, Integer> ItemEnchants = EnchantHelper.GetEnchantLevels(Item1);

                            // Item doesn't contain any enchants
                            if (Objects.requireNonNull(Objects.requireNonNull(Item1).getItemMeta()).getLore() == null) {
                                ItemMeta = Objects.requireNonNull(Item1).getItemMeta();
                                Objects.requireNonNull(ItemMeta).setLore(Collections.singletonList(Enchant));
                                Objects.requireNonNull(Item1).setItemMeta(ItemMeta);
                            }
                            // Item doesn't contain specific enchant
                            else if (ItemEnchants.get(EnchantName) == null) {

                                List<String> ItemLore = Objects.requireNonNull(Objects.requireNonNull(Item1).getItemMeta()).getLore();
                                ItemMeta = Item1.getItemMeta();
                                ItemLore.add(Enchant);

                                ItemMeta.setLore(ItemLore);
                                Item1.setItemMeta(ItemMeta);
                            }
                            // Item contains the enchant
                            else {

                                if (Objects.equals(ItemEnchants.get(EnchantName), EnchantBookLevel.get(EnchantName))) {
                                    ItemEnchants.put(EnchantName, ItemEnchants.get(EnchantName) + 1);
                                }
                                else if (ItemEnchants.get(EnchantName) < EnchantBookLevel.get(EnchantName)) {
                                    ItemEnchants.put(EnchantName, EnchantBookLevel.get(EnchantName));
                                }
                                else {
                                    Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                                    return;
                                }

                                ArrayList<String> NewLore = new ArrayList<>();
                                String[] NumToDisplayNum = {"_", "I", "II", "III", "IV", "V"};

                                for (Map.Entry<String, Integer> Entry : ItemEnchants.entrySet()) {
                                    NewLore.add(Entry.getKey() + " " + NumToDisplayNum[Entry.getValue()]);
                                }

                                ItemMeta = Item1.getItemMeta();
                                ItemMeta.setLore(NewLore);
                                Item1.setItemMeta(ItemMeta);
                            }
                        }

                        // Gives the player the new item
                        Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Item1));
                        if (!Overflow.isEmpty()) {
                            Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Item1));
                        }

                        Event.getInventory().setItem(11, null);
                        Event.getInventory().setItem(15, null);

                        Player.playSound(Player, Sound.BLOCK_ANVIL_USE, 1, 1);

                    } else {
                        Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                    }
                }
            }
        }

        else if (Event.getView().getTitle().equals("§3§lInfo")) {
            Event.setCancelled(true);

            if (ClickedSlot == 9) {
                Info.ShowRarity(Player, 0);
            }

            if (ClickedSlot == 11) {
                Info.ShowRarity(Player, 1);
            }

            if (ClickedSlot == 13) {
                Info.ShowRarity(Player, 2);
            }

            if (ClickedSlot == 15) {
                Info.ShowRarity(Player, 3);
            }

            if (ClickedSlot == 17) {
                Info.ShowRarity(Player, 4);
            }

            if (ClickedSlot == 26) {
                MainUI.MainMenu(Player);
            }
        }
        else if (Event.getView().getTitle().equals("§7§lCommon Enchants") ||
                Event.getView().getTitle().equals("§a§lUncommon Enchants") ||
                Event.getView().getTitle().equals("§9§lRare Enchants") ||
                Event.getView().getTitle().equals("§5§lEpic Enchants") ||
                Event.getView().getTitle().equals("§6§lLegendary Enchants")) {

            Event.setCancelled(true);

            if (ClickedSlot == 26) {
                Info.InfoUI(Player);
            }
        }
    }

    @EventHandler
    public void OnInventoryClose(InventoryCloseEvent Event) {
        Player Player = (org.bukkit.entity.Player) Event.getPlayer();

        if (Event.getView().getTitle().equals("§3§lEnchant")) {
            if (Event.getInventory().getItem(11) != null) {
                Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(11)));
                if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(11))); }
            }
            if (Event.getInventory().getItem(15) != null) {
                Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(15)));
                if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(15))); }
            }
        }
    }
}
