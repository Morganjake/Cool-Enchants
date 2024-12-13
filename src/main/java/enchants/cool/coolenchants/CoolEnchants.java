package enchants.cool.coolenchants;

import enchants.cool.coolenchants.Enchants.Chestplate.Revenge;
import enchants.cool.coolenchants.Enchants.Hoe.Replant;
import enchants.cool.coolenchants.Enchants.Pickaxe.Tunneller;
import enchants.cool.coolenchants.Enchants.Sword.Butcher;
import enchants.cool.coolenchants.Enchants.Sword.Smite;
import enchants.cool.coolenchants.Enchants.Trident.Storm;
import enchants.cool.coolenchants.Helper.AttackerOnDeath;
import enchants.cool.coolenchants.UI.InventoryClickListener;
import enchants.cool.coolenchants.UI.MainUI;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CoolEnchants extends JavaPlugin {

    private static CoolEnchants Plugin;

    @Override
    public void onEnable() {

        Plugin = this;

        this.getCommand("coolenchants").setExecutor(new MainUI());

        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new AttackerOnDeath(), this);
        getServer().getPluginManager().registerEvents(new Butcher(), this);
        getServer().getPluginManager().registerEvents(new Revenge(), this);
        getServer().getPluginManager().registerEvents(new Replant(), this);
        getServer().getPluginManager().registerEvents(new Storm(), this);
        getServer().getPluginManager().registerEvents(new Smite(), this);
        getServer().getPluginManager().registerEvents(new Tunneller(), this);

        try {
            getServer().getPluginManager().registerEvents(new Admin(), this);
            getLogger().warning("Admin file found");
        } catch (Exception e) {
            getLogger().info("No Admin file found");
        }

        ArmourUpdater.Start();

        getLogger().info("Cool Enchants Loaded");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CoolEnchants GetPlugin() {
        return Plugin;
    }
}
