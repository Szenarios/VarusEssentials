package de.Jan.Varus.Essentials.Command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class VanishCommand implements CommandExecutor {
	public static ArrayList<Player> vanished = new ArrayList<>(); 
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender; 
			if(!player.hasPermission("varus.vanish")) {
				player.sendMessage(Main.PREFIX + "§cDu hast keine Brechtigung diesen Command auszuführen!");
				return true; 
			}
			if(vanished.contains(player)) {
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("varus.cansee.vanish") && player != players) {
						players.sendMessage(Main.PREFIX + player.getDisplayName() + " §aist nun für alle anderen Spieler wieder Sichtbar!");
					} else {
						players.showPlayer(player);
					}
				}
				player.sendMessage(Main.PREFIX + "§aDu bist jetzt für alle Spieler Sichtbar!"); 
				vanished.remove(player); 
			} else {
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("varus.cansee.vanish") && player != players) {
						players.sendMessage(Main.PREFIX +  player.getDisplayName() + " §cist nun für alle anderen Spieler unischtbar!");
					} else {
						players.hidePlayer(player);
					}
				}
				player.sendMessage(Main.PREFIX + "§aDu bist jetzt für §edie meisten §aSpieler unsichtbar!"); 
				vanished.add(player); 
			}
		}
		return true;
	}
}
