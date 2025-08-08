package com.bocktom.phoenixDebugStick;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		if(!player.hasPermission("debugstick.use"))
			return;

		ItemStack item = player.getInventory().getItemInMainHand();
		if(item.getType() != Material.DEBUG_STICK)
			return;

		if(!item.isSimilar(PhoenixDebugStick.plugin.debugStick)) {
			// Allow only admins to use other debug sticks
			if(!player.hasPermission("debugstick.admin")) {
				player.sendMessage(MSG.get("not-allowed"));
				event.setCancelled(true);
				return;
			} else {
				// Admins can use any debug stick
				return;
			}
		}

		Block clicked = event.getClickedBlock();

		if(clicked == null)
			return;

		if(!PhoenixDebugStick.plugin.getConfig().getList("ignored").contains(clicked.getType().toString()))
			return;

		if(player.hasPermission("debugstick.admin")) // Admins are allowed to use the debug stick on any block
			return;

		player.sendMessage(MSG.get("not-allowed"));
		event.setCancelled(true);
	}

}
