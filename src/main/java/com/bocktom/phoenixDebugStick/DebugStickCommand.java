package com.bocktom.phoenixDebugStick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DebugStickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
		if (!sender.hasPermission("debugstick.admin")) {
			sender.sendMessage("Du hast keine Berechtigung für diesen Befehl");
			return true;
		}
		if (!(sender instanceof org.bukkit.entity.Player player)) {
			sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden");
			return true;
		}
		player.sendMessage(MSG.get("item-received"));
		DebugStickItem.give(player);
		return true;
	}
}
