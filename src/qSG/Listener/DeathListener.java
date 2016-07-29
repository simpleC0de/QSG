package qSG.Listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import qSG.Main.GameState;
import qSG.Main.Main;
import qSG.Main.MySQL;

public class DeathListener implements Listener {

	
	private Main plugin;
	public DeathListener(Main plugin)
	{
		this.plugin = plugin;
	}
	MySQL sql = this.plugin.getMySQL();
	public void setKills(String uuid, int Kills)
	{
		MySQL sql = this.plugin.getMySQL();
		
		if(this.getKills(uuid) != 0)
		{
			sql.queryUpdate("UPDATE qsqstats SET kills=" + getKills(uuid) + " WHERE player_uuid="+uuid);	
		}
		else
		{
			sql.queryUpdate("INSERT INTO qsqstats (player_uuid, kills) VALUES (" + uuid +", " + getKills(uuid) + ")");
		}
	}
	public int getKills(String uuid )
	{
		MySQL sql = this.plugin.getMySQL();
		Connection conn = sql.getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		int kills = 0;
		try {
			if(!(conn.isValid(2000)))
			{
				
				try {
					sql.closeConnection();
					sql.openConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				st = conn.prepareStatement("SELECT * FROM qsgstats WHERE player_uuid=" + uuid);
				st.setString(1, uuid);
				rs = st.executeQuery();
				rs.last();
				if(rs.getRow() == 0)
				{
					return 0;
				}
				else
				{
					rs.first();
					kills = rs.getInt("kills");
				}	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql.closeRessources(rs, st);
		}
		return kills;
	}
	
	
	public int getWon(String uuid)
	{
		MySQL sql = this.plugin.getMySQL();
		Connection conn = sql.getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		int wongames = 0;
		try
		{
			st = conn.prepareStatement("SELECT * FROM qsgstats WHERE player_uuid=" +uuid);
			rs = st.executeQuery();
			rs.last();
			if(rs.getRow() == 0)
			{
				wongames = 0;
				return wongames;
			}
			else
			{
				rs.first();
				wongames = rs.getInt("won_games");
				return wongames;
			}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}finally
		{
			sql.closeRessources(rs, st);
		}
		return wongames;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onDeath(PlayerDeathEvent e)
	{
		

		
		
		
		
		if(e.getEntity() instanceof Player)
		{
			Player p = (Player)e.getEntity();
			if(plugin.online.contains(p))
			{
				plugin.online.remove(p);
			}
			else
			{
				p.kickPlayer(ChatColor.RED + "Kicked from the Server.");
			}
			if(plugin.online.size() <= 4)
			{
				plugin.gs = GameState.INGAME;
				if(plugin.run2.size() == 0)
				{
					plugin.run2.add(p);
					new BukkitRunnable() {
						int cd = 30;
						@Override
						public void run() {
							if(cd == 20)
							{
								Bukkit.broadcastMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "QSG" + ChatColor.BLUE + "]" + ChatColor.GRAY + "Deathmatch startet in " + ChatColor.RED + cd + " Sekunden!");
							}
							if(cd <= 10)
							{
								Bukkit.broadcastMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "QSG" + ChatColor.BLUE + "]" + ChatColor.GRAY + "Deathmatch startet in " + ChatColor.RED + cd + " Sekunden!");
							}
							
							if(cd == 0)
							{
								for(Player all : Bukkit.getOnlinePlayers())
								{
									all.playSound(all.getLocation(), Sound.ENDERMAN_SCREAM, 4F, 5F);
									all.playSound(all.getLocation(), Sound.ENDERMAN_SCREAM, 4F, 5F);
									all.playSound(all.getLocation(), Sound.ENDERMAN_SCREAM, 4F, 5F);
									Firework fw = (Firework) all.getWorld().spawn(all.getLocation(), Firework.class);
									Firework fw1 = (Firework) all.getWorld().spawn(all.getLocation(), Firework.class);
									Firework fw2 = (Firework) all.getWorld().spawn(all.getLocation(), Firework.class);
									Firework fw3 = (Firework) all.getWorld().spawn(all.getLocation(), Firework.class);
									FireworkMeta fmeta = fw.getFireworkMeta();
									fmeta.setPower(20);
									fw.setVelocity(all.getLocation().getDirection().multiply(0.5));
									fw.setFireworkMeta(fmeta);
									
									ArmorStand stand = all.getLocation().getWorld().spawn(all.getLocation(), ArmorStand.class);
									stand.setCustomName(all.getDisplayName());
									ItemStack head = new ItemStack(Material.SKULL);
									SkullMeta meta = (SkullMeta) head.getItemMeta();
									meta.setOwner(all.getDisplayName());
									head.setItemMeta(meta);								
									stand.setHelmet(head);
							        stand.setBasePlate(false);     
							        fw.setPassenger(stand);
							        fw.detonate();
							        fw1.detonate();
							        fw2.detonate();
							        fw3.detonate();
							        if(fw.isDead())
							        {
							        	fw.remove();
							        }
							        else
							        {
							        	return;
							        }
								}
								try
								{
									double x = plugin.getConfig().getDouble("Deathmatch.x");
									double y = plugin.getConfig().getDouble("Deathmatch.y");
									double z = plugin.getConfig().getDouble("Deathmatch.z");
									double pitch = plugin.getConfig().getDouble("Deathmatch.pitch");
									double yaw = plugin.getConfig().getDouble("Deathmatch.yaw");
									float dy = (float)yaw;
									float dp = (float)pitch;
									//
									double x1 = plugin.getConfig().getDouble("Deathmatch.x1");
									double y1 = plugin.getConfig().getDouble("Deathmatch.y1");
									double z1 = plugin.getConfig().getDouble("Deathmatch.z1");
									double pitch1 = plugin.getConfig().getDouble("Deathmatch.pitch1");
									double yaw1 = plugin.getConfig().getDouble("Deathmatch.yaw1");
									float dy1 = (float)yaw1;
									float dp1 = (float)pitch1;
									//
									double x2 = plugin.getConfig().getDouble("Deathmatch.x2");
									double y2 = plugin.getConfig().getDouble("Deathmatch.y2");
									double z2 = plugin.getConfig().getDouble("Deathmatch.z2");
									double pitch2 = plugin.getConfig().getDouble("Deathmatch.pitch2");
									double yaw2 = plugin.getConfig().getDouble("Deathmatch.yaw2");
									float dy2 = (float)yaw2;
									float dp2 = (float)pitch2;
									//
									double x3 = plugin.getConfig().getDouble("Deathmatch.x3");
									double y3 = plugin.getConfig().getDouble("Deathmatch.y3");
									double z3 = plugin.getConfig().getDouble("Deathmatch.z3");
									double pitch3 = plugin.getConfig().getDouble("Deathmatch.pitch3");
									double yaw3 = plugin.getConfig().getDouble("Deathmatch.yaw3");
									float dy3 = (float)yaw3;
									float dp3 = (float)pitch3;
									//
									Location dloc4 = new Location(p.getWorld(), x3, y3, z3, dp3, dy3);
									Location dloc3 = new Location(p.getWorld(), x2, y2, z2, dp2, dy2);
									Location dloc2 = new Location(p.getWorld(), x1, y1, z1, dp1, dy1);
									Location dloc = new Location(p.getWorld(), x, y, z, dp, dy);
									plugin.online.get(0).teleport(dloc);
									plugin.online.get(1).teleport(dloc2);
									plugin.online.get(2).teleport(dloc3);
									plugin.online.get(3).teleport(dloc4);
								}
								catch(ArrayIndexOutOfBoundsException ex)
								{
									return;
								}
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 20);
				}
				else
				{
					return;
				}
				
			}
			
			
			
			
			
			
			
			
			if(plugin.online.size() == 1)
			{
				plugin.gs = GameState.OFF;
				
				Bukkit.broadcastMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "QSG" + ChatColor.BLUE + "]" + ChatColor.GRAY + plugin.online.get(0).getDisplayName() + ChatColor.YELLOW + " hat die Runde gewonnen!");
				MySQL sql = plugin.getMySQL();
				Connection conn = sql.getConnection();
				String uuid = plugin.online.get(0).getUniqueId().toString();
				if(this.getWon(uuid) != 0)
				{
					sql.queryUpdate("UPDATE qsqstats SET won_games=" + getWon(uuid) + " WHERE player_uuid="+uuid);
				}
				else
				{
					sql.queryUpdate("INSERT INTO qsqstats (player_uuid, won_games) VALUES (" + uuid +", " + getWon(uuid) + ")");
				}
				try {
					if(conn.isValid(2000))
					{
						
					}
					else
					{
						
						try {
							sql.closeConnection();
							sql.openConnection();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				new BukkitRunnable() {
					int cd = 10;
					@Override
					public void run() {
						cd--;
						Bukkit.broadcastMessage(ChatColor.RED + "Stoppe Server in " + ChatColor.GOLD + cd + ChatColor.RED + " Sekunden!");
						if(cd == 3)
						{
							for(Player all : Bukkit.getOnlinePlayers())
							{
								ByteArrayOutputStream b = new ByteArrayOutputStream();
					        	DataOutputStream out = new DataOutputStream(b);
					        	try {
									out.writeUTF("Connect");out.writeUTF("Hub1");} catch (IOException e1) {}
					        	all.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
							}
						}
						if(cd == 1)
						{
							Bukkit.broadcastMessage(ChatColor.RED + "Stoppe Server!");
							Bukkit.shutdown();
							cancel();
						}
						
					}
				}.runTaskTimer(plugin, 0, 20);
			}
		}
		else
		{
			return;
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e)
	{
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SPECTATOR);
		double x = plugin.getConfig().getDouble("Spectator.Spawn.x");
		double y = plugin.getConfig().getDouble("Spectator.Spawn.y");
		double z = plugin.getConfig().getDouble("Spectator.Spawn.z");
		Location loc = new Location(p.getWorld(), x, y, z);
		try
		{
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.teleport(loc);					
				}
			}.runTaskLaterAsynchronously(plugin, 15);
		}catch(Exception ex)
		{
			return;
		}
	}
}
