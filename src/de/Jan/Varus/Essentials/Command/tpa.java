package de.Jan.Varus.Essentials.Command;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.Jan.Varus.Essentials.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class tpa implements CommandExecutor {
	private JavaPlugin plugin; 
	public tpa(JavaPlugin plugin) {
		this.plugin = plugin; 
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(args.length != 1) {
			sender.sendMessage(Main.PREFIX + "Bitte gebe einen Spieler an!");
			return true; 
		} 
		Player player = (Player) sender; 
		Player toPlayer = Bukkit.getPlayer(args[0]); 
		
		
		Main.tpa.put(toPlayer, player); 
		String Message = ""; 
		
		TextComponent accept = new  TextComponent();
		accept.setText("§7[§aaccept§7]");
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aAcceptiert die anfrage!").create()));
		
		
		TextComponent deny = new  TextComponent();
		deny.setText("§7[§cdeny§7]");
		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cVerweigert die anfrage!").create()));
		
		player.sendMessage(Main.PREFIX + "Die Teleport anfrage wurde an " + toPlayer.getDisplayName() + " §7gesendet! " + Message);
		toPlayer.sendMessage(Main.PREFIX + "Der Spieler "+  player.getDisplayName() + " §7möchte sich zu dir Teleportieren!\n");
		toPlayer.spigot().sendMessage(accept, deny);
		return true;
	}
}
