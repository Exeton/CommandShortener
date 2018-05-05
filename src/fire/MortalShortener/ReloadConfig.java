package fire.MortalShortener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class ReloadConfig implements CommandExecutor{
	Main Main;
	public ReloadConfig(Main main) {
		Main = main;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Main.reloadConfig();
		Main.loadConfig();
		arg0.sendMessage(ChatColor.GREEN + "Config reloaded");
		return true;
	}

}
