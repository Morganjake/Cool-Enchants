package enchants.cool.coolenchants.Enchants.Boots;

import enchants.cool.coolenchants.Helper.EnchantHelper;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class Sonic implements Listener {

    public static void Update(Player Player, int Level) {
        double PlayerSpeed = Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getBaseValue();
        Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(PlayerSpeed + (double) Level / 100);
    }

    @EventHandler
    public static void OnPlayerJoin(PlayerJoinEvent Event) {

        Player Player = Event.getPlayer();

        Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1);

        ItemStack Boots = Player.getInventory().getBoots();

        ArrayList<String> Lore = EnchantHelper.GetEnchants(Boots);
        if (!Lore.contains("Sonic")) { return; }
        Integer EnchantLevel = EnchantHelper.GetEnchantLevels(Boots).get("Sonic");

        double PlayerSpeed = Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getBaseValue();
        Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(PlayerSpeed + (double) EnchantLevel / 100);
    }
}
