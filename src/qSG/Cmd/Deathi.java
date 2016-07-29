package qSG.Cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import qSG.Main.Main;
import qSG.Main.MySQL;

public class Deathi implements CommandExecutor, Listener {

	private Main plugin;
	public Deathi(Main plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player)
		{
			if(cmd.getLabel().equalsIgnoreCase("stats"))
			{
				 int kills = getKills(((Player)cs).getUniqueId().toString());
				 cs.sendMessage(ChatColor.GREEN + "Du hast " + kills + "kills!");
			}
		}
		return true;
	}
	
	public int getKills(String uuid )
	{
		MySQL sql = this.plugin.getMySQL();
		Connection conn = sql.getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		int kills = 0;
		try {
			st = conn.prepareStatement("SELECT * FROM qsgstats WHERE player_uuid=" +uuid);
			st.setString(1, uuid);
			rs = st.executeQuery();
			rs.last();
			if(rs.getRow() == 0)
			{
				kills = 0;
				return 0;
			}
			else
			{
				rs.first();
				kills = rs.getInt("kills");
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

}
