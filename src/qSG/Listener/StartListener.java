package qSG.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import qSG.Main.GameState;
import qSG.Main.Main;

public class StartListener implements Listener{

	private Main plugin;
	public StartListener(Main plugin)
	{
		this.plugin = plugin;
	}
	@SuppressWarnings("static-access")
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		
		if(plugin.online.size() == 3)
		{
			if(plugin.run.size() == 0)
			{
				new BukkitRunnable() {
					int cd = 60;
					
					@SuppressWarnings("unused")
					@Override
					public void run() {
						cd--;					
						plugin.run.add(e.getPlayer());
						if(cd == 60)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd == 50)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd == 40)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd == 30)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd == 20)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd <= 15)
						{
							Bukkit.broadcastMessage(ChatColor.GOLD + "Spiel startet in " + ChatColor.GRAY + cd + ChatColor.GOLD + " Sekunden!");
						}
						if(cd == 5)
						{
							plugin.gs = GameState.INGAME;
						}
						if(cd == 0)
						{
							try
							{
								double x = plugin.getConfig().getDouble("Spawn.1.x");
								double y = plugin.getConfig().getDouble("Spawn.1.y");
								double z = plugin.getConfig().getDouble("Spawn.1.z");
								double yaw = plugin.getConfig().getDouble("Spawn.1.yaw");
								double pitch = plugin.getConfig().getDouble("Spawn.1.pitch");
								float yawf = (float)yaw;
								float pitchf = (float)pitch;
								//
								double x1 = plugin.getConfig().getDouble("Spawn.2.x");
								double y1 = plugin.getConfig().getDouble("Spawn.2.y");
								double z1 = plugin.getConfig().getDouble("Spawn.2.z");
								double yaw1 = plugin.getConfig().getDouble("Spawn.2.yaw");
								double pitch1 = plugin.getConfig().getDouble("Spawn.2.pitch");
								float yawf1 = (float)yaw1;
								float pitchf1 = (float)pitch1;
								//
								double x2 = plugin.getConfig().getDouble("Spawn.3.x");
								double y2 = plugin.getConfig().getDouble("Spawn.3.y");
								double z2 = plugin.getConfig().getDouble("Spawn.3.z");
								double yaw2 = plugin.getConfig().getDouble("Spawn.3.yaw");
								double pitch2 = plugin.getConfig().getDouble("Spawn.3.pitch");
								float yawf2 = (float)yaw;
								float pitchf2 = (float)pitch;
								//
								double x3 = plugin.getConfig().getDouble("Spawn.4.x");
								double y3 = plugin.getConfig().getDouble("Spawn.4.y");
								double z3 = plugin.getConfig().getDouble("Spawn.4.z");
								double yaw3 = plugin.getConfig().getDouble("Spawn.4.yaw");
								double pitch3 = plugin.getConfig().getDouble("Spawn.4.pitch");
								float yawf3 = (float)yaw;
								float pitchf3 = (float)pitch;
								//
								double x4 = plugin.getConfig().getDouble("Spawn.5.x");
								double y4 = plugin.getConfig().getDouble("Spawn.5.y");
								double z4 = plugin.getConfig().getDouble("Spawn.5.z");
								double yaw4 = plugin.getConfig().getDouble("Spawn.5.yaw");
								double pitch4 = plugin.getConfig().getDouble("Spawn.5.pitch");
								float yawf4 = (float)yaw;
								float pitchf4 = (float)pitch;
								//
								double x5 = plugin.getConfig().getDouble("Spawn.6.x");
								double y5 = plugin.getConfig().getDouble("Spawn.6.y");
								double z5 = plugin.getConfig().getDouble("Spawn.6.z");
								double yaw5 = plugin.getConfig().getDouble("Spawn.6.yaw");
								double pitch5 = plugin.getConfig().getDouble("Spawn.6.pitch");
								float yawf5 = (float)yaw1;
								float pitchf5 = (float)pitch1;
								//
								double x6 = plugin.getConfig().getDouble("Spawn.7.x");
								double y6 = plugin.getConfig().getDouble("Spawn.7.y");
								double z6 = plugin.getConfig().getDouble("Spawn.7.z");
								double yaw6 = plugin.getConfig().getDouble("Spawn.7.yaw");
								double pitch6 = plugin.getConfig().getDouble("Spawn.7.pitch");
								float yawf6 = (float)yaw;
								float pitchf6 = (float)pitch;
								//
								double x7 = plugin.getConfig().getDouble("Spawn.8.x");
								double y7 = plugin.getConfig().getDouble("Spawn.8.y");
								double z7 = plugin.getConfig().getDouble("Spawn.8.z");
								double yaw7 = plugin.getConfig().getDouble("Spawn.8.yaw");
								double pitch7 = plugin.getConfig().getDouble("Spawn.8.pitch");
								float yawf7 = (float)yaw;
								float pitchf7 = (float)pitch;
								//
								double x8 = plugin.getConfig().getDouble("Spawn.9.x");
								double y8 = plugin.getConfig().getDouble("Spawn.9.y");
								double z8 = plugin.getConfig().getDouble("Spawn.9.z");
								double yaw8 = plugin.getConfig().getDouble("Spawn.9.yaw");
								double pitch8 = plugin.getConfig().getDouble("Spawn.9.pitch");
								float yawf8 = (float)yaw;
								float pitchf8 = (float)pitch;
								//
								double x9 = plugin.getConfig().getDouble("Spawn.10.x");
								double y9 = plugin.getConfig().getDouble("Spawn.10.y");
								double z9 = plugin.getConfig().getDouble("Spawn.10.z");
								double yaw9 = plugin.getConfig().getDouble("Spawn.10.yaw");
								double pitch9 = plugin.getConfig().getDouble("Spawn.10.pitch");
								float yawf9 = (float)yaw1;
								float pitchf9 = (float)pitch1;
								//
								double x10 = plugin.getConfig().getDouble("Spawn.11.x");
								double y10 = plugin.getConfig().getDouble("Spawn.11.y");
								double z10 = plugin.getConfig().getDouble("Spawn.11.z");
								double yaw10 = plugin.getConfig().getDouble("Spawn.11.yaw");
								double pitch10 = plugin.getConfig().getDouble("Spawn.11.pitch");
								float yawf10 = (float)yaw;
								float pitchf10 = (float)pitch;
								//
								double x11= plugin.getConfig().getDouble("Spawn.12.x");
								double y11= plugin.getConfig().getDouble("Spawn.12.y");
								double z11= plugin.getConfig().getDouble("Spawn.12.z");
								double yaw11= plugin.getConfig().getDouble("Spawn.12.yaw");
								double pitch11= plugin.getConfig().getDouble("Spawn.12.pitch");
								float yawf11= (float)yaw;
								float pitchf11= (float)pitch;
								//
								double x12 = plugin.getConfig().getDouble("Spawn.13.x");
								double y12 = plugin.getConfig().getDouble("Spawn.13.y");
								double z12 = plugin.getConfig().getDouble("Spawn.13.z");
								double yaw12 = plugin.getConfig().getDouble("Spawn.13.yaw");
								double pitch12 = plugin.getConfig().getDouble("Spawn.13.pitch");
								float yawf12 = (float)yaw;
								float pitchf12 = (float)pitch;
								//
								double x13 = plugin.getConfig().getDouble("Spawn.14.x");
								double y13 = plugin.getConfig().getDouble("Spawn.14.y");
								double z13 = plugin.getConfig().getDouble("Spawn.14.z");
								double yaw13 = plugin.getConfig().getDouble("Spawn.14.yaw");
								double pitch13 = plugin.getConfig().getDouble("Spawn.14.pitch");
								float yawf13 = (float)yaw1;
								float pitchf13 = (float)pitch1;
								//
								double x14= plugin.getConfig().getDouble("Spawn.15.x");
								double y14= plugin.getConfig().getDouble("Spawn.15.y");
								double z14= plugin.getConfig().getDouble("Spawn.15.z");
								double yaw14= plugin.getConfig().getDouble("Spawn.15.yaw");
								double pitch14= plugin.getConfig().getDouble("Spawn.15.pitch");
								float yawf14= (float)yaw;
								float pitchf14= (float)pitch;
								//
								double x15= plugin.getConfig().getDouble("Spawn.16.x");
								double y15= plugin.getConfig().getDouble("Spawn.16.y");
								double z15= plugin.getConfig().getDouble("Spawn.16.z");
								double yaw15= plugin.getConfig().getDouble("Spawn.16.yaw");
								double pitch15= plugin.getConfig().getDouble("Spawn.16.pitch");
								float yawf15= (float)yaw;
								float pitchf15= (float)pitch;
								//
								org.bukkit.World world = (org.bukkit.World) e.getPlayer().getWorld();
								try
								{
									
									Location loc = new Location(world, x, y, z, yawf, pitchf);
									Location loc1 = new Location(world, x1, y1, z1, yawf1, pitchf1);
									Location loc2 = new Location(world, x2, y2, z2, yawf2, pitchf2);
									Location loc3 = new Location(world, x3, y3, z3, yawf3, pitchf3);
									Location loc4 = new Location(world, x4, y4, z4, yawf4, pitchf4);
									Location loc5 = new Location(world, x5, y5, z5, yawf5, pitchf5);
									Location loc6 = new Location(world, x6, y6, z6, yawf6, pitchf6);
									Location loc7 = new Location(world, x7, y7, z7, yawf7, pitchf7);
									Location loc8 = new Location(world, x8, y8, z8, yawf8, pitchf8);
									Location loc9 = new Location(world, x9, y9, z9, yawf9, pitchf9);
									Location loc10 = new Location(world, x10, y10, z10, yawf10, pitchf10);
									Location loc11 = new Location(world, x11, y11, z11, yawf11, pitchf11);
									Location loc12 = new Location(world, x12, y12, z12, yawf12, pitchf12);
									Location loc13 = new Location(world, x13, y13, z13, yawf13, pitchf13);
									Location loc14 = new Location(world, x14, y14, z14, yawf14, pitchf14);
									Location loc15 = new Location(world, x15, y15, z15, yawf15, pitchf15);
									try
									{
										plugin.online.get(0).teleport(loc);
										plugin.online.get(1).teleport(loc1);
										plugin.online.get(2).teleport(loc2);
										plugin.online.get(3).teleport(loc3);
										plugin.online.get(4).teleport(loc4);
										plugin.online.get(5).teleport(loc5);
										plugin.online.get(6).teleport(loc6);
										plugin.online.get(7).teleport(loc7);
										plugin.online.get(8).teleport(loc8);
										plugin.online.get(9).teleport(loc9);
										plugin.online.get(10).teleport(loc10);
										plugin.online.get(11).teleport(loc11);
										plugin.online.get(12).teleport(loc12);
										plugin.online.get(13).teleport(loc13);
										plugin.online.get(14).teleport(loc14);
										plugin.online.get(15).teleport(loc15);
									}catch(Exception ex)
									{
										Bukkit.broadcastMessage("224");
										System.out.println("Exception");
									}
								}
								catch(Exception exi)
								{
									Bukkit.broadcastMessage("230");
									return;
								}
								
								
								
								
							}catch(ArrayIndexOutOfBoundsException ex)
							{
								return;
							}
							
							if(cd == 0)
							{
								for(Player all : Bukkit.getOnlinePlayers())
								{
									all.setGameMode(GameMode.SURVIVAL);
								}
								
								cancel();
							}
						}
						
					}
				}.runTaskTimer(plugin, 0, 20);
			}
			else
			{
				return;
			}
			
		}
	}
}
