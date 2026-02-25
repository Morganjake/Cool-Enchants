package enchants.cool.coolenchants.Helper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static enchants.cool.coolenchants.JsonHandler.GetJsonValue;
import static enchants.cool.coolenchants.JsonHandler.Toggle;
import static enchants.cool.coolenchants.UI.MainUI.MainMenu;

public class Commands implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender CommandSender, Command Command, String Label, String[] Args) {
        if (!(CommandSender instanceof Player)) {
            return false;
        }

        if (!Command.getName().equalsIgnoreCase("coolenchants")) {
            return false;
        }

        Player Player = (Player) CommandSender;

        if (Args.length == 0) {
            MainMenu(Player);
        }
        else {
            if (Objects.equals(Args[0], "toggletunneller")) {
                Toggle(Player, "toggletunneller");
                Player.sendMessage("§3The Tunneller enchant has been toggled " + (GetJsonValue(Player, "toggletunneller") ? "on" : "off"));
            }
            else if (Objects.equals(Args[0], "toggletreecapitator")) {
                Toggle(Player, "toggletreecapitator");
                Player.sendMessage("§3The Treecapitator enchant has been toggled " + (GetJsonValue(Player, "toggletreecapitator") ? "on" : "off"));
            }
            else if (Objects.equals(Args[0], "togglenightvision")) {
                Toggle(Player, "togglenightvision");
                Player.sendMessage("§3The night vision enchant has been toggled " + (GetJsonValue(Player, "togglenightvision") ? "on" : "off"));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> suggestions = new ArrayList<>();

        suggestions.add("toggletunneller");
        suggestions.add("toggletreecapitator");
        suggestions.add("togglenightvision");

        return suggestions;
    }
}
