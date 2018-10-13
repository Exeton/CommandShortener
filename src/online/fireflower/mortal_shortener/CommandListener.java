package online.fireflower.mortal_shortener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onCommand(PlayerCommandPreprocessEvent event){
		if (!event.getPlayer().hasPermission("staff.shorten") && !event.getPlayer().isOp())
			return;
		
		String msg = event.getMessage();
		for (String keyword : MortalShortener.replacements.keySet()){
			msg = msg.replace(keyword, MortalShortener.replacements.get(keyword));
		}
		event.setMessage(msg);
	}
}
