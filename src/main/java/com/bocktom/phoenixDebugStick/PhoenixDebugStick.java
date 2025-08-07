package com.bocktom.phoenixDebugStick;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhoenixDebugStick extends JavaPlugin {

	public static PhoenixDebugStick plugin;
	public ItemStack debugStick;

	@Override
	public void onEnable() {
		plugin = this;
		getConfig().options().copyDefaults(true);
		saveConfig();

		debugStick = getConfig().getItemStack("item");
		if(debugStick == null) {
			getLogger().warning("Debug stick item not found in config. Disabling plugin.");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		getCommand("debugstick").setExecutor(new DebugStickCommand());
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}

}
