package enchants.cool.coolenchants.Enchants.Boots;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Sonic {

    public static void Update(Player Player, int Level) {
        double PlayerSpeed = Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getBaseValue();
        Objects.requireNonNull(Player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(PlayerSpeed + (double) Level / 100);
    }
}
