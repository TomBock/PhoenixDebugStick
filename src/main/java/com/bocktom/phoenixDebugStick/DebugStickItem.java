package com.bocktom.phoenixDebugStick;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DebugStickItem {

	public static void give(Player player) {

		ItemStack stick = PhoenixDebugStick.plugin.debugStick.clone();
		player.getInventory().addItem(stick);

		player.sendMessage("§aDebug Stick wurde in dein Inventar gelegt.");
	}

}
