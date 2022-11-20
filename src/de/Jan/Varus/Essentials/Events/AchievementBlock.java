package de.Jan.Varus.Essentials.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import de.Jan.Varus.Essentials.Command.VanishCommand;

public class AchievementBlock implements Listener {

	@EventHandler
	public void onAchievement(PlayerAdvancementDoneEvent event) {
		Bukkit.getConsoleSender().sendMessage(event.getAdvancement().getKey().getNamespace());
		if(VanishCommand.vanished.contains(event.getPlayer())) {}
		// TODO 
	}
	
}
