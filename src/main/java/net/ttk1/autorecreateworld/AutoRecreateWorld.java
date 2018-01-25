package net.ttk1.autorecreateworld;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class AutoRecreateWorld extends JavaPlugin {
    private MVWorldManager manager;

    @Override
    public void onEnable(){
        MultiverseCore mvc = (MultiverseCore) getServer().getPluginManager().getPlugin("Multiverse-Core");
        manager = mvc.getMVWorldManager();
        getLogger().info("AutoRecreateWorld enabled");
    }

    @Override
    public void onDisable(){
        getLogger().info("AutoRecreateWorld disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
        if (sender instanceof Player) {
            if(sender.isOp()) {
                Collection<MultiverseWorld> worlds = manager.getMVWorlds();
                for(MultiverseWorld world: worlds) {
                    sender.sendMessage(world.getName());
                }
                return true;
            }
        } else {
            sender.sendMessage("operators only command");
            return true;
        }
        return false;
    }
}
