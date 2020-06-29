package de.Jan.Varus.Essentials.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender; 
			if(player.hasPermission("varus.fly")) {
				if(player.getAllowFlight()) {
					player.setFlying(false);
					player.setAllowFlight(false);
					player.sendMessage(Main.PREFIX + "§cDu kannst nun nicht mehr fliege!");
				} else {
					player.setAllowFlight(true); 
					player.setFlying(true);
					player.sendMessage(Main.PREFIX + "§aDu kannst nun fliegen!");
				}
			} else {
				sender.sendMessage(Main.PREFIX + "§cDu hast keine Rechte!");
			}
		}
		return true;
	}

}
