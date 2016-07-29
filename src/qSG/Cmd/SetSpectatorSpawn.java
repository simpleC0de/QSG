package qSG.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import qSG.Main.Main;

public class SetSpectatorSpawn implements CommandExecutor {

	private Main plugin;
	public SetSpectatorSpawn(Main plugin)
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
				if(cmd.getLabel().equalsIgnoreCase("setsspawn"))
				{
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					plugin.getConfig().set("Spectator.Spawn.x", x);
					plugin.getConfig().set("Spectator.Spawn.y", y);
					plugin.getConfig().set("Spectator.Spawn.z", z);
					plugin.saveConfig();
				}
			}
			
		}
		else
		{
			return true;
		}
		return true;
	}

}
