package enchants.cool.coolenchants;

import enchants.cool.coolenchants.UI.Info;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class Admin implements Listener {

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent Event) {

        if (Event.getView().getTitle().equals("§3§lCommon Enchants") ||
                Event.getView().getTitle().equals("§a§lUncommon Enchants") ||
                Event.getView().getTitle().equals("§9§lRare Enchants") ||
                Event.getView().getTitle().equals("§5§lEpic Enchants") ||
                Event.getView().getTitle().equals("§6§lLegendary Enchants")) {

            Player Player = (Player) Event.getWhoClicked();
            int ClickedSlot = Event.getSlot();

            Event.setCancelled(true);

            if (ClickedSlot == 26) {
                return;
            }

//            if (Event.getInventory().getItem(ClickedSlot) != null && Player.getName().equals("Person")) {
//                Player.getInventory().addItem(Objects.requireNonNull(Event.getInventory().getItem(ClickedSlot)));
//            }
        }
    }
}
