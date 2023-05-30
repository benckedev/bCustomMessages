package dev.bencke.config;

import dev.bencke.bCustomMessages;
import org.bukkit.configuration.file.FileConfiguration;

public class Messages {

    private static final FileConfiguration config = bCustomMessages.getInstance().getConfig();

    public static String whitelist_kick = config.getString("whitelist.kick_message").replace("&", "§");

    public static String shutdown = config.getString("shutdown.message").replace("&", "§");

    public static String unknown_command = config.getString("command.unknown_command").replace("&", "§");
}
