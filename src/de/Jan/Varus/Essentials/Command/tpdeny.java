package de.Jan.Varus.Essentials.Command;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Jan.Varus.Essentials.Main;

public class tpdeny implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player toplayer = (Player) sender; 
		if(Main.tpa.get(toplayer) != null) {
			Player player = Main.tpa.get(toplayer); 
			player.sendMessage(Main.PREFIX + "§cDeine Teleportanfrage wurde Verweigert!");
			toplayer.sendMessage(Main.PREFIX + "Der Spieler " + player.getDisplayName() + " §7wird nicht zu dir Teleportiert!");
			player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 5, 5);
			toplayer.playSound(toplayer.getLocation(), Sound.BLOCK_ANVIL_BREAK, 5, 5);
			Main.tpa.remove(toplayer); 	
		} else {
			sender.sendMessage(Main.PREFIX + "Es ist gerade keine Tpa Anfrage offen!");
			return true; 
		}
		return true;
	}
}