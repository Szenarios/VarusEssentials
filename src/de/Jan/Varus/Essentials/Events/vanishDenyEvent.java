package de.Jan.Varus.Essentials.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.Jan.Varus.Essentials.Command.VanishCommand;


public class vanishDenyEvent implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) { 
		if(VanishCommand.vanished.contains(event.getPlayer()))
			event.setCancelled(true);
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) { 
		if(VanishCommand.vanished.contains(event.getPlayer()))
			event.setCancelled(true);
	}
	@EventHandler
	public void onDmg(EntityDamageByEntityEvent event) { 
		if(event.getDamager().getType() == EntityType.PLAYER) {
			if(event.getEntity().getType() != EntityType.PLAYER) {
				Player player = (Player) event.getDamager(); 
				if(VanishCommand.vanished.contains(player))
					event.setCancelled(true);
			}
		} 
	}
}
