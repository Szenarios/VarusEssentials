package de.Jan.Varus.Essentials.Command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class gmCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender; 
			if(player.hasPermission("varus.gm")) {
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(Main.PREFIX + "Dein Gamemode ist nun §e" + player.getGameMode().toString());
					} else 
					if(args[0].equalsIgnoreCase("2")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(Main.PREFIX + "Dein Gamemode ist nun §e" + player.getGameMode().toString());
					} else 
					if(args[0].equalsIgnoreCase("3")) {
						player.setGameMode(GameMode.SPECTATOR);
						player.sendMessage(Main.PREFIX + "Dein Gamemode ist nun §e" + player.getGameMode().toString());
					} else 
					if(args[0].equalsIgnoreCase("0")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(Main.PREFIX + "Dein Gamemode ist nun §e" + player.getGameMode().toString());
					}
				} else {
					sender.sendMessage(Main.PREFIX + "§e/gm <1/2/3>");
				}
			} else {
				sender.sendMessage(Main.PREFIX + "§cDu hast keine Rechnte!");
			}
		}
		return true;
	}
}
