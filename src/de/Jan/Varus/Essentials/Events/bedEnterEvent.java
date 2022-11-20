package de.Jan.Varus.Essentials.Events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

import de.Jan.Varus.Essentials.Main;

public class bedEnterEvent implements Listener {
	@EventHandler
	public void onbedEnter(PlayerBedEnterEvent event) {
		if(event.getBedEnterResult() == BedEnterResult.OK) {
			List<Player> sleeping = new ArrayList<>(); 
			event.getPlayer().getWorld().getPlayers().forEach(player -> {
				if(player.isSleeping()) {
					sleeping.add(player); 
				}
			});
			if((event.getPlayer().getWorld().getPlayers().size() / 2)-1 <= sleeping.size()) {
				int zeit = 24000; 
				zeit = (int) (zeit - event.getPlayer().getWorld().getTime()); 
				
				event.getPlayer().getWorld().setTime(event.getPlayer().getWorld().getTime() + zeit);
				event.getPlayer().getWorld().getPlayers().forEach(player ->{
					player.sendMessage(Main.PREFIX + "§7" + event.getPlayer().getName() + " schläft nun!"); 
					player.sendMessage(Main.PREFIX + "§6Guten Morgen!");
				});
				
			} else {
				event.getPlayer().getWorld().getPlayers().forEach(player ->{player.sendMessage(Main.PREFIX + "§7" + event.getPlayer().getName() + " schläft nun! ("+sleeping.size()+"/"+(int)(event.getPlayer().getWorld().getPlayers().size() /2)+")");});
			}
			
		}
	}
}
