<<<<<<< HEAD
package me.Altitude.RPG;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public void onEnable(){
		this.getLogger().info("Altitude's RPG has been enabled!!!");
	}
}
=======
package me.Altitude.RPG;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public static Main plugin;
	public 	  final Logger logger = Logger.getLogger("Minecraft");
	public FileConfiguration config;
	
	public void onDisable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() +"version" + pdffile.getVersion() + "Is now disable");
	}
	
	
	public void onEnable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() +"version" + pdffile.getVersion() + "Is now enabled");
		getServer().getPluginManager().registerEvents(this, this);
		config = this.getConfig();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        ItemStack Pistol = new ItemStack(Material.STICK);
        ItemMeta meta = (ItemMeta) Pistol.getItemMeta();
        meta.setDisplayName("Pistol");
        Pistol.setItemMeta(meta);
        ItemStack Wand = new ItemStack(Material.BLAZE_ROD);
        meta = (ItemMeta) Wand.getItemMeta();
   
        ShapelessRecipe recipe = new ShapelessRecipe(Pistol).addIngredient(Material.STICK).addIngredient(Material.FLINT_AND_STEEL);
   
        this.getServer().addRecipe(recipe);
       

}
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event){
        ItemStack Pistol = new ItemStack(Material.STICK);
        Player player = event.getPlayer();
        ShapelessRecipe recipe = new ShapelessRecipe(Pistol).addIngredient(Material.STICK).addIngredient(Material.FLINT_AND_STEEL);
        if(player.hasPermission("rw.pistol"));
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && recipe.equals(Pistol)){
            player.launchProjectile(Arrow.class);
    }
}
}

>>>>>>> origin/master
