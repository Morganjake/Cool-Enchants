package enchants.cool.coolenchants.Enchants.Chestplate;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;


public class Tank {

    public static void UpdateTank(Player Player, int Level) {
        double PlayerMaxHealth = Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue();
        Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(PlayerMaxHealth + Level * 2);
    }
}
