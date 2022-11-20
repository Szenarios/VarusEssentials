package de.Jan.Varus.Essentials.Events;


import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

public class AnbauHelperEvent implements Listener {
	private SmartSeeds[] seeds = new SmartSeeds[4]; 
	public AnbauHelperEvent() { 
		seeds[0] = new SmartSeeds(Material.POTATOES, Material.POTATO, Material.POTATOES); 
		seeds[1] = new SmartSeeds(Material.CARROTS, Material.CARROT, Material.CARROTS);
		seeds[2] = new SmartSeeds(Material.BEETROOTS, Material.BEETROOT_SEEDS, Material.BEETROOTS);
		seeds[3] = new SmartSeeds(Material.WHEAT, Material.WHEAT_SEEDS, Material.WHEAT);
	}
	
	public void onblockBreak(BlockBreakEvent event) {
		System.out.println(event.getBlock().getType());
		for (SmartSeeds seed: seeds) {
			if (event.getBlock().getType() == seed.getBlock()) {
				replace(seed, event.getBlock(), event.getPlayer());
			}
		}
	}
	@EventHandler
	public void playerInteract(PlayerInteractEvent event) {
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block block = event.getClickedBlock(); 
			for (SmartSeeds seed: seeds) {
				if (block.getType() == seed.getBlock()) {
					if(isFullGrown(block)){
						if(event.getPlayer().getInventory().contains(seed.getSeed())) {
							replace(seed, block,event.getPlayer());
						}
					}
				}
			}
		}
	}
	public boolean isFullGrown(Block block) { 
		BlockState state = block.getState();
		if(state.getData() instanceof Crops && ((Crops)state.getData()).getState().equals(CropState.RIPE)) {
			return true;
		}
		return false; 
	}
	public void replace(SmartSeeds seed, Block block, Player player) {
		block.breakNaturally();
		if(player.getInventory().contains(seed.getSeed())) {
		block.setType(seed.getPlaceBlock());
			remove(seed.getSeed(), player.getInventory());
		}
		
	}
	public void remove(Material material, Inventory inv) {
		for(ItemStack stack : inv.getContents()) {
			ItemStack st = stack; 
			if(st.getType() == material) {
				if(st.getAmount() != 0) {
					if(st.getAmount() == 1) {
						inv.remove(st);
					} else {
						st.setAmount(st.getAmount() -1);
					}
					break; 
				}
			}
		}
	}
}
