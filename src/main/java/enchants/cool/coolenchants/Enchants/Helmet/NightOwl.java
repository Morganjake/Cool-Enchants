package enchants.cool.coolenchants.Enchants.Helmet;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightOwl {

    public static void Update(Player Player, boolean TurnOn) {

        if (TurnOn) {
            Player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE , 0, true, false));
        }
        else {
            Player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }
}
