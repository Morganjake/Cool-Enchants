package enchants.cool.coolenchants;

import enchants.cool.coolenchants.Enchants.Axe.Treecapitator;
import enchants.cool.coolenchants.Enchants.Boots.LavaWalker;
import enchants.cool.coolenchants.Enchants.Boots.Sonic;
import enchants.cool.coolenchants.Enchants.Boots.VoidWalker;
import enchants.cool.coolenchants.Enchants.Bow.Poison;
import enchants.cool.coolenchants.Enchants.Bow.Velocity;
import enchants.cool.coolenchants.Enchants.Chestplate.Revenge;
import enchants.cool.coolenchants.Enchants.Elytra.MachineGuns;
import enchants.cool.coolenchants.Enchants.Elytra.ReinforcedWings;
import enchants.cool.coolenchants.Enchants.Helmet.HugeCerebrum;
import enchants.cool.coolenchants.Enchants.Hoe.Replant;
import enchants.cool.coolenchants.Enchants.Leggings.Regeneration;
import enchants.cool.coolenchants.Enchants.Leggings.Tamer;
import enchants.cool.coolenchants.Enchants.Tool.Tunneller;
import enchants.cool.coolenchants.Enchants.Sword.Bleed;
import enchants.cool.coolenchants.Enchants.Sword.Butcher;
import enchants.cool.coolenchants.Enchants.Sword.Lifesteal;
import enchants.cool.coolenchants.Enchants.Sword.Smite;
import enchants.cool.coolenchants.Enchants.Trident.Storm;
import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.UI.InventoryClickListener;
import enchants.cool.coolenchants.UI.MainUI;
import enchants.cool.coolenchants.UI.Sacrifice;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CoolEnchants21 extends JavaPlugin {

    private static CoolEnchants21 Plugin;

    @Override
    public void onEnable() {

        Plugin = this;

        Objects.requireNonNull(this.getCommand("coolenchants")).setExecutor(new MainUI());

        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new Sacrifice(), this);
        getServer().getPluginManager().registerEvents(new AttackerOnDeath(), this);

        getServer().getPluginManager().registerEvents(new Butcher(), this);
        getServer().getPluginManager().registerEvents(new Revenge(), this);
        getServer().getPluginManager().registerEvents(new Replant(), this);
        getServer().getPluginManager().registerEvents(new Storm(), this);
        getServer().getPluginManager().registerEvents(new Smite(), this);
        getServer().getPluginManager().registerEvents(new Tunneller(), this);
        getServer().getPluginManager().registerEvents(new Lifesteal(), this);
        getServer().getPluginManager().registerEvents(new HugeCerebrum(), this);
        getServer().getPluginManager().registerEvents(new MachineGuns(), this);
        getServer().getPluginManager().registerEvents(new Velocity(), this);
        getServer().getPluginManager().registerEvents(new Poison(), this);
        getServer().getPluginManager().registerEvents(new Bleed(), this);
        getServer().getPluginManager().registerEvents(new VoidWalker(), this);
        getServer().getPluginManager().registerEvents(new Tamer(), this);
        getServer().getPluginManager().registerEvents(new ReinforcedWings(), this);
        getServer().getPluginManager().registerEvents(new Treecapitator(), this);
        getServer().getPluginManager().registerEvents(new LavaWalker(), this);
        getServer().getPluginManager().registerEvents(new Sonic(), this);
        Regeneration.Regen();

        try {
            getServer().getPluginManager().registerEvents(new Admin(), this);
        } catch (Exception e) {
            String DoNothing = "Do Nothing";
        }

        ArmourUpdater.Start();
        LavaWalker.StartLavaUpdater();

        getLogger().info("Cool Enchants Loaded");
        getServer().broadcast("Cool Enchants Reloaded", "");
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        HandlerList.unregisterAll();
    }

    public static CoolEnchants21 GetPlugin() {
        return Plugin;
    }
}
