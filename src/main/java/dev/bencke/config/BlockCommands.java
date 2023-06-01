package dev.bencke.config;

import dev.bencke.bCustomMessages;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class BlockCommands {

    private static final FileConfiguration config = bCustomMessages.getInstance().getConfig();

    public static List<String> block_cmds = (List<String>) config.getList("commands.block_cmd");
}
