package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.handlers.LocationHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class PortalCommand extends CommandHandler {

    public PortalCommand() {
        super("Portal", "BetterKitPvP.Admin", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length <= 0) {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Portal Create [Name] [Material] &8- &7 Create a new Portal of your selection."));
            sender.sendMessage(utils.format(" &8•  &f/Portal Remove [Name] &8- &7 Delete e existing Portal."));
            sender.sendMessage(utils.format(" &8•  &f/Portal Tool &8- &7 Get yourself a portal tool to make a new selection."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            return;
        }
        if (args[0].toLowerCase().equalsIgnoreCase("create")) {

            return;
        }else if(args[0].toLowerCase().equalsIgnoreCase("remove")){

            return;
        }else if(args[0].toLowerCase().equalsIgnoreCase("tool")){

            return;
        }else{
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Portal Create [Name] [Material] &8- &7 Create a new Portal of your selection."));
            sender.sendMessage(utils.format(" &8•  &f/Portal Remove [Name] &8- &7 Delete e existing Portal."));
            sender.sendMessage(utils.format(" &8•  &f/Portal Tool &8- &7 Get yourself a portal tool to make a new selection."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
        }
    }
}
