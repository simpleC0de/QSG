package qSG.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import qSG.Main.Main;


public class ClickListener implements Listener {
	private Main plugin;
	public ClickListener(Main plugin)
	{
		this.plugin = plugin;
	}
	
	
	
	//RESSORUCES
	public HashMap<Location, Inventory> sgchests = new HashMap<>();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		
		Player p = e.getPlayer();
		if(plugin.online.contains(p))
		{
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				if(e.getClickedBlock().getType().equals(Material.CHEST))
				{
					e.setCancelled(true);
					Location loc = e.getClickedBlock().getLocation();
					Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.BLACK + "QSG Chest");
					if(sgchests.containsKey(loc))
					{
						p.openInventory(sgchests.get(loc));					
						return;
					}
					else
					{
						Random r = new Random();
						int l = r.nextInt(15);
						
						
						List<ItemStack> items = new ArrayList<>();
						
						
						for(String all : plugin.getConfig().getStringList("values"))
						{
							int ID = 0;
							int subID = 0;
							int amount = 0;
							int chance = 0;
							
							if(all.contains(":"))
							{
								String[] array = all.split(":");
								ID = Integer.valueOf(array[0]);
								String a = array[1];
								a = a.substring(0, 1);
								
								subID = Integer.valueOf(a);
							}
							
							String[] array = all.split(", ");
							amount = Integer.valueOf(array[1]);
							chance = Integer.valueOf(array[2]);
							
							for(int i = 0; i < chance; i++)
							{
								items.add(new ItemStack(ID, amount, (short) subID));
								
							}
							
								
							}
						
						while(l != 0)
						{
							l--;
							
							Random r2 = new Random();
							
							Random r3 = new Random();
							
							int n2  = r2.nextInt(27);
							
							int n3 = r3.nextInt(items.size());
							
							inv.setItem(n2, items.get(n3));
						}
						
						
						sgchests.put(loc, inv);
						
						p.openInventory(sgchests.get(loc));
						
						return;
						
						}
					
					}
				else if(e.getClickedBlock().getType().equals(Material.CHEST) || e.getClickedBlock().getType().equals(Material.ENDER_CHEST))
				{
					e.setCancelled(true);
				} 
				else
				{
					e.setCancelled(false);
				}
				}
		}
		else
		{
			e.setCancelled(false);
			return;
		}
		
		}
	
}
