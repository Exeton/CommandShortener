package online.fireflower.mortal_shortener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class ReloadConfig implements CommandExecutor{
	MortalShortener mortalShortener;
	public ReloadConfig(MortalShortener mortalShortener) {
		this.mortalShortener = mortalShortener;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		mortalShortener.reloadConfig();
		mortalShortener.loadConfig();
		arg0.sendMessage(ChatColor.GREEN + "Config reloaded");
		return true;
	}

}
