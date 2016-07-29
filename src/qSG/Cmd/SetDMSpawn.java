package qSG.Cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import qSG.Main.Main;

public class SetDMSpawn implements CommandExecutor {

	private Main plugin;
	public SetDMSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(cmd.getLabel().equalsIgnoreCase("setdmspawn"))
			{
				if(p.hasPermission("qsg.dmspawn"))
				{
					if(args.length == 1)
					{
						String msg = args[0];
						try
						{
							int zahl = Integer.parseInt(msg);
							if(zahl == 1)
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double pitch = p.getLocation().getPitch();
								double yaw = p.getLocation().getYaw();
								plugin.getConfig().set("Deathmatch.x", x);
								plugin.getConfig().set("Deathmatch.y", y);
								plugin.getConfig().set("Deathmatch.z", z);
								plugin.getConfig().set("Deathmatch.pitch", pitch);
								plugin.getConfig().set("Deathmatch.yaw", yaw);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "1. Deathmatch Spawn gesetzt.");
								
							}
							if(zahl == 2)
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double pitch = p.getLocation().getPitch();
								double yaw = p.getLocation().getYaw();
								plugin.getConfig().set("Deathmatch.x1", x);
								plugin.getConfig().set("Deathmatch.y1", y);
								plugin.getConfig().set("Deathmatch.z1", z);
								plugin.getConfig().set("Deathmatch.pitch1", pitch);
								plugin.getConfig().set("Deathmatch.yaw1", yaw);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "2. Deathmatch Spawn gesetzt.");
							}
							if(zahl == 3)
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double pitch = p.getLocation().getPitch();
								double yaw = p.getLocation().getYaw();
								plugin.getConfig().set("Deathmatch.x2", x);
								plugin.getConfig().set("Deathmatch.y2", y);
								plugin.getConfig().set("Deathmatch.z2", z);
								plugin.getConfig().set("Deathmatch.pitch2", pitch);
								plugin.getConfig().set("Deathmatch.yaw2", yaw);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "3. Deathmatch Spawn gesetzt.");
							}
							if(zahl == 4)
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double pitch = p.getLocation().getPitch();
								double yaw = p.getLocation().getYaw();
								plugin.getConfig().set("Deathmatch.x3", x);
								plugin.getConfig().set("Deathmatch.y3", y);
								plugin.getConfig().set("Deathmatch.z3", z);
								plugin.getConfig().set("Deathmatch.pitch3", pitch);
								plugin.getConfig().set("Deathmatch.yaw3", yaw);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "3. Deathmatch Spawn gesetzt.");
							}
							else
							{
								p.sendMessage(ChatColor.RED + "/setdmspawn 1-4");
							}
							
						}
						catch(NumberFormatException ex)
						{
							p.sendMessage(ChatColor.RED + msg + " ist keine Zahl!");
						}
					}
					else
					{
						p.sendMessage(ChatColor.RED + "/setdmspawn 1-4");
					}
				}
				
			}
		}
		return true;
	}

}
