package de.Jan.Varus.Essentials.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class invseeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender; 
			if(player.hasPermission("varus.invsee")) {
				if(args.length >= 1) {
					String target = args[0]; 
					if(Bukkit.getPlayer(target) != null) {
						Player targetPlayer = Bukkit.getPlayer(target); 
						player.openInventory(targetPlayer.getInventory()); 
						player.sendMessage(Main.PREFIX + "§eDu hast das Inventar von " + targetPlayer.getDisplayName() + " §egeöffnet!");
					} else {
						sender.sendMessage(Main.PREFIX + "§cDieser Spieler ist nicht online!");
					}
				} else {
					sender.sendMessage(Main.PREFIX + "§e/invsee <player>"); 
				}
			} else {
				sender.sendMessage(Main.PREFIX + "§cDu hast keine Rechte!");
			}
				
		}
		return true;
	}
}
