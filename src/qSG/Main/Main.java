package qSG.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import qSG.Cmd.Deathi;
import qSG.Cmd.SetDMSpawn;
import qSG.Cmd.SetSpawn;
import qSG.Cmd.SetSpectatorSpawn;
import qSG.Cmd.Setlobby;
import qSG.Listener.ClickListener;
import qSG.Listener.DeathListener;
import qSG.Listener.JoinListener;
import qSG.Listener.StartListener;

public class Main extends JavaPlugin {

	private MySQL sql;
	public List<Player> online = new ArrayList<>();
	public List<Player> run = new ArrayList<>();
	public List<Player> run2 = new ArrayList<>();
	public static GameState gs = GameState.LOBBY;
	public void onEnable()
	{
		
		try {
			this.sql = new MySQL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Failed to start MySQL-service ('" + e.getMessage()+ "').");
		}
		try {
			
			sql.openConnection();
			System.out.println("[QuickSurvivalGames] Mit der Datenbank verbunden.");
			sql.queryUpdate("CREATE TABLE IF NOT EXISTS qsgstats(kills int,death int,player_uuid varchar(255),won_games int);");
			System.out.println("[QuickSurvivalGames] Table wurde erstellt, oder gefunden.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadConfig();
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getPluginManager().registerEvents(new ClickListener(this), this);
		this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		this.getServer().getPluginManager().registerEvents(new StartListener(this), this);
		this.getServer().getPluginManager().registerEvents(new DeathListener(this), this);
		this.getCommand("stats").setExecutor(new Deathi(this));
		this.getCommand("setlobby").setExecutor(new Setlobby(this));
		this.getCommand("setspawn").setExecutor(new SetSpawn(this));
		this.getCommand("setdmspawn").setExecutor(new SetDMSpawn(this));
		this.getCommand("setsspawn").setExecutor(new SetSpectatorSpawn(this));
		System.out.println("[QSG] Erfolgreich geladen.");
	}
	
	public void loadConfig()
	{
	if(getDataFolder().exists())
	{
		reloadConfig();
	}
	else
	{
		getConfig().set("host", "localhost");
		getConfig().set("port", 8889);
		getConfig().set("user", "root");
		getConfig().set("password", "root");
		getConfig().set("database", "QSG");
		getConfig().options().header("QuickSurvivalGames");
		List<String> values = getConfig().getStringList("values");
		values.add("264:0, 1, 1");
		getConfig().set("values", values);
		
		saveConfig();
	}
	}
	public void onDisable()
	{
		for(int i = 0; i < online.size(); i++)
		{
			online.remove(i);
		}
		for(int i = 0; i < run.size(); i++)
		{
			run.remove(i);
		}
		for(int i = 0; i < run2.size(); i++)
		{
			run2.remove(i);
		}
		System.out.println("[QuickSurvivalGames] Successfully disabled the Plugin.");
	}
	public MySQL getMySQL()
	{
		return this.sql;
	}
}
