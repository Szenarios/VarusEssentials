package de.Jan.Varus.Essentials.Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.craftbukkit.v1_15_R1.block.CraftCreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import de.Jan.Varus.Essentials.Main;

public class blockBreakEvent implements Listener {
	@EventHandler
	public void onBlockBrak(BlockBreakEvent event) {
		if(event.getBlock().getType() == Material.SPAWNER) {
			if(event.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || event.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE) {
				if(event.getPlayer().getItemInHand().getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.SILK_TOUCH)) {
					event.setExpToDrop(0);
					ItemStack item = new ItemStack(Material.SPAWNER); 
					
					BlockStateMeta meta = (BlockStateMeta) item.getItemMeta(); 
					CreatureSpawner itemSpawner = (CreatureSpawner) meta.getBlockState();
					
					Block block = event.getBlock(); 
					CraftCreatureSpawner blockSpawner = (CraftCreatureSpawner) block.getState();
					System.out.println(blockSpawner.getCreatureTypeName());
					
					itemSpawner.setSpawnedType(EntityType.fromName(blockSpawner.getCreatureTypeName()));
					meta.setBlockState(itemSpawner);
					item.setItemMeta(meta); 
					
					int rdm = Main.returnRDM(1, 3); 
					if(rdm == 2) {
						event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), item); 
					} else {
						event.getPlayer().playSound(event.getBlock().getLocation(), Sound.ENTITY_ITEM_BREAK, 5,5);
					}
				}
			}
		}
	}
}
