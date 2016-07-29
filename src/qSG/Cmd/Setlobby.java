package qSG.Cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import qSG.Main.Main;

public class Setlobby implements CommandExecutor {

	private Main plugin;
	public Setlobby(Main plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(p.hasPermission("qsq.setlobby"))
			{
				if(cmd.getLabel().equalsIgnoreCase("setlobby"))
				{
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					double yaw = p.getLocation().getYaw();
					double pitch = p.getLocation().getPitch();
					plugin.getConfig().set("Lobby.x", x);
					plugin.getConfig().set("Lobby.y", y);
					plugin.getConfig().set("Lobby.z", z);
					plugin.getConfig().set("Lobby.yaw", yaw);
					plugin.getConfig().set("Lobby.pitch", pitch);
					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "Lobby gesetzt.");
				}	
			}
			
		}
		return true;
	}

}
