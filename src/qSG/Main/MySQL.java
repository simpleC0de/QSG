package qSG.Main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class MySQL {

	private Connection conn;
	private Main plugin;
	private String hostname;
	private String user;
	private String password;
	private String database;
	private int port;
	public MySQL(Main plugin) throws Exception
	{
		this.plugin = plugin;
		
		this.hostname = plugin.getConfig().getString("host");
		this.port = plugin.getConfig().getInt("port");
		this.user = plugin.getConfig().getString("user");
		this.password = plugin.getConfig().getString("password");
		this.database = plugin.getConfig().getString("database");
		this.openConnection();
		
	}
	public Connection openConnection() throws Exception
	{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database, this.user, this.password);
			this.conn = conn;
			return conn;
	
	
	}
	public Connection getConnection()
	{
		return this.conn;
	}
	public boolean hasConnection()
	{
		try {
			return this.conn != null || this.conn.isValid(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void closeRessources(ResultSet rs, PreparedStatement st)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
		}
		if(st != null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	public void closeConnection()
	{
		try {
			this.conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			this.conn = null;
		}
		
	}
	public void queryUpdate(String query)
	{
		PreparedStatement st = null;
		
		Connection conn = this.conn;
		try {
			 st = conn.prepareStatement(query);
			 st.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Failed to send update '" + query + "'.");
			e.printStackTrace();
		}finally
		{
			this.closeRessources(null, st);
		}
	}
	
	public boolean playerExists(Player player)
	{
		try
		{
			openConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM qsgstats WHERE UUID=?;");
			statement.setString(1, player.getUniqueId().toString());
			ResultSet resultset = statement.executeQuery();
			boolean containsplayer = resultset.next();
			
			statement.close();
			resultset.close();
			conn.close();
			return containsplayer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void addPlayer(Player player)
	{
		try
		{
			String UUID = player.getUniqueId().toString();
			String NAME = player.getName();
			String IP = player.getAddress().toString().split(":")[0];
			
			// UUID | USERNAME | IP | KILLS | DEATHS | POINTS
			PreparedStatement newPlayer = conn.prepareStatement("INSERT INTO 'qsgstats' values(?,?,?,0,0,0);");
			newPlayer.setString(1, UUID);
			newPlayer.setString(2, NAME);
			newPlayer.setString(3, IP);
			newPlayer.execute();
			newPlayer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
	
	
}
