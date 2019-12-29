package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal.CreateCommand;
import nl.trydev07.betterkitpvp.handlers.NPCHandler;
import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/* TryDev07 created on 14/12/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ShopCommand extends CommandHandler {

    public ShopCommand(){
        super("shop","BetterKitPvP.help",false);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length <= 0) {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Shop Create &8- &7 Create the shop at your location."));
            sender.sendMessage(utils.format(" &8•  &f/Shop Remove &8- &7 Delete the existing shop."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            return;
        }
        if (args[0].toLowerCase().equalsIgnoreCase("create")) {
            new NPCHandler("Shop").addNpc(p.getLocation(), EntityType.VILLAGER,"Shop", utils.format("&eShop"));
            sender.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("ShopCreate").toString()));
            return;
        } else if (args[0].toLowerCase().equalsIgnoreCase("remove")) {
            NPCHandler.getNpcHandler("Shop", p).removeNpc();
            sender.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("ShopRemove").toString()));
        } else {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Shop Create &8- &7 Create the shop at your location."));
            sender.sendMessage(utils.format(" &8•  &f/Shop Remove &8- &7 Delete the existing shop."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
        }
    }
}
