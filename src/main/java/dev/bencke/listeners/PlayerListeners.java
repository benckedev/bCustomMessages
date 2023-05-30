package dev.bencke.listeners;

import dev.bencke.bCustomMessages;
import dev.bencke.config.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(bCustomMessages.getInstance().getServer().hasWhitelist() && !p.isWhitelisted()) {
            p.kickPlayer(Messages.whitelist_kick);
        }
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage().substring(1);
        String[] args = message.split(" ");

        if (bCustomMessages.getInstance().getServer().getPluginCommand(args[0]) == null || !bCustomMessages.getInstance().getServer().getPluginCommand(args[0]).isRegistered()) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Messages.unknown_command);
        }
    }

}
