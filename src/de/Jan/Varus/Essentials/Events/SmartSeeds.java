package de.Jan.Varus.Essentials.Events;

import org.bukkit.Material;

public class SmartSeeds {
	private Material block; 
	private Material seed; 
	private Material placeBlock;
	public SmartSeeds(Material block, Material seed, Material placeblock) {
		this.block = block; 
		this.seed = seed; 
		this.placeBlock= placeblock; 
	}
	public Material getBlock() {
		return block;
	}
	public void setBlock(Material block) {
		this.block = block;
	}
	public Material getSeed() {
		return seed;
	}
	public void setSeed(Material seed) {
		this.seed = seed;
	}
	public Material getPlaceBlock() {
		return placeBlock;
	}
	public void setPlaceBlock(Material placeBlock) {
		this.placeBlock = placeBlock;
	} 
	
}
