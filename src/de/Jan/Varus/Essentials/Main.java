package de.Jan.Varus.Essentials;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.Jan.Varus.Essentials.Command.FlyCommand;
import de.Jan.Varus.Essentials.Command.VanishCommand;
import de.Jan.Varus.Essentials.Command.enderseeCommand;
import de.Jan.Varus.Essentials.Command.gmCommand;
import de.Jan.Varus.Essentials.Command.invseeCommand;
import de.Jan.Varus.Essentials.Command.msgCommand;
import de.Jan.Varus.Essentials.Events.AnbauHelperEvent;
import de.Jan.Varus.Essentials.Events.bedEnterEvent;
import de.Jan.Varus.Essentials.Events.blockBreakEvent;
import de.Jan.Varus.Essentials.Events.blockPlaceEvent;
import de.Jan.Varus.Essentials.Events.joinEvent;
import de.Jan.Varus.Essentials.Events.vanishDenyEvent;

public class Main extends JavaPlugin {
	public static HashMap<Player, Player> tpa = new HashMap<>(); 
	public static final String PREFIX = "§9Varus §8| §7"; 
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + " §aIst Aktiviert!");
		Bukkit.getPluginCommand("fly").setExecutor(new FlyCommand());
		Bukkit.getPluginCommand("invsee").setExecutor(new invseeCommand());
		Bukkit.getPluginCommand("endersee").setExecutor(new enderseeCommand());
		Bukkit.getPluginCommand("gm").setExecutor(new gmCommand());
		Bukkit.getPluginCommand("msg").setExecutor(new msgCommand());
		Bukkit.getPluginCommand("v").setExecutor(new VanishCommand());
		
		Bukkit.getPluginManager().registerEvents(new bedEnterEvent(), this);
		Bukkit.getPluginManager().registerEvents(new vanishDenyEvent(), this);
//		Bukkit.getPluginManager().registerEvents(new blockBreakEvent(), this);
//		Bukkit.getPluginManager().registerEvents(new blockPlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new joinEvent(), this);

//		Bukkit.getPluginManager().registerEvents(new AnbauHelperEvent(), this);
	}
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§cIst Deaktiviert!");
	}
	public static int returnRDM(int max, int min) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
