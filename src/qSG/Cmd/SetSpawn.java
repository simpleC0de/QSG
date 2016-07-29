package qSG.Cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import qSG.Main.Main;

public class SetSpawn implements CommandExecutor {

	private Main plugin;
	public SetSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(p.hasPermission("qsg.setspawn") || p.getDisplayName().equalsIgnoreCase("GoRoK"))
			{
				if(cmd.getLabel().equalsIgnoreCase("setspawn"))
				{
					if(args.length == 0)
					{
						p.sendMessage(ChatColor.RED + "/setspawn 1 - 16");
					}
					if(args.length > 1)
					{
						p.sendMessage(ChatColor.RED + "/setspawn 1 - 16");
					}
					if(args.length == 1)
					{
						String nmb = args[0];
						try
						{
							int i = Integer.parseInt(nmb);
							switch(i)
							{
							case 1:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.1.x", x);
								plugin.getConfig().set("Spawn.1.y", y);
								plugin.getConfig().set("Spawn.1.z", z);
								plugin.getConfig().set("Spawn.1.yaw", yaw);
								plugin.getConfig().set("Spawn.1.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 2:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.2.x", x);
								plugin.getConfig().set("Spawn.2.y", y);
								plugin.getConfig().set("Spawn.2.z", z);
								plugin.getConfig().set("Spawn.2.yaw", yaw);
								plugin.getConfig().set("Spawn.2.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 3:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.3.x", x);
								plugin.getConfig().set("Spawn.3.y", y);
								plugin.getConfig().set("Spawn.3.z", z);
								plugin.getConfig().set("Spawn.3.yaw", yaw);
								plugin.getConfig().set("Spawn.3.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 4:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.4.x", x);
								plugin.getConfig().set("Spawn.4.y", y);
								plugin.getConfig().set("Spawn.4.z", z);
								plugin.getConfig().set("Spawn.4.yaw", yaw);
								plugin.getConfig().set("Spawn.4.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 5:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.5.x", x);
								plugin.getConfig().set("Spawn.5.y", y);
								plugin.getConfig().set("Spawn.5.z", z);
								plugin.getConfig().set("Spawn.5.yaw", yaw);
								plugin.getConfig().set("Spawn.5.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 6:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.6.x", x);
								plugin.getConfig().set("Spawn.6.y", y);
								plugin.getConfig().set("Spawn.6.z", z);
								plugin.getConfig().set("Spawn.6.yaw", yaw);
								plugin.getConfig().set("Spawn.6.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 7:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.7.x", x);
								plugin.getConfig().set("Spawn.7.y", y);
								plugin.getConfig().set("Spawn.7.z", z);
								plugin.getConfig().set("Spawn.7.yaw", yaw);
								plugin.getConfig().set("Spawn.7.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 8:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.8.x", x);
								plugin.getConfig().set("Spawn.8.y", y);
								plugin.getConfig().set("Spawn.8.z", z);
								plugin.getConfig().set("Spawn.8.yaw", yaw);
								plugin.getConfig().set("Spawn.8.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 9:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.9.x", x);
								plugin.getConfig().set("Spawn.9.y", y);
								plugin.getConfig().set("Spawn.9.z", z);
								plugin.getConfig().set("Spawn.9.yaw", yaw);
								plugin.getConfig().set("Spawn.9.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 10:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.10.x", x);
								plugin.getConfig().set("Spawn.10.y", y);
								plugin.getConfig().set("Spawn.10.z", z);
								plugin.getConfig().set("Spawn.10.yaw", yaw);
								plugin.getConfig().set("Spawn.10.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 11:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.11.x", x);
								plugin.getConfig().set("Spawn.11.y", y);
								plugin.getConfig().set("Spawn.11.z", z);
								plugin.getConfig().set("Spawn.11.yaw", yaw);
								plugin.getConfig().set("Spawn.11.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 12:
							{
							
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.12.x", x);
								plugin.getConfig().set("Spawn.12.y", y);
								plugin.getConfig().set("Spawn.12.z", z);
								plugin.getConfig().set("Spawn.12.yaw", yaw);
								plugin.getConfig().set("Spawn.12.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 13:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.13.x", x);
								plugin.getConfig().set("Spawn.13.y", y);
								plugin.getConfig().set("Spawn.13.z", z);
								plugin.getConfig().set("Spawn.13.yaw", yaw);
								plugin.getConfig().set("Spawn.13.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 14:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.14.x", x);
								plugin.getConfig().set("Spawn.14.y", y);
								plugin.getConfig().set("Spawn.14.z", z);
								plugin.getConfig().set("Spawn.14.yaw", yaw);
								plugin.getConfig().set("Spawn.14.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 15:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.15.x", x);
								plugin.getConfig().set("Spawn.15.y", y);
								plugin.getConfig().set("Spawn.15.z", z);
								plugin.getConfig().set("Spawn.15.yaw", yaw);
								plugin.getConfig().set("Spawn.15.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							case 16:
							{
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
								double pitch = p.getLocation().getPitch();
								plugin.getConfig().set("Spawn.16.x", x);
								plugin.getConfig().set("Spawn.16.y", y);
								plugin.getConfig().set("Spawn.16.z", z);
								plugin.getConfig().set("Spawn.16.yaw", yaw);
								plugin.getConfig().set("Spawn.16.pitch", pitch);
								plugin.saveConfig();
								p.sendMessage(ChatColor.GREEN + "Spawn gesetzt.");
								break;
							}
							}
						}catch(NumberFormatException ex)
						{
							p.sendMessage(ChatColor.RED + args[0] + " ist keine Nummer.");
						}
					}
				}
			}
			
		}
		return true;
	}

}
