package enchants.cool.coolenchants.UI;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

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
                Roulette.Spin(Player, new int[]{55, 85, 95, 99, 100});
            }

            else if (ClickedSlot == 12) {
                if (Player.getLevel() < 30) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 6);
                Roulette.Spin(Player, new int[]{25, 55, 85, 97, 100});
            }

            else if (ClickedSlot == 14) {
                if (Player.getLevel() < 35) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 8);
                Roulette.Spin(Player, new int[]{10, 35, 70, 90, 100});
            }

            else if (ClickedSlot == 16) {
                if (Player.getLevel() < 40) { Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1); return; }
                Player.setLevel(Player.getLevel() - 10);
                Roulette.Spin(Player, new int[]{0, 15, 45, 80, 100});
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

            ItemStack ClickedItem = Event.getCurrentItem();
            if (ClickedItem == null) { return; }
            String ItemName = ClickedItem.toString();
            if (Event.getClickedInventory() == Player.getInventory()) {

                if ( ItemName.contains("_SWORD") || ItemName.contains("_PICKAXE") ||
                        ItemName.contains("_AXE") || ItemName.contains("_SHOVEL") ||
                        ItemName.contains("_HOE") || ItemName.contains("TRIDENT") ||
                        ItemName.contains("SHIELD") || ItemName.contains("ELYTRA") ||
                        ItemName.contains("_HELMET") || ItemName.contains("_CHESTPLATE") ||
                        ItemName.contains("_LEGGINGS") || ItemName.contains("_BOOTS") ) {

                    // Checks if the gui has an item held in it
                    if (Event.getInventory().getItem(11) != null) {
                        // Give the player the item or throws it out if their inventory is full
                        Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(11)));
                        if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(11))); }
                    }

                    // Checks if the gui has an enchant book held in it
                    if (Event.getInventory().getItem(15) != null) {
                        // Checks if the book is compatible with the new item
                        if ( ClickedItem.toString().contains("_SWORD") || ClickedItem.toString().contains("_PICKAXE") ||
                                ClickedItem.toString().contains("_AXE") || ClickedItem.toString().contains("_SHOVEL") ||
                                ClickedItem.toString().contains("_HOE") || ClickedItem.toString().contains("TRIDENT") ||
                                ClickedItem.toString().contains("SHIELD") || ClickedItem.toString().contains("ELYTRA") ||
                                ClickedItem.toString().contains("_HELMET") || ClickedItem.toString().contains("_CHESTPLATE") ||
                                ClickedItem.toString().contains("_LEGGINGS") || ClickedItem.toString().contains("_BOOTS") ) {
                            Event.getInventory().setItem(11, ClickedItem);
                        }
                        else {
                            Event.getInventory().setItem(11, ClickedItem);

                            // Gives the enchant book back
                            Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(15)));
                            if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(15))); }
                            Event.getInventory().setItem(15, null);
                        }
                    }
                    else {
                        Event.getInventory().setItem(11, ClickedItem);
                    }

                    Player.getInventory().setItem(ClickedSlot, null);
                }

                else if (ClickedItem.getLore() != null && Objects.equals(ClickedItem.getLore().get(0), "§3§l--Cool Enchants--")) {

                    // Checks if the gui has an enchant book held in it
                    if (Event.getInventory().getItem(15) != null) {
                        // Give the player the enchant book or throws it out if their inventory is full
                        Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(15)));
                        if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(15))); }
                    }

                    // Checks if the gui has an item held in it
                    if (Event.getInventory().getItem(11) != null) {
                        // Checks if the enchant book is compatible with the item
                        String EnchantableItem = Event.getInventory().getItem(11).toString();
                        if ( EnchantableItem.contains("_SWORD") || EnchantableItem.contains("_PICKAXE") ||
                                EnchantableItem.contains("_AXE") || EnchantableItem.contains("_SHOVEL") ||
                                EnchantableItem.contains("_HOE") || EnchantableItem.contains("TRIDENT") ||
                                EnchantableItem.contains("SHIELD") || EnchantableItem.contains("ELYTRA") ||
                                EnchantableItem.contains("_HELMET") || EnchantableItem.contains("_CHESTPLATE") ||
                                EnchantableItem.contains("_LEGGINGS") || EnchantableItem.contains("_BOOTS") ) {
                            Event.getInventory().setItem(15, ClickedItem);
                        }
                        else { return; }
                    }
                    else {
                        Event.getInventory().setItem(15, ClickedItem);
                    }

                    Player.getInventory().setItem(ClickedSlot, null);
                }
            }
            else if (ClickedSlot == 22 && Event.getInventory().getItem(11) != null && Event.getInventory().getItem(15) != null) {

                // Adds the enchant to the item's lore
                String Enchant = ChatColor.stripColor(Event.getInventory().getItem(15).getLore().get(2));
                int MaxLevel = Integer.valueOf(ChatColor.stripColor(Event.getInventory().getItem(15).getLore().get(3)).split(" ")[2]);
                ArrayList<String> ItemLore = (ArrayList<String>) Event.getInventory().getItem(11).getLore();
                if (ItemLore == null) { ItemLore = new ArrayList<String>();}

                // Converts Strings into Components
                ArrayList<Component> ComponentLore = new ArrayList<>();
                for (String Line : ItemLore) {
                    ComponentLore.add(Component.text(Line));
                }

                Map<String, Integer> ItemEnchantLevels = EnchantHelper.GetEnchantLevels(ComponentLore);
                Map<String, Integer> EnchantBookLevel = EnchantHelper.GetEnchantLevels(Collections.singletonList(Component.text(Enchant)));

                String EnchantName = (String) EnchantBookLevel.keySet().toArray()[0];

                // Checks if the item already has the enchant
                if (ItemEnchantLevels.containsKey(EnchantName)) {

                    if (Objects.equals(EnchantBookLevel.get(EnchantName), ItemEnchantLevels.get(EnchantName))) {
                        int NewLevel = ItemEnchantLevels.get(EnchantName) + 1;

                        if (NewLevel > MaxLevel) {
                            Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                            return;
                        }
                        else {
                            ItemEnchantLevels.put(EnchantName, ItemEnchantLevels.get(EnchantName) + 1) ;
                        }

                    }
                    else {
                        Player.playSound(Player, Sound.BLOCK_ANVIL_LAND, 1, 1);
                        return;
                    }

                    ArrayList<String> NewLore = new ArrayList<String>();
                    String[] NumToDisplayNum = {"_", "I", "II", "III", "IV", "V"};

                    for (Map.Entry<String, Integer> Entry : ItemEnchantLevels.entrySet()) {
                        NewLore.add(Entry.getKey() + " " + NumToDisplayNum[Entry.getValue()]);
                    }

                    Event.getInventory().getItem(11).setLore(NewLore);
                }
                else {
                    ItemLore.add(Enchant);
                    Event.getInventory().getItem(11).setLore(ItemLore);
                }

                Map<Integer, ItemStack> Overflow = Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(11)));
                if (!Overflow.isEmpty()) { Player.getWorld().dropItem(Player.getLocation(), Objects.requireNonNull(Event.getInventory().getItem(11))); }

                Event.getInventory().setItem(11, null);
                Event.getInventory().setItem(15, null);
                Player.playSound(Player, Sound.BLOCK_ANVIL_USE, 1, 1);

            }

            else if (ClickedSlot == 26) {
                MainUI.MainMenu(Player);
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
        else if (Event.getView().getTitle().equals("§3§lCommon Enchants") ||
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
