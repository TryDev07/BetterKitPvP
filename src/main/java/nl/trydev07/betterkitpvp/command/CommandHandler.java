package nl.trydev07.betterkitpvp.command;


import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.addRandomSpawnCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.setSpawnCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.helpCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.util.Collections;
import java.util.List;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public abstract class CommandHandler implements CommandExecutor{

    private final String commandName;
    private final String permission;
    private final boolean canConsoleUse;
    public static JavaPlugin plugin;


    public abstract void execute(CommandSender sender, String[] args);

    public CommandHandler(String commandName, String permission, boolean canConsoleUse) {
        this.commandName = commandName;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        plugin.getCommand(commandName).setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (!cmd.getLabel().equalsIgnoreCase(commandName))
            return true;
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(Core.getFileManager().getConfig("Messages.yml").get("NoPermission").toString().replaceAll("%PERMISSION%", permission));
            return true;
        }
        if (!canConsoleUse && !(sender instanceof Player)) {
            sender.sendMessage("Only players may use this command sorry!");
            return true;
        }
        execute(sender, args);
        return true;
    }


    public final static void registerCommands(JavaPlugin pl){
        plugin = pl;
        new setSpawnCommand();
        new addRandomSpawnCommand();
        new helpCommand();
    }
}
