package pl.karol.superpickaxe;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperPickaxe extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin enabled");
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin disabled");
    }
}
