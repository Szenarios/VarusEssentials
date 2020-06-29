package de.Jan.Varus.Essentials.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class msgCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) { 
			Player player = (Player) sender; 
			if(args.length >= 2) {
				String target = args[0]; 
				if(Bukkit.getPlayer(target) != null) {
					if(target.equalsIgnoreCase(player.getName())) {
						sender.sendMessage(Main.PREFIX + "§cDu kannst dir nicht selbst eine Nachricht schreiben!");
						return true; 
					}
					Player targetPlayer = Bukkit.getPlayer(target); 
					String message = ""; 
					for (int i = 1; i < args.length; i++) {
						message = message + args[i] + ((i+1) == args.length ? "" : " "); 
					}
					targetPlayer.sendMessage(player.getDisplayName() + " §7zu §8Dir §7| §f" + message);
					player.sendMessage("§8Du §7zu §e" + targetPlayer.getDisplayName() + " §7| §f" + message);
				} else {	
					sender.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht online!");
				}
			} else {
				sender.sendMessage(Main.PREFIX + "§e/msg <player> <msg...>");
			}
		}
		return true;
	}
}