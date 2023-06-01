package dev.bencke.command;

import dev.bencke.bCustomMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BCM implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("bcm.admin")) {
            sender.sendMessage("§cVocê não tem permissão para isso");
            return true;
        }

        if (args.length <= 0) {
            sender.sendMessage(" ");
            sender.sendMessage(" §abCustomMessages - mensagens customizáveis");
            sender.sendMessage("    §a/bcm reload §8- §7recarregue as configurações");
            sender.sendMessage(" ");
            return true;
        }

        String sub_cmd = args[0];
        if (sub_cmd.equalsIgnoreCase("reload")) {
            sender.sendMessage("§7Recarregando configurações...");
            bCustomMessages.getInstance().reloadConfig();
            bCustomMessages.getInstance().saveConfig();
            sender.sendMessage("§aConfigurações recarregadas com sucesso.");
        }

        return true;
    }
}
