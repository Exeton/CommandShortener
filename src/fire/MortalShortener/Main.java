package fire.MortalShortener;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{

	public static Map<String, String> replacements;
	@Override
	public void onEnable(){		
		loadConfig();
        this.getCommand("MortalShortenerReload").setExecutor(new ReloadConfig(this));
    	PluginManager pm = getServer().getPluginManager();
    	pm.registerEvents(new CommandListener(), this);
	}

	@Override
	public void onDisable(){
		
	}

	
	public void loadConfig(){
		makeConfig();
		FileConfiguration config = getConfig();
		Map<String, String> ShortenersMap = new HashMap<String, String>();
		for (String key : config.getKeys(false)){
			ShortenersMap.put("#" + key, config.getString(key));
		}		
		replacements = ShortenersMap;		
	}	
	private void makeConfig(){
		if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().info("Config.yml not found, creating!");
            saveDefaultConfig();
        }
	}
}
