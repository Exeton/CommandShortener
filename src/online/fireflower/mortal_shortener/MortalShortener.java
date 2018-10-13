package online.fireflower.mortal_shortener;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MortalShortener extends JavaPlugin{

	KeywordReplacer keywordReplacer;

	@Override
	public void onEnable(){		
		loadConfig();
        this.getCommand("MortalShortenerReload").setExecutor(new ReloadConfig(this));
    	PluginManager pm = getServer().getPluginManager();
    	pm.registerEvents(new CommandListener(keywordReplacer), this);
	}

	@Override
	public void onDisable(){
		
	}

	
	public void loadConfig(){
		makeConfig();
		FileConfiguration config = getConfig();
		Map<String, String> replacements = new HashMap<>();
		for (String key : config.getKeys(false)){
            replacements.put("#" + key, config.getString(key));
		}
        keywordReplacer = new KeywordReplacer(replacements);
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
