package de.Jan.Varus.Essentials.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.craftbukkit.v1_15_R1.block.CraftCreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class blockPlaceEvent implements Listener{
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if(event.getBlock().getType() == Material.SPAWNER) {
			ItemStack item = event.getItemInHand(); 
			BlockStateMeta meta = (BlockStateMeta) item.getItemMeta(); 
			CreatureSpawner itemSpawner = (CreatureSpawner) meta.getBlockState();
			
			Block block = event.getBlock(); 
			CraftCreatureSpawner blockSpawner = (CraftCreatureSpawner) block.getState();
			blockSpawner.setSpawnedType(itemSpawner.getSpawnedType());
			blockSpawner.update(); 
		}
	}
}
