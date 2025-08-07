package com.bocktom.phoenixDebugStick;

import static org.bukkit.Bukkit.getLogger;

public class MSG {

	public static String get(String path) {
		String msg = PhoenixDebugStick.plugin.getConfig().getString("msg." + path);
		if(msg == null) {
			getLogger().severe("MSG missing: <" + path + ">");
			return "§cMSG missing: <" + path + ">";
		}
		return msg;
	}

}
