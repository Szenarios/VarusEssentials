package de.Jan.Varus.Essentials.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.Jan.Varus.Essentials.Command.VanishCommand;

public class joinEvent implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent event) { 
		for(Player players : VanishCommand.vanished) {
			event.getPlayer().hidePlayer(players);
		}
	}
}
