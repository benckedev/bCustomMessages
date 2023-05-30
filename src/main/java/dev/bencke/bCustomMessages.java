package dev.bencke;

import dev.bencke.config.Messages;
import dev.bencke.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class bCustomMessages extends JavaPlugin {

    public static bCustomMessages instance;

    public static bCustomMessages getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerListeners(), this);

        getLogger().info("Plugin carregado com sucesso.");
    }

    @Override
    public void onDisable() {

        getServer().getOnlinePlayers().forEach(i -> {
            i.kickPlayer(Messages.shutdown);
        });

        saveConfig();
        getLogger().info("Plugin desativado com sucesso.");
    }
}
