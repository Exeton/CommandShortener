package online.fireflower.mortal_shortener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{

	KeywordReplacer keywordReplacer;

	public CommandListener(KeywordReplacer keywordReplacer){
	    this.keywordReplacer = keywordReplacer;
    }

	@EventHandler(priority = EventPriority.NORMAL)
	public void onCommand(PlayerCommandPreprocessEvent event){
		if (!event.getPlayer().hasPermission("staff.shorten"))
			return;

		event.setMessage(keywordReplacer.replace(event.getMessage()));
	}
}
