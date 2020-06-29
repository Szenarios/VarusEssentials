package de.Jan.Varus.Essentials;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.Jan.Varus.Essentials.Command.FlyCommand;
import de.Jan.Varus.Essentials.Command.enderseeCommand;
import de.Jan.Varus.Essentials.Command.gmCommand;
import de.Jan.Varus.Essentials.Command.invseeCommand;
import de.Jan.Varus.Essentials.Command.msgCommand;
import de.Jan.Varus.Essentials.Command.tpa;
import de.Jan.Varus.Essentials.Command.tpaccept;
import de.Jan.Varus.Essentials.Command.tpdeny;
import de.Jan.Varus.Essentials.Events.blockBreakEvent;
import de.Jan.Varus.Essentials.Events.blockPlaceEvent;

public class Main extends JavaPlugin {
	public static HashMap<Player, Player> tpa = new HashMap<>(); 
	public static final String PREFIX = "§9Varus §8| §7"; 
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + " §aIst Aktiviert!");
		Bukkit.getPluginCommand("fly").setExecutor(new FlyCommand());
		Bukkit.getPluginCommand("invsee").setExecutor(new invseeCommand());
		Bukkit.getPluginCommand("endersee").setExecutor(new enderseeCommand());
		Bukkit.getPluginCommand("tpa").setExecutor(new tpa(this));
		Bukkit.getPluginCommand("tpdeny").setExecutor(new tpdeny());	
		Bukkit.getPluginCommand("tpaccept").setExecutor(new tpaccept());
		Bukkit.getPluginCommand("gm").setExecutor(new gmCommand());
		Bukkit.getPluginCommand("msg").setExecutor(new msgCommand());
		
		Bukkit.getPluginManager().registerEvents(new blockBreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new blockPlaceEvent(), this);
	}
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§cIst Deaktiviert!");
	}
	public static int returnRDM(int max, int min) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
